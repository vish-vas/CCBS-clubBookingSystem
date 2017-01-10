import java.util.ArrayList;
/**
 * Sport class defines a sport object and manages the collection of courts assigned to a sport.
 * 
 * @author Vishvas Handa 
 * @version 1.0
 */
public class Sport
{
   private String sportName;
   private double usageFee;
   private double insuranceFee;
   private double affiliationFee;
   private int sportTimeLimit;
   private ArrayList<Court> allocatedCourts = new ArrayList<Court>();
   
    public Sport(String str)
    {
        String [] ar = str.split(",");
        this.sportName = ar[0];
        this.usageFee = Double.parseDouble(ar[1]);
        this.insuranceFee = Double.parseDouble(ar[2]);
        this.affiliationFee = Double.parseDouble(ar[3]);
        this.sportTimeLimit = Integer.parseInt(ar[4]);
        for(int i=5; i<ar.length; i++)
        {
            this.allocatedCourts.add(new Court(ar[i]));
        }
    }
    
    public Sport(String name, double usage, double insurance, double affiliation, int timeLimit)
    {
       this.sportName = name;
       this.usageFee = usage;
       this.insuranceFee = insurance;
       this.affiliationFee = affiliation;
       this.sportTimeLimit = timeLimit;
       
    }
    
    public String addCourt(Court newCourt)
    {
       this.allocatedCourts.add(newCourt);
       return "Successfully added new court "+newCourt.getCourtNumber()+" for "+this.sportName+".";
    }
   
    public ArrayList<Court> getAllCourts()
    {
       return this.allocatedCourts;
    }
   
    public String getSportName()
    {
       return this.sportName;
    }
    
    public int getSportTimeLimit()
    {
        return this.sportTimeLimit;
    }
    
    public String toString()
    {
        return " Sport: "+this.sportName+" has "+allocatedCourts.size()+" courts and maximum time for its court booking is "+this.sportTimeLimit+" hour/s.";
    }
}
