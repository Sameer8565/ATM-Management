import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.pin=552;
        obj.checkPin();
    }
}

class ATM {
    float balance;
    int pin;
    double accountNumber = 12345678;

    public void checkPin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Invalid PIN. Try again.");
            System.out.println("If you have forgotten your PIN, enter 5.");
            int choice = sc.nextInt();
            if (choice == 5) {
                forgetPin();
            }
        }
    }

    public void menu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Forget PIN");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                forgetPin();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                menu();
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw:");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Money withdrawn successfully.");
        }
        menu();
    }

    public void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit:");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Money deposited successfully.");
        menu();
    }

    public void forgetPin() {
        System.out.println("Enter your account number:");
        Scanner sc = new Scanner(System.in);
        double enteredAccountNumber = sc.nextDouble();
        if (enteredAccountNumber == accountNumber) {
            System.out.println("Enter new PIN:");
            int newPin = sc.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Account number does not match.");
        }
        menu();
    }
}
