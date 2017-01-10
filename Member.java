import java.util.ArrayList;
/**
 * Member class manages the collection of member bookings and sports.
 * 
 * @author Vishvas Handa 
 * @version 1.0
 */
public class Member
{
   private ArrayList<Booking> memberBookings;
   private ArrayList<Sport> playedSports;
   private String memberName;
   private String memberNumber;
   private boolean memberFinancial;
   
   public Member(String memNum,String name, boolean memFinancial)
   {
       this.memberName = name;
       this.memberNumber = memNum;
       this.memberFinancial = memFinancial;
       memberBookings = new ArrayList<Booking>();
       playedSports= new ArrayList<Sport>();
    }
    
    public String setMemberName(String name)
    {
        this.memberName = name;
        return "The member name is updated Successfully.";
    }
    
    public String setMemberFinalcial(boolean memberFinance)
    {
        this.memberFinancial = memberFinancial;
        return "Member financial detail updated successfully";
    }
    
    public String addPlayedSport(Sport newPlayedSport)
    {
        this.playedSports.add(newPlayedSport);
        return "New sport added to the Played Sports list for "+memberName;
    }
    
    public ArrayList<Booking> getAllMemberBookings()
    {
        return this.memberBookings;
    }
    
    public boolean isSportPlayed(Sport s)
    {
        for(Sport sp : playedSports)
        {
            if(sp.equals(s))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Sport> getAllPlayedSports()
    {
        return this.playedSports;
    }
    
    public String getMemberName()
    {
        return this.memberName;
    }
    
    public String getMemberNumber()
    {
        return this.memberNumber;
    }
    
    public boolean getMemberFinancial()
    {
        return this.memberFinancial;
    }
    
    public String deleteBooking(Booking oldBooking)
    {
        Court c = oldBooking.getBookedForCourt();
        if(c.deleteCourtBooking(oldBooking))
        {
            this.memberBookings.remove(oldBooking);
            return "Member and Court booking removed successfully.";
        }
        return "operation failed";
    }
    
    public String addMemberBooking(Booking newBooking)
    {
        this.memberBookings.add(newBooking);
        return "Member Booking added successfully";
    }
    
    
    public String toString()
    {
        return "Member Name: "+memberName+", Number: "+memberNumber+", Finances Paid: "+memberFinancial+".";
    }
    
    public boolean oneBookingPerDayCheck(Booking newBooking)
    {
        for(Booking b:memberBookings)
        {
            if(newBooking.getBookingDate().equals(b.getBookingDate()))
            return false;
        }
        return true;
    }
}
