import java.util.Random;

public class Goat extends Animal implements IMilkable{

    private Random random = new Random();
    private int MIN_CAPACITY = 20;
    private int MAX_CAPACITY = 40;
    private String name;
    private double uddersStatus;
    private double udderBalance;
    int udderCapacity;
    private double milking; //


    public Goat(String type, int age, double weight, double milking) {
        super(type, age, weight);
        this.milking = milking;
    }

    public Goat(int id, String type, int age, double weight) {
        super(id, type, age, weight);
        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);

    }



    public String getName() {
        return name;
    }
    public int getUdderCapacity() {
        return udderCapacity;
    }




    public int getMIN_CAPACITY() {
        return MIN_CAPACITY;
    }
    public void setMIN_CAPACITY(int MIN_CAPACITY) {
        this.MIN_CAPACITY = MIN_CAPACITY;
    }
    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
    public void setMAX_CAPACITY(int MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getUddersStatus() {
        return uddersStatus;
    }
    public void setUddersStatus(double uddersStatus) {
        this.uddersStatus = uddersStatus;
    }
    public double getUdderBalance() {
        return udderBalance;
    }
    public void setUdderBalance(double udderBalance) {
        this.udderBalance = udderBalance;
    }

    public void setUdderCapacity(int udderCapacity) {
        this.udderCapacity = udderCapacity;
    }
    public double getMilking() {
        return milking;
    }
    public void setMilking(double milking) {
        this.milking = milking;
    }






    @Override
    public double milk() {

        double amount= 0 + new Random().nextInt(udderCapacity);

        return amount;
    }


    @Override
    public String toString() {
        return "Goat{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                ", milking=" + milking +
                '}';
    }


}
