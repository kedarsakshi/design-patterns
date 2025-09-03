
 interface BankAccount {
 void withdraw(double amount);
 void deposit(double amount);
    
}

class RealBankAccount implements BankAccount{
    private double balance;
    public RealBankAccount(double initiaBalance){
        this.balance=initiaBalance;
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount){
            balance -=amount;
            System.out.println("withdraw balance "+ amount+" remaining balance is : "+balance);
        }else{
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public void deposit(double amount) {
        balance +=amount;
         System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
    }
}

class BankAccountProxy implements BankAccount{
    private RealBankAccount rAccount;
    private String userRole;

    public BankAccountProxy(String userRole , double initiaBalance){
        this.rAccount=new RealBankAccount(initiaBalance);
        this.userRole=userRole;
    }

    @Override
    public void withdraw(double amount) {
        if(userRole.equalsIgnoreCase("Admin")){
            rAccount.withdraw(amount);
        }else{
             System.out.println("Access Denied: Only Admin can withdraw.");
        }

    }

    @Override
    public void deposit(double amount) {
        rAccount.deposit(amount);
    }
}

public class ProxyBankDemo {
    public static void main(String[] args) {
     BankAccount user=new BankAccountProxy("user", 500);   
     BankAccount admin=new BankAccountProxy("admin", 500);

     user.deposit(500);
     user.withdraw(200);

     admin.withdraw(300);

    }
}
