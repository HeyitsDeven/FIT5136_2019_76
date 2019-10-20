import java.util.ArrayList;
/**
 * Write a description of class ListOfOwners here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfOwners
{

    private ArrayList<Owner> owners;

    public ListOfOwners()
    {
        owners = new ArrayList<>();
    }

    public ListOfOwners(ArrayList newOwners)
    {
        owners = newOwners;

    }
    
    
    public void addOwner( boolean newIfVaild, String newAccountName, String newPassword, String newEmail)
    {
        Owner owner = new Owner(newIfVaild, newAccountName, newPassword, newEmail);
        owners.add(owner);
    }
    
    public void loadOwner(String[] detail) throws Exception
    {
        Owner owner = new Owner(Boolean.valueOf(detail[3]),detail[0],detail[1],detail[2]);
        owners.add(owner);
    }
    
    
    public ArrayList<String> getDetail()
    {
        ArrayList detail = new ArrayList();
        
        for(int i = 0; i < owners.size();i++)
        {
            detail.add(owners.get(i).getDetail());
        }
        return detail;
    }
    
    public ArrayList<String> getNames()
    {
        ArrayList names = new ArrayList();
        
        for(int i = 0; i < owners.size(); i++)
        {       
            names.add(owners.get(i).getAccountName());
        }
        return names;
    
    }
    
    public ArrayList<String> getMails()
    {
        ArrayList mails = new ArrayList();
        
        for(int i = 0; i < owners.size(); i++)
        {       
            mails.add(owners.get(i).getEmail());
        }
        return mails;
    
    }
    
    public void setAccountName(int index,String newAccountName)
    {
        owners.get(index).setAccountName(newAccountName);
    }

    public String getAccountName(int index)
    {
        return owners.get(index).getAccountName();
    }

    public void setPassword(int index,String newPassword)
    {
        owners.get(index).setPassword(newPassword);
    }

    public String getPassword(int index)
    {
        return owners.get(index).getPassword();
    }

    public void setEmail(int index,String newEmail)
    {
        owners.get(index).setEmail(newEmail);
    }

    public String getEmail(int index)
    {
        return owners.get(index).getEmail();
    }
    
    public void setIfVaild(int index,boolean newIfVaild)
    {
        owners.get(index).setIfVaild(newIfVaild);
    }

    public boolean getIfVaild(int index)
    {
        return owners.get(index).getIfVaild();
    }

    


}
