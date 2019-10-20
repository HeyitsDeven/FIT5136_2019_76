
/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account
{
    
    private boolean ifVaild;
    private String accountName;
    private String password;

    public Account()
    {
       
        ifVaild = false;        
        accountName = "";
        password = "";
    }

    public Account( boolean newIfVaild, String newAccountName, String newPassword)
    {
      
        ifVaild = newIfVaild; 
        accountName = newAccountName;
        password = newPassword;
    }
    
    public void setAccountName(String newAccountName)
    {
        accountName = newAccountName;
    }
    

    public void setIfVaild(boolean newIfVaild)
    {
        ifVaild = newIfVaild;
    }

    public boolean getIfVaild()
    {
        return ifVaild;
    }    
    
    public String getAccountName()
    {
        return accountName;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public String getPassword()
    {
        return password;
    }
    

}
