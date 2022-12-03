public class MilkingMachine {

    private MilkTank milkTank;

    // CHECK THIS METHOD

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

    @Override
    public String toString() {
        return "MilkingMachine{" +
              //  "milkTank=" + milkTank +
                '}';
    }
}
