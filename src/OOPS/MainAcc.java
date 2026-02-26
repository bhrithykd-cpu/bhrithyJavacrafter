package OOPS;

public class MainAcc {
        public static void main(String[] args) {
            Account acc = new Account(5000);
            ATM atm = new ATM(acc);

            atm.checkBalance();
            atm.withdraw(2000);
            atm.checkBalance();
            atm.deposit(1500);
            atm.checkBalance();
        }
    }


