package io.github.pactstart.commonutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static final String STANDARD_TIME_FORMAT = "yyyy:MM:dd HH:mm:ss";
    public static final String STANDARD_DATE_FORMAT = "yyyy:MM:dd";
    public static final String STANDARD_DATE_FORMAT2 = "yyyy-MM-dd";
    public static final String STANDARD_TIME_FORMAT2 = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_TIME_FORMAT3 = "yyyy-MM-dd HH:mm";
    public static final String STANDARD_MONTH_FORMAT = "yyyy-MM";
    public static final String ISO_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static String getWeekByDate(Date date) {
        int w = getWeekInt(date) - 1;
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }

    public static int getWeekInt(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(7);
        return w;
    }

    public static int getDayNum(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(5);
    }

    public static Date getToday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Long getTodayTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTimeInMillis();
    }

    public static Date getYesterday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, -1);
        return cal.getTime();
    }

    public static Date getThisWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayWeek = cal.get(7);
        if (dayWeek == 1) {
            cal.add(5, -1);
        }
        cal.set(7, 2);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 1);
        return cal.getTime();
    }

    public static Date getThisWeekEnd(Date date) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);
        currentDate.setFirstDayOfWeek(2);
        currentDate.set(11, 23);
        currentDate.set(12, 59);
        currentDate.set(13, 59);
        currentDate.set(7, 1);
        return currentDate.getTime();
    }

    public static Date getThisMonthDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 2);
        return cal.getTime();
    }

    public static Date getThisMonthLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.add(2, 1);
        cal.add(5, -1);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        return cal.getTime();
    }

    public static Date getThisSeasonDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(2);
        int season = (month + 1 + 4) / 4;
        switch (season) {
            case 1:
                cal.set(2, 0);
                break;
            case 2:
                cal.set(2, 3);
                break;
            case 3:
                cal.set(2, 6);
                break;
            case 4:
                cal.set(2, 9);
                break;
            default:
                break;
        }

        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 3);
        return cal.getTime();
    }

    public static Date getThisYearDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(6, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 4);
        return cal.getTime();
    }

    public static Date getLastSevenDays(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(6, -7);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getLastDays(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(6, n);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static int getWeekOfDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(3);
    }

    public static String getDateStr(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date getStandardStringDate(String strDate) {
        return getStringDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getStringDate(String strDate, String strType) {
        Date date = null;

        SimpleDateFormat objSDF = new SimpleDateFormat(strType);
        try {
            date = objSDF.parse(strDate);
        } catch (Exception e) {
        }
        return date;
    }

    public static String currTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static Date min(Date end, Date now) {
        int compare = end.compareTo(now);
        return compare > 0 ? now : end;
    }

    public static Date getLastSencond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);

        return cal.getTime();
    }

    public static Date getCurrDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getLastMilliSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        cal.set(14, 999);

        return cal.getTime();
    }

    public static Date getYesterdayStartTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, -1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);

        return cal.getTime();
    }

    public static Date getYesterdayEndMillSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, -1);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        cal.set(14, 999);

        return cal.getTime();
    }

    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date randomDate(Date start, Date end) {
        try {
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));

        if ((rtn == begin) || (rtn == end)) {
            return random(begin, end);
        }
        return rtn;
    }

    public static Date add(Date date, int type, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, value);
        return calendar.getTime();
    }

    public static Date dateAddMonth(Date date, int month) {
        return add(date, 2, month);
    }

    public static Date dateAddDay(Date date, int day) {
        return add(date, 6, day);
    }

    public static Date dateAddYear(Date date, int year) {
        return add(date, 1, year);
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static boolean isEqualsDate(Date dateSrc, Date dateDesc, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(dateSrc).equals(dateFormat.format(dateDesc));
    }

    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(5, 1);
        a.roll(5, -1);
        int maxDate = a.get(5);
        return maxDate;
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy:MM:dd HH:mm:ss");
    }

    public static String formatDate(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
        return null;
    }

    public static Long getTimestamp(String date) {
        return Long.valueOf(getStandardStringDate(date).getTime());
    }

    public static int getMaxDateByYearAndMonth(int year, int month) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.set(1, year);
        cal.set(2, month - 1);
        return cal.getActualMaximum(5);
    }

    public static Date getNatureMonthDate(Date date, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.add(2, monthNum);
        cal.add(5, -1);
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        return cal.getTime();
    }

    public static int daysBetween(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
        } catch (ParseException e) {
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();

        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();

        long between_days = (time2 - time1) / 86400000L;

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *  解析UTC时间格式的字符串为Date
     * @param utcTime 格式"2017-09-07T04:35:53Z"
     * @return 日期
     * @throws ParseException 解析异常
     */
    public Date parseUTC(String utcTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.parse(utcTime);
    }
}