import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UI
{
    private Input input = new Input();
    private IO io = new IO();
    private ListOfCustomers customers = new ListOfCustomers();
    private ListOfOwners owners = new ListOfOwners();
    private ListOfHalls halls = new ListOfHalls();
    private ListOfQuotations quotations = new ListOfQuotations();
    private int currentUserIndex = -1;
    private Administrator administrator = new Administrator();

    public void showHall()
    {
        halls.showAll();

    }

    public UI()
    {
        loadHall();
        loadCustomer();
        loadOwner();
        loadQuotation();
    }

    public void start()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Prime Events     *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("Please enter the option number(1/2)");
        int temp = input.valid12();

        if(temp == 1)
            loginPage();
        else if(temp == 2)
            registerPage();
    }

    public void loginPage()
    {

        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*      Login Page      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Login as customer");
        System.out.println("2. Login as owner");
        System.out.println("3. Login as administrator");
        System.out.println("Please enter the option number 1 ~ 3 ");
        int temp = input.valid13();

        System.out.println("Please enter your user name or email... ");
        String userNameOrMail = input.String();
        System.out.println("Please enter your password ");
        System.out.println("The password should: At least 8 digits/At least one lower case charactor/At least one upper case charactor/At least one special charactor");
        String password = input.validPassWord();

        if(temp == 1)
        {   
            boolean tempBoolean = checkCustomerPassword(userNameOrMail, password);

            if(tempBoolean == true)
            {
                currentUserIndex = getCustomerIndex(userNameOrMail);
                if(currentUserIndex == -1)
                    currentUserIndex =  getCustomerIndexByMail(userNameOrMail);
                
                if(customers.getIfVaild(currentUserIndex) == false)
                    {
                        System.out.println("Your account has been suspended");
                        System.out.println("Press enter to quit...");
                        input.String();
                        start();
                    }
                
                
                
                System.out.println("Login successfuly, press enter to continue... ");
                input.String();
                customerPage();
            }
            else
            {
                System.out.println("Wrong user name or password entered... ");
                System.out.println(" ");
                System.out.println("1. Login again");
                System.out.println("2. Exit");
                System.out.println("Please enter the option number 1 ~ 2 ");
                int temp1 = input.valid12();
                if(temp1 == 1)
                    loginPage();
                else
                    start();

            }
        }
        else if(temp == 2)
        {
            boolean tempBoolean = checkOwnerPassword(userNameOrMail, password);
            if(tempBoolean == true)
            {

                currentUserIndex = getOwnerIndex(userNameOrMail);
                if(currentUserIndex == -1)
                    currentUserIndex =  getOwnerIndexByMail(userNameOrMail);
                if(customers.getIfVaild(currentUserIndex) == false)
                    {
                        System.out.println("Your account has been suspended");
                        System.out.println("Press enter to quit...");
                        input.String();
                        start();
                    }
                

                System.out.println("Login successfuly, press enter to continue... ");
                input.String();
                ownerPage();

            }
            else
            {
                System.out.println("Wrong user name or password entered... ");
                System.out.println(" ");
                System.out.println("1. Login again");
                System.out.println("2. Exit");
                System.out.println("Please enter the option number 1 ~ 2 ");
                int temp1 = input.valid12();
                if(temp1 == 1)
                    loginPage();
                else
                    start();

            }
        }
        else
        {
            if(userNameOrMail.equals(administrator.getUsername()) && password.equals(administrator.getPassword()))
                administratorPage(); 
            else
                {
                    System.out.println("Wrong user name or password entered...");
                    input.String();
                    loginPage();
                }
            }
    }

    public void administratorPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*  Administrator Page  *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1 suspend a customer");
        System.out.println("2 suspend an owner ");
        System.out.println("3 set discount for all halls ");
        System.out.println("4 logout ");
        System.out.println("Please enter the option number 1 ~ 4 ");
        int temp = input.valid14();
        if(temp == 1)
        {
            System.out.println("Please enter the customer name to suspend... ");
            String name = input.String();
            int index = getCustomerIndex(name);
            if (index == -1)
            {
                System.out.println("Sorry, customer  not found");
                System.out.println("Press enter to continue... ");
                input.String();
                administratorPage();
            }
            customers.setIfVaild(index,false);
            System.out.println("The customer has suspended");
            System.out.println("Press enter to continue... ");
            input.String();
            administratorPage();
        }
        else if(temp == 2)
        {
            System.out.println("Please enter the owner name to suspend... ");
            String name = input.String();
            int index = getOwnerIndex(name);
            if (index == -1)
            {
                System.out.println("Sorry, owner not found");
                System.out.println("Press enter to continue... ");
                input.String();
                administratorPage();
            }
            owners.setIfVaild(index,false);
            System.out.println("The owner has suspended");
            System.out.println("Press enter to continue... ");
            input.String();
            administratorPage();

        }
        else if(temp == 3)
        {
            System.out.println("Please enter the discount for all halls");
            double discount = input.Double();
            halls.setAllDiscount(discount);
            System.out.println("Discount set successfully");
            System.out.println("Press enter to continue...");
            input.String();
            administratorPage();
        }
        else
        {
            logoutPage();
        }
    }

    public void registerPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*    Register Page     *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Customer");
        System.out.println("2. Owner");
        System.out.println("Please enter the option number 1 ~ 2 ");   
        int temp = input.valid12();
        if(temp == 1)
        {   

            boolean ifSame = true;
            String name;
            String email;
            do
            {
                System.out.println("Please enter your email address...");
                email = input.validMail(); 
                ifSame =  ifregistedCustomerMail( email);
                if(ifSame == true)
                {
                    System.out.println("The email address has been registered");
                    System.out.println(" ");
                    System.out.println("1 Enter a new email address");
                    System.out.println("2 To login page");
                    System.out.println("Please enter the option number 1 ~ 2 ");
                    temp = input.valid12();
                    if(temp == 2)
                        loginPage();
                }
            }while(ifSame == true);

            do
            {
                System.out.println("Please enter your user name...");
                name = input.String(); 
                ifSame =  ifregistedCustomerName(name);
                if(ifSame == true)
                {
                    System.out.println("The name has been registered, please try again");
                }
            }while(ifSame == true);        

            System.out.println("Hello " + name + ", please enter your password...");
            System.out.println("The password should: At least 8 digits/At least one lower case charactor/At least one upper case charactor/At least one special charactor");
            String password = input.validPassWord();
            System.out.println("Password set sucessfully");
            System.out.println(" ");

            
            System.out.println("Concession type");
            System.out.println(" ");
            System.out.println("1 Veteran");
            System.out.println("2 Senior citizen");
            System.out.println("3 N/A");
            System.out.println("Please enter the option number 1 ~ 3 ");
            int tempCon = input.valid13();
            boolean ifCon = false;
            if(tempCon == 1)
            {    
                System.out.println("You are registed as Veteran");   
                ifCon = true;
            }
            else if(tempCon == 2)
            {
                System.out.println("You are registed as Senior citizen");
                ifCon = true;
            }

            else
            {
                System.out.println("Customer Account created");
            }
            customers.addCustomer(true, name, password, email, ifCon);
            currentUserIndex = getCustomerIndex(name);
            System.out.println("Press enter to continue...");
            input.String();
            customerPage();
        }
        else
        {

            boolean ifSame = true;
            String name;
            String email;
            do
            {
                System.out.println("Please enter your email address...");
                email = input.validMail(); 
                ifSame =  ifregistedOwnerMail( email);
                if(ifSame == true)
                {
                    System.out.println("The email address has been registered");
                    System.out.println(" ");
                    System.out.println("1 Enter a new email address");
                    System.out.println("2 To login page");
                    System.out.println("Please enter the option number 1 ~ 2 ");
                    temp = input.valid12();
                    if(temp == 2)
                        loginPage();
                }
            }while(ifSame == true);

            do
            {
                System.out.println("Please enter your user name...");
                name = input.String(); 
                ifSame =  ifregistedOwnerName(name);
                if(ifSame == true)
                {
                    System.out.println("The name has been registered, please try again");
                }
            }while(ifSame == true);        

            System.out.println("Hello " + name + ", please enter your password...");
            String password = input.validPassWord();
            System.out.println("Password set sucessfully");
            System.out.println(" ");

            System.out.println("Owner account created, press any button to continue...");
            owners.addOwner(true, name, password, email);
            currentUserIndex = getOwnerIndex(name);
            input.String();
            ownerPage();
        }

    }

    public void logoutPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*      Logout Page     *");
        System.out.println("************************");
        System.out.println(" ");
        saveCustomer();
        saveOwner();
        saveHall();
        saveQuotation();
        System.out.println("Logout successfully ");
        System.out.println("Press enter to continue.. ");
        input.String();
        start();

    }

    public void ownerPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*      Owner Page      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Add a hall");
        System.out.println("2. Update a hall");
        System.out.println("3. Remove a hall");
        System.out.println("4. Accpect quotations");
        System.out.println("5. Logout");
        System.out.println("Please enter the option number 1 ~ 5 ");
        int temp = input.valid15();
        if(temp == 1 )
        {
            addAHallPage();
        }

        else if(temp == 2 )
        {
            updateAHallPage();
        }

        else if(temp == 3 )
        {
            RemoveAHallPage();
        }

        else if(temp == 4)
        {
            ownerQuotationPage();
        }

        else
        {
            logoutPage();
        }

    }

    public void ownerQuotationPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*    Quotation Page    *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Please enter the quotation code that you would like to accept ");
        System.out.println("Or enter 0 to exit ");
        ArrayList<Integer> userQuotationIndex = new ArrayList<>();
        userQuotationIndex = getQuotationIndexByOwner();
        for(int i =0; i < userQuotationIndex.size(); i++)
        {
            quotations.showQuotation( userQuotationIndex.get(i));
        }
        int index = input.Int();
        if(index == 0)
        {
            ownerPage();
        }

        quotations.setIfAcceptByOwner(index-1,true);
        int hallIndex = getHallIndexByQuotation(index-1);
        if(hallIndex == -1)
        {
            System.out.println("The hall is no longer available, you cannot accept the quotaion..");

        }

        else
        {
            halls.setDate(hallIndex,quotations.getStartDate(index-1),quotations.getEndDate(index-1));
            System.out.println("Quotation updated");
        }
        System.out.println("Press enter to continue...");
        input.String();
        ownerPage();

    }

    public int getHallIndexByQuotation(int index)
    {
        int number;
        String name;
        name = quotations.getHallName(index);
        number = getHallIndex(name);
        return number;
    }

    public ArrayList<Integer> getQuotationIndexByOwner()
    {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < quotations.size(); i++)
        {
            if(owners.getAccountName(currentUserIndex).equals(quotations.getReceiver(i)))
            {
                index.add(i);
            }
        }
        return index;
    }

    public ArrayList<Integer> getQuotationIndexByCustomer()
    {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < quotations.size(); i++)
        {
            if(customers.getAccountName(currentUserIndex).equals(quotations.getSender(i)))
            {
                index.add(i);
            }
        }
        return index;
    }

    public void addAHallPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*      Add a hall      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Please enter the hall name...");//geshi
        String name = input.String(); 
        System.out.println("Please enter the hall capacity...");  
        int capacity = input.Int();
        System.out.println("Please enter the hall description...");
        String description = input.String();
        System.out.println("Please enter the hall rent...");
        double rent = input.Double();
        System.out.println("Please enter the discount rate ...");
        System.out.println("Input ranged from 0 to 1, 0.1 means 10% off, 0.9 means 90% off ");
        double discount = input.validDouble();
        System.out.println("Please enter the discount rate for concession customer ...");
        System.out.println("Input ranged from 0 to 1, 0.1 means 10% off, 0.9 means 90% off ");
        double concession = input.validDouble();
        System.out.println("Please enter the hall diposit...");
        double diposit = input.Double();
        System.out.println("Please enter the hall location...");
        String location = input.String();

        halls.addHall(name, description, true, concession, discount, diposit, rent, capacity, location, owners.getAccountName(currentUserIndex),"1111.01.01","",0);

        System.out.println("Hall created, press enter to continue...");  
        input.String();
        ownerPage();
    }

    public void updateAHallPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*    Update a hall     *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Pleace enter the hall name...");
        String name = input.String();
        int index = getHallIndex(name);
        if(index == -1)
        {
            System.out.println("No hall named " + name);
            System.out.println("Press enter to continue...");
            input.String();
            ownerPage();
        }
        System.out.println("Update option");
        System.out.println(" ");
        System.out.println("1. Name");
        System.out.println("2. Capacity");
        System.out.println("3. Description");
        System.out.println("4. Rent");
        System.out.println("5. Discount");
        System.out.println("6. Concession");
        System.out.println("7. Diposit ");
        System.out.println("8. Location ");
        System.out.println("9. Exit");
        System.out.println("Please enter the option number 1 ~ 9 ");
        int temp = input.valid19();
        if(temp == 1 )
        {
            System.out.println("Please enter the updated hall name...");
            String name1 = input.String(); 
            halls.setName(index,name1);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 2)
        {
            System.out.println("Please enter the updated hall capacity...");  
            int capacity = input.Int();
            halls.setCapacity(index,capacity);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 3)
        {
            System.out.println("Please enter your the updated hall description...");
            String description = input.String();
            halls.setDescription(index,description);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 4)
        {
            System.out.println("Please enter the updated hall rent...");
            double rent = input.Double();
            halls.setRent(index,rent);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 5)
        {
            System.out.println("Please enter the updated discount rate ...");
            System.out.println("Input ranged from 0 to 1, 0.1 means 10% off, 0.9 means 90% off ");
            double discount = input.Double();
            halls.setDiscount(index,discount);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 6)
        {
            System.out.println("Please enter the updated discount rate for concession customer ...");
            System.out.println("Input ranged from 0 to 1, 0.1 means 10% off, 0.9 means 90% off ");
            double concession = input.Double();
            halls.setConcession(index,concession);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 7)
        {
            System.out.println("Please enter the updated hall diposit...");
            double diposit = input.Double();
            halls.setDiposit(index,diposit);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }
        else if(temp == 8)
        {
            System.out.println("Please enter the updated hall location...");
            String location = input.String();
            halls.setLocation(index,location);
            System.out.println("Updated successfully");
            System.out.println("Press enter to continue...");
            input.String(); 
            ownerPage();
        }

        else
        {
            ownerPage();
        }

    }    

    public void RemoveAHallPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Remove a hall    *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Pleace enter the hall name...");
        String name = input.String();
        int index = getHallIndex(name);
        halls.setAvailability(index,false);
    }  

    public void customerPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Customer Page    *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Search a hall");
        System.out.println("2. Book a hall");
        System.out.println("3. Check quotation");
        System.out.println("4. Logout");
        System.out.println("Please enter the option number 1 ~ 4 ");
        int temp = input.valid14();
        if(temp == 1 )
        {
            searchPage();
        }

        else if(temp == 2 )
        {
            bookPage();
        }
        else if(temp == 3 )
        {
            customerQuotationPage();
        }
        else
        {
            logoutPage();
        }
    }

    public void customerQuotationPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*       Quotation      *");
        System.out.println("************************");
        System.out.println(" ");
        ArrayList<Integer> userQuotationIndex = new ArrayList<>();
        userQuotationIndex = getQuotationIndexByCustomer();
        for(int i =0; i < userQuotationIndex.size(); i++)
        {
            quotations.showQuotation( userQuotationIndex.get(i));
        }

        System.out.println("Press enter to quit... ");
        System.out.println(" ");
        System.out.println("1. Pay Disposit");
        System.out.println("2. Exit");
        System.out.println("Please enter the option number 1 ~ 2 ");
        int temp = input.valid12();
        if(temp == 1)
            dipositPage();
        else
            customerPage();
    }    

    public void dipositPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*        Diposit       *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Please enter the hall name...");
        String name = input.String();
        int index = getHallIndex(name);
        if (index == -1)
        {
            System.out.println("Sorry, No Halls available");
        }
        else
        {
            System.out.println("The diposit you needs to pay is: $" + halls.getDiposit(index));
            System.out.println("Press enter to pay");
            input.String();
            System.out.println(" ");
            System.out.println("Payment received, reciption will be sent to your e-mail address");
            System.out.println("Press enter to contine...");
            input.String();
            customerPage();
        }

    }

    public void searchPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Search page      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("1. Search by Date");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Location");
        System.out.println("4. Show All");
        System.out.println("5. Exit");
        System.out.println("Please enter the option number 1 ~ 5 ");
        int temp = input.valid15();
        if(temp == 1 )
        {
            searchByDate();
        }

        else if(temp == 2 )
        {
            searchByName();
        }

        else if(temp == 3 )
        {
            searchByLocation();
        }
        else if(temp == 4)
        {
            halls.showAll();
            System.out.println("press enter to continue...");
            input.String();
            searchPage();
        }
        else
        {
            customerPage();
        }
    }

    public void searchByLocation()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*    Search Location   *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Please enter the hall Location");
        String location = input.String();
        int index = getHallIndexByLocation(location);
        if (index == -1)
        {
            System.out.println("Sorry, No Halls available");
        }
        else
        {
            halls.show(index);
        }
        System.out.println("Press enter to continue...");
        input.String();
        customerPage(); 
    }    

    public void searchByName()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Search Name      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println("Please enter the hall name");
        String name = input.String();
        int index = getHallIndex(name);
        if (index == -1)
        {
            System.out.println("Sorry, No Halls available");
        }
        else
        {
            halls.show(index);
        }
        System.out.println("Press enter to continue...");
        input.String();
        customerPage(); 
    }

    public void searchByDate()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*     Search Date      *");
        System.out.println("************************");
        System.out.println(" ");

        boolean ifOk = false;
        String startDate;
        String endDate;

        do{
            System.out.println("Please enter the start date(yyyy.mm.dd)...");
            startDate = input.validDate();
            System.out.println("Please enter the end date(yyyy.mm.dd)...");
            endDate = input.validDate();

            if(halls.isBefore(startDate,endDate) == true )
            {
                ifOk = true;    
            }
            else
            {
                System.out.println("start date cannot be later than end date");
                System.out.println(" ");
                System.out.println("1. Enter Again");
                System.out.println("2. Back to HomePage");
                System.out.println("Please enter the option number 1 ~ 2 ");
                int i = input.valid12();
                if(i == 2)
                {
                    customerPage();
                }
            }
        } while( ifOk == false);

        ArrayList<Integer> index = halls.searchByDate(startDate,endDate);
        for(int i = 0; i <index.size(); i++)
        {
            halls.show(i);
        }

        if(index.size() == 0)
            System.out.println("Sorry, No Halls available");

        System.out.println("Press enter to continue...");
        input.String();
        customerPage();   
    }

    public void bookPage()
    {
        System.out.println('\f'); 
        System.out.println("************************");
        System.out.println("*       Book page      *");
        System.out.println("************************");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Please enter the hall name...");
        String hallName = input.String();
        int hallIndex = getHallIndex(hallName);
        if(hallIndex == -1)
        {
            System.out.println("No hall named " + hallName);
            System.out.println("Press enter to continue...");
            input.String();
            customerPage();
        }
        halls.show(hallIndex);
        boolean ifOk = false;
        String startDate;
        String endDate;
        do{
            System.out.println("Please enter the start date(yyyy.mm.dd)...");
            startDate = input.validDate();
            System.out.println("Please enter the end date(yyyy.mm.dd)...");
            endDate = input.validDate();

            if(halls.isBefore(startDate,endDate) == true && halls.ifDateBooked(hallIndex,startDate,endDate) == false)
            {
                ifOk = true;    
            }
            else
            {
                System.out.println("start date cannot be later than end date");
                System.out.println(" ");
                System.out.println("1. Enter Again");
                System.out.println("2. Back to HomePage");
                System.out.println("Please enter the option number 1 ~ 2 ");
                int i = input.valid12();
                if(i == 2)
                {
                    customerPage();
                }
            }
        } while( ifOk == false);

        System.out.println("Please enter the event type...");
        System.out.println(" ");
        System.out.println("1.Wedding ceremony");
        System.out.println("2.Wedding reception");
        System.out.println("3.Birthday");
        System.out.println("4.Anniversary");
        System.out.println("Please enter the option number 1 ~ 4 ");
        int typeIndex = input.valid14();
        String eventType = null;
        if(typeIndex == 1)
            eventType = "Wedding ceremony";
        else if (typeIndex == 2)
            eventType = "Wedding reception";
        else if (typeIndex == 3)
            eventType = "Birthday";
        else if (typeIndex == 4)
            eventType = "Anniversary";

        System.out.println("Will you pareparing catering by your self...");
        System.out.println(" ");
        System.out.println("1.Carting by Owner");
        System.out.println("2.Carting by Customer");
        System.out.println("Please enter the option number 1 ~ 2 ");
        int cartingIndex = input.valid12();
        boolean ifCatering  = true;        
        if(cartingIndex == 1)
        {
            ifCatering = true;
        }
        else if (cartingIndex == 2)
        {
            ifCatering = false;
        }
        int index = getHallIndex(hallName);
        quotations.addQuotation(customers.getAccountName(currentUserIndex),halls.getOwnerName(index), hallName, startDate, endDate, eventType, ifCatering, false);
        System.out.println("Quotation created, press enter to continue...");
        input.String();
        customerPage();
    }

    public boolean checkCustomerPassword(String nameOrMail, String password)
    {

        int temp = getCustomerIndex(nameOrMail);
        if(temp == -1)
        {
            temp = getCustomerIndexByMail(nameOrMail);
        }

        if(temp == -1)
        {
            return false;
        }
        else{
            if(customers.getPassword(temp).equals(password) )
            {
                return  true;
            }
            else
                return false;
        }
    }

    public boolean checkOwnerPassword(String nameOrMail, String password)
    {

        int temp = getOwnerIndex(nameOrMail);
        if(temp == -1)
        {
            temp = getCustomerIndexByMail(nameOrMail);
        }

        if(temp == -1)
        {
            return false;
        }
        else{
            String storedPassword = owners.getPassword(temp);
            if(storedPassword.equals( password) )
            {
                return  true;
            }
            else
            {
                return false;
            }
        }
    }

    public void saveCustomer()
    {
        io.saveCustomer(customers.getDetail());
    }

    public void saveHall()
    {
        io.saveHall(halls.getDetail());

    }

    public void saveOwner()
    {
        io.saveOwner(owners.getDetail());

    }

    public void saveQuotation()
    {
        io.saveQuotation(quotations.getDetail());

    }

    // public int getCustomerIndexByEmail(String mail)
    // {
        // ArrayList mails = new ArrayList();
        // mails = customers.getMails();
        // return mails.indexOf(mail);

    // }

    // public int getOwnerIndexByEmail(String mail)
    // {
        // ArrayList mails = new ArrayList();
        // mails = owners.getMails();
        // return mails.indexOf(mail);

    // }
    
    
    public int getCustomerIndex(String name)
    {
        ArrayList names = new ArrayList();
        names = customers.getNames();
        return names.indexOf(name);

    }

    public int getOwnerIndex(String name)
    {
        ArrayList names = new ArrayList();
        names = owners.getNames();
        return names.indexOf(name);

    }

    public int getCustomerIndexByMail(String mail)
    {
        ArrayList mails = new ArrayList();
        mails = customers.getMails();
        return mails.indexOf(mail);

    }

    public int getOwnerIndexByMail(String mail)
    {
        ArrayList mails = new ArrayList();
        mails = owners.getMails();
        return mails.indexOf(mail);

    }    

    public int getHallIndex(String name)
    {       
        ArrayList names = new ArrayList();
        names = halls.getNames();
        return names.indexOf(name);
    }

    public int getHallIndexByLocation(String location)
    {       
        ArrayList locations = new ArrayList();
        locations = halls.getLocations();
        return locations.indexOf(location);
    }

    public void loadCustomer()
    {
        try
        {
            ArrayList<String> details = new ArrayList<>();
            details = io.readCustomer();
            for(int i = 0; i < details.size(); i++)
            { 
                String[] detail = details.get(i).split(",");
                customers.loadCustomer(detail);
            }
        }
        catch(Exception e)
        {
        }
    }

    public void loadOwner()
    {
        try
        {
            ArrayList<String> details = new ArrayList<>();
            details = io.readOwner();
            for(int i = 0; i < details.size(); i++)
            {
                String[] detail = details.get(i).split(",");
                owners.loadOwner(detail);
            }
        }
        catch(Exception e)
        {
        }
    }

    public void loadHall()
    {
        try
        {
            ArrayList<String> details = new ArrayList<>();
            details = io.readHall();
            for(int i = 0; i < details.size(); i++)
            {
                String[] detail = details.get(i).split(",");
                halls.loadHall(detail);
            }
        }
        catch(Exception e)
        {
        }
    }

    public void loadQuotation()
    {
        try
        {
            ArrayList<String> details = new ArrayList<>();
            details = io.readQuotation();
            for(int i = 0; i < details.size(); i++)
            {
                String[] detail = details.get(i).split(",");
                quotations.loadQuotation(detail);
            }
        }
        catch(Exception e)
        {
        }
    }

    public boolean ifregistedOwnerName(String name)
    {
        ArrayList names = new ArrayList();
        names = owners.getNames();
        for(int i = 0; i < names.size(); i++)
        {
            if(name.equals(names.get(i)))
                return true;
        }
        return false; 
    }

    public boolean ifregistedOwnerMail(String mail)
    {
        ArrayList mails = new ArrayList();
        mails = owners.getMails();
        for(int i = 0; i < mails.size(); i++)
        {
            if(mail.equals(mails.get(i)))
                return true;
        }
        return false; 
    }

    public boolean ifregistedCustomerName(String name)
    {
        ArrayList names = new ArrayList();
        names = customers.getNames();
        for(int i = 0; i < names.size(); i++)
        {
            if(name.equals(names.get(i)))
                return true;
        }
        return false; 
    }

    public boolean ifregistedCustomerMail(String mail)
    {
        ArrayList mails = new ArrayList();
        mails = customers.getMails();
        for(int i = 0; i < mails.size(); i++)
        {
            if(mail.equals(mails.get(i)))
                return true;
        }
        return false; 
    }

}
