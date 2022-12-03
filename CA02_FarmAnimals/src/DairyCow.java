import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;


public class DairyCow extends Animal implements IMilkable{

    private static Random random = new Random(); // class variable, only one
    private int MIN_CAPACITY = 20;
    private int MAX_CAPACITY = 40;



    private String name;
    private double uddersStatus;
    private double udderBalance;
    int udderCapacity;
    private double milking; //


//    public DairyCow(String type, int age, double weight, double milking) {
//        super(type, age, weight);
//        this.milking = milking;
//    }

    public DairyCow(int id, String type, int age, double weight) {
        super(id, type, age, weight);
        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);

    }

    private final String[] NAMES = new String[]{
            "lala1", "lala2", "lala3", "lala4", "lala5",
            "lala6", "lala7", "lala8", "lala9", "lala10",
            "lala11", "lala12", "lala13", "lala14", "lala15",
            "lala16", "lala17", "lala18", "lala19", "lala20",
            "lala21", "lala22", "lala23", "lala24", "lala25",
            "lala26", "lala27", "lala28", "lala29", "lala30",};

    String nameCow = NAMES[new Random().nextInt(NAMES.length) ];



//    public DairyCow(){
//        super();
//        this.name= nameCow;
//        this.uddersStatus= 20 + random.nextInt(40);
//    }


//    public DairyCow(String name){
//
//
//        Random random = new Random();
//        this.name= name;
//        this.uddersStatus= 20 + new Random().nextInt(40);
//
//    }

    public String getName() {
        return name;
    }
    public int getUdderCapacity() {
        return udderCapacity;
    }




    DairyCow(int id){
        super(id); //calls animal constructor
        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);
        this.name= nameCow;

    }


    @Override
    public double milk() {
        double amount= 0 + new Random().nextInt(udderCapacity);
        return amount;
    }

    @Override
    public String toString() {
        return "DairyCow{" +

                "autoGeneratedID=" + autoGeneratedID +
                ", type='" + type  +
                ", age=" + age +
                ", weight=" + weight +
                ", nameCow=" + nameCow +
             //  ", NAMES=" + Arrays.toString(NAMES) +

                ", udderBalance=" + udderBalance +
                ", udderCapacity=" + udderCapacity +


                '}';
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





}

