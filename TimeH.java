
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeH {

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static boolean didTimePass(long lastTime, int duration) {
        return (System.currentTimeMillis() - lastTime > duration);
    }

    public static boolean didTimePass(long nowTime, long lastTime, long duration) {
        return (nowTime - lastTime > duration);
    }

    public static long getTimePassed(long lastTime) {
        return System.currentTimeMillis() - lastTime;
    }

    public static long getTimePassed(long nowTime, long lastTime) {
        return nowTime - lastTime;
    }

    public static String getTimeInFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static long[] calcTimeFromDelta(long time) {
        long hours = time / (60000 * 60);
        long mins = (time % (60000 * 60)) / 60000;
        long secs = (time % 60000) / 1000;
        long ms = time % 1000;
        return new long[]{ms, secs, mins, hours};
    }

//    public static int getSecondsFromMS(long time) {
//        return nowTime - lastTime;
//    }
    public static int getSeconds(Date date) {
        return date.getSeconds();
    }

    public static int getMinutes(Date date) {
        return date.getMinutes();
    }

    public static int getHours(Date date) {
        return date.getHours();
    }

    public static int getDay(Date date) {
        return date.getDay();
    }

    public static int getMonth(Date date) {
        return date.getMonth();
    }

    public static int getYear(Date date) {
        return date.getYear();
    }
}
