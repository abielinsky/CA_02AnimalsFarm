public class Sheep {

    private String name;
    private int age;
    private double weight;
    private String pedigree;


    public Sheep(String name, int age, double weight, String pedigree) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.pedigree = pedigree;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", pedigree='" + pedigree + '\'' +
                '}';
    }



}
