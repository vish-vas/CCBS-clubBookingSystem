import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class IOSupport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IOSupport
{
    public static ArrayList<String> readDataFromFile(String fileName)
    {
       ArrayList<String> fileData = new ArrayList<String>();
       try
       {
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
       
       String temp = reader.readLine();
       while(temp!=null)
       {
           fileData.add(temp);
           temp = reader.readLine();
       }
       reader.close();
       }
       catch(FileNotFoundException e)
       {
           System.out.println("Database file Not Found");
        }
        catch(IOException e)
        {
            System.out.println("File Empty");
        }
       return fileData;
    }
    
    public static void saveDataToFile(String fileName, ArrayList<String> fileData)
    {
        try
        {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for(String s : fileData)
        {
            writer.println(s);
        }
        writer.close();
        }
        catch (IOException e)
        {
        System.out.println("Error saving to file.");
        }
    }
    
    public static void println(String print)
    {
        System.out.println(print);
    }
}
