import java.util.Comparator;

public class orderCompare implements Comparator<Farm>{


    @Override
    public int compare(Farm farm1, Farm farm2) {
        return Integer.valueOf(farm1.getId()).compareTo(farm2.getId());
    }



}
