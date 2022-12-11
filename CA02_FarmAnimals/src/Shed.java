import java.util.ArrayList;
import java.util.Collection;
public class Shed {

    private int id;
    private String name;
//    private final
    private MilkTank tank;

    private  MilkTank milkTank;


    private AutoGeneratedID autoGeneratedID = AutoGeneratedID.getInstance("IdSet.txt");

    private ArrayList<Animal> animals;
    ArrayList <Animal> animalList;
    private MilkingMachine milkingMachine;

    public Shed(String name) {
        if (name == null )
            throw new IllegalArgumentException("null arguments encountered");
        this.id = autoGeneratedID.getNextId();
        this.name = name;
    }

    public Shed(int id, String name) {
        this.id = id;
        this.name = name;
      //  this.tank = tank;
        this.animalList = new ArrayList<>();  //make it plural animals.. or animal|List
    }

    public void addMilkTank(MilkTank milkTank){
        this.milkTank= milkTank;
    }

    public MilkTank getTank() {
        return tank;
    }

    public MilkTank getMilktank(){
        return this.getMilktank();
    }


    public void installMilkingMachine(MilkingMachine milkingMachine){
        this.milkingMachine = milkingMachine;
        this.milkingMachine.setMilkTank(this.tank);

    }



    public void milkAllAnimals(){

            try {
               for (Animal animal : animalList)
                    if(animal instanceof IMilkable){   // introduce this to see result

                        this.milkingMachine.milk((IMilkable)animal);
                    }
            }
            catch (Exception e){
                throw new IllegalStateException("The Milking machine has not been installed");
            }

    }


    public void milkAnimal(Collection<Animal> animals){



    }

    public void addTank(MilkTank tank){
        this.tank= tank;
    }

    @Override
    public String toString() {
        return "Shed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", milkTank=" + milkTank +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTank(MilkTank tank) {
        this.tank = tank;
    }

    public MilkTank getMilkTank() {
        return milkTank;
    }

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }

    public AutoGeneratedID getAutoGeneratedID() {
        return autoGeneratedID;
    }

    public void setAutoGeneratedID(AutoGeneratedID autoGeneratedID) {
        this.autoGeneratedID = autoGeneratedID;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public MilkingMachine getMilkingMachine() {
        return milkingMachine;
    }

    public void setMilkingMachine(MilkingMachine milkingMachine) {
        this.milkingMachine = milkingMachine;
    }
}
