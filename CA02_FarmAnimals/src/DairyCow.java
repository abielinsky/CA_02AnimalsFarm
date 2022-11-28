public class DairyCow extends Animal implements IMilkable{

    private int MIN_CAPACITY = 20;
    private int MAX_CAPACITY = 40;

    int udderCapacity;

    DairyCow(int id){
        super(id); //calls animal constructor
        this.udderCapacity = Random(MIN_CAPACITY, MAX_CAPACITY);
    }


    public double milk()
    {
        //code to milk an animal
        return Random (0, udderCapacity);
    }





}

