package org.me.mmlogo.utils;

public class DrawUtils {

    public static String drawSequence(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
