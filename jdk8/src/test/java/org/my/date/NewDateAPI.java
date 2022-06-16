package org.my.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class NewDateAPI {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println("当前时间："+now);

        //获取当月第一天
        System.out.println("当月第一天："+now.with(TemporalAdjusters.firstDayOfMonth()));

        //获取本月第2天：
        System.out.println("本月第2天："+now.withDayOfMonth(2));

        //获取下月第一天
        System.out.println("下月第一天："+now.with(TemporalAdjusters.firstDayOfNextMonth()));

        //获取明年第一天
        System.out.println("明年第一天："+now.with(TemporalAdjusters.firstDayOfNextYear()));

        //获取本年第一天
        System.out.println("本年第一天："+now.with(TemporalAdjusters.firstDayOfYear()));

        //获取当月最后一天，再也不用计算是28，29，30还是31：
        System.out.println("当月最后一天："+now.with(TemporalAdjusters.lastDayOfMonth()));

        //获取本年最后一天
        System.out.println("本年最后一天："+now.with(TemporalAdjusters.lastDayOfYear()));

        //获取当月的第一个星期一
        System.out.println("当月的第一个星期一："+now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));

        //获取当月的最后一个星期一
        System.out.println("当月的最后一个星期一："+now.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)));

        //获取当月第三周星期五
        System.out.println("当月第三周星期五："+now.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));

        //获取本周一
        System.out.println("本周一："+now.with(DayOfWeek.MONDAY));

        //获取上周二
        System.out.println("上周二："+now.minusWeeks(1).with(ChronoField.DAY_OF_WEEK, 2));

        //(往前不包括当天)获取当前日期的上一个周一  如果今天是周一，则返回上周一
        System.out.println("上一个周一(不包括当天)："+now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));

        //(往前包括当天)最近星期五的日期  如果今天是星期五，则返回今天日期
        System.out.println("上一个周一(包括当天)："+now.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY)));

        //获取下周二
        System.out.println("下周二："+now.plusWeeks(1).with(ChronoField.DAY_OF_WEEK, 2));

        //(往后不包括当天)获取当前日期的下一个周日 如果今天是周日，则返回下周日的时间  如果今天是星期一，则返回本周日的时间
        System.out.println("下一个周日(不包括当天)："+now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

        //(往后包括当天)最近星期五的日期  如果今天是星期五，则返回今天日期
        System.out.println("下一个周日(包括当天)："+now.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));


    }
}
