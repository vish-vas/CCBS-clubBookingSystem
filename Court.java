import java.util.ArrayList;
/**
 * Court class manages a collection of court bookings for each court object.
 * 
 * @author Vishvas Handa 
 * @version 1.0
 */
public class Court
{
   private String courtNumber;
   private ArrayList<Booking> courtBookings;
   
    public Court(String number)
    {
       this.courtNumber = number;
       courtBookings = new ArrayList<Booking>();
    }
    
    public String getCourtNumber()
    {
        return this.courtNumber;
    }
    
    public ArrayList<Booking> getAllCourtBookings()
    {
        return this.courtBookings;
    }
    
    
    
    public boolean isBookingAvailable(Booking tempBooking)
    {
        int ts, te, bs, be;
        //tempStartTime, tempEndTime, bookingStartTime, bookingEndTime.
        ts = tempBooking.getBookingStartTime();
        te = ts+tempBooking.getBookingDuration();
        for(Booking b : courtBookings)
        {
            if(tempBooking.getBookingDate().equals(b.getBookingDate()))
            {
                bs = b.getBookingStartTime();
                be = b.getBookingDuration()+bs;
                if(ts<=bs && te>=bs || ts<=be && te>=be || ts>bs && te<be || ts<bs && te>be || ts==bs && te==be)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public ArrayList<Booking> blockBookingHelper(Booking blockBooking)
    {
        ArrayList<Booking> foundBookings = new ArrayList<Booking>();
        int ts, te, bs, be;
        //tempStartTime, tempEndTime, bookingStartTime, bookingEndTime.
        ts = blockBooking.getBookingStartTime();
        te = ts+blockBooking.getBookingDuration();
        for(Booking b : courtBookings)
        {
            if(blockBooking.getBookingDate().equals(b.getBookingDate()))
            {
                bs = b.getBookingStartTime();
                be = b.getBookingDuration()+bs;
                if(ts<=bs && te>=bs || ts<=be && te>=be || ts>bs && te<be || ts<bs && te>be || ts==bs && te==be)
                {
                    foundBookings.add(b);
                }
            }
        }
        return foundBookings;
    }
    
    public String addCourtBooking(Booking newBooking)
    {
        if(this.courtBookings.add(newBooking))
        return "Court Booking added successfully.";
        else
        return "Court Booking failed!";
    }
    
    public boolean deleteCourtBooking(Booking oldBooking)
    {
        if(this.courtBookings.remove(oldBooking))
        return true;
        else
        return false;
    }
}
