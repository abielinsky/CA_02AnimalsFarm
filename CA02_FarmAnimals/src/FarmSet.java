import java.io.File;
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
            Scanner sc = new Scanner(new File(filename));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                String email = sc.next();
                String phone = sc.next();

                FarmList.add(new Farm(id, name, email, phone));
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown" + e);
        }
    }





}
