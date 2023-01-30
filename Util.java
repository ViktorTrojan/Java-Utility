public class Util {
    
    public static void sleep(int ms) {
        if (ms < 0) ms = 0;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // restore interrupted thread
            Thread.currentThread().interrupt();
        }
    }
}
