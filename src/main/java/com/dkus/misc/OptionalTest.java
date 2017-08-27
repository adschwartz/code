package com.dkus.misc;

import java.util.Date;
import java.util.Optional;

/**
 * @author aschwartz on 3/23/16.
 */

public class OptionalTest {

    public OptionalTest() {

        Optional<Date> date = Optional.ofNullable(null);
        System.out.println(date.map(Date::toInstant));

        Optional<Date> date2 = Optional.ofNullable(new Date());
        System.out.println(date2.map(Date::toInstant));
    }

    public static void main(String[] args) {
        OptionalTest o = new OptionalTest();
    }
}
