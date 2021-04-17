package ch.chillihero.util;

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
