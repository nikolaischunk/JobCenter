package ch.chillihero.util;

import ch.chillihero.Person;

public class convertPerson {

    public static String convert(Person person) {
        if (person == null) {
            return "No person set";
        } else {
            return person.getFirstname() + " " + person.getLastname();
        }
    }

}
