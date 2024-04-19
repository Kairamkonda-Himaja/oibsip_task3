import java.util.Scanner;

public class AtmInterface {
    String name;
    String username;
    String password;
    String account_no;
    float balance=100000f;
    String transactionsHistory=" ";
    int transactions=0;
    Scanner sc=new Scanner(System.in);
    public void register(){
       // System.out.println("***WELCOME TO SBI BANK***");
        System.out.println("---REGISTRATION FORM---");
        System.out.println();
        System.out.print("Enter YourName : ");
        name=sc.next();
        System.out.println();
        System.out.print("Enter UserName : ");
        username=sc.next();
        System.out.println();
        System.out.print("Enter password : ");
        password=sc.next();
        System.out.println();
        System.out.print("Enter Account number : ");
        account_no=sc.next();
        System.out.println();
        System.out.println("--REGISTRATION COMPLETED ..! LOGIN PLEASE--");
        System.out.println();

    }
    public boolean login(){
        boolean login=false;
        System.out.println("---LOGIN FORM---");
        System.out.println("Enter UserName : ");
        String uname=sc.next();
        System.out.println();
        while (!login) {
            if(username.equals(uname)){
                System.out.print("Enter correct password : ");
                String pswd=sc.next();
                System.out.println();
                while (!login) {
                    if(password.equals(pswd)){
                        System.out.println("Login Successful");
                        login=true;
                    }
                    else{
                        System.out.println("Incorrect password.!");
                        login=false;
                        break;
                    }   
                }
                
            }
            else{
                System.out.println("Incorrect UserName.!");
            }
        }
        System.out.println();
        return login;
    }
    public void withDraw(){
        System.out.print("Enter Amount To Be Withdrawn : ");
        float withDrawAmt=sc.nextFloat();
        System.out.println();
        if(balance>=withDrawAmt){
            balance-=withDrawAmt;
            System.out.println("Amount Withdrawn Successfully.!");
            transactions++;
            String str=withDrawAmt+"rs withdrawn\n";
            transactionsHistory=transactionsHistory.concat(str);
            
        }
        else{
            System.out.println("Insufficent Amount.!");
        }
        System.out.println();
    }
    public void deposite(){
        System.out.print("Enter amount to be deposited : ");
        float depositeAmt=sc.nextFloat();
        System.out.println();
        if(depositeAmt<100000f){
            balance+=depositeAmt;
            System.out.println("Amount Deposited Successsfully.!");
            transactions++;
            String str=depositeAmt+" rs deposited\n";
            transactionsHistory=transactionsHistory.concat(str);
        }
        System.out.println();
    }
    public void transfer(){
        System.out.print("Enter recipient Name :  ");
        String recipient=sc.next();
        System.out.println();
        System.out.print("Enter Transfer Amount : ");
        float transferAmt=sc.nextFloat();
        System.out.println();
        if(balance>=transferAmt){
            balance-=transferAmt;
            System.out.println("Amount "+transferAmt+" rs transferred Successfully to "+recipient);
            transactions++;
            String str=transferAmt+"rs transferred\n";
            transactionsHistory=transactionsHistory.concat(str);
        }
        else{
            System.out.println("Insufficient Balance");
        }
        System.out.println();
    }


    public void checkBalance(){
        System.out.println("Total Balance : "+balance);
        System.out.println();
    }
    public void transactionsHistory(){
        if(transactions==0){
            System.out.println("Empty.!");
        }
        else{
            System.out.println("\n"+transactionsHistory);
        }
        System.out.println();
    }
}

 class AtmInterfaceMain {

    public static void main(String[] args) {
        System.out.println("Welcome to SBI bank..!");
        System.out.println("Register Here");
        Scanner sc=new Scanner(System.in);
        AtmInterface b=new AtmInterface();
        b.register();
        System.out.println("Do you want to login (yes/no)..?");
        String ans=sc.next();
        if(ans.equalsIgnoreCase("yes")){
           boolean loginStatus= b.login();
            if(loginStatus){
            System.out.println("Welcome "+b.name);
            boolean isFinished=false;
            while (!isFinished) {
                System.out.println("\n 1.Withdraw\n 2.deposite\n 3.transfer\n 4.checkBalance\n 5.transaction history\n 6.Exit\n");
                System.out.print("Enter your choice : ");
                int choice=sc.nextInt();
                System.out.println();
            switch (choice) {
                case 1:
                
                    b.withDraw();
                   break;
                case 2:
                    b.deposite();
                    break;
                case 3:
                    b.transfer();
                    break;
                case 4:
                    b.checkBalance();
                    break;
                case 5:
                    b.transactionsHistory();
                    break;
                case 6 :
                    return;
                default:
                    System.out.println("Provide Valid Input");
                    break;
            }
        }
    }
        }
        else{
            System.out.println("Thanks for Registering");
        }

    sc.close();
       
    }

}