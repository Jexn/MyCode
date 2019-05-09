package Day08.experiment_2;

import java.util.Arrays;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[100];
        numberOfCustomer = 0;
    }

    public void addCustomer(String firstName, String lastName) {
        if (numberOfCustomer < customers.length) {
            customers[numberOfCustomer] = new Customer(firstName, lastName);
            numberOfCustomer++;
        }else {
            System.out.println("空间不足");
        }
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.length)
            return customers[index];
        else
            return null;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customers=" + Arrays.toString(customers) +
                ", numberOfCustomer=" + numberOfCustomer +
                '}';
    }
}
