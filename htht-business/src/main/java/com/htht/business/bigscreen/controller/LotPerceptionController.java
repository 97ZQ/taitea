package com.htht.business.bigscreen.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.htht.business.utils.LotPerceptionUtils;
import com.htht.business.utils.vo.*;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**天气接口
 * @projectName: citurs-orchard
 * @package: com.htht.business.bigscreen.controller
 * @className: LotPerceptionController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/1 11:05
 * @version: 1.0
 */
@SaIgnore
@RestController
@RequestMapping("/lotPerception")
@RequiredArgsConstructor
public class LotPerceptionController {
    private static final String API_KEY = "3cd8a411ca654aefa9daf6a197465d1e";


    /**
     * 查询天气
     * @return
     * @throws IOException
     */
    @GetMapping("/lotPerceptionValue")
    @SaIgnore
    public R<Object> getWeatherValue() throws IOException {
        return R.ok(LotPerceptionUtils.getWeather());
    }

    /**
     * 查询一周的天气
     * @return
     * @throws IOException
     */
    @GetMapping("/getWeatherWeek")
    @SaIgnore
    public R<Object> getWeatherWeek() throws IOException {
        return R.ok(LotPerceptionUtils.getWeekWeather("山东省","泰安市", "泰山区"));
    }

    /**
     * 查询14天的天气
     */


    @GetMapping("/getFourteenDayWeather")
    @SaIgnore
    public R<Object> getFourteenDayWeather() throws Exception {
//        String site = "taishan";

        ArrayList arrayList = new ArrayList();
        Res1 cs = new Res1();

        Document doc = null;
        doc = Jsoup.connect("https://www.tianqi.com/shandong-shengzhuangzhen/14022/40/").get();

        List<WeatherVo> weatherVos = new ArrayList<>();

        Element titles = doc.getElementsByClass("weatherbox3").get(0);
        Element body = doc.getElementsByClass("box_day").get(0);
        Elements table_day_tbg = body.getElementsByClass("table_day tbg");
        for (Element element : table_day_tbg) {
            WeatherVo weatherVo = new WeatherVo();
            Elements h3 = element.select("h3");
            String date = h3.select("b").get(0).text();
            String theDay = h3.select("em").get(0).text();
            weatherVo.setDate(date);
            weatherVo.setTheDay(theDay);
            Elements ul = element.select("ul");
            System.out.println("ul = " + ul);
            String weatherCondition  = ul.select("li").get(1).text();
            weatherVo.setCondition(weatherCondition);
            String temp = ul.select("li").get(2).text();
            weatherVo.setTemperature(temp);
            int index = temp.indexOf("~");
            String lowTemp = temp.substring(0, index);
            System.out.println("result = " + lowTemp);
            int i = temp.indexOf("℃");
            String highTemp = temp.substring(index + 1 , i);
            System.out.println("substring = " + highTemp);
            Integer lowTempInt = Integer.valueOf(lowTemp);
            Integer highTempInt = Integer.valueOf(highTemp);
            Integer result = 0;

            if (highTempInt > 37){
                weatherVo.setTempCondition("高温红色预警");
                result = 1;
            }
            if (lowTempInt >= 25 && highTempInt <= 37){
                weatherVo.setTempCondition("高温预警");
                result = 1;
            }
            if (lowTempInt <= 0){
                weatherVo.setTempCondition("低温预警");
                result = 1;
            }
            if (lowTempInt >= 0 && highTempInt <= 25){
                weatherVo.setTempCondition("适宜");
                result = 1;
            }
            if (lowTempInt <= -10 ){
                weatherVo.setTempCondition("低温红色预警");
                result = 1;
            }

            if (result == 0){
                weatherVo.setTempCondition("适宜");
            }
            weatherVos.add(weatherVo);
        }
        Elements table_day = body.getElementsByClass("table_day");
        int i = 0;
        for (Element element : table_day) {
            i ++ ;
            if (i < 4){
            }else {
                WeatherVo weatherVo = new WeatherVo();
                Elements h3 = element.select("h3");
                String h31 = element.select("h3").text();
                System.out.println("h31 = " + h31);
                String ch = "日";

                int position = h31.indexOf(ch);
                System.out.println("position = " + position);
                String theDay = h31.substring(position + 2, h31.length());
//                System.out.println("substring = " + substring);

                System.out.println("h3 = " + h3.text());
                String date = h3.select("b").get(0).text();
                System.out.println("date = " + date);

//                String theDay = h3.select("em").get(0).text();
                weatherVo.setDate(date);
                weatherVo.setTheDay(theDay);
                Elements ul = element.select("ul");
                String weatherCondition = ul.select("li").get(1).text();
                weatherVo.setCondition(weatherCondition);
                String temp = ul.select("li").get(2).text();
                weatherVo.setTemperature(temp);
                int index = temp.indexOf("~");
                String lowTemp = temp.substring(0, index);
                System.out.println("result = " + lowTemp);
                int j = temp.indexOf("℃");
                String highTemp = temp.substring(index + 1 , j);
                System.out.println("substring = " + highTemp);
                Integer lowTempInt = Integer.valueOf(lowTemp);
                Integer highTempInt = Integer.valueOf(highTemp);
                Integer result = 0;

                if (highTempInt > 37){
                    weatherVo.setTempCondition("高温红色预警");
                    result = 1;
                }
                if (lowTempInt >= 25 && highTempInt <= 37){
                    weatherVo.setTempCondition("高温预警");
                    result = 1;
                }
                if (lowTempInt <= 0){
                    weatherVo.setTempCondition("低温预警");
                    result = 1;
                }
                if (lowTempInt >= 0 && highTempInt <= 25){
                    weatherVo.setTempCondition("适宜");
                    result = 1;
                }
                if (lowTempInt <= -10 ){
                    weatherVo.setTempCondition("低温红色预警");
                    result = 1;
                }

                if (result == 0){
                    weatherVo.setTempCondition("适宜");
                }


                weatherVos.add(weatherVo);
            }
        }
//        Elements childNodes = body.select("childNodes");
//        Element childChildrenRef = doc.getElementsByClass("childNodes").get(0);
//        System.out.println("childChildrenRef = " + childChildrenRef);
//        cs.setTitle(titles.select("h1").get(0).text());
//        cs.setImage(titles.select("img").get(0).attr("src"));
//        cs.setTime(titles.select("span").get(0).text());
//        cs.setToday(titles.select("p").get(0).text());
//        weatherVos.remove(weatherVos.size()-1);
        Integer count = 25;
        weatherVos.subList(weatherVos.size() - count, weatherVos.size()).clear();
        return R.ok(weatherVos);
    }
}
