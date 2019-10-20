import java.util.ArrayList;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends Account
{
    private String email;
    private boolean ifConcession; 
    
    public Customer(boolean newIfVaild, String newAccountName, String newPassword, String newEmail, boolean newIfConcession)
    {
        super(newIfVaild, newAccountName, newPassword);
        email = newEmail;
        ifConcession = newIfConcession;
    }


    
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
    
    public String getEmail()
    {
        return email;
    }
   
    public void setIfConcession(boolean newIfConcession)
    {
        ifConcession = newIfConcession;
    }
    
    public boolean getIfConcession()
    {
        return ifConcession;
    }    
    
    public String getDetail()
    {
        return (getAccountName()+ "," +getPassword()+ "," +getEmail()+ "," +getIfConcession()+ "," +getIfVaild());
    }


}
