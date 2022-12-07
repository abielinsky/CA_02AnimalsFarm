import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnimalManager   {

    private final ArrayList<DairyCow> DairyCowList;
//    private final ArrayList<Shed> ShedList;
//    private final ArrayList<Shed> ShedList;
//    private final ArrayList<Shed> ShedList;

    public AnimalManager(String fileName) {
        this.DairyCowList = new ArrayList<>();
        getDairyCowFile(fileName);
    }

    public List<DairyCow> getDairyCowList() {return this.DairyCowList; }

    private void getDairyCowFile(String filename) {

        try {
            Scanner INFO = new Scanner(new File(filename));
// DELIMITER FOR COMA OR NEXT LINE
            INFO.useDelimiter("[,\r\n]+");
            while (INFO.hasNext()) {
                int id = INFO.nextInt();
                String type = INFO.next();
                int age = INFO.nextInt();
                double weight = INFO.nextDouble();
                DairyCowList.add(new DairyCow(id, type, age, weight));
            }
            INFO.close();
        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }

    public void displayAllDailyCow() {
        if (!DairyCowList.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-35s %-45s \n", "ID", " TYPE", "AGE", "WEIGHT");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (DairyCow dairyCowList : this.DairyCowList) {
                System.out.printf("%-10d %-20s %-35s %-45s \n", dairyCowList.getId(), dairyCowList.getType(), dairyCowList.getAge(), dairyCowList.getWeight());
            }
        } else {
            System.out.println("\n *********** NO DAILY COWS IN THE DATA *************");
        }
    }

    public Farm addNewDailyCow(DairyCow dairyCow) throws IOException {
        boolean found = false;
        for (DairyCow dairyCow1 : DairyCowList) {
            if (dairyCow1.equals(dairyCow)) {
                found = true;
                System.out.println("DAIRY COW WITH SAME DATA");
                break;
            }
        }
        if (found == false) {
            DairyCowList.add(dairyCow);
            System.out.println("===========> DAIRY COW ADDED <=========");
        }
        return null;
    }


    //adding de information to the file
    public void addFarmInFile() throws IOException {
        FileWriter writer = new FileWriter("DairyCow.txt");
        for (DairyCow dairyCow : DairyCowList) {
            String data = dairyCow.getId() + "," + dairyCow.getType() + "," + dairyCow.getAge()+ "," + dairyCow.getWeight() ;
            writer.append(data + "\n");
        }
        writer.close();
        System.out.println("DAIRY COW IS SAVED IN FILE!!!");
    }

    public void editDairyCow(int id) {
        DairyCow dairyCow1 = findDairyCowbyID(id);
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter NEW TYPE of ANIMAL: ");
        String dairyCowType = input.nextLine();
        System.out.println("\nEnter NEW AGE of ANIMAL: ");
        int dairyCowAge = input.nextInt();
        System.out.println("\nEnter NEW WEIGHT of ANIMAL: ");
        int dairyCowWeight = input.nextInt();
        dairyCow1.setType(dairyCowType);
        dairyCow1.setAge(dairyCowAge);
        dairyCow1.setWeight(dairyCowWeight);
        System.out.println(" ==========>  The FArm with ID " + id + " has been edited <===== ");
    }

    public DairyCow findDairyCowbyID(int id) {
        for (DairyCow dairyCow : DairyCowList) {
            if (dairyCow.getId() == id) {
                return dairyCow;
            }
        }
        System.out.println("\n=========>  There is no FArm with id " + id + " in the list!  <====== ");
        return null;
    }




}
