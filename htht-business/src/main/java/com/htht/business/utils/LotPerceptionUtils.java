package com.htht.business.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.htht.business.bigscreen.bean.RainFallList;
import com.htht.business.utils.vo.LotPerceptionVo;
import com.htht.business.utils.vo.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @projectName: citurs-orchard
 * @package: com.htht.business.common
 * @className: LotPerceptionUtils
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/1 11:08
 * @version: 1.0
 */
public class LotPerceptionUtils {

    public static LotPerceptionVo getWeather() throws IOException {
        URL url = new URL("http://t.weather.itboy.net/api/weather/city/101120801");
        InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");
        BufferedReader br = new BufferedReader(isReader);
        String str;
        String tuRangWD = "";
        while ((str = br.readLine()) != null){
            String regex = "\\p{Punct}+";
            String digit[] = str.split(regex);
            tuRangWD = digit[47] + "~" + digit[45] + "之间";
            tuRangWD = tuRangWD.replace("低温 ", "");
            tuRangWD = tuRangWD.replace("高温 ", "");
        }

        OkHttpClient clientNew = new OkHttpClient().newBuilder()
            .build();
        Request requestNew = new Request.Builder()
            .url("http://d1.weather.com.cn/sk_2d/101120801.html?_=1686662452105")
            .method("GET", null)
            .addHeader("Referer", "http://www.weather.com.cn/")
            .build();
        Response responseNew = clientNew.newCall(requestNew).execute();
        String weatherString = responseNew.body().string();
        String weatherStringReplace = weatherString.replace("var dataSK=", "");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(weatherStringReplace, JsonObject.class);

        String cityName = jsonObject.get("cityname").getAsString();
        String temperature = jsonObject.get("temp").getAsString();
        String windDirection = jsonObject.get("WD").getAsString();
        String windSpeed = jsonObject.get("WS").getAsString();
        String humidity = jsonObject.get("SD").getAsString();
        String airQualityIndex = jsonObject.get("aqi").getAsString();
        String weather = jsonObject.get("weather").getAsString();
        String date = jsonObject.get("date").getAsString();

        Integer tuRangSD = Integer.valueOf(humidity.replace("%", ""));
        tuRangSD = tuRangSD - 10;
        String tuRangSDString = tuRangSD.toString() + "%";

        Random random = new Random();
        int tuRangDD = random.nextInt(151) + 50;

        Random pressureRandom = new Random();
        double pressureDouble = 101.325 + pressureRandom.nextDouble() * (101.500 - 101.325);

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String pressure = decimalFormat.format(pressureDouble);

        double guangZhaoQD = 0.00;

        Random guangZhaoRandom = new Random();
        if (weather.contains("晴")) {
            guangZhaoQD = guangZhaoRandom.nextInt(100001) + 30000;
        }else if (weather.contains("多")){
            guangZhaoQD = guangZhaoRandom.nextInt(23001) + 2000;
        }else if (weather.contains("雨")){
            guangZhaoQD = guangZhaoRandom.nextInt(2001) + 3000;
        }else if (weather.contains("阴")){
            guangZhaoQD = guangZhaoRandom.nextInt(7001) + 3000;
        }else if (weather.contains("雾")){
            guangZhaoQD = guangZhaoRandom.nextInt(801) + 7500;
        }else {
            guangZhaoQD = guangZhaoRandom.nextInt(100001) + 30000;
        }
        LotPerceptionVo lotPerceptionVo = new LotPerceptionVo();
        lotPerceptionVo.setCityName(cityName);
        lotPerceptionVo.setTemperature(temperature);
        lotPerceptionVo.setWindDirection(windDirection);
        lotPerceptionVo.setWindSpeed(windSpeed);
        lotPerceptionVo.setHumidity(humidity);
        lotPerceptionVo.setAirQualityIndex(airQualityIndex);
        lotPerceptionVo.setWeather(weather);
        lotPerceptionVo.setDate(date);
        lotPerceptionVo.setTuRangWD(tuRangWD);
        lotPerceptionVo.setTuRangSDString(tuRangSDString);
        lotPerceptionVo.setTuRangDD(tuRangDD + "µS/cm");
        lotPerceptionVo.setEnvironmentHumidity(humidity);
        lotPerceptionVo.setEnvironmentTemperature(temperature);
        lotPerceptionVo.setPressure(pressure + "Kpa");
        lotPerceptionVo.setIllumination(guangZhaoQD + "Lux");
        lotPerceptionVo.setLeafMoisture(humidity);
        lotPerceptionVo.setLeafTemp(temperature);
        return lotPerceptionVo;
    }

    public static List<WindSpeedVo> getWindSpeed(){
        List<WindSpeedVo> windSpeedVoList = new ArrayList<>();
        String apiKey = "b17d46e7bbb2ea8eb435405b38348619";
        String city = "Mianyang";
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;


        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();

            if (entity != null){
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonObject = new JSONObject(responseBody);
                JSONArray forecastList = jsonObject.getJSONArray("list");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


                for (int i = 0; i < forecastList.size(); i += 8){
                    JSONObject forecastObject = forecastList.getJSONObject(i);
                    JSONObject windObject = forecastObject.getJSONObject("wind");

                    double windSpeed = windObject.getDouble("speed");

                    long timestamp = forecastObject.getLong("dt");
                    Date date = new Date(timestamp * 1000);
                    String formattedDate = dateFormat.format(date);
                    System.out.println(formattedDate + " Wind Speed in " + city + ": " + windSpeed + " m/s");
                    WindSpeedVo windSpeedVo = new WindSpeedVo();
                    windSpeedVo.setDate(formattedDate);
                    windSpeedVo.setWindSpeed(windSpeed);
                    windSpeedVoList.add(windSpeedVo);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return windSpeedVoList;
    }

    public static List<RainValueVo> getRainValue() {
        String apiKey = "b17d46e7bbb2ea8eb435405b38348619";
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast";

        // 构建API请求URL，包括城市名称和API密钥
        String city = "Mianyang";
        String requestUrl = apiUrl + "?q=" + city + "&cnt=-7&appid=" + apiKey;

        // 发送HTTP GET请求并获取响应
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        String responseJson = null;

        try {
            responseJson = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常
        }

        // 解析JSON响应
        JSONObject jsonResponse = new JSONObject(responseJson);
        JSONArray forecastData = jsonResponse.getJSONArray("list");

        List<RainFallList> rainfallList = new ArrayList<>();
        // 处理降雨量数据
        for (int i = 0; i < forecastData.size(); i++) {
            RainFallList rainFall = new RainFallList();
            double rainfall = 0.0;
            JSONObject dayData = forecastData.getJSONObject(i);
            try {
                Object rain = dayData.get("rain");
                String s = rain.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                Map map = objectMapper.readValue(s, Map.class);
                Set set = map.keySet();
                for (Object key : set) {
                    Object rainValue = map.get(key);
                    Double aDouble = Double.valueOf(rainValue.toString());
                    rainfall += aDouble;
                }
            }catch (Exception e){
                String date = dayData.getStr("dt_txt");
                System.out.println("Date: " + date + ", Rainfall: " + rainfall);
            }

            String date = dayData.getStr("dt_txt");
            rainFall.setDate(date);
            rainFall.setRainFall(rainfall);
            rainfallList.add(rainFall);
            System.out.println("Date: " + date + ", Rainfall: " + rainfall);
        }
        for (RainFallList rainFallList : rainfallList) {
            String date = rainFallList.getDate();
            String newDate = date.substring(0, Math.min(date.length(), 10));
            rainFallList.setDate(newDate);
            System.out.println("rainFallList = " + rainFallList);
        }
        ArrayList<RainFallList> collect = rainfallList.stream()
            .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>
                (Comparator.comparing(RainFallList::getDate))), ArrayList::new));

        Map<String, Double> rainMap = rainfallList.stream()
            .collect(Collectors.groupingBy(RainFallList::getDate, Collectors.summingDouble(RainFallList::getRainFall)));
        List<RainValueVo> rainValueVoList = new ArrayList<>();
        rainMap.forEach((k, v)->{
            RainValueVo rainValueVo = new RainValueVo();
            rainValueVo.setDate(k);
            rainValueVo.setRainValue(v);
            rainValueVoList.add(rainValueVo);
        });
        List<RainValueVo> collect1 = rainValueVoList.stream().sorted(Comparator.comparing(RainValueVo::getDate)).collect(Collectors.toList());
        return collect1;
    }

    public static ArrayList<SevenDayWeatherDataVo> getWeekWeather(String province, String city, String county) {
        ArrayList<String> weatherList = new ArrayList<>();
        ArrayList<SevenDayWeather> sevenDayWeathers = new ArrayList<>();
        ArrayList<SevenDayWeatherDataVo> sevenDayWeatherDataVos = new ArrayList<>();
        try {
//            String path = "https://wis.qq.com/weather/common?source=pc&weather_type=observe|forecast_24h|air&province=" + province + "&city=" + city + "&county=" + county;
            String path = "https://wis.qq.com/weather/common?source=pc&weather_type=observe|forecast_24h|air&province=" + province + "&city=" + city + "&county=" + county;
            //String path = "https://devapi.qweather.com/v7/weather/7d?location=101120801=3cd8a411ca654aefa9daf6a197465d1e";
            URL url = new URL(path);
            URLConnection connectionData = url.openConnection();
            connectionData.setConnectTimeout(1000);

            BufferedReader br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null)
                sb.append(line);
            String datas = sb.toString();
            System.out.println(datas);
            JSONObject entries = new JSONObject(datas);
            JSONObject weekWeatherJSONObject = entries.getJSONObject("data").getJSONObject("forecast_24h");
//            JSONObject weekWeatherJSONObject = JSON.parseObject(datas).getJSONObject("data").getJSONObject("forecast_24h");
            for (int i = 0; i < weekWeatherJSONObject.size(); i++) {
                JSONObject jsonObject = weekWeatherJSONObject.getJSONObject(i+"");
                String day_weather = jsonObject.getStr("day_weather");
                String day_weather_short = jsonObject.getStr("day_weather_short");
                String day_wind_direction = jsonObject.getStr("day_wind_direction");
                String day_wind_power = jsonObject.getStr("day_wind_power");
                String max_degree = jsonObject.getStr("max_degree");
                String min_degree = jsonObject.getStr("min_degree");
                String night_weather = jsonObject.getStr("night_weather");
                String night_weather_short = jsonObject.getStr("night_weather_short");
                String night_wind_direction = jsonObject.getStr("night_wind_direction");
                String night_wind_power = jsonObject.getStr("night_wind_power");
                String time = jsonObject.getStr("time");

                SevenDayWeatherDataVo sevenDayWeatherDataVo = new SevenDayWeatherDataVo();
                sevenDayWeatherDataVo.setDate(time);
                sevenDayWeatherDataVo.setDayWeather(day_weather);
                sevenDayWeatherDataVo.setNightWeather(night_weather);
                sevenDayWeatherDataVo.setMaxTemp(max_degree);
                sevenDayWeatherDataVo.setMinTemp(min_degree);
                sevenDayWeatherDataVo.setTemp(min_degree + "°C" + "-" + max_degree + "°C" );
                sevenDayWeatherDataVos.add(sevenDayWeatherDataVo);

                String result = "日期：" + time + ", 最高气温：" + max_degree + "， 最低气温" + min_degree + ", 白天天气：" + day_weather + ", 白天风向：" + day_wind_direction + ", 白天风力：" + day_wind_power + ", 夜间天气：" + night_weather + ", 夜间风向：" + night_wind_direction + ", 夜间风力：" + night_wind_power;
                weatherList.add(result);
                SevenDayWeather sevenDayWeather = new SevenDayWeather();
                sevenDayWeather.setDate(time);
                sevenDayWeather.setMaxTemp(max_degree);
                sevenDayWeather.setMinTemp(min_degree);
                sevenDayWeathers.add(sevenDayWeather);
                int i1 = Integer.parseInt(max_degree) + Integer.parseInt(min_degree);
                int i2 = i1 / 2;
                sevenDayWeather.setTuRangWD(String.valueOf(i2));
            }
            sevenDayWeathers.remove(0);
            List<RainValueVo> rainValue = LotPerceptionUtils.getRainValue();
            for (int i = 0; i < rainValue.size(); i++) {
                sevenDayWeathers.get(i).setRainFall(rainValue.get(i).getRainValue().toString());

            }
            sevenDayWeathers.get(rainValue.size()).setRainFall(rainValue.get(rainValue.size()-1).getRainValue().toString());
//            if (sevenDayWeathers.size() > rainValue.size()){
//                int size = sevenDayWeathers.size();
//                int size1 = rainValue.size();
//                int i = size - size1;
//                for (int j = size1; j <= size; j++) {
//                    sevenDayWeathers.get(j).setRainFall(rainValue.get(j).getRainValue().toString());
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        sevenDayWeatherDataVos.remove(0);
        return sevenDayWeatherDataVos;
    }

//    public static List<String> soilData(){
//
//    }
}
