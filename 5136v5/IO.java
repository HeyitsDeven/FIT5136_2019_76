import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class input here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IO
{
    
    
    public IO()
    {
    }


    public void save(String filename,String string)
    {
        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            try
            {

                outputFile.println(string);
            }
            finally
            {
                outputFile.close();
            }
        }
        catch(FileNotFoundException exeption)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        } 

    }

    public ArrayList read(String filename)
    {
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner input = new Scanner(inputFile);
                ArrayList<String> temps;
                temps = new ArrayList<>();
                while(input.hasNextLine())
                {
                    String temp = input.nextLine();
                    temps.add(temp);
                }
                return temps;
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        } 
        return null;
    }

    public void saveCustomer(ArrayList<String> list)
    {
        
        StringBuffer string = new StringBuffer();
        for(int i= 0; i < list.size(); i++)
        {
           string.append(list.get(i) + "\r");
        }
        save("CustomerAccount.TXT",string.toString());
    }
    
    public ArrayList<String> readCustomer()
    {
        return read("CustomerAccount.TXT");
    }
        
    public void saveOwner(ArrayList<String> list)
    {

        StringBuffer string = new StringBuffer();
        for(int i= 0; i < list.size(); i++)
        {
           string.append(list.get(i) + "\r");
        }

        save("OwnerAccount.TXT",string.toString());
    }
    
    public ArrayList<String> readOwner()
    {
        return read("OwnerAccount.TXT");
    }

    public void saveHall(ArrayList<String> list)
    {
        StringBuffer string = new StringBuffer();
        for(int i= 0; i < list.size(); i++)
        {
           string.append(list.get(i) + "\r");
        }
        save("HallDetail.TXT",string.toString());
    }
    
    public ArrayList<String> readHall()
    {
        return read("HallDetail.TXT");
    }

    public void saveQuotation(ArrayList<String> list)
    {
        StringBuffer string = new StringBuffer();
        for(int i= 0; i < list.size(); i++)
        {
           string.append(list.get(i) + "\r");
        }
        save("QuotationDetail.TXT",string.toString());
    }
    
    public ArrayList<String> readQuotation()
    {
        return read("QuotationDetail.TXT");
    }
    
    
    
        // public void saveDate(ArrayList<String> list)
    // {
        // StringBuffer string = new StringBuffer();
        // for(int i= 0; i < list.size(); i++)
        // {
           // string.append(list.get(i) + "\r");
        // }
        // save("Date.TXT",string.toString());
    // }
    
    // public ArrayList<String> readDate()
    // {
        // return read("Date.TXT");
    // }

    
}

