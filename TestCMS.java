
/**
 * TestCMS class is aimed to test all the features of the Club Management System.
 * 
 * @author Vova 
 * @version 1.0
 */
public class TestCMS
{
    public static void main(String ar[])
    {
        Manager ma = new Manager();
        ma.showAllMembers();
        ma.showAvailableCourts();
        ma.showAllMembers();
    }
}
