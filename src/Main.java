public class Main {
    public static void main(String[] args) {

        SBI_Account Shivam = new SBI_Account("Shivam", "7977377098", 20000);

        System.out.println("Details before any transaction");
        System.out.println(Shivam.getName());
        System.out.println(Shivam.getAccount_No());
        System.out.println(Shivam.getIFSC());
        System.out.println(Shivam.getBalance());
        System.out.println(Shivam.getRateOfInterest());
        System.out.println(Shivam.getPassword());

//        FetchBalance(correct password)
        System.out.println(Shivam.FetchBalance("7977377098"));
//        wrong password first attempt
        System.out.println(Shivam.FetchBalance("545565"));
//        second attempt
        System.out.println(Shivam.FetchBalance("545565"));
//        third attempt
        System.out.println(Shivam.FetchBalance("545565"));
//        forth attempt
        System.out.println(Shivam.FetchBalance("545555"));
//        fifth attempt
        System.out.println(Shivam.FetchBalance("545555"));


//        Withdrawing(correct password && wrong amt)
        System.out.println(Shivam.withdraw("7977377098", 80000));
//        wrong password && correct amt
        System.out.println(Shivam.withdraw("79773770", 4000));
//        correct all
        System.out.println(Shivam.withdraw("7977377098", 10000));


//        Deposit(correct password)
        System.out.println(Shivam.deposit(1000000, "7977377098"));
//        wrong password
        System.out.println(Shivam.deposit(1000000, "7977"));


//        ChangePassword
//        both the passwords are same
        System.out.println(Shivam.ChangePassword("7977377098", "7977377098"));
//        current password wrong
        System.out.println(Shivam.ChangePassword("797737", "7506550261"));
//        correct all
        System.out.println(Shivam.ChangePassword("7977377098", "7506550261"));

//        RateOfReturn
        System.out.println(Shivam.calculateInterest(2));

        System.out.println("Details After Transactions");
        System.out.println(Shivam.getName());
        System.out.println(Shivam.getAccount_No());
        System.out.println(Shivam.getIFSC());
        System.out.println(Shivam.getBalance());
        System.out.println(Shivam.getRateOfInterest());
        System.out.println(Shivam.getPassword());
    }
}

