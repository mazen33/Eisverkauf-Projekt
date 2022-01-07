public class Colored {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void blue(String str) {
        System.out.print(ANSI_BLUE + str + ANSI_RESET);
    }

    public static void red(String str) {
        System.out.print(ANSI_RED + str + ANSI_RESET);
    }

    public static void yellow(String str) {
        System.out.print(ANSI_YELLOW + str + ANSI_RESET);
    }

    public static void purple(String str) {
        System.out.print(ANSI_PURPLE + str + ANSI_RESET);
    }

    public static void green(String str) {
        System.out.print(ANSI_GREEN + str + ANSI_RESET);
    }

    public static void cyan(String str) {
        System.out.print(ANSI_CYAN + str + ANSI_RESET);
    }


    /********** background ***********/

    public static void bkRed(String str){
        System.out.println(ANSI_RED_BACKGROUND + ANSI_WHITE + str + ANSI_RESET);
    }

}
