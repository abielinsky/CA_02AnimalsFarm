import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppSimulatorTest {

    AnimalManager animalManager = new AnimalManager("animals.txt");


    @Test
    public void findAnimalByIdTest()
    {
        System.out.println("Find Animal by ID Test");
        Animal animal = animalManager.findAnimalByID(3629);
        assertEquals(3629, animal.getId());
    }



}