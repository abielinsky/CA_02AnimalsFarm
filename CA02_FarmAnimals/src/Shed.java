import java.util.ArrayList;
import java.util.Collection;
public class Shed {

    private int id;
    private String name;
//    private final
    private MilkTank tank;


    ArrayList <Animal> animalList;
    private MilkingMachine milkingMachine;

    public Shed(int id, String name, MilkTank tank) {
        this.id = id;
        this.name = name;
        this.tank = tank;
        this.animalList = new ArrayList<>();  //make it plural animals.. or animal|List
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


    @Override
    public String toString() {
        return "Shed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tank=" + tank +
                '}';
    }


}
