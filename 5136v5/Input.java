import java.util.Scanner;
/**
 * Write a description of class input here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Input
{

    public Input()
    {
    }

    public String String()
    {
        boolean ifOK = false;
        String tempStr = "";
        do{

            try{
                Scanner sc = new Scanner(System.in);
                tempStr = sc.nextLine();
                ifOK = true;
            }
            catch(Exception e)
            {
                System.out.println("Only integer input allowed, please try again...");
            }

        }while(ifOK == false);
        return tempStr;  
    }

    public int Int()
    {
        boolean ifOK = false;
        int tempInt = 0;
        do{

            try{
                Scanner sc = new Scanner(System.in);
                tempInt = sc.nextInt();
                ifOK = true;
            }
            catch(Exception e)
            {
                System.out.println("Only integer input allowed, please try again...");
            }

        }while(ifOK == false);

        return tempInt;  
    }

    public double Double()
    {
        boolean ifOK = false;
        double tempDou = 0.0;
        do{

            try{
                Scanner sc = new Scanner(System.in);
                tempDou = sc.nextDouble();
                ifOK = true;
            }
            catch(Exception e)
            {
                System.out.println("Only integer input allowed, please try again...");
            }

        }while(ifOK == false);
        return tempDou;  
    }

    public int valid12()
    {
        boolean ifOK = false;
        do{
            int tempInt= Int();
            if(tempInt == 1 || tempInt == 2)
            {
                ifOK = true;
                return tempInt;
            }
            else
            {
                System.out.println("Only 1/2 accepted");
            }
        }while(ifOK == false);
        return -1;
    }

    
        public int valid13()
    {
        boolean ifOK = false;
        do{
            int tempInt= Int();
            if(tempInt == 1 || tempInt == 2 || tempInt == 3)
            {
                ifOK = true;
                return tempInt;
            }
            else
            {
                System.out.println("Only 1/2/3 accepted");
            }
        }while(ifOK == false);
        return -1;
    }
    
        public int valid14()
    {
        boolean ifOK = false;
        do{
            int tempInt= Int();
            if(tempInt == 1 || tempInt == 2 || tempInt == 3 || tempInt == 4)
            {
                ifOK = true;
                return tempInt;
            }
            else
            {
                System.out.println("Only 1/2/3/4 accepted");
            }
        }while(ifOK == false);
        return -1;
    }    
    
        public int valid15()
    {
        boolean ifOK = false;
        do{
            int tempInt= Int();
            if(tempInt == 1 || tempInt == 2 || tempInt == 3 || tempInt == 4 || tempInt == 5 )
            {
                ifOK = true;
                return tempInt;
            }
            else
            {
                System.out.println("Only 1/2/3/4/5 accepted");
            }
        }while(ifOK == false);
        return -1;
    }
    
    public int valid19()
    {
        boolean ifOK = false;
        do{
            int tempInt= Int();
            if(tempInt == 1 || tempInt == 2 || tempInt == 3 || tempInt == 4 || tempInt == 5 || tempInt == 6 || tempInt == 7 || tempInt == 8 ||tempInt == 9)
            {
                ifOK = true;
                return tempInt;
            }
            else
            {
                System.out.println("Only 1/2/3/4/5/6/7/8/9 accepted");
            }
        }while(ifOK == false);
        return -1;
    }
    
        public double validDouble()
    {
        boolean ifOK = false;
        do{
            double tempDouble= Double();
            if(tempDouble <= 1 && tempDouble >=0)
            {
                ifOK = true;
                return tempDouble;
            }
            else
            {
                System.out.println("Only figure between 0 and 1 accepted");
            }
        }while(ifOK == false);
        return -1;
    }
    
    public String validPassWord()
    {
        boolean ifOK = false;
        String pattern = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";

        do{
            String tempStr= String();
            if(tempStr.matches(pattern) )
            {
                ifOK = true;
                return tempStr;
            }
            else
            {
                System.out.println("This is not a vaild password");
                System.out.println("Please enter it again...");
            }
        }while(ifOK == false);
        
        return null;
    }

    public String validDate()
    {
        boolean ifOK = false;
        String pattern = "[0-9][0-9][0-9][0-9].[0-9][0-9].[0-9][0-9]";

        do{
            String tempStr= String();
            if(tempStr.matches(pattern) )
            {
                ifOK = true;
                return tempStr;
            }
            else
            {
                System.out.println("This is not a vaild date ");
                System.out.println("Please enter it again...");
            }
        }while(ifOK == false);
        
        return null;
    } 
    
        public String validMail()
    {
        boolean ifOK = false;
        String pattern = "\\w+([-+_.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

        do{
            String tempStr= String();
            if(tempStr.matches(pattern) )
            {
                ifOK = true;
                return tempStr;
            }
            else
            {
                System.out.println("It is not a vaild e-mail address.");
                System.out.println("Please enter it again...");
            }
        }while(ifOK == false);
        
        return null;
    }
}
