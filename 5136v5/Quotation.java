import java.util.ArrayList;
/**
 * Write a description of class Quotation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quotation
{

    String sender;
    String receiver;
    String hallName;
    String startDate;
    String endDate;
    String eventType;
    boolean ifCateringByOwner;
    boolean ifAcceptByOwner;
    public Quotation()
    {
        sender = "";
        receiver = "";
        hallName = "";
        startDate = "";
        endDate = "";
        eventType = "";
        ifCateringByOwner = false;
        ifAcceptByOwner = false;
    }

    public Quotation(String newSender, String newReceiver, String newHallName, String newStartDate, 
    String newEndDate, String newEventType, boolean newIfCateringByOwner, boolean newIfAcceptByOwner)
    {
        sender = newSender;
        receiver = newReceiver;
        hallName = newHallName;
        startDate = newStartDate;
        endDate = newEndDate;
        eventType = newEventType;
        ifCateringByOwner = newIfCateringByOwner;
        ifAcceptByOwner = newIfAcceptByOwner;
    }


    
    
    public void loadQuotation(ArrayList<String> list)
    {

        for(int i = 0; i < list.size(); i++)
        {
            String[] detail = list.get(i).split(",");
            new Quotation(detail[0], detail[1], detail[2], detail[3], detail[4], detail[5], Boolean.valueOf(detail[5]), Boolean.valueOf(detail[6]));
        }

    }

    public String getDetail()
    {
        return (getSender()+ "," +getReceiver()+ "," + getHallName() + "," +getStartDate()+ "," 
            +getEndDate()+","+getEventType()+","+getIfCateringByOwner()+","+ getIfAcceptByOwner());
    }

    public void setSender(String newSender)
    {
        String sender = newSender;
    }

    public String getSender()
    {
        return sender;
    }

    public void setReceiver(String newReceiver)
    {
        String receiver = newReceiver;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setHallName(String newHallName)
    {
        String hallName = newHallName;
    }

    public String getHallName()
    {
        return hallName;
    }

    public void setStartDate(String newStartDate)
    {
        String startDate = newStartDate;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setEndDate(String newEndDate)
    {
        String endDate = newEndDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEventType(String newEventType)
    {
        String eventType = newEventType;
    }

    public String getEventType()
    {
        return eventType;
    }

    public void setIfCateringByOwner(boolean newIfCateringByOwner)
    {
        boolean ifCateringByOwner = newIfCateringByOwner;
    }

    public boolean getIfCateringByOwner()
    {
        return ifCateringByOwner;
    }

    public void setIfAcceptByOwner(boolean newIfAcceptByOwner)
    {
        boolean ifAcceptByOwner = newIfAcceptByOwner;
    }

    public boolean getIfAcceptByOwner()
    {
        return ifAcceptByOwner;
    }

}
