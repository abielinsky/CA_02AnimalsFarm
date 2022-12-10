import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AnimalManager  implements Serializable {

    private final ArrayList<Animal> animalList;

//    private final ArrayList<Goat> GoatList;
//    private final ArrayList<BeefCow> BeefCowList;
//    private final ArrayList<Sheep> SheepList;


    public AnimalManager(String fileName) {
        this.animalList = new ArrayList<>();
        loadAnimalFromFile(fileName);
    }



    private void loadAnimalFromFile(String fileName) {

        int udderCapacity = 0;
       // String name = " ";
        String pedigree = "";
        try {
            Scanner reed = new Scanner(new File(fileName));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            reed.useDelimiter("[,\r\n]+");

            while (reed.hasNext()) {

                int id = reed.nextInt();
                String type = reed.next();
                int age = reed.nextInt();
                double weight = reed.nextDouble();

                String name = reed.next();

                if (type.equalsIgnoreCase("DairyCow") ||
                        type.equalsIgnoreCase("Goat")) {
//                    name = reed.next();
                    udderCapacity = reed.nextInt();
                }
                else {
//                    name = reed.next();
                    pedigree = reed.next();
                }
                if (type.equalsIgnoreCase("DairyCow") ||
                        type.equalsIgnoreCase("Goat")) {
                    // construct a DairyCow object and add it to the Animal list
                    animalList.add(new DairyCow(id, type, age, weight, name, udderCapacity));
                }
                else if (type.equalsIgnoreCase("BeefCow") ||
                        type.equalsIgnoreCase("Sheep")) {
                    // construct a BeefCow object and add it to the Animal list
                    animalList.add(new BeefCow(id, type, age, weight, name, pedigree));
                }
            }
            reed.close();
        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }



    public void displayAllAnimals()
    {
        System.out.printf("%-10s%-12s%-18s%-18s%-20s%-20s%-20s%-20s \n",
                "Id",
                "Type",
                "Age",
                "Weight",
                "nameDairyCow",
                "udderCapacity",
                "nameBeefCow",
                "pedigree"
                );

        System.out.println("=======   =========   ===============   ===============   =================   =================   ===============   ===============");
        for (Animal a : animalList)
            System.out.printf("%-10s%-12s%-18s%-18s%-20s%-20s%-20s%-20s\n",

                   a.getId(), a.getType(), a.getAge(), a.getWeight(),

                    (a instanceof DairyCow ? ((DairyCow) a).getName(): "-" ),
                    (a instanceof DairyCow ? ((DairyCow) a).getUdderCapacity(): "-"),
                    (a instanceof BeefCow ? ((BeefCow) a).getName(): "-"),
                    (a instanceof BeefCow ? ((BeefCow) a).getPedigree(): "-")
            );


    }


    public void saveAnimalToFile(String fileName) {
        try
        {
            PrintWriter out = new PrintWriter(fileName);
            for (Animal a : animalList) {
                if (a.getType().equalsIgnoreCase("DairyCow") || a.getType().equalsIgnoreCase("Goat"))
                    out.println(a.getId()+","+a.getType()+","+a.getAge()+","+a.getWeight()
                                +","+((DairyCow) a).getName()+","+((DairyCow) a).getUdderCapacity());
                else
                    out.println(a.getId()+","+a.getType()+","+a.getAge()+","+a.getWeight()
                            +","+((BeefCow) a).getName()+","+((BeefCow) a).getPedigree());
            }
            out.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException caught." + exception);
            exception.printStackTrace();
        }

    }


    public AnimalManager addNewDairyCow(Animal animal)  {
            animalList.add(animal);
            System.out.println("===========> ANIMAL ADDED <=========");
        return null;
    }

    public void addDairyCowInFile() throws IOException {
        FileWriter writer = new FileWriter("animals.txt");
        for (Animal animal : animalList) {
            String data = animal.getId() + "," + animal.getType() + "," + animal.getAge() + "," + animal.getWeight() ;
            writer.append(data + "\n");

        }
        writer.close();
        System.out.println("DAIRY COW IS SAVED IN FILE!!!");

    }


    public void editDairyCow(int id) {

        Animal animal = findAnimalByID(id);

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter new age of the animal: ");
        int newAge = input.nextInt();
        System.out.println("\nEnter the new weight: ");
        double NewWeight = input.nextDouble();

        animal.setAge(newAge);
        animal.setWeight(NewWeight);

        System.out.println(" ==========>  The FArm with ID " + id + " has been edited <===== ");

    }

    public Animal findAnimalByID(int id) {
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        System.out.println("\n=========>  There is no ANIMAL with id " + id + " in the list!  <====== ");
        return null;
    }



    public void deleteAnimalById(int animalID) {
        animalList.removeIf(n -> n.equals(findAnimalByID(animalID)));
//        animalList.removeIf(n -> (n.equals(findAnimalByID(animalID))));
//        animalList.removeIf(n -> (n.equals(animalID)));
//          animalList.removeIf(n -> (n.findAnimalByID.equals(animalID)));
    }


    public double calculateAverageMilk() {
        double total = 0;

        DairyCow b;
        for (int i=0; i<= animalList.size(); i++) {
//            total += b.getUdderCapacity();
//            total += DairyCow.get(i).getUdderCapacity();
        }

        return total / animalList.size();
    }
    
    
    
}
