
import java.util.ArrayList;

/**
 * Write a description of class ListOfHalls here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfHalls
{

    private ArrayList<Hall> halls;

    public ListOfHalls()
    {
        halls = new ArrayList<>();
    }

    public ListOfHalls(ArrayList newHalls)
    {
        halls = newHalls;

    }
    
    
    public void addHall(String newName, String newDescription, boolean newAvailability, double newConcession, 
                            double newDiscount, double newDiposit, double newRent, int newCapacity, String newLocation, 
                            String newOwnerName, String newBookedDates, String newFeedback, double newAdminDiscount)
    {
        Hall hall = new Hall(newName, newDescription, newAvailability, newConcession, newDiscount, 
                            newDiposit, newRent, newCapacity, newLocation, newOwnerName, newBookedDates,newFeedback, newAdminDiscount);
        halls.add(hall);
    }
    
    public void loadHall(String[] detail) throws Exception
    {
        Hall hall = new Hall(detail[0],detail[1],Boolean.valueOf(detail[2]),Double.parseDouble(detail[3]),
                                  Double.parseDouble(detail[4]),Double.parseDouble(detail[5]),
                                  Double.parseDouble(detail[6]),Integer.parseInt(detail[7]),detail[8],detail[9],detail[10], detail[11], Double.parseDouble(detail[12]));
        halls.add(hall);
    }
    
    public ArrayList<String> getNames()
    {
        ArrayList names = new ArrayList();
        
        for(int i = 0; i < halls.size();i++)
        {
            names.add(halls.get(i).getName());
        }
        return names;
    }
    
    
    public ArrayList<String> getLocations()
    {
        ArrayList locations = new ArrayList();
        
        for(int i = 0; i < halls.size();i++)
        {
            locations.add(halls.get(i).getLocation());
        }
        return locations;

    }
    
    public ArrayList<Integer> searchByDate(String startDateString, String endDateString)
    {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < halls.size();i++)
        {
            if(!halls.get(i).ifDateBooked(startDateString,endDateString))
                index.add(i);
        }
        return index;
    }
    
    public void setAllDiscount(double discount)
    {
        
        for(int i = 0; i < halls.size(); i++) 
            {
                setAdminDiscount(i,discount);
            }
    
    }
   
    
    public void setDate(int index,String startDateString, String endDateString)
    {
       halls.get(index).setDate(startDateString, endDateString);
    }
    
    public boolean isBefore(String startDateString, String endDateString)
    {
        if(halls.size() > 0)
        {
            return halls.get(0).isBefore(startDateString,endDateString);
        }
        else
        {
            System.out.println("no hall available");
            return true;
        }
    }
     
    public ArrayList<String> getDetail()
    {
        ArrayList detail = new ArrayList();
        
        for(int i = 0; i < halls.size();i++)
        {
            detail.add(halls.get(i).getDetail());
        }
        return detail;
    }
    
    public void showAll()
    {
        for(int i=0; i < halls.size(); i++)
        {
            halls.get(i).printDetail();
        }
    
    }
    
    
 
    public void show(int index)
    {
        halls.get(index).printDetail();
    }
    
    
    public boolean ifDateBooked(int index, String startDateString, String endDateString)
    {
        return halls.get(index).ifDateBooked(startDateString,endDateString);    
    }
    
    
    public void setName(int index,String newName)
    {
        halls.get(index).setName(newName);
    }

    public String getName(int index)
    {
        return halls.get(index).getName();
    }

    public void setDescription(int index,String newDescription)
    {
        halls.get(index).setDescription(newDescription);
    }

    public String getDescription(int index)
    {
        return halls.get(index).getDescription();
    }

    public void setAvailability(int index,boolean newAvailability)
    {
        halls.get(index).setAvailability(newAvailability);
    }

    public boolean getAvailability(int index)
    {
        return halls.get(index).getAvailability();
    }

    public void setConcession(int index,double newConcession)
    {
        halls.get(index).setConcession(newConcession);
    }

    public double getConcession(int index)
    {
        return halls.get(index).getConcession();
    }

    public void setDiscount(int index,double newDiscount)
    {
        halls.get(index).setDiscount(newDiscount);
    }

    public double getDiscount(int index)
    {
        return halls.get(index).getDiscount();
    }

    public void setDiposit(int index,double newDiposit)
    {
        halls.get(index).setDiposit(newDiposit);
    }

    public double getDiposit(int index)
    {
        return halls.get(index).getDiposit();
    }

    public void setRent(int index,double newRent)
    {
        halls.get(index).setRent(newRent);
    }

    public double getRent(int index)
    {
        return halls.get(index).getRent();
    }

    public void setCapacity(int index,int newCapacity)
    {
        halls.get(index).setCapacity(newCapacity);
    }

    public int getCapacity(int index)
    {
        return halls.get(index).getCapacity();
    }

    public void setLocation(int index,String newLocation)
    {
        halls.get(index).setLocation(newLocation);
    }

    public String getLocation(int index)
    {
        return halls.get(index).getLocation();
    }

    public void setOwnerName(int index,String newOwnerName)
    {
        halls.get(index).setOwnerName(newOwnerName);
    }

    public String getOwnerName(int index)
    {
        return halls.get(index).getOwnerName();
    }
    
    public void setAdminDiscount(int index,double newAdminDiscount)
    {
        halls.get(index).setAdminDiscount(newAdminDiscount);
    }

    public double getAdminDiscount(int index)
    {
        return halls.get(index).getAdminDiscount();
    }   
    
}
