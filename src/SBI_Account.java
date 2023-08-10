import java.util.UUID;

public class SBI_Account implements BankAccountInterface {
    private String Name;

    private String password;

    private double balance;

    private String Account_No;

    final double rateOfInterest = 2.70;

    final String IFSC = "SBI039850";


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_No() {
        return Account_No;
    }

    public void setAccount_No(String account_No) {
        Account_No = account_No;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSC() {
        return IFSC;
    }


    public SBI_Account() {

    }

    public SBI_Account(String name, String password, double balance) {
        Name = name;
        this.password = password;
        this.balance = balance;
        this.Account_No = String.valueOf(UUID.randomUUID());
    }


    int count = 0;

    @Override
    public String FetchBalance(String password) {
        if (this.password.equals(password)) {
            count = 0;
            return "Your current balance is " + balance;
        } else {
            if (count < 4) {
                count++;
                int tries = 4 - count;
                return "Incorrect Password you have " + tries + " try available";
            }
        }
        return "Please Contact your nearest branch to reset your password";
    }

    @Override
    public String deposit(double amount, String password) {
        if (this.password.equals(password)) {
            double totalAmt = this.balance + amount;
            setBalance(totalAmt);
            return "Transaction Successful! " + amount + " has been added to your account. your updated balance is " + totalAmt;
        } else {
            return "Incorrect Password!";
        }
    }

    @Override
    public String ChangePassword(String OldPassword, String newPassword) {
        if (this.password.equals(OldPassword) && this.password.equals(newPassword)) {
            return "New password can't be same as the old password!";
        } else if (this.password.equals(OldPassword) && this.password != newPassword) {
            this.password = newPassword;
            return "Password Changed Successfully";
        }
        return "Incorrect Password!";
    }

    @Override
    public String withdraw(String password, double amount) {
        if (this.password.equals(password)) {
            if (amount <= this.balance) {
                double amt = this.balance - amount;
                setBalance(amt);
                return "Transaction Successful! your Acc: " + getAccount_No() + " debited by " + amt + ".";
            } else if (amount > this.balance) {
                return "Insufficient Balance!";
            }
        } else
            return "Incorrect Password";
        return null;
    }

    @Override
    public double calculateInterest ( int year){
        return (balance * rateOfInterest * year) / 100;
    }

    @Override
    public String toString () {
        return "HDFC_Account{" +
                "Name='" + Name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", Account_No='" + Account_No + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSC='" + IFSC + '\'' +
                '}';
    }
}