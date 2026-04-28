import java.time.LocalDate;

public class Exercise2 {
    public static void question1(){

        Account[] accounts = new Account[5];
        for ( int i = 0; i < accounts.length; i++){
            accounts[i] = new Account();

            accounts[i].email = "Email " + (i + 1);
            accounts[i].userName = "User  " + (i + 1);
            accounts[i].fullName = "Full Name " + (i + 1);
            accounts[i].createDate = LocalDate.now();
        }
        for (Account acc: accounts){
            System.out.println(acc.email + " - " + acc.userName + " - " + acc.fullName + " - " + acc.createDate);
        }
    }
}
