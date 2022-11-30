import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppSimulator {

    FarmSet farmSet;

    public static void main(String[] args) throws IOException {
        AppSimulator app = new AppSimulator();
        app.start();
    }

    public void start() throws IOException {

        System.out.println("\nFarm Simulator System for milky animals\n");

        farmSet = new FarmSet("farm.txt");

        try {
            displayMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayMenu() throws IOException {



        final int FARMS = 1;
        final int SHEDS = 2;
        final int MILKING_MACHINE = 3;
        final int MILK_TANK  = 4;
        final int ANIMALS = 5;


        final int EXIT = 6;

        Scanner input = new Scanner(System.in);
        int option = 0 ;

        do
        {

            System.out.println("********** MENU **********");
            System.out.println("*   1.  FARMS            *");
            System.out.println("*   2.  SHEDS            *");
            System.out.println("*   3.  MILKING MACHINE  *");
            System.out.println("*   4.  MILK TANK        *");
            System.out.println("*   5.  ANIMALS          *");
            System.out.println("*   6.  EXIT             *");
            System.out.println("**************************");
            System.out.println("Option");


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

                case SHEDS:

                    System.out.println("");
                    System.out.println("........");

                    System.out.println("......................\n\n");

                    break;

                case MILKING_MACHINE: //


                    System.out.println(".........................");
                    System.out.println("-----");
                    break;


                case EXIT: //FINISH ALL PROCESS

                    System.out.println(" bye bye bye");
                    break;

                default:
                    System.out.println("Enter a right option");

            }


            }
            catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        }

            while (option != EXIT) ;

    }





    private void MenuFarmDisplay() throws IOException {





        final int SHOW_FARMS = 1;
        final int ADD_FARM = 2;
        final int EXTRA = 3;
        final int EXIT = 4;

        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
           


                System.out.println("\n.:MENU FARM:.");
                System.out.println("1.  SHOW ALL FARMS   ");
                System.out.println("2.  ADD A FARM       ");
                System.out.println("3.                   ");

                System.out.println("4.   End.                ");
                System.out.println("Option");


                 try {
                String usersInput = input.nextLine();
                option = Integer.parseInt(usersInput);


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
                        String farmPhone = input.nextLine();

                        Farm farm1 = new Farm(farmOwner, farmPostcode, farmPhone);
                        farmSet.addNewFarm(farm1);


                        System.out.println("==================== Finishing Add ===================\n\n");

                        break;

                    case EXTRA: //


                        System.out.println(".........................");
                        System.out.println("-----");
                        break;


                    case EXIT: //FINISH ALL PROCESS
                        farmSet.addFarmInFile();
                        System.out.println(" bye bye bye");
                        break;

                    default:
                        System.out.println("Enter a right option");


                }

            }
                catch (InputMismatchException | NumberFormatException e) {
                    System.out.print("PLEASE ENTER A VALID OPTION");
                }

        }
        while (option != EXIT) ;


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




