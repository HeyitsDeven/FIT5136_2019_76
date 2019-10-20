import java.util.ArrayList;
/**
 * Write a description of class ListOfCustomers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfCustomers
{

    private ArrayList<Customer> customers;

    public ListOfCustomers()
    {
        customers = new ArrayList<>();
    }

    public ListOfCustomers(ArrayList newCustomers)
    {
        customers = newCustomers;

    }

    public void addCustomer( boolean newIfVaild, String newAccountName, String newPassword, String newEmail, boolean newIfConcession)
    {
        Customer customer = new Customer(newIfVaild, newAccountName, newPassword, newEmail, newIfConcession);
        customers.add(customer);
    }

    public void loadCustomer(String[] detail) throws Exception
    {
        Customer customer = new Customer(Boolean.valueOf(detail[4]),detail[0],detail[1],detail[2],Boolean.valueOf(detail[3]));
        customers.add(customer);
    }

    public ArrayList<String> getDetail()
    {
        ArrayList detail = new ArrayList();

        for(int i = 0; i < customers.size(); i++)
        {
            detail.add(customers.get(i).getDetail());
        }
        return detail;
    }

    public ArrayList<String> getNames()
    {
        ArrayList names = new ArrayList();

        for(int i = 0; i < customers.size(); i++)
        {       
            names.add(customers.get(i).getAccountName());
        }
        return names;

    }

    public ArrayList<String> getMails()
    {
        ArrayList mails = new ArrayList();

        for(int i = 0; i < customers.size(); i++)
        {       
            mails.add(customers.get(i).getEmail());
        }
        return mails;

    }

    
    public void setAccountName(int index,String newAccountName)
    {
        customers.get(index).setAccountName(newAccountName);
    }

    public String getAccountName(int index)
    {
        return customers.get(index).getAccountName();
    }

    public void setPassword(int index,String newPassword)
    {
        customers.get(index).setPassword(newPassword);
    }

    public String getPassword(int index)
    {
        return customers.get(index).getPassword();
    }

    public void setEmail(int index,String newEmail)
    {
        customers.get(index).setEmail(newEmail);
    }

    public String getEmail(int index)
    {
        return customers.get(index).getEmail();
    }

    public void setIfVaild(int index,boolean newIfVaild)
    {
        customers.get(index).setIfVaild(newIfVaild);
    }

    public boolean getIfVaild(int index)
    {
        return customers.get(index).getIfVaild();
    }

    public void setIfConcession(int index,boolean newIfConcession)
    {
        customers.get(index).setIfConcession(newIfConcession);
    }

    public boolean getIfConcession(int index)
    {
        return customers.get(index).getIfConcession();
    }

    
}
