import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShedsSet {

    private final ArrayList<Shed> ShedList;


    public ShedsSet(String fileName) {
        this.ShedList = new ArrayList<>();
        getShedsFile(fileName);
    }

    public ArrayList<Shed> getSheds() {
        return this.ShedList;
    }

    private void getShedsFile(String filename) {

        try {
            Scanner INFO = new Scanner(new File(filename));
// DELIMITER FOR COMA OR NEXT LINE
            INFO.useDelimiter("[,\r\n]+");

            while (INFO.hasNext()) {
                int id = INFO.nextInt();
                String name = INFO.next();

                ShedList.add(new Shed(id, name));
            }
            INFO.close();

        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }


    public void displayAllSheds() {
        if (!ShedList.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s  \n", "ID", " Name ");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (Shed shed : this.ShedList) {
                System.out.printf("%-10d %-20s  \n", shed.getId(), shed.getName());
            }
        } else {
            System.out.println("\n *********** NO SHEDS IN THE DATA *************");
        }

    }

    public Shed addNewShed(Shed shed) throws IOException {
        boolean found = false;
        for (Shed shed1 : ShedList) {
            if (shed.equals(shed1)) {
                found = true;
                System.out.println("SHED WITH SAME DATA");
                break;
            }
        }
        if (found == false) {
            ShedList.add(shed);
            System.out.println("===========> SHED ADDED <=========");
        }
        return null;
    }



    public void addShedInFile() throws IOException {
        FileWriter writer = new FileWriter("shed.txt");
        for (Shed shed : ShedList) {
            String data = shed.getId() + "," + shed.getName()  ;
            writer.append(data + "\n");
        }
        writer.close();
        System.out.println("FARM IS SAVED IN FILE!!!");
    }

    public void editShed(int id) {
        Shed shed1 = findShedByID(id);
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter NAME of SHED: ");
        String shedName = input.nextLine();
        shed1.setName(shedName);
        System.out.println(" ==========>  The FArm with ID " + id + " has been edited <===== ");
    }

    public Shed findShedByID(int id) {
        for (Shed shed : ShedList) {
            if (shed.getId() == id) {
                return shed;
            }
        }
        System.out.println("\n=========>  There is no SHED with id " + id + " in the list!  <====== ");
        return null;
    }


    public void deleteShed(int id) {
        for (Shed shed : ShedList) {

            if (shed.getId() == id) {

                ShedList.remove(shed);
                System.out.println("The SHED with " + id + " DELETED");
                break;
            }
        }
    }



}
