package banksystem;

import java.util.Scanner;

public class BankSystem {

    static Scanner in = new Scanner(System.in);
    static final String adminuser="admin";
    static final String adminpass="123456";
    static int count = 100;
    static int []customerID = new int[count];
    static String []customerName = new String[count];
    static String []customerPhone = new String[count];
    static double []customerAmmount = new double[count];
    static int countAll = 0;
    static int contCustomer = 0;
    public static void login(String username,String password ){
        if(username.equals(adminuser )&& password.equals(adminpass )){
           System.out.println("Successfully logged in .......... User Manager ");
           admintmenu();
        }
        else{
           System.out.println("Username or password error. Try again");
        }      
    }
    
    static void admintmenu(){
        boolean t= true;
            while (t) {
             System.out.println(""+
                    "1. Create new account\n"
             + "2. Deposit an ammount in an account\n"
             + "3. Withdrow an ammount from an account\n"
             + "4. Delete a bank account\n"
             + "5. Search for a bank account \n"
             + "6. View all bank accounts\n"
             + "7. Enter 7 if you want to exit \n"
             + "Please enter the type of poeration");
                int s = in.nextInt();
                switch(s){
                case 1:CreateAccount();
                break;
                case 2:DepositAmmount();
                break;
                case 3:WithdrowAmmount();
                break;
                case 4:DeleteCustomer();
                break;
                case 5:ammountSearch();
                break;
                case 6:displayAll();
                break;
                case 7: t= false;
                break;
                default:System.out.println("Wrong selection");  
            }  
        }
    }
     
     
    public static void CreateAccount(){
        
        customerID[contCustomer] = contCustomer;
        System.out.print("Enter the customer name: ");
        customerName [contCustomer] = in.next();
        System.out.print("Enter the customer phone number: ");
        customerPhone[contCustomer] = in.next();
        System.out.print("Enter the customer ammount: ");
        customerAmmount [contCustomer] = in.nextDouble();
        System.out.println("Successfully added");
        countAll++;
        contCustomer++;
    }
        
    public static void DepositAmmount () {
        System.out.print("Enter the customer number that you want to deposit money in his account: ");
        int id = in.nextInt();
        for (int i = 0; i < customerName.length; i++) {
            if (id == customerID[i]) {
                System.out.print("Enter the ammount that he want to deposit: ");
                double ammount = in.nextDouble();
                customerAmmount[i] += ammount;
                System.out.println("Successfully deposit");
                break;
            }
            else{
                System.out.println("ID does not exist");
                break;
            }
        }
    }
      
    public static void WithdrowAmmount () {
        System.out.print("Enter the customer number that you want to withdrow money in his account: ");
        int id = in.nextInt();
        for (int i = 0; i < customerName.length; i++) {
            if (id == customerID[i]) {
                System.out.print("Enter the ammount that he want to withdrow: ");
                double ammount = in.nextDouble();
                customerAmmount[i] -= ammount;
                System.out.println("Successfully withdrow");
                break;
            }
            else{
                System.out.println("ID does not exist");
                break;
            }
        }
    }
        
    public static void DeleteCustomer(){
        System.out.print("Enter the customer number :");
        int num  = in.nextInt();
        for (int i = 0; i < customerID.length; i++) {
            if (num == customerID[i]) {
                customerID[i] = 0;
                customerName[i] = null;
                customerPhone[i] = null;
                customerAmmount[i]= 0;
                System.out.println("Successfully deleted");
                break;

            }else{
                System.out.println("ID does not exist");
                break;
            }
        }
    }
      
    public static void ammountSearch () {
        System.out.print("Search for a bank account");
        System.out.print("Enter the customer name that you want to research of: ");
        String name = in.next();
        for (int i = 0; i < customerName.length; i++) {
            if (name.equalsIgnoreCase(customerName[i])) {
                 System.out.println("Bank account exist");
                 break;
            }
            else{
                System.out.println("Bank account does not exist");
                break;
            }
      }
    }
       
    public static void displayAll() {
        System.out.println("View all account bank");
            for (int i = 0; i < countAll; i++) {
                System.out.println("name= " + customerName[i] + " phone number= " + customerPhone[i] + " ammount= " + customerAmmount[i]);
            }
    }
    
    public static void main(String[] args) {
       System.out.println("******Welcome to the Bank System******");
       System.out.println("Please sign in to continue");
       boolean logged=false;
       String username,password;
        int option;
        do{
            System.out.println(" log in -1 ");
            System.out.println(" Exit -0 ");
            System.out.print (" Please choose to continue ");
            option=in.nextInt();

            switch(option){
                case 1:
                    logged=true;
                    System.out.println("Enter your username");
                    username=in.next();
                    System.out.println("Enter the password");
                    password=in.next();
                    login(username,password);
                    break;

                case 0:
                    logged=false;
                    break;

                default:
                    System.out.println("Wrong selection");
            }
        }
        while(logged);     
    }
    
}
