import java.util.Random;

public class DairyCow extends Animal implements IMilkable{

    private int MIN_CAPACITY = 20;
    private int MAX_CAPACITY = 40;
    private String name;
    private double uddersStatus;
    private double udderBalance;


    int udderCapacity;

    private final String[] NAMES = new String[]{
            "lala1", "lala2", "lala3", "lala4", "lala5",
            "lala6", "lala7", "lala8", "lala9", "lala10",
            "lala11", "lala12", "lala13", "lala14", "lala15",
            "lala16", "lala17", "lala18", "lala19", "lala20",
            "lala21", "lala22", "lala23", "lala24", "lala25",
            "lala26", "lala27", "lala28", "lala29", "lala30",};

    String test = NAMES[new Random().nextInt(NAMES.length)];

//    DairyCow(int id){
//import java.util.Random;
//
//public class DairyCow extends Animal implements IMilkable{
//
//    private int MIN_CAPACITY = 20;
//    private int MAX_CAPACITY = 40;
//    private String name;
//    private double uddersStatus;
//    private double udderBalance;
//
//
//    int udderCapacity;
//
//    private final String[] NAMES = new String[]{
//            "lala1", "lala2", "lala3", "lala4", "lala5",
//            "lala6", "lala7", "lala8", "lala9", "lala10",
//            "lala11", "lala12", "lala13", "lala14", "lala15",
//            "lala16", "lala17", "lala18", "lala19", "lala20",
//            "lala21", "lala22", "lala23", "lala24", "lala25",
//            "lala26", "lala27", "lala28", "lala29", "lala30",};
//
//    String test = NAMES[new Random().nextInt(NAMES.length)];
//
////    DairyCow(int id){
////        super(id); //calls animal constructor
////        this.name= test;
////        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);
////    }
//
//
//    DairyCow(int id){
//        super(id); //calls animal constructor
//        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);
//
//    }
//
//    @Override
//    public void milk() {
//
//        this.name= test;
//        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);
//    }
//
//
////    public double milk()
////    {
////        //code to milk an animal
////        return Random (0, udderCapacity);
////    }
//
//    public DairyCow(){
//        super();
//
//


    DairyCow(int id){
        super(id); //calls animal constructor
        this.udderCapacity= MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY);

    }

    @Override
    public void milk() {

    }


//    public double milk()
//    {
//        //code to milk an animal
//        return Random (0, udderCapacity);
//    }
//
//    public DairyCow(String name){
//
//        this.name= name;
//
//    }
//
//
//
//
//
//
//}

