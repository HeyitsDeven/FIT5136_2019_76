import java.util.ArrayList;
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owner extends Account
{
    
    private String email;
    
    public Owner(boolean newIfVaild, String newAccountName, String newPassword, String newEmail)
    {
        super(newIfVaild, newAccountName, newPassword);
        email = newEmail;
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getDetail()
    {
        return (getAccountName()+ "," +getPassword()+ "," +getEmail()+ "," +getIfVaild());
    }
    
    // public void loadCustomer(ArrayList<String> list)
    // {
        
        // for(int i = 0; i < list.size(); i++)
        // {
            // String[] detail = list.get(i).split(",");
            // new Owner(Boolean.valueOf(detail[3]), detail[0], detail[1], detail[2]);
        // }
    
    // }
}
