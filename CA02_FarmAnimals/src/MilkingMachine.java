public class MilkingMachine {

    private int id;
    private String NameMachine;
    private MilkTank milkTank;

    // CHECK THIS METHOD

    public MilkingMachine(String nameMachine) {
        NameMachine = nameMachine;
    }

    public MilkingMachine(){

    }

    public MilkTank getMilkTank() {
        return this.milkTank;
    }

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }

    public void milk(IMilkable animal) {

        double amount = animal.milk();


        if(this.milkTank == null){
            System.out.println("MILKING MACHINE NOT INSTALLED");
        }
        else{
            this.milkTank.addMilkToTank(amount);
        }

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMachine() {
        return NameMachine;
    }

    public void setNameMachine(String nameMachine) {
        NameMachine = nameMachine;
    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
              //  "milkTank=" + milkTank +
                '}';
    }
}
