import java.util.*;
import java.text.SimpleDateFormat;
/**
 * The class is aimed to do data conversion and checks etc.
 * 
 * @author Vishvas 
 * @version 1.0
 */
public class DataHelper
{
    public static Date convertStringToDate(String str)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
        Date d = format.parse(str);
        return d;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
        
    }
    
    public static boolean sameDayBookingCheck(Booking tempBooking, Member m)
    {
        ArrayList<Booking> memberBookings = m.getAllMemberBookings();
        for(Booking b : memberBookings)
        {
            if(tempBooking.getBookingDate().equals(b.getBookingDate()))
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean withinAWeekCheck(Date newDate)
    {
       Date d = new Date();
       if(newDate.after(d))
       {
           Calendar cal = Calendar.getInstance(); 
           cal.setTime(d); 
           cal.add(Calendar.DATE, 7);
           d = cal.getTime();
           if(newDate.before(d))
           return true;
        }
       return false;
    }
    
    public static boolean validateBookingDuration(Sport playedSport, int minutes)
    {
        if(minutes<=playedSport.getSportTimeLimit())
        return true;
        else
        return false;
    }
    
    public static int convertHoursToMinutes(int hours, int minutes)
    {
        int storageMinutes = hours*60+minutes;
        return storageMinutes;
    }
    
    public static String convertMinutesToHours(int minutes)
    {
        int displayHours,displayMinutes;
        displayHours = minutes/60;
        displayMinutes = minutes%60;
        return "Time: "+displayHours+"."+displayMinutes;
    }
    
    public static boolean bookingTimingValidator(int hours, int minutes, int duration)
    {
        //to chech if time is within court timings.
        int startTime = convertHoursToMinutes(hours,minutes);
        int endTime = startTime+duration;
        if(startTime>=480 || endTime <= 1380)
        return true;
        else
        return false;
    }
   }
