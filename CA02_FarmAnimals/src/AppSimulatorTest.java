import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppSimulatorTest {

    AnimalManager animalManager = new AnimalManager("animals.txt");


    @Test
    public void findAnimalByIdTest1()
    {
        System.out.println("Find Animal by ID Test");
        Animal animal = animalManager.findAnimalByID(4059);
        assertEquals(4059, animal.getId());
    }

    @Test
    public void findAnimalByIdTest2()
    {
        System.out.println("Find Animal by ID Test");
        Animal animal = animalManager.findAnimalByID(4051);
        assertEquals(4051, animal.getId());
    }

    @Test
    public void findAnimalByIdTest3()
    {
        System.out.println("Find Animal by ID Test");
        Animal animal = animalManager.findAnimalByID(4057);
        assertEquals(4057, animal.getId());
    }



}