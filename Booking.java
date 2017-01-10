import java.util.Date;
/**
 * Booking class defines an booking object and manages its details.
 * 
 * @author Vishvas Handa 
 * @version 1.0
 */
public class Booking
{
   private int bookingStartTime;
   private int bookingDuration;
   private Date bookingDate;
   private Member bookedForMember;
   private Court bookedForCourt;
   
    public Booking(int startTime, int duration, Date date)
    {
        //for creating a temp booking.
        this.bookingStartTime = startTime;
        this.bookingDuration = duration;
        this.bookingDate = date;
    }
    
    public Booking(int startTime, int duration, Date date, Court aCourt)
    {
       this.bookingStartTime = startTime;
       this.bookingDuration = duration;
       this.bookingDate = date;
       this.bookedForCourt = aCourt;
    }
    
    public Booking(int startTime, int duration, Date date, Member aMember, Court aCourt)
    {
       this.bookingStartTime = startTime;
       this.bookingDuration = duration;
       this.bookingDate = date;
       this.bookedForMember = aMember;
       this.bookedForCourt = aCourt;
    }
    
    public Booking(int time, int duration)
    {
        this.bookingStartTime=time;
        this.bookingDuration = duration;
    }
    
    public int getBookingStartTime()
    {
        return this.bookingStartTime;
    }
    
    public int getBookingDuration()
    {
        return this.bookingDuration;
    }
    
    public Date getBookingDate()
    {
        return this.bookingDate;
    }
    
    public Court getBookedForCourt()
    {
        return this.bookedForCourt;
    }
    
    public Member getBookedForMember()
    {
        return this.bookedForMember;
    }
    
    public String toString()
    {
        return "Booking details- Date: "+this.bookingDate+",Start Time: "+this.bookingStartTime+", Booking Duration: "+bookingDuration+" Court: "+bookedForCourt.getCourtNumber()+".";
    }
    
    public String toStringForCourt()
    {
        return "Booking details- Date: "+this.bookingDate+",Start Time: "+this.bookingStartTime+", Booking Duration: "+bookingDuration+" Member name: "+bookedForMember.getMemberName()+".";
    }
    
    public String toStringForBlockBooking()
    {
        return "Member Name: "+this.bookedForMember.getMemberName()+" Member Number: "+this.bookedForMember.getMemberNumber()+", Booking Date: "+this.bookingDate+",Start Time: "+this.bookingStartTime+", Booking Duration: "+bookingDuration+" Court: "+bookedForCourt.getCourtNumber()+".";
    }
    
}
