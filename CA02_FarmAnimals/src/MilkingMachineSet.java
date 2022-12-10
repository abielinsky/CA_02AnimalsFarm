import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MilkingMachineSet {

    private final ArrayList<MilkingMachine> MilkingMachineList;

    public MilkingMachineSet(String fileName) {
        this.MilkingMachineList = new ArrayList<>();
        getMilkingMachineFile(fileName);
    }



    private void getMilkingMachineFile(String filename) {

        try {
            Scanner INFO = new Scanner(new File(filename));
// DELIMITER FOR COMA OR NEXT LINE
            INFO.useDelimiter("[,\r\n]+");

            while (INFO.hasNext()) {
                int id = INFO.nextInt();
                String name = INFO.next();

                MilkingMachineList.add(new MilkingMachine(id, name));
            }
            INFO.close();

        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }

    public void displayAllMilkMachines() {
        if (!MilkingMachineList.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s  \n", "ID", " Name ");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (MilkingMachine milkingMachine : this.MilkingMachineList) {
                System.out.printf("%-10d %-20s  \n", milkingMachine.getId(), milkingMachine.getNameMachine());
            }
        } else {
            System.out.println("\n *********** NO MACHINES INSTALLED *************");
        }

    }

    public Shed installMachine(MilkingMachine milkingMachine) throws IOException {
        boolean found = false;
        for (MilkingMachine milkingMachine1 : MilkingMachineList) {
            if (milkingMachine.equals(milkingMachine1)) {
                found = true;
                System.out.println("MACHINE ALREADY EXISTS");
                break;
            }
        }
        if (found == false) {
            MilkingMachineList.add(milkingMachine);
            System.out.println("===========> MACHINE INSTALLED <=========");
        }
        return null;
    }


    public void addMachineInFile() throws IOException {
        FileWriter writer = new FileWriter("milkingMachine.txt");
        for (MilkingMachine milkingMachine : MilkingMachineList) {
            String data = milkingMachine.getId() + "," + milkingMachine.getNameMachine()  ;
            writer.append(data + "\n");
        }
        writer.close();
//        System.out.println("MACHINE INSTALLED");
    }

    public void editMachine(int id) {
        MilkingMachine milkingMachine1 = findMachineByID(id);
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter NAME of SHED: ");
        String nameMachine = input.nextLine();
        milkingMachine1.setNameMachine(nameMachine);
        System.out.println(" ==========>  The MACHINE with ID " + id + " has been edited <===== ");
    }


    public MilkingMachine findMachineByID(int id) {
        for (MilkingMachine milkingMachine : MilkingMachineList) {
            if (milkingMachine.getId() == id) {
                return milkingMachine;
            }
        }
        System.out.println("\n=========>  There is no MACHINE with id " + id + " in the list!  <====== ");
        return null;
    }




    public void deleteMachine(int id) {
        for (MilkingMachine milkingMachine : MilkingMachineList) {

            if (milkingMachine.getId() == id) {

                MilkingMachineList.remove(milkingMachine);
                System.out.println("The MACHINE with " + id + " HAS BEEN DESsINSTALLED");
                break;
            }
        }
    }



}
