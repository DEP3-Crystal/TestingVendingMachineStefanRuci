import java.util.ArrayList;
import java.util.Scanner;
//        Vending machine has following coins: 1c, 5c, 10c, 25c, 50c, 1$.
////                Your task is to write a program that will be used in a vending machine to return change.
//                Assume vending machine will always want to return the least number of coins.
//        Devise a function getChange(M, P) where M is how much money was inserted into the machine and
//        P the price of the item selected that returns an array of the integer representing the
//        number of denominations to return.
//
//        Example:
//        getChange(5, 0.99) should return [1,0,0,0,0,4]
//
//        4.01
//        0.01 -> 0.1

public class VendingMachine {
    private double amount;
    private double price;

    public VendingMachine() {

    }

    public VendingMachine(double amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Integer> getChange() {

        int c1, c5, c10, c50, d1, c25;
        int rd1, rc5, rc10, rc25, rc50;
        double change = this.amount - this.price;
        d1 = (int) (change / 1); //d1=1
        int rchange = (int) (change * 100);
        rd1 = rchange % 100;//rd1=0.7
        c50 = rd1 / 50;
        rc50 = rd1 % 50;
        c25 = rc50 / 25;
        rc25 = rc50 % 25;
        c10 = rc25 / 10;
        rc10 = rc25 % 10;
        c5 = rc10 / 5;
        rc5 = rc10 % 5;
        c1 = rc5;
        ArrayList<Integer> rest = new ArrayList<>(6);
        rest.add(0, c1);
        rest.add(1, c5);
        rest.add(2, c10);
        rest.add(3, c25);
        rest.add(4, c50);
        rest.add(5, d1);
        return rest;//18.91
    }

    public void menu() {
        System.out.println("Press :\n1 : For picking a product \n0 : Exit Program ");
        System.out.println("2 : For displaying menu again ");

    }

    void setAmountAndPrice() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter  amount of money that you will put inside :  ");
        this.amount = in.nextDouble();
        System.out.println("Enter   the price of the product you want to buy : ");
        this.price = in.nextDouble();
        getChange();
    }

    boolean validAmount() {
        if (this.amount >= this.price && this.amount < 50) {
            return true;
        } else return false;
    }

    void notValidAmountMesage() {
        if (this.amount < this.price) {
            System.out.println("Your amount is enough for this product");
        } else System.out.println("amount must be under 50 $");

    }

    public void clientProcessing() {
        setAmountAndPrice();
        if (validAmount()) {
            System.out.println("Your change is " + getChange());
            menu();

        } else {
            notValidAmountMesage();
            menu();
        }
    }

    public static void main(String[] args) {
        System.out.println("VENDING MACHINE");
        System.out.println(" Vending machine has following coins: 1c, 5c, 10c, 25c, 50c, 1$ \n");
        VendingMachine client01 = new VendingMachine();
        int chose = -1;
        Scanner in = new Scanner(System.in);
        client01.menu();
        do {
            chose = (int)in.nextLine().charAt(0);
            switch (chose) {
                case 1:
                    client01.clientProcessing();
                    break;
                case 0:
                    System.exit(0);
                    break;
                case 2:
                default:
                    client01.menu();
            }
        } while (chose !=0);

    }


}
