import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MilkTankSet {

    private final ArrayList<MilkTank> MilkTankList;

    public MilkTankSet(String fileName) {
        this.MilkTankList = new ArrayList<>();
        getMilkTankFile(fileName);
    }

    private void getMilkTankFile(String fileName) {
        try {
            Scanner INFO = new Scanner(new File(fileName));
            // DELIMITER FOR COMA OR NEXT LINE
            INFO.useDelimiter("[,\r\n]+");

            while (INFO.hasNext()) {
                int id = INFO.nextInt();
                String name = INFO.next();
                int capacity = INFO.nextInt();
                MilkTankList.add(new MilkTank(id, name, capacity));
            }
            INFO.close();

        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }

    public void displayAllTanks() {
        if (!MilkTankList.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s \n", "ID", " Name ", " Capacity ");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (MilkTank milkTank : this.MilkTankList) {
                System.out.printf("%-10d %-20s %-20s \n", milkTank.getId(), milkTank.getNameTank(), milkTank.getCapacity());
            }
        } else {
            System.out.println("\n *********** NO TANKS INSTALLED *************");
        }
    }


    public Shed installTank(MilkTank milkTank) throws IOException {
        boolean found = false;
        for (MilkTank milkTank1 : MilkTankList) {
            if (milkTank.equals(milkTank1)) {
                found = true;
                System.out.println("TANK ALREADY EXISTS");
                break;
            }
        }
        if (found == false) {
            MilkTankList.add(milkTank);
            System.out.println("===========> NEW TANK INSTALLED <=========");
        }
        return null;
    }

    public void addMilkTankInFile() throws IOException {
        FileWriter writer = new FileWriter("milktanks.txt");
        for (MilkTank milkTank : MilkTankList) {
            String data = milkTank.getId() + "," + milkTank.getNameTank() + "," + milkTank.getCapacity() ;
            writer.append(data + "\n");
        }
        writer.close();
//        System.out.println("MACHINE INSTALLED");
    }


    public void editTank(int id) {
        MilkTank milkTank1 = findTankByID(id);
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter NAME of TANK: ");
        String nameMachine = input.nextLine();
        milkTank1.setNameTank(nameMachine);
        System.out.println("\nEnter capacity of TANK: ");
        int nameTank = input.nextInt();
        milkTank1.setCapacity(nameTank);
        System.out.println(" ==========>  The MACHINE with ID " + id + " has been edited <===== ");
    }

    public MilkTank findTankByID(int id) {
        for (MilkTank milkTank : MilkTankList) {
            if (milkTank.getId() == id) {
                return milkTank;
            }
        }
        System.out.println("\n=========>  There is no TANKS with id " + id + " in the list!  <====== ");
        return null;
    }

    public void deleteTank(int id) {
        for (MilkTank milkTank : MilkTankList) {

            if (milkTank.getId() == id) {

                MilkTankList.remove(milkTank);
                System.out.println("The TANK with " + id + " HAS BEEN DESsINSTALLED");
                break;
            }
        }
    }



}






































