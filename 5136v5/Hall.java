import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.*;
import java.time.temporal.*;
/**
 * Write a description of class Hall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hall
{

    private String name;
    private String description;
    private boolean availability;
    private double concession;
    private double discount;
    private double diposit;
    private double rent;
    private int capacity;
    private String location;
    private String ownerName;
    private String bookedDates;
    private ArrayList<LocalDate> dates = new ArrayList<>();
    private String feedback;
    private double adminDiscount;

    public Hall()
    {
        name = "";
        description = "";
        availability = false;
        concession = 1;
        discount = 1;
        diposit = 0;
        rent = 0;
        capacity = 0;
        location = "";
        ownerName = "";
        bookedDates = "1111.01.01";
        loadDate(bookedDates);
        feedback = "";
        adminDiscount = 0;
    }

    public Hall(String newName, String newDescription, boolean newAvailability, double newConcession, 
    double newDiscount, double newDiposit, double newRent, int newCapacity, String newLocation, 
    String newOwnerName, String newBookedDates, String newFeedback, double newAdminDiscount)
    {
        name = newName;
        description = newDescription;
        availability = newAvailability;
        concession = newConcession;
        discount = newDiscount;
        diposit = newDiposit;
        rent = newRent;
        capacity = newCapacity;
        location = newLocation;
        ownerName = newOwnerName;
        bookedDates = newBookedDates;
        loadDate(bookedDates);
        feedback = newFeedback;
        adminDiscount = 0;
    }

    public String getDetail()
    {
        return (getName()+ "," +getDescription()+ "," +getAvailability()+ "," +getConcession()+ "," +getDiscount()+ "," +getDiposit() +
            ","+getRent()+ "," + getCapacity() + "," +getLocation() + "," + getOwnerName() + "," + getBookedDates() + "," + getFeedback() + "," + getAdminDiscount());
    }

    public void loadDate(String detail)//"2019.02.03/2019.04.23"
    {
        LocalDate date;
        String[] details = detail.split("/");
        for(int i = 0; i < details.length; i++) 
        {
            String[] string = detail.split("\\.");
            date = LocalDate.of(Integer.parseInt(string[0]),Integer.parseInt(string[1]),Integer.parseInt(string[2]));
            dates.add(date);
        }
    }

    public void saveDate()
    {
        StringBuffer string = new StringBuffer();
        for(int i = 0; i < dates.size(); i++) 
        {
            string.append(dates.get(i).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")) + "/");
        }
        bookedDates = string.toString();
    }

    public void printBookedDate()
    {
        System.out.println("The booked dates of this hall:");
        for(int i = 0; i < dates.size(); i++) 
        {
            System.out.println(dates.get(i).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        }
    }

    public ArrayList<LocalDate> dateBetween(LocalDate d1, LocalDate d2)
    {
        ArrayList<LocalDate> datesInRange = new ArrayList<>();
        do{
            d1 = d1.plus(1,ChronoUnit.DAYS);
            datesInRange.add(d1);
        }while(!isEqual(d1,d2));
        return datesInRange;
    }

    public LocalDate stringToDate(String DateString)
    {
        String[] DateStrings = DateString.split("\\.");
        LocalDate date = LocalDate.of(Integer.parseInt(DateStrings[0]),Integer.parseInt(DateStrings[1]),Integer.parseInt(DateStrings[2]));
        return date;
    }

    public void setDate(String startDateString, String endDateString)
    {
        LocalDate d1 = stringToDate(startDateString);
        LocalDate d2 = stringToDate(endDateString);
        ArrayList<LocalDate> datesInRange = dateBetween(d1, d2);
        dates.addAll(datesInRange);
        saveDate();
    }

    public boolean ifDateBooked(String startDateString, String endDateString)
    {
        LocalDate d1 = stringToDate(startDateString);
        LocalDate d2 = stringToDate(endDateString);
        loadDate(bookedDates);
        ArrayList<LocalDate> datesInRange = dateBetween(d1, d2);
        for(int i = 0; i < datesInRange.size(); i++) 
        {
            for(int j = 0; j < dates.size(); j++)
            {
                if(isEqual(datesInRange.get(i),dates.get(j)))
                    return true;
            }
        }
        return false;
    }

    public boolean isBefore(String startDateString, String endDateString)
    {
        LocalDate d1 = stringToDate(startDateString);
        LocalDate d2 = stringToDate(endDateString);
        return d1.isBefore(d2);
    }

    public boolean isEqual(LocalDate d1, LocalDate d2)
    {
        return d1.equals(d2);
    }

    public void printDetail()
    {
        System.out.println("name: " + getName());
        System.out.println("description: " + getDescription());
        System.out.println("availability: " + getAvailability());
        System.out.println("concession: " + getConcession());
        System.out.println("discount: " + getHigherDiscount());
        System.out.println("diposit: " + getDiposit());
        System.out.println("capacity: " + getCapacity());
        System.out.println("location: " + getLocation());
        System.out.println("owner name: " + getOwnerName());
        getFeedback();
    }

    public double getHigherDiscount()
    {
        if(discount > adminDiscount)
            return discount;
        else if (adminDiscount > discount)
            return adminDiscount;
        else 
            return 0;
    }

    public void setName(String newName)
    {
        String name = newName;
    }

    public String getName()
    {
        return name;
    }

    public void setDescription(String newDescription)
    {
        String description = newDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setAvailability(boolean newAvailability)
    {
        boolean availability = newAvailability;
    }

    public boolean getAvailability()
    {
        return availability;
    }

    public void setConcession(double newConcession)
    {
        double concession = newConcession;
    }

    public double getConcession()
    {
        return concession;
    }

    public void setDiscount(double newDiscount)
    {
        double discount = newDiscount;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiposit(double newDiposit)
    {
        double diposit = newDiposit;
    }

    public double getDiposit()
    {
        return diposit;
    }

    public void setRent(double newRent)
    {
        double rent = newRent;
    }

    public double getRent()
    {
        return rent;
    }

    public void setCapacity(int newCapacity)
    {
        int capacity = newCapacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setLocation(String newLocation)
    {
        String capacity = newLocation;
    }

    public String getLocation()
    {
        return location;
    }

    public void setOwnerName(String newOwnerName)
    {
        ownerName = newOwnerName;
    }

    public String getOwnerName()
    {
        return ownerName;
    }    

    public void setBookedDates(String newBookedDates)
    {
        bookedDates = newBookedDates;
    }

    public String getBookedDates()
    {
        return bookedDates;
    }

    public void setFeedback(String newFeedback)
    {
        feedback = feedback + "|" +newFeedback;

    }

    public String getFeedback()
    {

        String[] feedbacks = feedback.split("\\|");
        for(int i = 0; i < feedbacks.length; i++) 
        {
            System.out.println(feedbacks[i]);
        }
        return feedback;
    }

    public void setAdminDiscount(double newAdminDiscount)
    {
        adminDiscount = newAdminDiscount;
    }

    public double getAdminDiscount()
    {
        return adminDiscount;
    }

    
}