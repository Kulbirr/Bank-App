public interface BankAccountInterface {
    String FetchBalance(String password);

    String deposit(double amount, String password);

    String ChangePassword(String OldPassword, String newPassword);

    String withdraw(String password, double amount);
    double calculateInterest(int year);

}
