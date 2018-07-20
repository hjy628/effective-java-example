package chap2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonBad {

    private final Date birthDate = new Date();

    //other fields,methods,and constructor omitted.
    //don't  do this

    public  boolean isBabyBoomer(){
        // Unnecessary allocation of expensive object
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        Date boomEnd = gmtCal.getTime();

        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;

    }




}
