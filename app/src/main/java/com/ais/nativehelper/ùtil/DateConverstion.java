package com.ais.nativehelper.ùtil;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateConverstion {
    public static Date StringToDate1(String date1 ){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
       // sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        try {

            Date date = sdf.parse(date1.split("\\.")[0]);

            return date;
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return null;

    }


    public static String StringToDate(String time ) {

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        //Date date = sdf.parse("2013-01-09T19:32:49.103+05:30");
        Date date1;
        try {
            date1 = sdf.parse(time);
            sdf.setTimeZone(TimeZone.getTimeZone("IST"));
            //System.out.println(sdf.format(date1));

            Date date =new Date();
            //System.out.println(sdf.format(date));
            //DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

            // getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
            long diff = date.getTime() - date1.getTime();

            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));


            int diffhours = (int) (diff / (60 * 60 * 1000));


            int diffmin = (int) (diff / (60 * 1000));


            int diffsec = (int) (diff / (1000));
            //System.out.println("difference between seconds: " + crunchifyFormatter.format(diffsec));

            //System.out.println("difference between milliseconds: " + crunchifyFormatter.format(diff));

            if(diffDays>0) {
                // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                // DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                //DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
                //DateFormat df4 = new SimpleDateFormat("MM dd, yyyy");
                DateFormat df5 = new SimpleDateFormat("E,dd MMM yyyy");
                //DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");



                return df5.format(date1);


            }
            else if (diffsec<60 && diffsec> 0) {
                return ""+diffsec+" sec";

            }
            else if(diffmin<60 && diffmin> 0)
            {
                return ""+diffmin+" m";
            }
            else if(diffhours<24 && diffhours> 0)
            {
                return ""+diffhours+"h";
            }

            else {
                DateFormat df5 = new SimpleDateFormat("E,dd MMM yyyy");
                return df5.format(date1);
            }



        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;

    }


    public static String shopdateConversion(Date date)
    {

        //Displaying current time in 12 hour format with AM/PM
        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(date);
        //System.out.println("Current time in AM/PM: "+dateString);



       /* //Displaying current date and time in 12 hour format with AM/PM
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        String dateString2 = dateFormat2.format(new Date()).toString();
        System.out.println("Current date and time in AM/PM: "+dateString2);*/

        return dateString;

    }


    //CALCULATING TIME DAY DEFRENCE
    public static int diffrenceDate(Date date) {
        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        SimpleDateFormat serverSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat localSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        serverSDF.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        localSDF.setTimeZone(TimeZone.getDefault());
        SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");




        try {
            // Use parse method to get date object of both dates
            Date date1 = obj.parse(getcurrentDateAndTime());
            Date date2 = obj.parse(date.toString());
            // Calucalte time difference in milliseconds
            // Calucalte time difference in milliseconds
            long time_difference = date2.getTime() - date1.getTime();
            // Calucalte time difference in days
            long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
            // Calucalte time difference in years
            long years_difference = (time_difference / (1000l * 60 * 60 * 24 * 365));
            // Calucalte time difference in seconds
            long seconds_difference = (time_difference / 1000) % 60;
            // Calucalte time difference in minutes
            long minutes_difference = (time_difference / (1000 * 60)) % 60;

            // Calucalte time difference in hours
            long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
            // Show difference in years, in days, hours, minutes, and seconds


            if(days_difference>=1)
            {
                Log.e("test8888888888",""+days_difference);
                return (int) days_difference;
            }
            else
            {
                return 0;
            }

        }
        // Catch parse exception
        catch (ParseException excep) {
            excep.printStackTrace();
            return 2;
        }


    }



    public static String getcurrentDateAndTime(){

        Date c = Calendar.getInstance().getTime();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = simpleDateFormat.format(c);
        return formattedDate;
    }

}
