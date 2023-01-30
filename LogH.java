public class LogH {

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    public static final String RESET = "\u001B[0m";
    
    public static void log(String s) {
        String time = TimeH.getTimeInFormat("HH:mm:ss");
        System.out.println("[" + toRed(time) + "]: " + s);
    }
    
    public static void lineBreak() {
        System.out.println("");
    }
    
    public static String toBlack(String s) {
        return BLACK + s + RESET;
    }
    
    public static String toRed(String s) {
        return RED + s + RESET;
    }
    
    public static String toGreen(String s) {
        return GREEN + s + RESET;
    }
    
    public static String toYellow(String s) {
        return YELLOW + s + RESET;
    }
    
    public static String toBlue(String s) {
        return BLUE + s + RESET;
    }
    
    public static String toPurple(String s) {
        return PURPLE + s + RESET;
    }
    
    public static String toCyan(String s) {
        return CYAN + s + RESET;
    }
    
    public static String toWhite(String s) {
        return WHITE + s + RESET;
    }
    
    

}
