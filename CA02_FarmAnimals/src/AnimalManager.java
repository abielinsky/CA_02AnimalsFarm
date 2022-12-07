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


    public Farm addNewDailyCow(DairyCow dailyCow) throws IOException {
        boolean found = false;
        for (DairyCow dailyCow1 : DairyCowList) {
            if (dailyCow1.equals(dailyCow)) {
                found = true;
                System.out.println("DAIRY COW WITH SAME DATA");
                break;
            }
        }
        if (found == false) {

            DairyCowList.add(dailyCow);

            System.out.println("===========> DAIRY COW ADDED <=========");

        }
        return null;
    }





}
