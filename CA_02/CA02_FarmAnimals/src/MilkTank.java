public class MilkTank {


    private double capacity;
    private double currentAmount;

    public MilkTank(int capacity) {
        this.capacity = capacity;
    }

    public MilkTank() {
        this.capacity = 2000;
    }

    public double getCapacity() {
        return capacity;
    }

    public double freeSpace(){
        return currentAmount - capacity;
    }

    public void addToTank(double amount){


    }


    public double getFromTank(double amount){
    if (currentAmount >= capacity){
        currentAmount -= amount;
        return amount;

    }else {
        System.out.println("Empty Tank");
    }

    return 0.00;
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "capacity=" + capacity +
                ", currentAmount=" + currentAmount +
                '}';
    }


}
