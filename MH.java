
import java.util.Random;

// MATHHELPER CLASS
public class MH {

    public static float sin(float val) {
        return (float) Math.sin(toRAD(val));
    }

    public static float cos(float val) {
        return (float) Math.cos(toRAD(val));
    }

    public static float tan(float val) {
        return (float) Math.tan(toRAD(val));
    }

    public static float asin(float val) {
        return (float) toDEG((float) Math.asin(val));
    }

    public static float acos(float val) {
        return (float) toDEG((float) Math.acos(val));
    }

    public static float atan(float val) {
        return (float) toDEG((float) Math.atan(val));
    }

    public static float atan2(float y, float x) {
        return (float) toDEG((float) Math.atan2(y, x));
    }

    public static float toRAD(float val) {
        //return (float) (val * (Math.PI / 180f));
        return (float) Math.toRadians(val);
    }

    public static float toDEG(float val) {
        //return (float) (val * (180f / Math.PI));
        return (float) Math.toDegrees(val);
    }

    public static float abs(float val) {
        return Math.abs(val);
    }

    public static float len(float x, float y) {
        return (float) Math.sqrt(x * x + y * y);
    }

    public static float len3(float x, float y, float z) {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public static float clamp(float d, float min, float max) {
        return Math.min(Math.max(d, min), max);
    }

    public static int clamp(int d, int min, int max) {
        return Math.min(Math.max(d, min), max);
    }

    public static float min(float a, float b) {
        return Math.min(a, b);
    }

    public static float max(float a, float b) {
        return Math.max(a, b);
    }

    // round to some decimal places round(10.221, 1) = 10.2
    public static float round(float num, int dez) {
        float dezNum = (float) Math.pow(10, dez);
        return Math.round(num * dezNum) / dezNum;
    }

    public static float random(float min, float max) {
        return (float) (Math.random() * (max - min)) + min;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    // a distribution of random values in float where for e.g 180 is the most common
    public static float gaussianRandom(float val, float strength, float min, float max) {
        Random r = new Random();

        float value = (float) (r.nextGaussian() * strength + val);
        return MH.clamp(value, min, max);
    }

    public static float lerp(float pA, float pB, float t) {
        return pA + t * (pB - pA);
    }

    // normalize value to 0-1
    public static float normalize(float val, float min, float max) {
        float delta = max - min;
        float deltaVal = val - min;
        return deltaVal / delta;
    }

    // normalize vector
    public static float[] normalize(float x, float y) {
        float len = MH.len(x, y);
        x /= len;
        y /= len;
        return new float[]{x, y};
    }
}
