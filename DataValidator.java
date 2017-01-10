
/**
 * to check if the entered data is of required form.
 * 
 * @author Vishvas 
 * @version 1.0
 */
public class DataValidator
{
    public static boolean checkCorruptInputFromMemFile(String a[])
    {
       if(a[1].matches("[a-zA-Z]+"))
       {
           if(a[2].equals("true")||a[2].equals("false"))
           {
               return true;
            }
        }
        return false;
    }
    
    public static boolean checkCorruptInputFromSportFile(String a)
    {
        String ar[] = a.split(",");
        if(ar[0].matches("[a-zA-Z]+"))
        {
            try
            {
                double d;
                d = Double.parseDouble(ar[1]);
                d = Double.parseDouble(ar[2]);
                d = Double.parseDouble(ar[3]);
                int x = Integer.parseInt(ar[4]);
                return true;
            }
            catch(NumberFormatException e)
            {
                IOSupport.println("Sport file has corrupted sport fee data.");
            }
        }
        return false;
    }
}
