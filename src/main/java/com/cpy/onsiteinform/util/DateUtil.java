package com.cpy.onsiteinform.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Description: 时间工具包
 * Create DateTime: 2018-08-01 16:46
 *
 * @author Sxj
 */
public class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";

    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    public static final String DATE_FORMAT_YYYYMMDD_NUM = "yyyyMMdd";

    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT_YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DEFAULT_DATE_HHMMSS = "HH:mm:ss";

    public static final String DEFAULT_DATE_HHMM = "HH:mm";

    private static final String[] MONTH_STRING = {"January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    public static String toGMTString(Date source) {
        if (null == source) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        DateFormat df = new SimpleDateFormat("dd {0} yyyy HH:mm:ss");
        df.setCalendar(cal);
        sb.append(df.format(source)).append(" GMT");
        int index = getMonth(source) - 1;
        String m = MONTH_STRING[index].substring(0, 3);
        return MessageFormat.format(sb.toString(), m);
    }

    public static String toYMDString(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).format(date);
        } else {
            return null;
        }
    }

	public static String toYMDNUMString(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_NUM).format(date);
		} else {
			return null;
		}
	}

    public static String toYMDHMString(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMM).format(date);
        } else {
            return null;
        }
    }

    public static String toYMDHMSSSString(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMMSSSSS).format(date);
        } else {
            return null;
        }
    }

    public static String toYMDStringHMS(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DEFAULT_DATE_HHMMSS).format(date);
        } else {
            return null;
        }
    }


    public static String toYMDHSString(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
        } else {
            return null;
        }
    }

    public static Date parseDateYMDHS(String dateStr) {
        return parse(dateStr, DEFAULT_DATE_FORMAT);
    }

    public static Date parseDate(String dateStr) {
        return parse(dateStr, DATE_FORMAT_YYYYMMDD);
    }

    private static Date parse(String yearMonth, String dateFormat) {
        Date date;
        try {
            date = new SimpleDateFormat(dateFormat).parse(yearMonth);
        } catch (Exception pe) {
            return null;
        }
        return date;
    }

    public static Date getMonthDate(Date date) {
        return getMonthDate(date, -2);
    }

    public static Date getMonthDate(Date date, int num) {
        Calendar c = toCalendar(date);
        if (c != null) {
            int m = (num <= 0 ? c.get(Calendar.DAY_OF_MONTH) - 1 : num);
            c.add(Calendar.MONTH, -m);
            return c.getTime();
        } else {
            return null;
        }
    }

    public static int getMonth(Date date) {
        Calendar c = toCalendar(date);
        if (c != null) {
            return c.get(Calendar.MONTH) + 1;
        } else {
            return -1;
        }
    }

    public static Calendar toCalendar(Date date) {
        Calendar c = null;
        if (date != null) {
            c = Calendar.getInstance();
            c.setTime(date);
        }
        return c;
    }

    public static int getToday() {
        int todayWeek = Calendar.getInstance().getTime().getDay();
        if (todayWeek == 0) {
            return 7;
        }
        return todayWeek;
    }

    public static Date getDate() {
        Calendar canlendar = Calendar.getInstance();
        return canlendar.getTime();
    }

    /**
     * 用年，月，日，时，分，秒构造日期类型
     *
     * @param iYear
     * @param iMonth
     * @param iDate
     * @param iHour
     * @param iMinute
     * @param iSecond
     * @return
     */
    public static Date getDate(int iYear, int iMonth, int iDate, int iHour,
                               int iMinute, int iSecond) {
        iMonth--;
        Calendar canlendar = Calendar.getInstance();
        canlendar.clear();
        canlendar.set(iYear, iMonth, iDate, iHour, iMinute, iSecond);
        return canlendar.getTime();
    }

    /**
     * 用年，月，日，时，分构造日期类型
     *
     * @param iYear
     * @param iMonth
     * @param iDate
     * @param iHour
     * @param iMinute
     * @return
     */
    public static Date getDate(int iYear, int iMonth, int iDate, int iHour,
                               int iMinute) {
        return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute, 0);
    }

    /**
     * 用年，月，日，时构造日期类型
     *
     * @param iYear
     * @param iMonth
     * @param iDate
     * @param iHour
     * @return
     */
    public static Date getDate(int iYear, int iMonth, int iDate, int iHour) {
        return DateUtil.getDate(iYear, iMonth, iDate, iHour, 0, 0);
    }

    /**
     * 用年，月，日构造日期类型
     *
     * @param iYear
     * @param iMonth
     * @param iDate
     * @return
     */
    public static Date getDate(int iYear, int iMonth, int iDate) {
        return DateUtil.getDate(iYear, iMonth, iDate, 0, 0, 0);
    }

    /**
     * 用年，月构造日期类型
     *
     * @param iYear
     * @param iMonth
     * @return
     */
    public static Date getDate(int iYear, int iMonth) {
        return DateUtil.getDate(iYear, iMonth, 1, 0, 0, 0);
    }

    /**
     * 用年构造日期类型
     *
     * @param iYear
     * @return
     */
    public static Date getDate(int iYear) {
        return DateUtil.getDate(iYear, 1, 1, 0, 0, 0);
    }

    public static Date getDate(String sYear) {
        int iYear = DateUtil.getRightNumber(sYear);
        return DateUtil.getDate(iYear);
    }

    public static Date getDate(String sYear, String sMonth) {
        int iYear = DateUtil.getRightNumber(sYear);
        int iMonth = DateUtil.getRightNumber(sMonth);
        return DateUtil.getDate(iYear, iMonth);
    }

    public static Date getDate(String sYear, String sMonth, String sDate) {
        int iYear = DateUtil.getRightNumber(sYear);
        int iMonth = DateUtil.getRightNumber(sMonth);
        int iDate = DateUtil.getRightNumber(sDate);
        return DateUtil.getDate(iYear, iMonth, iDate);
    }

    public static Date getDate(String sYear, String sMonth, String sDate,
                               String sHour) {
        int iYear = DateUtil.getRightNumber(sYear);
        int iMonth = DateUtil.getRightNumber(sMonth);
        int iDate = DateUtil.getRightNumber(sDate);
        int iHour = DateUtil.getRightNumber(sHour);
        return DateUtil.getDate(iYear, iMonth, iDate, iHour);
    }

    public static Date getDate(String sYear, String sMonth, String sDate,
                               String sHour, String sMinute) {
        int iYear = DateUtil.getRightNumber(sYear);
        int iMonth = DateUtil.getRightNumber(sMonth);
        int iDate = DateUtil.getRightNumber(sDate);
        int iHour = DateUtil.getRightNumber(sHour);
        int iMinute = DateUtil.getRightNumber(sMinute);
        return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute);
    }

    public static Date getDate(String sYear, String sMonth, String sDate,
                               String sHour, String sMinute, String sSecond) {
        int iYear = DateUtil.getRightNumber(sYear);
        int iMonth = DateUtil.getRightNumber(sMonth);
        int iDate = DateUtil.getRightNumber(sDate);
        int iHour = DateUtil.getRightNumber(sHour);
        int iMinute = DateUtil.getRightNumber(sMinute);
        int iSecond = DateUtil.getRightNumber(sSecond);
        return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute, iSecond);
    }

    public static Date parseDate(String day, String hour, String minute) {
        Date date = parseDate(day, "yyyy-MM-dd");
        date = addHo(date, hour);
        date = addMi(date, minute);
        return date;
    }

    private static int getRightNumber(String sNumber) {
        try {
            return Integer.parseInt(sNumber);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean isMax(Date date0, Date date1) {
        if (date0 == null || date1 == null) {
            return false;
        }
        if (date0.getTime() > date1.getTime()) {
            return true;
        }
        return false;

    }

    public static Date Max(Date date0, Date date1) {
        if (date0 != null && date1 != null) {
            if (date0.getTime() > date1.getTime()) {
                return date0;
            }
            return date1;
        } else if (date0 != null && date1 == null) {
            return date0;
        } else if (date0 == null && date1 != null) {
            return date1;
        } else {
            return null;
        }
    }

    public static Date Min(Date date0, Date date1) {
        if (date0 != null && date1 != null) {
            if (date0.getTime() < date1.getTime()) {
                return date0;
            }
            return date1;
        } else {
            return null;
        }
    }

    /**
     * 得到两个日期毫秒级差
     *
     * @param date0
     * @param date1
     * @return
     */
    public static long getMillisecondDif(Date date0, Date date1) {
        if (date0 == null || date1 == null) {
            return 0;
        }
        return date0.getTime() - date1.getTime();
    }

    /**
     * 得到两个日期秒级差
     *
     * @param date0
     * @param date1
     * @return
     */
    public static long getSecondDif(Date date0, Date date1) {
        return DateUtil.getMillisecondDif(date0, date1) / 1000;
    }

    /**
     * 得到两个日期分钟差
     *
     * @param date0
     * @param date1
     * @return
     */
    public static long getMinuteDif(Date date0, Date date1) {
        return DateUtil.getSecondDif(date0, date1) / 60;
    }

    /**
     * 得到两个日期小时差
     *
     * @param date0
     * @param date1
     * @return
     */
    public static int getHourDif(Date date0, Date date1) {
        return (int) DateUtil.getMinuteDif(date0, date1) / 60;
    }

    /**
     * 得到两个日期天数差
     *
     * @param date0
     * @param date1
     * @return
     */
    public static int getDayDif(Date date0, Date date1) {
        return (int) DateUtil.getHourDif(date0, date1) / 24;
    }

    /**
     * @param date0
     * @param date1
     * @return
     * @function : 两个日期月份差
     */
    public static int getMonthDif(Date date0, Date date1) {
        int elapsed = 0;
        GregorianCalendar gc0 = (GregorianCalendar) GregorianCalendar.getInstance();
        GregorianCalendar gc1 = (GregorianCalendar) GregorianCalendar.getInstance();

        if (date1.getTime() > date0.getTime()) {
            gc0.setTime(date0);
            gc1.setTime(date1);
        } else {
            gc1.setTime(date0);
            gc0.setTime(date1);
        }
        gc1.clear(Calendar.MILLISECOND);
        gc1.clear(Calendar.SECOND);
        gc1.clear(Calendar.MINUTE);
        gc1.clear(Calendar.HOUR_OF_DAY);
        gc1.clear(Calendar.DATE);

        gc0.clear(Calendar.MILLISECOND);
        gc0.clear(Calendar.SECOND);
        gc0.clear(Calendar.MINUTE);
        gc0.clear(Calendar.HOUR_OF_DAY);
        gc0.clear(Calendar.DATE);

        while (gc0.before(gc1)) {
            gc0.add(Calendar.MONTH, 1);
            elapsed++;
        }
        return elapsed;
    }

    private static Date addDate(Date date, int iArg0, int iDate) {
        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(date);
        canlendar.add(iArg0, iDate);
        return canlendar.getTime();
    }

    /**
     * 日期增加秒
     *
     * @param date      日志
     * @param iSecond   秒
     * @return
     */
    public static Date addSecond(Date date, int iSecond) {
        return addDate(date, Calendar.SECOND, iSecond);
    }

    /**
     * 日期增加分钟
     *
     * @param date      日期
     * @param iMinute   分钟
     * @return
     */
    public static Date addMinute(Date date, int iMinute) {
        return addDate(date, Calendar.MINUTE, iMinute);
    }

    /**
     * 日期增加小时
     *
     * @param date      日期
     * @param iHour     小时
     * @return
     */
    public static Date addHour(Date date, int iHour) {
        return addDate(date, Calendar.HOUR, iHour);
    }

    /**
     * 日期增加天数
     *
     * @param date      日期
     * @param day     天数
     * @return
     */
    public static Date addDay(Date date, Integer day) {
        if (day != null) {
            return addDate(date, Calendar.DAY_OF_MONTH, day);
        }
        return date;
    }

    /**
     * 日期增加月
     *
     * @param date      日期
     * @param iMonth    月
     * @return
     */
    public static Date addMonth(Date date, int iMonth) {
        return addDate(date, Calendar.MONTH, iMonth);
    }

    /**
     * 日期增加年
     *
     * @param date      日期
     * @param iYear     年
     * @return
     */
    public static Date addYear(Date date, int iYear) {
        return addDate(date, Calendar.YEAR, iYear);
    }

    public static Date addSecond(Date date, String sSecond) {
        return addSecond(date, getRightNumber(sSecond));
    }

    public static Date addMi(Date date, String sMinute) {
        return addMinute(date, getRightNumber(sMinute));
    }

    public static Date addHo(Date date, String sHour) {
        return addHour(date, getRightNumber(sHour));
    }

    public static Date addDa(Date date, String sDate) {
        return addDay(date, getRightNumber(sDate));
    }

    public static Date addMo(Date date, String sMonth) {
        return addMonth(date, getRightNumber(sMonth));
    }

    public static Date addYe(Date date, String sYear) {
        return addYear(date, getRightNumber(sYear));
    }

    public static String getDateFormate(Date date, String formate) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
        return simpleDateFormate.format(date);
    }

    public static String get4yMdHmsS(Date date) {
        return getDateFormate(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static String get4yMdHms(Date date) {
        return getDateFormate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String get4yMdHmsNoDash(Date date) {
        return getDateFormate(date, "yyyyMMddHHmmss");
    }

    public static String get4yMdHm(Date date) {
        return getDateFormate(date, "yyyy-MM-dd HH:mm");
    }

    public static String get4yMdHmNoDash(Date date) {
        return getDateFormate(date, "yyyyMMddHHmm");
    }

    public static String get4yMd(Date date) {
        return getDateFormate(date, "yyyy-MM-dd");
    }

    public static String get4yMM(Date date) {
        return getDateFormate(date, "yyyyMM");
    }

    public static String get4yM(Date date) {
        return getDateFormate(date, DATE_FORMAT_YYYYMM);
    }

    public static String get4yHh(Date date) {
        return getDateFormate(date, "hh:mm:ss");
    }

    public static String get4yMdNoDash(Date date) {
        return getDateFormate(date, "yyyyMMdd");
    }

    public static Date parseDateFullYear(String sDate) {
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormate.parse(sDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDate(String sDate, String formate) {
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
        try {
            return sDate == null ? null : simpleDateFormate.parse(sDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 得到时间的部分
     *
     * @param date
     * @param part
     * @return
     */
    public static int getPartOfTime(Date date, String part) {
        Calendar canlendar = Calendar.getInstance();
        canlendar.clear();
        canlendar.setTime(date);
        if (part.equals("year")) {
            return canlendar.get(Calendar.YEAR);
        }
        if (part.equals("month")) {
            return canlendar.get(Calendar.MONTH);
        }
        if (part.equals("date")) {
            return canlendar.get(Calendar.DAY_OF_MONTH);
        }
        if (part.equals("hour")) {
            return canlendar.get(Calendar.HOUR_OF_DAY);
        }
        if (part.equals("minute")) {
            return canlendar.get(Calendar.MINUTE);
        }
        if (part.equals("second")) {
            return canlendar.get(Calendar.SECOND);
        }
        if (part.equals("milliSecond")) {
            return canlendar.get(Calendar.MILLISECOND);
        }
        return -1;
    }

    /**
     * 判断一个日期是不是今天
     *
     * @return
     */
    public static boolean isToday(Date date) {
        if (DateUtil.get4yMd(date).equals(
                DateUtil.get4yMd(Calendar.getInstance().getTime()))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLeapYear(int yearNum) {
        boolean isLeep = false;
        /** 判断是否为闰年，赋值给一标识符flag */
        if ((yearNum % 4 == 0) && (yearNum % 100 != 0)) {
            isLeep = true;
        } else if (yearNum % 400 == 0) {
            isLeep = true;
        } else {
            isLeep = false;
        }
        return isLeep;
    }

    /**
     * 计算某年某月的结束日期
     *
     * @param yearNum
     * @param monthNum
     * @return
     * @throws ParseException
     */
    public static String getYearMonthEndDay(int yearNum, int monthNum)
            throws ParseException {
        String tempYear = Integer.toString(yearNum);
        String tempMonth = Integer.toString(monthNum);
        String tempDay = "31";
        if (tempMonth.equals("1") || tempMonth.equals("3")
                || tempMonth.equals("5") || tempMonth.equals("7")
                || tempMonth.equals("8") || tempMonth.equals("10")
                || tempMonth.equals("12")) {
            tempDay = "31";
        }
        if (tempMonth.equals("4") || tempMonth.equals("6")
                || tempMonth.equals("9") || tempMonth.equals("11")) {
            tempDay = "30";
        }
        if (tempMonth.equals("2")) {
            if (isLeapYear(yearNum)) {
                tempDay = "29";
            } else {
                tempDay = "28";
            }
        }

        String tempDate = tempYear + "-" + tempMonth + "-" + tempDay;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(sdf.parse(tempDate));
        return sDate;
    }

    /**
     * 计算当前日期是星期几(星期日为0)
     *
     * @param strDate
     * @return
     */
    public static int getWeekDay(Date strDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(strDate);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 当前时间是否在 两个时间之间
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean nowIsBetweenDates(Date start, Date end) {
        Date temp = null;
        if (start.getTime() >= end.getTime()) {
            // 换位
            temp = start;
            start = end;
            end = temp;
        }

        long nowTime = System.currentTimeMillis();
        if (nowTime <= start.getTime() || nowTime >= end.getTime()) {
            // 直接返回
            return false;
        }

        return true;
    }

    /**
     * 获取某一天的开始时间 00:00:00.000
     *
     * @param date
     */
    public static Date getStartDateByDate(Date date) {
        Date firstDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        firstDate = cal.getTime();
        return firstDate;
    }

    /**
     * 获取某一天的结束时间 23:99:99.000
     *
     * @param date
     */
    public static Date getEndDateByDate(Date date) {
        Date firstDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
	    cal.set(Calendar.MILLISECOND, 0);
        firstDate = cal.getTime();
        return firstDate;
    }

    /**
     * @param date
     * @return
     * @function : 获取一周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Date firstDay = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        firstDay = addDay(cal.getTime(), 1);
        return firstDay;
    }

    /**
     * @param date
     * @return
     * @function : 获取一周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Date lastDay = null;
        lastDay = addDay(getFirstDayOfWeek(date), 6);
        return lastDay;
    }

    /**
     * 获取日期的年份
     *
     * @param date
     * @return
     */
    public static int getYearByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取日期的月份
     *
     * @param date
     * @return
     */
    public static int getMonthByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = 0;
        month = cal.get(Calendar.MONTH) + 1;
        if (month == 13) {
            month = 1;
        }
        return month;
    }

    /**
     * 获取日期
     *
     * @param date
     * @return
     */
    public static int getDayByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @param date
     * @return
     * @function : 获取小时
     */
    public static int getHourByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @param date
     * @return
     * @function : 获取分钟
     */
    public static int getMinuteByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取某一月的开始时间
     *
     * @param date
     */
    public static Date getStartDateByMonth(Date date) {
        Date firstDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        firstDate = cal.getTime();
        return firstDate;
    }

    /**
     * 获取某一月的结束时间
     *
     * @param date
     */
    public static Date getEndDateByMonth(Date date) {
        Date firstDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        firstDate = cal.getTime();
        return firstDate;
    }

    /**
     * @param date
     * @return
     * @function : 得到日期部分
     */
    public static Date getDatePart(Date date) throws ParseException {
        String strdate = get4yMd(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strdate);
    }

    /**
     * @param dt
     * @function : 根据日期获得星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * @return
     * @function : 获取时间的毫秒数
     */
    public static Long getTimeInMillis(Date date) {
        Calendar cal = Calendar.getInstance();
        Date curDate = null;
        if (date == null) {
            curDate = new Date();
        } else {
            curDate = date;
        }
        cal.setTime(curDate);
        return cal.getTimeInMillis();
    }

    /**
     * @param date
     * @return
     * @function : 获取没有时间部分的日期
     */
    public static Date getDateNoTime(Date date) {
        return getDate(getYearByDate(date), getMonthByDate(date),
                getDayByDate(date));
    }


    public static Date getWeekDate(Date date) {
        Calendar c = toCalendar(date);
        if (c != null) {
            int m = c.get(Calendar.DAY_OF_WEEK);
            if (m - 1 == 0) {
                c.add(Calendar.DAY_OF_WEEK, -6);
            } else {
                c.add(Calendar.DAY_OF_WEEK, -(m - 2));
            }
            DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            df.format(c.getTime());
            return c.getTime();
        } else {
            return null;
        }
    }

    /**
     * Description 获取当前日期（YYYY-MM-DD）
     *
     * @param
     * @return 当前时间
     */
    public static Date newDateToYMD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = sdf.parse(sdf.format(new Date()));
        } catch (Exception e) {
        }
        return time;
    }


}
