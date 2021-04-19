package ch.chillihero.util;

/**
 *
 * Class to Convert a int to a String and return the Value for better understanding
 * */
public class convertStatus {
    public static String convert(int status) {
        String statusAsString;
        switch (status) {
            case 0:
                statusAsString = "Open";
                break;
            case 1:
                statusAsString = "In Work";
                break;
            case 2:
                statusAsString = "Done";
                break;
            default:
                statusAsString = "Not a Correct Status";
                break;
        }
        return statusAsString;
    }
}
