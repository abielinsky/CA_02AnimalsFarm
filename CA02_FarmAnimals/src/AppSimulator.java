import javax.swing.*;
import java.io.*;
import java.util.*;

public class AppSimulator {

    FarmSet farmSet;
    ShedsSet shedSet;
    AnimalManager animalManager;
    MilkingMachineSet milkingMachineSet;
    MilkTankSet milkTankSet;

    public static void main(String[] args) throws IOException {

        List<Farm> MyListFarmCompareTo = new ArrayList<Farm>();
        List<Farm> MyListFarmCompare = new ArrayList<Farm>();


        Farm FarmA = new Farm(2536, "Abiel", "D52F325", 25632563);
        FarmA.addCow(new DairyCow(5252, "DairyCow", 10, 50.20, "", 60));
        MilkingMachine milkingMachine = new MilkingMachine(2020, "superTurbo");
        MilkTank tank1 = new MilkTank(3663,"TANK1", 2000);

        Shed shedA = new Shed(636, "SHED1" );

        tank1.addMilkToTank(500);
        tank1.addMilkToTank(100);
        tank1.addMilkToTank(300);

        FarmA.addShed(shedA);
//        shedA.installMilkingMachine(milkingMachine);
        FarmA.addMilkingMachine(milkingMachine);
        shedA.addMilkTank(tank1);
        shedA.milkAllAnimals();

        Farm FarmB = new Farm(2537, "Luis", "D52F202", 52634152);
        Farm FarmC = new Farm(2524, "Jack", "D52F205", 96325874);
        Farm FarmD = new Farm(2525, "Ann", "D52F302", 96325896);
        Farm FarmE = new Farm(2540, "Derek", "D52F536", 41258796);
        Farm FarmF = new Farm(2551, "Maria", "D52F528", 52364185);
        Farm FarmG = new Farm(2553, "Patrick", "D52F897", 321478965);
        Farm FarmH = new Farm(2560, "Joseph", "D52F636", 932178264);

        MyListFarmCompareTo.add(FarmA);
        MyListFarmCompareTo.add(FarmB);
        MyListFarmCompareTo.add(FarmC);
        MyListFarmCompareTo.add(FarmD);
        MyListFarmCompareTo.add(FarmE);
        MyListFarmCompareTo.add(FarmF);
        MyListFarmCompareTo.add(FarmG);
        MyListFarmCompareTo.add(FarmH);

        MyListFarmCompare.add(FarmA);
        MyListFarmCompare.add(FarmB);
        MyListFarmCompare.add(FarmC);
        MyListFarmCompare.add(FarmD);
        MyListFarmCompare.add(FarmE);
        MyListFarmCompare.add(FarmF);
        MyListFarmCompare.add(FarmG);
        MyListFarmCompare.add(FarmH);
        System.out.println("============================================  SORT BY COMPARE CLASS  =====================================================================");
        Collections.sort(MyListFarmCompare, new orderCompare());
        for (Farm farm : MyListFarmCompare)
        {
            System.out.println(farm);
        }
        System.out.println("============================================  SORT BY COMPARE CLASS  ====================================================================");

        FarmB.addCow(new DairyCow(5151, "DairyCow", 15, 200.20, "", 10));
        MilkingMachine milkingMachine2 = new MilkingMachine(1110, "Mega");
        MilkTank tank2 = new MilkTank(2020,"TANK2", 2000);

        tank2.addMilkToTank(500);
        tank2.addMilkToTank(600);
        tank2.addMilkToTank(300);

        Shed shedB = new Shed(203, "SHED2" );

        FarmB.addShed(shedB);
        FarmB.addMilkingMachine(milkingMachine);
        shedB.addMilkTank(tank2);
        shedB.milkAllAnimals();
        System.out.println("============================================================================================================================================");
        System.out.println("==============================================  FARMS AND ITS DATA  ======================================================================");
        System.out.println(FarmA);
        System.out.println(FarmB);
        System.out.println("==============================================  FARMS AND ITS DATA  =====================================================================");
        System.out.println("============================================================================================================================================");

        System.out.println("\n==============================================  ANIMALS IN FARM H  =====================================================================");
        FarmH.addCow(new DairyCow(1002, "DairyCow", 10, 10.20, "", 0));
        FarmH.addCow(new DairyCow(1002, "DairyCow", 10, 10.20, "", 0));
        System.out.println(FarmA);
        System.out.println("============================================================================================================================================");
        System.out.println("\n==============================================  MILK TANKS IN SHED A y B =====================================================================");
        System.out.println(shedA);
        System.out.println(shedB);
        System.out.println("============================================================================================================================================");

        AppSimulator app = new AppSimulator();
        app.start();

    }

    public void start() {
        System.out.println("\nFarm Simulator System for milky animals");
        farmSet = new FarmSet("farm.txt");
        shedSet = new ShedsSet("shed.txt");
        animalManager = new AnimalManager("animals.txt");
        milkingMachineSet = new MilkingMachineSet("milkingMachine.txt");
        milkTankSet = new MilkTankSet("milktanks.txt");
        try {
            displayMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
        animalManager.saveAnimalToFile("animals.txt");
    }

    private void displayMenu() throws IOException {
        final int FARMS = 1;
        final int SHEDS = 2;
        final int ANIMALS = 3;
        final int MILKING_MACHINE = 4;
        final int MILK_TANK  = 5;
        final int EXIT = 6;
        Scanner input = new Scanner(System.in);
        int option = 0 ;
        do
        {
            System.out.println("\n__________ MENU __________");
            System.out.println("|   1.  FARMS            |");
            System.out.println("|   2.  SHEDS            |");
            System.out.println("|   3.  ANIMALS          |");
            System.out.println("|   4.  MILKING_MACHINE  |");
            System.out.println("|   5.  MILK_TANK        |");
            System.out.println("|   6.  EXIT             |");
            System.out.println("**************************\n");
           // System.out.println("Option");
            try
            {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
            switch (option) {
                case FARMS: //Checking data farm
                    System.out.println("");
                    MenuFarmDisplay();
                    break;
                case SHEDS: //
                    System.out.println("");
                    MenuShedsDisplay();
                    break;
                case ANIMALS:
                    System.out.println("");
                    MenuAnimalsDisplay();
                    break;
                case MILKING_MACHINE: //
                    MenuMilkingMachine();
                    break;
                case MILK_TANK: //
                    MenuMilkTank();
                    break;
                case EXIT: //FINISH ALL PROCESS
                    farmSet.addFarmInFile();
                    animalManager.addDairyCowInFile();
                    System.out.println(" bye finish all process");
                    break;
                default:
                    System.out.println("Enter a right option");
                    break;
            }
            }
            catch (InputMismatchException | NumberFormatException  | IOException  e) {
//                System.out.print("*** ERROR, ENTER A VALID OPTION ***");
            }
        }while (option != EXIT) ;
    }

    private void MenuFarmDisplay(){
        final int SHOW_FARMS = 1;
        final int ADD_FARM = 2;
        final int EDIT_FARM = 3;
        final int EXIT = 4;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("_____________ MENU ___________");
            System.out.println("|   1.  SHOW ALL FARMS ==>   |");
            System.out.println("|   2.  ADD A FARM     ==>   |");
            System.out.println("|   3.  EDIT FARM      ==>   |");
            System.out.println("|   4.  <=== BACK            |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 4]");
            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                Scanner keyboard = new Scanner(System.in);
                switch (option) {
                    case SHOW_FARMS: //Checking data farm

                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("=============== Displaying Data of Farms =============");
                        farmSet.displayAllFarms();
                        System.out.println("==================== Farms Info ends =================\n\n");
                        break;
                    case ADD_FARM:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("============= Adding Farm to the Simulator ===========");
                        System.out.println("\nEnter NAME of farm's OWNER: ");
                        String farmOwner = input.nextLine();
                        System.out.println("\nEnter the POSTCODE of Farm: ");
                        String farmPostcode = input.nextLine();
                        System.out.println("\nEnter the Phone of Farm: ");
                        int Phone = input.nextInt();
                        Farm farm1 = new Farm(farmOwner, farmPostcode, Phone);
                        farmSet.addNewFarm(farm1);
                        break;
                    case EDIT_FARM: //
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("============= Editing Farm to the Simulator ===========");
                        farmSet.displayAllFarms();
                        System.out.println("\nEnter FARM ID to edit: ");
                        boolean isNum1 = false;
                        while (isNum1 != true) {
                            try {
                                int farmID = keyboard.nextInt();
                                isNum1 = true;
                                farmSet.editFarm(farmID);
                                break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("Please enter a number for ID!!!");
                            }
                        }
                        System.out.println("======================================================");
                        break;
                    case EXIT:
                        farmSet.addFarmInFile();
                        System.out.println(" bye bye bye");
                        break;
                    default:
                        System.out.println("Enter a right option");
                        break;
                }
            }catch (InputMismatchException | NumberFormatException | IOException  e) {
                //   System.out.print("PLEASE ENTER A VALID OPTION");
            }
        }while (option != EXIT) ;
    }

    private void MenuShedsDisplay() {
        final int ADD_SHED = 1;
        final int EDIT_SHED = 2;
        final int DELETE_SHED = 3;
        final int DISPLAY_SHED = 4;
        final int BACK = 5;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("________ *** SHEDS *** _______");
            System.out.println("|   1.  ADD          ==>   |");
            System.out.println("|   2.  EDIT         ==>   |");
            System.out.println("|   3.  DELETE       ==>   |");
            System.out.println("|   4.  DISPLAY ALL  ==>   |");
            System.out.println("|   5.  <========== BACK   |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 4]");
            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                Scanner keyboard = new Scanner(System.in);
                switch (option) {
                    case ADD_SHED: //Checking data farm
                        System.out.println("");
                        System.out.println("===============  MENU SHEDS ================");
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("============= Adding Sheds to the Simulator ===========");
                        System.out.println("\nEnter NAME of SHED: ");
                        String ShedName = input.nextLine();
                        Shed shed1 = new Shed(ShedName);
                        shedSet.addNewShed(shed1);
                        System.out.println("===========================================\n\n");
                        break;
                    case EDIT_SHED:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("============= Editing SHED to the Simulator ===========");
                        shedSet.displayAllSheds();
                        System.out.println("\nEnter SHED ID to edit: ");
                        boolean isNum1 = false;
                        while (isNum1 != true) {
                            try {
                                int shedID = keyboard.nextInt();
                                isNum1 = true;
                                shedSet.editShed(shedID);
                                break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("Please enter a number for ID!!!");
                            }
                        }
                        break;
                    case DELETE_SHED:
                        System.out.println("");
                        System.out.println("=====================");
                        shedSet.displayAllSheds();
                        System.out.println("\nEnter shed ID to delete: ");
                        boolean isID = false;
                        while (isID != true) {
                            try {
                                int shedIDdel = keyboard.nextInt();
                                isID = true;
                                //shed deleted by id
                                shedSet.deleteShed(shedIDdel);

                                // break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("INPUT A CORRECT ID!!!");
                            }
                        }
                        System.out.println("=====================");
                        break;
                    case DISPLAY_SHED:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("=============== Displaying Data of Farms =============");
                        shedSet.displayAllSheds();
                        System.out.println("==================== Farms Info ends =================\n\n");
                        break;
                    case BACK:
                        animalManager.addDairyCowInFile();
                        shedSet.addShedInFile();
                        System.out.println(" GOING BACK ");
                        break;
                    default:
                        System.out.println("Enter a right option");
                        break;
                }
            }catch (InputMismatchException | NumberFormatException | IOException  e) {
                //   System.out.print("PLEASE ENTER A VALID OPTION");
            }
        }while (option != BACK) ;
    }

    private void MenuAnimalsDisplay()  {
        final int DAIRY_COW = 1;
        final int GOAT = 2;
        final int BEEF_COW = 3;
        final int SHEEP = 4;
        final int DISPLAY = 5;
        final int DELETE = 6;
        final int AVERAGE_MILK = 7;
        final int BACK = 9;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("__________ ANIMALS MENU __________________");
            System.out.println("|   1.  DAIRY COW             ==>   |");
//            System.out.println("|   2.  GOAT                  ==>   |"); //same structure from DairyCow didn't have enough time to finish it
//            System.out.println("|   3.  BEEF_COW              ==>   |"); //same structure from DairyCow didn't have enough time to finish it
//            System.out.println("|   4.  SHEEP                 ==>   |"); //same structure from DairyCow didn't have enough time to finish it
            System.out.println("|   5.  DISPLAY ALL           ==>   |");
            System.out.println("|   6.  DELETE                ==>   |");
            System.out.println("|   7.  AVERAGE MILK          ==>   |"); // need more time
            System.out.println("|   9.  <================== BACK    |");
            System.out.println("******************************************");
            System.out.println("    Option [1 - 6]");
                try
                {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                        switch (option)
                        {
                            case DAIRY_COW: //Checking data farm
                                System.out.println("=============== DAIRY COW==================");
                                MenuDairyCowDisplay();
                                System.out.println("===========================================\n\n");
                                break;
                            case GOAT:
                                System.out.println("");
                                System.out.println("======================================================");
                                System.out.println("=====================");
                                break;
                            case BEEF_COW:
                                System.out.println("");
                                System.out.println("=====  =================================================");
                                System.out.println("=====================");
                                break;
                            case SHEEP:
                                System.out.println("");
                                System.out.println("======================================================");
                                System.out.println("============= ===========");
                                break;
                            case DISPLAY:
                                System.out.println("");
                                System.out.println("===========================================================================================================");
                                animalManager.displayAllAnimals();
                                System.out.println("===========================================================================================================");
                                break;
                            case DELETE:
                                DeleteAnimalByID();
                                break;
                            case AVERAGE_MILK:
//                                System.out.println("\nAverage of MILK PRODUCED\n" +
//                                        animalManager.calculateAverageMilk());
                                break;
                            case BACK:
                                System.out.println(" GOING BACK ");
                                break;
                            default:
                                System.out.println("Enter a right option");
                                break;
                        }
                  } catch (InputMismatchException | NumberFormatException e)
                    {
                        System.out.print("Invalid input");
                    }
        }while (option != BACK) ;
    }

    private void MenuDairyCowDisplay() {
        final int ADD_DAIRY_COW = 1;
        final int EDIT_DAIRY_COW = 2;
        final int BACK = 3;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("________ DAIRY COW MENU _______");
            System.out.println("|   1.  ADD          ==>   |");
            System.out.println("|   2.  EDIT         ==>   |");
            System.out.println("|   3.  <========== BACK   |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 4]");
            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                Scanner keyboard = new Scanner(System.in);
                switch (option) {
                    case ADD_DAIRY_COW:
                        System.out.println("\nEnter TYPE of DAIRY COW: ");
                        String dairyCowType = input.nextLine();
                        System.out.println("\nEnter AGE of DAIRY COW: ");
                        int dairyCowAge = input.nextInt();
                        System.out.println("\nEnter WEIGHT of DAIRY COW: ");
                        double dairyCowWeight = input.nextDouble();

                        Animal animal = new DairyCow(dairyCowType, dairyCowAge, dairyCowWeight );
                        animalManager.addNewDairyCow(animal);
                        System.out.println("===========================================\n\n");
                        break;
                    case EDIT_DAIRY_COW:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("\nEnter DAIRY COW ID to edit: ");
                        boolean isNum1 = false;
                        while (isNum1 != true) {
                            try {
                                int dairyCowID = keyboard.nextInt();
                                isNum1 = true;
                                animalManager.editDairyCow(dairyCowID);
                                break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("Please enter a number for ID!!!");
                            }
                        }
                        System.out.println("========================================================");
                        break;
                        case BACK:
//                      animalManager.addDairyCowInFile();
                        System.out.println(" GOING BACK ");
                        break;

                    default:
                        System.out.println("Enter a right option");
                        break;
                }
            }catch (InputMismatchException | NumberFormatException e) {
                //   System.out.print("PLEASE ENTER A VALID OPTION");
            }
        }while (option != BACK) ;
    }

    private void DeleteAnimalByID() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Animals List:");
        animalManager.displayAllAnimals();

        System.out.println("Enter ID of the Animal that you want to delete:");
        int animalID = keyboard.nextInt();

        if (animalManager.findAnimalByID(animalID) != null) {
            animalManager.deleteAnimalById(animalID);
            System.out.println("Animal deleted");
        }
        else {
            System.out.println("Animal not found");
        }

    }

    private void MenuMilkingMachine() {
        final int INSTALL_MACHINE = 1;
        final int EDIT_MACHINE = 2;
        final int DELETE_MACHINE = 3;
        final int DISPLAY_MACHINE = 4;
        final int BACK = 5;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("________   *** MACHINE   *** _______");
            System.out.println("|   1.  INSTALL          ==>   |");
            System.out.println("|   2.  EDIT             ==>   |");
            System.out.println("|   3.  DELETE           ==>   |");
            System.out.println("|   4.  DISPLAY ALL      ==>   |");
            System.out.println("|   5.  <============== BACK   |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 4]");
            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                Scanner keyboard = new Scanner(System.in);
                switch (option) {
                    case INSTALL_MACHINE: //Checking data farm
                        System.out.println("");
                        System.out.println("=====================  MENU SHEDS ====================");
                        System.out.println("======================================================");
                        System.out.println("======= INSTALLING MILK MACHINE to the Simulator =====");
                        System.out.println("\nEnter NAME of MILK MACHINE: ");
                        String NameMachine = input.nextLine();
                        MilkingMachine milkingMachine1 = new MilkingMachine(NameMachine);
                        milkingMachineSet.installMachine(milkingMachine1);
                        System.out.println("===========================================\n\n");
                        break;
                    case EDIT_MACHINE:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("==================== Editing MACHINE =================");
                        milkingMachineSet.displayAllMilkMachines();
                        System.out.println("\nEnter MACHINE ID to edit: ");
                        boolean isNum1 = false;
                        while (isNum1 != true) {
                            try {
                                int machineID = keyboard.nextInt();
                                isNum1 = true;
                                milkingMachineSet.editMachine(machineID);
                                break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("Please enter a number for ID!!!");
                            }
                        }
                        break;
                    case DELETE_MACHINE:
                        System.out.println("");
                        System.out.println("========================================================");
                        milkingMachineSet.displayAllMilkMachines();
                        System.out.println("\nEnter MACHINE ID to delete: ");
                        boolean isID = false;
                        while (isID != true) {
                            try {
                                int machineIDdel = keyboard.nextInt();
                                isID = true;
                                //shed deleted by id
                                milkingMachineSet.deleteMachine(machineIDdel);

                                // break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("INPUT A CORRECT ID!!!");
                            }
                        }

                        break;
                    case DISPLAY_MACHINE:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("=============== Displaying Data of Farms =============");
                        milkingMachineSet.displayAllMilkMachines();
                        System.out.println("==================== Farms Info ends =================\n\n");
                        break;
                    case BACK:
                        milkingMachineSet.addMachineInFile();
                        animalManager.addDairyCowInFile();
                        shedSet.addShedInFile();
                        System.out.println(" GOING BACK ");
                        break;
                    default:
                        System.out.println("Enter a right option");
                        break;
                }
            }catch (InputMismatchException | NumberFormatException | IOException  e) {
                //   System.out.print("PLEASE ENTER A VALID OPTION");
            }
        }while (option != BACK) ;



    }

    private void MenuMilkTank() {
        final int INSTALL_TANK = 1;
        final int EDIT_TANK = 2;
        final int DELETE_TANK = 3;
        final int DISPLAY_TANKS = 4;
        final int BACK = 5;
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n");
            System.out.println("__________   *** TANK   *** _________");
            System.out.println("|   1.  INSTALL          ==>   |");
            System.out.println("|   2.  EDIT             ==>   |");
            System.out.println("|   3.  DELETE           ==>   |");
            System.out.println("|   4.  DISPLAY ALL      ==>   |");
            System.out.println("|   5.  <============== BACK   |");
            System.out.println("************************************");
            System.out.println("    Option [1 - 4]");
            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);
                Scanner keyboard = new Scanner(System.in);
                switch (option) {
                    case INSTALL_TANK: //Checking data farm
                        System.out.println("");
                        System.out.println("=====================  MENU SHEDS ====================");
                        System.out.println("======================================================");
                        System.out.println("========= INSTALLING MILK TANK to the Simulator ======");
                        System.out.println("\nEnter NAME of MILK TANK: ");
                        String NameTank = input.nextLine();
                        System.out.println("\nEnter the Phone of Farm: ");
                        int capacity = input.nextInt();
                        MilkTank milkTank1 = new MilkTank(NameTank, capacity);
                        milkTankSet.installTank(milkTank1);
                        System.out.println("===========================================\n\n");
                        break;
                    case EDIT_TANK:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("==================== Editing TANK =================");
                        milkTankSet.displayAllTanks();
                        System.out.println("\nEnter TANK ID to edit: ");
                        boolean isNum1 = false;
                        while (isNum1 != true) {
                            try {
                                int tankID = keyboard.nextInt();
                                isNum1 = true;
                                milkTankSet.editTank(tankID);
                                break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("Please enter a CORRECT number for ID!!!");
                            }
                        }
                        break;
                    case DELETE_TANK:
                        System.out.println("");
                        System.out.println("========================================================");
                        milkTankSet.displayAllTanks();
                        System.out.println("\nEnter TANK ID to delete: ");
                        boolean isID = false;
                        while (isID != true) {
                            try {
                                int tankIDdel = keyboard.nextInt();
                                isID = true;
                                //tank deleted by id
                                milkTankSet.deleteTank(tankIDdel);

                                // break;
                            } catch (InputMismatchException e) {
                                keyboard.nextLine();
                                System.out.println("INPUT A CORRECT ID!!!");
                            }
                        }

                        break;
                    case DISPLAY_TANKS:
                        System.out.println("");
                        System.out.println("======================================================");
                        System.out.println("=============== Displaying Data of TANKS =============");
                        milkTankSet.displayAllTanks();
                        System.out.println("==================== TANKS Info ends =================\n\n");
                        break;
                    case BACK:
                        milkTankSet.addMilkTankInFile();
                        milkingMachineSet.addMachineInFile();
                        animalManager.addDairyCowInFile();
                        shedSet.addShedInFile();
                        System.out.println(" GOING BACK ");
                        break;
                    default:
                        System.out.println("Enter a right option");
                        break;
                }
            }catch (InputMismatchException | NumberFormatException | IOException  e) {
                //   System.out.print("PLEASE ENTER A VALID OPTION");
            }
        }while (option != BACK) ;



    }

}




