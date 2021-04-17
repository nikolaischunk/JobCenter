package ch.chillihero.util;

import java.util.Random;

public class AutoIncrement {
    private static int ID;

    public static String generate() {
        ID = new Random().nextInt(10000);
        return String.valueOf(ID);
    }
}
