import java.util.Objects;

public class Farm {

    private int id;
    private String owner;
    private String postcode;
    private String phone;


    private AutoGeneratedID autoGeneratedID = AutoGeneratedID.getInstance("IdSet.txt");

    public Farm(String owner, String postcode, String phone) {

        // some minimal validation
        if (owner == null )
            throw new IllegalArgumentException("null arguments encountered");

        this.id = autoGeneratedID.getNextId();
        this.owner = owner;
        this.postcode = postcode;
        this.phone = phone;

    }

    public Farm(int id, String owner, String postcode, String phone) {

        if (owner == null)
            throw new IllegalArgumentException("NULL ELEMENTS");

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

    public String getPhone() {
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAutoGeneratedID(AutoGeneratedID autoGeneratedID) {
        this.autoGeneratedID = autoGeneratedID;
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


    @Override
    public String toString() {
        return "Farm{" +
                " id = " + id +
                ", owner='" + owner + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' + '}';
    }



}
