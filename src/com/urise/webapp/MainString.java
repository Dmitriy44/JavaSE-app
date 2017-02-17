package com.urise.webapp;

/**
 * Created by Dima on 14.02.2017.
 */
public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5"};
//        String result = "";
        StringBuffer sb = new StringBuffer();
        for (String str : strArray) {
            sb.append(str).append(", ");
        }
        System.out.println(sb.toString());

        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab" + str3).intern();
        System.out.println(str1 == str2);
    }
}
