package com.urise.webapp;

/**
 * Created by Dima on 05.03.2017.
 */
public class MainUtil {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1));
        System.out.println(Integer.valueOf(-1) == new Integer(-1));
        int result = getInt();
        System.out.println(result);
    }


    private static Integer getInt() {
        return -1;
    }
}
