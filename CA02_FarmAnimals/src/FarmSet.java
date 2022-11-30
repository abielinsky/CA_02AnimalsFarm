import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FarmSet {

    private final ArrayList<Farm> FarmList;

    public FarmSet(String fileName) {
        this.FarmList = new ArrayList<>();
        getFarmFile(fileName);
    }

    public List<Farm> getFarms() {
        return this.FarmList;
    }

    private void getFarmFile(String filename) {

        try {
            Scanner INFO = new Scanner(new File(filename));
// DELIMITER FOR COMA OR NEXT LINE
            INFO.useDelimiter("[,\r\n]+");

            while (INFO.hasNext()) {
                int id = INFO.nextInt();
                String owner = INFO.next();
                String postcode = INFO.next();
                String phone = INFO.next();

                FarmList.add(new Farm(id, owner, postcode, phone));
            }
            INFO.close();

        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }


    public void displayAllFarms() {
        if (!FarmList.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-35s %-45s \n", "ID", " Owner", " PostCode", " Phone");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (Farm farm : this.FarmList) {
                System.out.printf("%-10d %-20s %-35s %-45s \n", farm.getId(), farm.getOwner(), farm.getPostcode(), farm.getPhone());
            }
        } else {
            System.out.println("\n *********** NO FARMS IN THE DATA *************");
        }

    }



    public Farm addNewFarm(Farm farm) throws IOException {
        boolean found = false;
        for (Farm farm1 : FarmList) {
            if (farm1.equals(farm)) {
                found = true;
                System.out.println("FARM WITH SAME DATA");
                break;
            }
        }
        if (found == false) {

            FarmList.add(farm);

            System.out.println("===========> FARM ADDED <=========");

        }
        return null;
    }


    //adding de information to the file
    public void addFarmInFile() throws IOException {
        FileWriter writer = new FileWriter("farm.txt");
        for (Farm farm : FarmList) {
            String data = farm.getId() + "," + farm.getOwner() + "," + farm.getPostcode() + "," + farm.getPhone() ;
            writer.append(data + "\n");

        }
        writer.close();
        System.out.println("FARM IS SAVED IN FILE!!!");

    }









}
