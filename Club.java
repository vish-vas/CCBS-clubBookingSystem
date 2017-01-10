import java.util.ArrayList;
/**
 * Club class manages the collection of members and sports.
 * 
 * @author Vishvas Handa 
 * @version 1.0
 */
public class Club
{
    private ArrayList<Member> listOfMembers;
    private ArrayList<Sport> listOfSports;
    private String clubName;
  
    public Club(String name)
    {
      this.clubName = name;
      listOfMembers = new ArrayList<Member>();
      listOfSports = new ArrayList<Sport>();
      try
      {
      this.getSportDataFromFile();
      this.getMemberDataFromFile();
      }
      catch(Exception e)
      {
      System.out.println(e);
      }
    }
  
    public String addMember(Member newMember)
    {
      this.listOfMembers.add(newMember);
      return "Successfully added member "+newMember.getMemberName();
    }
    
    public Boolean checkIfMemberExists(String memberID)
    {
        for(Member m : listOfMembers)
        {
            if(m.getMemberNumber().equals(memberID))
            return true;
        }
        return false;
    }
    
    public Member getMember(String memberID)
    {
        for(Member m : listOfMembers)
        {
            if(m.getMemberNumber().equals(memberID))
            return m;
        }
        return null;
    }
    
    public String deleteMember(Member oldMember)
    {
        String memName = oldMember.getMemberName();
        this.listOfMembers.remove(oldMember);
        return "Member :"+memName+" removed from the Member list.";
    }
    
    public ArrayList<Member> getAllMembers()
    {
        return this.listOfMembers;
    }
    
    public String addSport(Sport newSport)
    {
        if(this.listOfSports.add(newSport))
        return "Successfully added sport "+newSport.getSportName();
        else
        return "Adding new sport failed";
    }
    
    public ArrayList<Sport> getAllSports()
    {
        return this.listOfSports;
    }
    
    public boolean isSportAvailable(String name)
    {
        for(Sport s : listOfSports)
        {
            if(s.getSportName().equals(name))
            return true;
        }
        return false;
    }
    
    public Sport getSport(String sporrtName)
    {
        for(Sport s : listOfSports)
        {
            if(s.getSportName().equals(sporrtName))
            return s;
        }
        return null;
    }
    
    public String getClubName()
    {
        return this.clubName;
    }
    
    public String toString()
    {
        return "Club "+this.clubName+" offers "+this.listOfSports.size()+" sports and has "+this.listOfMembers.size()+" members.";
    }
    
    public void getMemberDataFromFile() throws Exception
    {
        ArrayList<String> fileData = IOSupport.readDataFromFile("Members.txt");
        for(String s : fileData)
        {
            String [] ar = s.split(",");
         
                if(DataValidator.checkCorruptInputFromMemFile(ar))
                {
                    Member m = new Member(ar[0],ar[1],Boolean.parseBoolean(ar[2]));
                    for(int i = 3; i<ar.length;i++)
                    {
                        if(this.isSportAvailable(ar[i]))
                        {
                            m.addPlayedSport(this.getSport(ar[i]));
                        }
                    }
                    listOfMembers.add(m);
                }
                else 
                {
                    IOSupport.println("Corrupted data entry in Members.txt : "+ar[0]+", "+ar[1]+", "+ar[2]);
                    IOSupport.println("Corrupted data removed from database.");
                }
        }
    }
    
    public void getSportDataFromFile() throws Exception
    {
        ArrayList<String> fileData = IOSupport.readDataFromFile("Sports.txt");
        for(String s : fileData)
        {
            if(DataValidator.checkCorruptInputFromSportFile(s))
            {
                listOfSports.add(new Sport(s));
            }
            else
            {
                IOSupport.println("Corrupt Data entry in Sport.txt : "+s);
            }
        }
    }
}
