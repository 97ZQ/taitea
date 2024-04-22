package com.htht.business.app.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbBrowishGreenPerson;
import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.htht.business.app.dto.AppDbBrowishGreenStatisticsDTO;
import com.htht.business.app.dto.CreateDateDTO;
import com.htht.business.app.service.AppDbBrowishGreenPersonService;
import com.htht.business.app.service.AppDbBrowishGreenStatisticsService;
import com.htht.business.app.mapper.AppDbBrowishGreenStatisticsMapper;
import com.htht.business.app.vo.AppDbBrowishGreenStatisticsVo;
import com.htht.business.app.vo.CreateDateVo;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbBrowishGreenStatisticsServiceImpl extends ServiceImpl<AppDbBrowishGreenStatisticsMapper, AppDbBrowishGreenStatistics>
    implements AppDbBrowishGreenStatisticsService {

    private final AppDbBrowishGreenPersonService appDbBrowishGreenPersonService;

    @Override
    public TableDataInfo<AppDbBrowishGreenStatistics> selectList(AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO) {
//        List<AppDbBrowishGreenStatistics> appDbBrowishGreenStatisticsList = new ArrayList<>();
        List<AppDbBrowishGreenStatistics> list = this.lambdaQuery()
            .eq(StringUtils.isNotBlank(appDbBrowishGreenStatisticsDTO.getDate()), AppDbBrowishGreenStatistics::getTime, appDbBrowishGreenStatisticsDTO.getDate())
            .eq(AppDbBrowishGreenStatistics::getTeaGardenId, appDbBrowishGreenStatisticsDTO.getTeaId())
            .list();
//        for (AppDbBrowishGreenStatistics appDbBrowishGreenStatistics : list) {
//            AppDbBrowishGreenStatistics appDbBrowishGreenStatistics1 = new AppDbBrowishGreenStatistics();
//            Long id = appDbBrowishGreenStatistics.getId();
//            Long teaGardenId = appDbBrowishGreenStatistics.getTeaGardenId();
//            List<AppDbBrowishGreenPerson> greenPersonList = appDbBrowishGreenPersonService.lambdaQuery()
//                .eq(AppDbBrowishGreenPerson::getBrowishGreenStatisticsId, id)
//                .eq(AppDbBrowishGreenPerson::getTeaId, teaGardenId)
//                .list();
//            Double firstLevel = 0.00;
//            Double secondLevel = 0.00;
//            for (AppDbBrowishGreenPerson appDbBrowishGreenPerson : greenPersonList) {
//                String browishGreenFirstLevel = appDbBrowishGreenPerson.getBrowishGreenFirstLevel();
//                String browishGreenSecondLevel = appDbBrowishGreenPerson.getBrowishGreenSecondLevel();
//                 firstLevel = Double.valueOf(browishGreenFirstLevel);
//                 secondLevel = Double.valueOf(browishGreenSecondLevel);
//            }
//            appDbBrowishGreenStatistics1.setFirstLevel(firstLevel);
//            appDbBrowishGreenStatistics1.setSecondLevel(secondLevel);
//            appDbBrowishGreenStatistics1.setTime(appDbBrowishGreenStatistics.getTime());
//            appDbBrowishGreenStatistics1.setId(appDbBrowishGreenStatistics.getId());
//            appDbBrowishGreenStatistics1.setTeaGardenId(teaGardenId);
//            appDbBrowishGreenStatisticsList.add(appDbBrowishGreenStatistics1);
//        }
        return TableDataInfo.build(list);
    }

    @Override
    public AppDbBrowishGreenStatisticsVo countTea(AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO) {
//        List<AppDbBrowishGreenStatistics> list = this.lambdaQuery()
//            .eq(StringUtils.isNotBlank(appDbBrowishGreenStatisticsDTO.getDate()), AppDbBrowishGreenStatistics::getTime, appDbBrowishGreenStatisticsDTO.getDate())
//            .eq(AppDbBrowishGreenStatistics::getTeaGardenId, appDbBrowishGreenStatisticsDTO.getTeaId())
//            .list();
        TableDataInfo<AppDbBrowishGreenStatistics> tableDataInfoList = selectList(appDbBrowishGreenStatisticsDTO);
        List<AppDbBrowishGreenStatistics> list = tableDataInfoList.getRows();
        double firstLevel = list.stream()
            .mapToDouble(AppDbBrowishGreenStatistics::getFirstLevel)
            .sum();
        double secondLevel = list.stream()
            .mapToDouble(AppDbBrowishGreenStatistics::getSecondLevel)
            .sum();
        AppDbBrowishGreenStatisticsVo appDbBrowishGreenStatisticsVo = new AppDbBrowishGreenStatisticsVo();
        appDbBrowishGreenStatisticsVo.setFirstLevel(firstLevel);
        appDbBrowishGreenStatisticsVo.setSecondLevel(secondLevel);
        return appDbBrowishGreenStatisticsVo;
    }

    @Override
    public TableDataInfo<AppDbBrowishGreenStatistics> createDate(CreateDateDTO createDateDTO) {
//        YearMonth yearMonth = YearMonth.now();
//        int year = yearMonth.getYear();
//        int month = yearMonth.getMonthValue();
//        String date = createDateDTO.getDate();
//        DateTime parse = DateUtil.parse(date, "yyyy-MM");
//        String dateTime = year + "-" + month;
//        System.out.println(dateTime);
//        System.out.println(date);
//        System.out.println(parse.toJdkDate().toString());

        if (createDateDTO.getDate() == null) {
            createDateDTO.setDate(DateUtil.format(new Date(), "yyyy-MM"));
        }

        boolean isYearMonthFormat = isDateFormatValid(createDateDTO.getDate(), "yyyy-MM");
        boolean isYearMonthDayFormat = isDateFormatValid(createDateDTO.getDate(), "yyyy-MM-dd");
        List<AppDbBrowishGreenStatistics> res = new ArrayList<>();
        if (isYearMonthFormat) {
            res = createMonthData(createDateDTO);
        }
        if (isYearMonthDayFormat) {
            res = createDayData(createDateDTO);
        }
        return TableDataInfo.build(res);


//        List<CreateDateVo> list = new ArrayList<>();
//
//
//        //如果dateTime等于空，就说明查询的是当前月份的数据
//
//        // 获取当前年份和月份
//        YearMonth yearMonth = YearMonth.parse(DateUtil.format(dateTime,"yyyy-MM-dd"));
//        int year = yearMonth.getYear();
//        int month = yearMonth.getMonthValue();
//
//        // 获取当前月份的月初日期
//        LocalDate monthStart = LocalDate.of(year, month, 1);
//
//        // 获取当前日期
//        LocalDate currentDate = LocalDate.now();
//
//        // 生成日期列表--这个月截至到今天的日期
//        List<LocalDate> dates = new ArrayList<>();
//        LocalDate date = monthStart;
//        while (!date.isAfter(currentDate)) {
//            dates.add(date);
//            date = date.plusDays(1);
//        }
//
//        // 输出日期列表
//        for (LocalDate d : dates) {
//            System.out.println(d);
//
//            CreateDateVo createDateVo = new CreateDateVo();
//            createDateVo.setDateTime(d.toString());
//            list.add(createDateVo);
//        }
//
//
//        return TableDataInfo.build(list);

        //如果异常，那么就是当前月份
        //如果是当前月份，那么就生成当前月份月初一直到现在的天数


        // private final Date date = new Date();
        // private DateTime dateTime = new DateTime(DateUtil.format(date,"yyyy-MM-dd")+" "+"00:00:00");
        //进来收青统计，生成当前月份所有天数
//        // 获取当前年份和月份
//        YearMonth yearMonth = YearMonth.now();
//        int year = yearMonth.getYear();
//        int month = yearMonth.getMonthValue();
//
//        // 获取当前月份的天数
//        int daysInMonth = yearMonth.lengthOfMonth();
//
//        // 输出当前月份的每一天
//        for (int day = 1; day <= daysInMonth; day++) {
//            LocalDate date = LocalDate.of(year, month, day);
//            System.out.println(date);
//        }
        //return null;
    }

    /**
     * 如果传的是月份，有天数
     * @param createDateDTO
     * @return
     */
    private List<AppDbBrowishGreenStatistics> createDayData(CreateDateDTO createDateDTO) {
        //如果是yyyy-MM-dd的日期格式，就直接查询指定日期的数据
        return this.lambdaQuery()
            .eq(AppDbBrowishGreenStatistics::getTime, DateUtil.parse(createDateDTO.getDate()))
            .eq(AppDbBrowishGreenStatistics::getTeaGardenId, createDateDTO.getTeaId())
            .list();
    }

    /**
     * 如果传的是月份，没有天数
     * @param createDateDTO
     * @return
     */
    private List<AppDbBrowishGreenStatistics> createMonthData(CreateDateDTO createDateDTO) {
        //判断月份是否是当前月
        String date = createDateDTO.getDate();//yyyy-MM
        Date nowDate = new Date();
        String nowMonth = DateUtil.format(nowDate, "yyyy-MM");//当前月
        if (nowMonth.equals(date)){
            //处理当前月的
            //1~29
            // 获取当前年份和月份
        YearMonth yearMonth = YearMonth.now();
        int year = yearMonth.getYear();
        int month = yearMonth.getMonthValue();

        // 获取当前月份的月初日期
        LocalDate monthStart = LocalDate.of(year, month, 1);

        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 生成日期列表--这个月截至到今天的日期
        List<LocalDate> dates = new ArrayList<>();
        LocalDate dateTime = monthStart;
        while (!dateTime.isAfter(currentDate)) {
            dates.add(dateTime);
            dateTime = dateTime.plusDays(1);
        }

            //判断数据库里面是否有这一条数据
            for (LocalDate localDate : dates) {
                Long count = this.lambdaQuery()
                    .eq(AppDbBrowishGreenStatistics::getTime, DateUtil.parse(localDate.toString() + " 00:00:00"))
                    .eq(AppDbBrowishGreenStatistics::getTeaGardenId, createDateDTO.getTeaId())
                    .count();
                if (count == 0){
                    AppDbBrowishGreenStatistics appDbBrowishGreenStatistics = new AppDbBrowishGreenStatistics();
                    appDbBrowishGreenStatistics.setTime(DateUtil.parse(localDate.toString() + " 00:00:00"));
                    appDbBrowishGreenStatistics.setSecondLevelAll(0.0);
                    appDbBrowishGreenStatistics.setFirstLevelAll(0.0);
                    appDbBrowishGreenStatistics.setTeaGardenId(createDateDTO.getTeaId());
                    this.saveOrUpdate(appDbBrowishGreenStatistics);
                }
            }


            String date1 = createDateDTO.getDate();
            String[] split = date1.split("-");

            List<String> list = Arrays.asList(split);
            String getYear = list.get(0);
            String getMonth = list.get(1);




            Long teaId = createDateDTO.getTeaId();
            List<AppDbBrowishGreenStatistics> yearAndMonth = this.baseMapper.getYearAndMonth(getYear, getMonth, teaId);
            return yearAndMonth;
        }

        //处理历史月份
        //获取历史月分天数
        //yyyy-MM
        String dateMM = createDateDTO.getDate();
        //获取月份
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate localDate = LocalDate.parse(dateMM, formatter);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        List<String> monDateList = getMonDateList(year, month);
        //获取到历史月份的日期后去判断数据库有无这一天的数据
        for (String dateTime : monDateList) {
            dateTime = dateTime + " 00:00:00";
            Long count = this.lambdaQuery()
                .eq(AppDbBrowishGreenStatistics::getTime, dateTime)
                .eq(AppDbBrowishGreenStatistics::getTeaGardenId, createDateDTO.getTeaId())
                .count();
            if (count == 0){
                AppDbBrowishGreenStatistics appDbBrowishGreenStatistics = new AppDbBrowishGreenStatistics();
                appDbBrowishGreenStatistics.setTime(DateUtil.parse(dateTime));
                appDbBrowishGreenStatistics.setSecondLevelAll(0.0);
                appDbBrowishGreenStatistics.setFirstLevelAll(0.0);
                this.saveOrUpdate(appDbBrowishGreenStatistics);
            }
        }

        return this.lambdaQuery()
            .eq(AppDbBrowishGreenStatistics::getTeaGardenId, createDateDTO.getTeaId())
            .list();
    }

    private static List<String> getMonDateList(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month); // 注意：月份是从0开始的
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

//        int day = i - 1;

        List<String> historyDateList = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            System.out.println("j = " + j);
            System.out.println(year + "-" + month + "-" + j);
            historyDateList.add(year + "-" + month + "-" + j);
        }
        return historyDateList;
    }


    private static boolean isDateFormatValid(String dateString, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            if (pattern.contains("dd")) {
                LocalDate.parse(dateString, formatter);
            } else {
                YearMonth.parse(dateString, formatter);
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}




