import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppSimulator {

    FarmSet farmSet;
    ShedsSet shedSet;
    AnimalManager animalManager;

    public static void main(String[] args) throws IOException {

        MilkingMachine milkingMachine = new MilkingMachine();

        Farm FarmA = new Farm(2536, "Abiel", "D52F325", 25632563);
        FarmA.addCow(new DairyCow("milkCow", 10, 50.20));
        Shed shedA = new Shed(636, "SHED1" );
        MilkTank tank1 = new MilkTank("TANK1", 2000);

        tank1.addMilkToTank(500);

        FarmA.addShed(shedA);
        shedA.installMilkingMachine(milkingMachine);
        //FarmA.addMilkingMachine(milkingMachine);
        shedA.addMilkTank(tank1);
        shedA.milkAllAnimals();

        System.out.println(FarmA);

        AppSimulator app = new AppSimulator();
        app.start();

    }


    public void start() {

        System.out.println("\nFarm Simulator System for milky animals");
        farmSet = new FarmSet("farm.txt");
        shedSet = new ShedsSet("shed.txt");
        animalManager = new AnimalManager("animals.txt");

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
        final int MILK_TANK  = 4;
        final int MILKING_MACHINE = 5;


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
                    System.out.println("......Displaying MENU Farms........");
                    MenuFarmDisplay();
                    System.out.println("..........MENU FARM ends............\n\n");

                    break;

                case SHEDS: //

                    System.out.println("");
                    System.out.println("......  Displaying MENU SHEDS ........");
                    MenuShedsDisplay();
                    System.out.println("..........MENU SHEDS ends............\n\n");
                    break;

                case ANIMALS:

                    System.out.println("");
                    System.out.println("......Displaying MENU Farms........");
                    MenuAnimalsDisplay();
                    System.out.println("..........MENU FARM ends............\n\n");


                    break;

                case MILKING_MACHINE: //


                    System.out.println(".........................");
                    System.out.println("-----");
                    break;


                case EXIT: //FINISH ALL PROCESS
                    farmSet.addFarmInFile();
//                    animalManager.addDairyCowInFile();
                    System.out.println(" bye bye bye");
                    break;

                default:
                    System.out.println("Enter a right option");
                    break;

            }


            }
            catch (InputMismatchException | NumberFormatException  | IOException  e) {
                System.out.print("*** ERROR, ENTER A VALID OPTION ***");
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

    private void MenuAnimalsDisplay() {

        final int DAIRY_COW = 1;
        final int GOAT = 2;
        final int BEEF_COW = 3;
        final int SHEEP = 4;
        final int DISPLAY = 5;
        final int BACK = 6;


        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n\n");
            System.out.println("__________ ANIMALS MENU _________");
            System.out.println("|   1.  DAIRY_COW      ==>   |");
            System.out.println("|   2.  GOAT           ==>   |");
            System.out.println("|   3.  BEEF_COW       ==>   |");
            System.out.println("|   4.  SHEEP          ==>   |");
            System.out.println("|   5.  <============ BACK   |");
            System.out.println("|   6.  <============ BACK   |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 5]");

            String usersInput = input.nextLine();
            option = Integer.parseInt(usersInput);

            Scanner keyboard = new Scanner(System.in);
            switch (option) {

                case DAIRY_COW: //Checking data farm

                    System.out.println("");
                    System.out.println("===================================================");
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
                    System.out.println("======================================================");
                    animalManager.displayAllAnimals();
                    System.out.println("============= =============");
                    break;



                case BACK:


                    System.out.println(" GOING BACK ");
                    break;
                default:
                    System.out.println("Enter a right option");
                    break;
            }
        }while (option != BACK) ;
    }

    private void MenuDairyCowDisplay() {

        final int ADD_DAIRY_COW = 1;
        final int EDIT_DAIRY_COW = 2;
        final int DELETE_DAIRY_COW = 3;
        final int DISPLAY_ALL_DAIRY_COW = 4;
        final int BACK = 5;

        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n\n");
            System.out.println("________ DAIRY COW MENU _______");
            System.out.println("|   1.  ADD          ==>   |");
            System.out.println("|   2.  EDIT         ==>   |");
            System.out.println("|   3.  DELETE (DIE) ==>   |");
            System.out.println("|   4.  DISPLAY ALL  ==>   |");
            System.out.println("|   5.  <========== BACK   |");
            System.out.println("******************************");
            System.out.println("    Option [1 - 4]");

            try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);

                Scanner keyboard = new Scanner(System.in);
                switch (option) {

                    case ADD_DAIRY_COW: //Checking data farm

//                        System.out.println("");
//                        System.out.println("===============  MENU DAIRY COW============");
//
//
//                        System.out.println("\nEnter TYPE of DAIRY COW: ");
//                        String dairyCowType = input.nextLine();
//                        System.out.println("\nEnter AGE of DAIRY COW: ");
//                        int dairyCowAge = input.nextInt();
//                        System.out.println("\nEnter WEIGHT of DAIRY COW: ");
//                        double dairyCowWeight = input.nextDouble();
//
//                        DairyCow dairyCow1 = new DairyCow(dairyCowType, dairyCowAge, dairyCowWeight );
//                        animalManager.addNewDailyCow(dairyCow1);


                        System.out.println("===========================================\n\n");
                        break;
                    case EDIT_DAIRY_COW:
//                        System.out.println("");
//                        System.out.println("======================================================");
//
//                        System.out.println("\nEnter DAIRY COW ID to edit: ");
//                        boolean isNum1 = false;
//                        while (isNum1 != true) {
//                            try {
//                                int dairyCowID = keyboard.nextInt();
//                                isNum1 = true;
//                                animalManager.editDairyCow(dairyCowID);
//                                break;
//                            } catch (InputMismatchException e) {
//                                keyboard.nextLine();
//                                System.out.println("Please enter a number for ID!!!");
//                            }
//                        }

                        System.out.println("========================================================");
                        break;
                    case DELETE_DAIRY_COW:
                        System.out.println("");
                        System.out.println("=====  =================================================");
                        System.out.println("=====================");
                        break;
                    case DISPLAY_ALL_DAIRY_COW:
//                        System.out.println("");
//                        System.out.println("===========================================================");
//                        System.out.println("================== Displaying Data of DAIRY COWS ===============");
//                        animalManager.displayAllDailyCow();
//                        System.out.println("======================= Farms Info ends ===================\n\n");
//                        System.out.println("===========================================================");

                        break;

                    case BACK:

//                        animalManager.addDairyCowInFile();
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









    private void MenuFarmDisplay()
    {



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











//
//        ArrayList<Animal> animalList  = new ArrayLis <>();
//        animalList.add( new DairyCow(101));
//
//        //double amount = animalsList.get(0).milk(); //Milk a Dairy Cow;
//
//        BeefCow beefCow1 = new BeefCow(501));
//        beefCow.milk();  ///////////////
//
//
//        // milk all the animals ??
//        for(Animal animal : animalList){
//           if (animal instanceof IMilkable) {
//               int amount = animal.milk();
//               totalMilk += amount;
//           }







}




