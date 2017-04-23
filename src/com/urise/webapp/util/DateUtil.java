package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Dima on 14.04.2017.
 */
public class DateUtil {
   public static LocalDate of(int year, Month month){
       return LocalDate.of(year, month, 1);
   }
}
