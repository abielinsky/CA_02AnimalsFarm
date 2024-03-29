import java.util.ArrayList;
import java.util.Objects;

public class Farm {

    private int id;
    private String owner;
    private String postcode;
    private int phone;




    private  Shed shed;

    private ArrayList<Animal> animals;

    private MilkingMachine MilkingMachine;

    private  MilkTank milkTank;


    private AutoGeneratedID autoGeneratedID = AutoGeneratedID.getInstance("IdSet.txt");

    public Farm(String owner, String postcode, int phone) {
        // some minimal validation
        if (owner == null )
            throw new IllegalArgumentException("null arguments encountered");
        this.id = autoGeneratedID.getNextId();
        this.owner = owner;
        this.postcode = postcode;
        this.phone = phone;

    }

    public Farm(int id, String owner, String postcode, int phone) {
        if (owner == null)
            throw new IllegalArgumentException("NULL ELEMENTS");
        this.animals = new ArrayList<Animal>();
        this.id = id;
        this.owner = owner;
        this.postcode = postcode;
        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getPhone() {
        return phone;
    }

    public AutoGeneratedID getAutoGeneratedID() {
        return autoGeneratedID;
    }

    public void setId() {
        ////IT WILL BECOME ONLY FROM THE GENERATOR
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAutoGeneratedID(AutoGeneratedID autoGeneratedID) {
        this.autoGeneratedID = autoGeneratedID;
    }



    public void installMilkingMachine(MilkingMachine milkingMachine){
        this.shed.installMilkingMachine(milkingMachine);
    }

    public void addShed(Shed shed){
        this.shed= shed;
    }

    public void addMilkTank(MilkTank milkTank){
        this.milkTank= milkTank;
    }

    public void addCow (Animal animals){
        this.animals.add(animals);
    }

    public void addMilkingMachine(MilkingMachine milkingMachine){
        this.MilkingMachine= milkingMachine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farm farm = (Farm) o;
        return owner.equals(farm.owner) && postcode.equals(farm.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, postcode);
    }


//    @Override
//    public String toString() {
//        return "Farm{" +
//                " id = " + id +
//                ", owner='" + owner + '\'' +
//                ", postcode='" + postcode + '\'' +
//                ", phone='" + phone + '\'' +
//                ", shed=" + shed + '\'' +'}';
//
//
//    }


    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone=" + phone +
                ", shed=" + shed +
                ", animals=" + animals +
              //  ", milkTank=" + milkTank +
                ", milkMachine=" + MilkingMachine +
                '}';
    }





}
