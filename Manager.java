import java.util.ArrayList;
/**
 * Manager class helps completing tasks with CMS
 * 
 * @author Vishvas 
 * @version 1.0
 */
public class Manager
{
    private Club c;
    public Manager()
    {
        c = new Club("Swin Club");
    }
    
    public void makeBookingForAMember()
    {
       IOSupport.println("Please follow the following procedure to make booking for a member.");
       IOSupport.println("Please input memberNumber");
       String memberNumber = "313";
       if(c.checkIfMemberExists(memberNumber))
       {
           Member m = c.getMember(memberNumber);
           if(m.getMemberFinancial())
           {
               int i=0;
               ArrayList<Sport> memberSports = m.getAllPlayedSports();
               for(Sport s:memberSports)
               {
                   i++;
                   IOSupport.println(i+". "+s.getSportName());
                }
              IOSupport.println("please select a sport for court booking.");
              int inputNumber=1;
              Sport s = memberSports.get(inputNumber-1);
              IOSupport.println("Please enter details for your booking.");
              IOSupport.println("Please input date (in dd-MM-yyyy format), time(in 24 hr format) and duration of the booking (in minutes)");
              String date="26-04-2015";
              int hours=15, minutes=30, duration = 60;
              if(DataHelper.validateBookingDuration(s,duration) && DataHelper.bookingTimingValidator(hours,minutes,duration))
              {
                  Booking bTemp = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date));
                  if(DataHelper.sameDayBookingCheck(bTemp,m))
                  {
                      if(DataHelper.withinAWeekCheck(bTemp.getBookingDate()))
                      {
                          ArrayList<Court> allCourts = s.getAllCourts();
                          Court court=null; boolean isAvailable=false;
                          for(Court co: allCourts)
                          {
                              if(co.isBookingAvailable(bTemp))
                              {
                                  court = co;
                                  isAvailable = true;
                                  break;
                              }
                      }
                      if(isAvailable)
                      {
                          Booking bNew = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date),m,court);
                          IOSupport.println(court.addCourtBooking(bNew));
                          IOSupport.println(m.addMemberBooking(bNew));
                      }
                      else
                      {
                          IOSupport.println("Booking not available.");
                        }
                    }
                    else
                    {
                        IOSupport.println("Booking can only be seven days in advance.");
                    }
                }
                else
                {
                    IOSupport.println("Only one booking is allowed per day per member.");
                }
            }
            else
            {
                IOSupport.println("Member bookings are allowed from 8.00 hrs to 23.00hrs.");
                IOSupport.println("And booking duration must not excede the maximum time allowed for a sport.");
                IOSupport.println("i.e. 60 minutes for Squash and 120 minutes for Tennis.");
            }
        }
        else
        {
            IOSupport.println("Non financial members can not make a court booking.");
        }
        }
        else
        {
            IOSupport.println("Member does not exist.");
            IOSupport.println("Please input correct member number");
        }
    }
    
    public void showAllMembers()
    {
        ArrayList<Member> members = c.getAllMembers();
        for(Member m : members)
        {
            IOSupport.println(m.toString());
        }
    }
    
    public void showMemberBookings(String memberNo)
    {
        IOSupport.println("Please follow the following procedure to view bookings made for a member.");
        IOSupport.println("give memberNo");
        if(c.checkIfMemberExists(memberNo))
        {
            Member m = c.getMember(memberNo);
            ArrayList<Booking> bookings = m.getAllMemberBookings();
            IOSupport.println("Bookings for "+m.getMemberName()+" are listed below:");
            for(Booking b : bookings)
            {
                IOSupport.println(b.toString());
            }
        }
    }
    
    public void deleteMemberBooking(String memberNo)
    {
        IOSupport.println("Please follow the following procedure to delete booking for a member.");
        if(c.checkIfMemberExists(memberNo))
        {
            Member m = c.getMember(memberNo);
            ArrayList<Booking> bookings = m.getAllMemberBookings();
            IOSupport.println("Bookings for "+m.getMemberName()+" are listed below:");
            int i=0;
            for(Booking b : bookings)
            {
                i++;
                IOSupport.println(i+". "+b.toString());
            }
            IOSupport.println("Select the booking you want to delete.");
            int bookingIndex = 1;
            Booking b = bookings.get(bookingIndex-1);
            IOSupport.println(m.deleteBooking(b));
        }
    }
    
    public void showCourtBookings()
    {
        IOSupport.println("Please follow the following procedure to view all court bookings.");
        IOSupport.println("Sports offered by the club are shown below:");
        ArrayList<Sport> sports = c.getAllSports();
        int i=0;
        for(Sport s : sports)
        {
            i++;
            IOSupport.println(i+". "+s.getSportName());
        }
        IOSupport.println("Please select the sport whose court bookings are to be displayed.");
        int sportSelection = 1;
        Sport s = sports.get(sportSelection-1);
        IOSupport.println("Displaying all available courts for "+s.getSportName());
        ArrayList<Court> courts = s.getAllCourts();
        int j=0;
        for(Court co : courts)
        {
            j++;
            IOSupport.println(i+". Court "+co.getCourtNumber());
        }
        IOSupport.println("Please select the court to view its bookings.");
        int courtSelection =3;
        Court court = courts.get(courtSelection-1);
        IOSupport.println("Displaying all bookings for Court "+court.getCourtNumber());
        ArrayList<Booking> bookings = court.getAllCourtBookings();
        int k=0;
        for(Booking b : bookings)
        {
            k++;
            IOSupport.println(k+". "+b.toStringForCourt());
        }
    }
    
    public void showAvailableCourts()
    {
        IOSupport.println("Please follow the following procedure to make booking for a court of your choice.");
        IOSupport.println("Listing available sports:");
        ArrayList<Sport> sports = c.getAllSports();
        IOSupport.println("Please select a sport whose court availability is to be displayed.");
        int i=0;
        for(Sport s : sports)
        {
            i++;
            IOSupport.println(i+". "+s.getSportName());
        }
        int sportSelect=1;
        Sport s = sports.get(sportSelect-1);
        IOSupport.println("Please enter details of a booking for which court availability is required");
        IOSupport.println("Please input date (in dd-MM-yyyy format), time(in 24 hr format) and duration of the booking (in minutes)");
        String date="26-04-2015";
        int hours=15, minutes=30, duration = 60;
        if(DataHelper.validateBookingDuration(s,duration) && DataHelper.bookingTimingValidator(hours,minutes,duration))
        {
                Booking bTemp = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date));
                //if(DataHelper.sameDayBookingCheck(bTemp,m))
                //{        
                    if(DataHelper.withinAWeekCheck(bTemp.getBookingDate()))
                    {
                      ArrayList<Court> allCourts = s.getAllCourts();
                      ArrayList<Court> availableCourts = new ArrayList<Court>();
                      i=0;
                      for(Court co : allCourts)
                      {
                          if(co.isBookingAvailable(bTemp))
                          {
                              i++;
                              IOSupport.println(i+". Court "+co.getCourtNumber()+" Available!");
                              availableCourts.add(co);
                          }
                      }
                      if(availableCourts.size()<0)
                      {
                      IOSupport.println("Please select the court you wish to book.");
                      int courtSelect = 2;
                      Court court = availableCourts.get(courtSelect-1);
                      IOSupport.println("Please input memberNumber");
                      String memberNumber = "313";
                      if(c.checkIfMemberExists(memberNumber))
                      {
                          Member m = c.getMember(memberNumber);
                          if(m.getMemberFinancial())
                          {
                              if(m.isSportPlayed(s))
                              {
                                  Booking bNew = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date),m,court);
                                  IOSupport.println(court.addCourtBooking(bNew));
                                  IOSupport.println(m.addMemberBooking(bNew));
                                }
                                else
                                {
                                    IOSupport.println("Booking could not be made because you are not enroled in the sport.");
                                }
                            }
                            else
                            {
                                IOSupport.println("Non financial members can not make a court booking.");
                            }
                        }
                        else
                        {
                            IOSupport.println("Member does not exist.");
                            IOSupport.println("Please input correct member number"); 
                        }
                    }
                    else
                    {
                        IOSupport.println("Sorry, No Courts are available for required booking.");
                    }
                }
                else
                {
                    IOSupport.println("Booking can only be seven days in advance.");
                }
        }
        else
        {
            IOSupport.println("Member bookings are allowed from 8.00 hrs to 23.00hrs.");
            IOSupport.println("And booking duration must not excede the maximum time allowed for a sport.");
            IOSupport.println("i.e. 60 minutes for Squash and 120 minutes for Tennis.");
        }
    }
    
    public void makeBlockBooking()
    {
        IOSupport.println("Please follow the following procedure to make a block booking.");
        IOSupport.println("Please enter details for your booking, the required courts will be selected further in the procedure.");
        IOSupport.println("Please input date (in dd-MM-yyyy format), time(in 24 hr format) and duration of the booking (in minutes)");
        String date="26-04-2015";
        int hours=15, minutes=30, duration = 200;
        if(DataHelper.bookingTimingValidator(hours,minutes,duration))
        {
            Booking blockTemp = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date));
            IOSupport.println("Please select the sport of your choice.");
            ArrayList<Sport> sports = c.getAllSports();
            int i=0;
            for(Sport s:sports)
            {
                i++;
                IOSupport.println(i+". "+s.getSportName());
            }
            int sportChoice = 1;
            Sport s = sports.get(sportChoice-1);
            ArrayList<Court> courts = s.getAllCourts();
            i=0;
            for(Court co : courts)
            {
                i++;
                IOSupport.println(i+". "+co.getCourtNumber());
            }
            String [] courtIndexes = {"10","12","15"};
            ArrayList<Court> selectedCourts = new ArrayList<Court>();
            for(int a=0;a<courtIndexes.length;a++)
            {
                for(Court co : courts)
                {
                    if(co.getCourtNumber().equals(courtIndexes[a]))
                    {
                        selectedCourts.add(co);
                    }
                }
            }
            ArrayList<Booking> clashingBookings = new ArrayList<Booking>();
            for(Court co : selectedCourts)
            {
                clashingBookings.addAll(co.blockBookingHelper(blockTemp));
            }
            IOSupport.println("Following are the booking details that are being removed please contact the respective members regarding it.");
            for(Booking b : clashingBookings)
            {
                IOSupport.println(b.toStringForBlockBooking());
                Member m = b.getBookedForMember();
                m.deleteBooking(b);
            }
            for(Court co : selectedCourts)
            {
                Booking blockFinal = new Booking(DataHelper.convertHoursToMinutes(hours,minutes), duration, DataHelper.convertStringToDate(date),co);
                IOSupport.println(co.addCourtBooking(blockFinal));
            }
        }
        else
        {
            IOSupport.println("Bookings are allowed from 8.00 hrs to 23.00hrs.");
        }
    }
}
