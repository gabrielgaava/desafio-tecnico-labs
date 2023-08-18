package org.com.labs.utils;

public abstract class FormatUtils {

    public static String formatRawDate(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);

        return year + "-" + month + "-" + day;
    }

    public static String tabs(int num) {
        StringBuilder tab = new StringBuilder();
        tab.append("\t".repeat(Math.max(0, num)));

        return tab.toString();
    }

}
