import java.util.ArrayList;
import java.util.Collection;

public class Shed {

    private int id;
    private String name;
//    private final
    private MilkTank tank;

    public Shed(int id, String name, MilkTank tank) {
        this.id = id;
        this.name = name;
        this.tank = tank;
        ArrayList <Animal> animal = new ArrayList<>();
    }


    public MilkTank getTank() {
        return tank;
    }

    public void installMilkingMachine(MilkingMachine milkingMachine){


    }

    public void milkAnimal(Animal animal){




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
