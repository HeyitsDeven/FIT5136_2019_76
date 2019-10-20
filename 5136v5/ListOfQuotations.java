import java.util.ArrayList;
/**
 * Write a description of class ListOfQuotations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfQuotations
{

    private ArrayList<Quotation> quotations;

    public ListOfQuotations()
    {
        quotations = new ArrayList<>();
    }

    public ListOfQuotations(ArrayList newQuotations)
    {
        quotations = newQuotations;

    }

    public void addQuotation( String newSender, String newReceiver, String newHallName, 
    String newStartDate, String newEndDate, String newEventType, boolean newIfCateringByOwner, boolean newIfAcceptByOwner)
    {
        Quotation quotation = new Quotation(newSender, newReceiver, newHallName,
                newStartDate,newEndDate,newEventType,newIfCateringByOwner,newIfAcceptByOwner);
        quotations.add(quotation);
    }

    public void loadQuotation(String[] detail) throws Exception
    {
        Quotation quotation = new Quotation(detail[0],detail[1],detail[2],detail[3],detail[4], detail[5], Boolean.valueOf(detail[5]), Boolean.valueOf(detail[6]));
        quotations.add(quotation);
    }

    public void showQuotation(int i)
    {
        String temp1;    
        if (getIfCateringByOwner(i))
        {
            temp1 = "Catering by Owner";
        }
        else 
        {
            temp1 = "Catering by Customer";
        }
        String temp2;
        if (getIfAcceptByOwner(i))
        {
            temp2 = "Accepted";

            
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int no = i+1;
            System.out.println("*******************Quotation Code: "+no + "**********************");
            System.out.println("Sender: " + getSender(i));
            System.out.println("Receiver: " + getReceiver(i));
            System.out.println("Hall Name: " + getHallName(i));
            System.out.println("Start Date: " + getStartDate(i));
            System.out.println("End Date: " + getEndDate(i));
            System.out.println("Event Type: " + getEventType(i));
            System.out.println("Owner Privide the Catering: " + temp1);
            System.out.println("Quotation State: " + temp2);
            System.out.println("----------------------------------------------------------");
            System.out.println("Your quotation has been accepted, please pay the disposit");
            System.out.println("**********************************************************");
        }
        else 
        {
            temp2 = "Pending";
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int no = i+1;
            System.out.println("*******************Quotation Code: "+no + "**********************");
            System.out.println("Sender: " + getSender(i));
            System.out.println("Receiver: " + getReceiver(i));
            System.out.println("Hall Name: " + getHallName(i));
            System.out.println("Start Date: " + getStartDate(i));
            System.out.println("End Date: " + getEndDate(i));
            System.out.println("Event Type: " + getEventType(i));
            System.out.println("Owner Privide the Catering: " + temp1);
            System.out.println("Quotation State: " + temp2);
            System.out.println("***********************************************************");
            
        }
    }

    public ArrayList<String> getDetail()
    {
        ArrayList detail = new ArrayList();

        for(int i = 0; i < quotations.size();i++)
        {
            detail.add(quotations.get(i).getDetail());
        }
        return detail;
    }

    public int size()
    {
        return quotations.size();
    }

    public void setSender(int index,String newSender)
    {
        quotations.get(index).setSender(newSender);
    }

    public String getSender(int index)
    {
        return quotations.get(index).getSender();
    }

    public void setReceiver(int index,String newReceiver)
    {
        quotations.get(index).setReceiver(newReceiver);
    }

    public String getReceiver(int index)
    {
        return quotations.get(index).getReceiver();
    }

    public void setHallName(int index,String newHallName)
    {
        quotations.get(index).setHallName(newHallName);
    }

    public String getHallName(int index)
    {
        return quotations.get(index).getHallName();
    }    

    public void setStartDate(int index,String newStartDate)
    {
        quotations.get(index).setStartDate(newStartDate);
    }

    public String getStartDate(int index)
    {
        return quotations.get(index).getStartDate();
    }

    public void setEndDate(int index,String newEndDate)
    {
        quotations.get(index).setEndDate(newEndDate);
    }

    public String getEndDate(int index)
    {
        return quotations.get(index).getEndDate();
    }

    public void setEventType(int index,String EventType)
    {
        quotations.get(index).setEventType(EventType);
    }

    public String getEventType(int index)
    {
        return quotations.get(index).getEventType();
    }

    public void setIfCateringByOwner(int index,boolean newIfCateringByOwner)
    {
        quotations.get(index).setIfCateringByOwner(newIfCateringByOwner);
    }

    public boolean getIfCateringByOwner(int index)
    {
        return quotations.get(index).getIfCateringByOwner();
    }

    public void setIfAcceptByOwner(int index,boolean newIfAcceptByOwner)
    {
        quotations.get(index).setIfAcceptByOwner(newIfAcceptByOwner);
    }

    public boolean getIfAcceptByOwner(int index)
    {
        return quotations.get(index).getIfAcceptByOwner();
    }

    
}
