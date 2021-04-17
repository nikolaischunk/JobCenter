package ch.chillihero.util;

import java.util.UUID;

public class uuidGenerator {
    public static String generate() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }
}