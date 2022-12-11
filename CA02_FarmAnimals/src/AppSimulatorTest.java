import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppSimulatorTest {

    AnimalManager animalManager = new AnimalManager("animals.txt");
    ShedsSet shedsSet = new ShedsSet("shed.txt");

    FarmSet farmSet = new FarmSet("farm.txt");


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

    @Test
    public void findShedlByIdTest4()
    {
        System.out.println("Find Shed by ID Test");
        Shed shed = shedsSet.findShedByID(4073);
        assertEquals(4073, shed.getId());
    }


    @Test
    public void findShedlByIdTest5()
    {
        System.out.println("Find Shed by ID Test");
        Shed shed = shedsSet.findShedByID(4074);
        assertEquals(4074, shed.getId());
    }


    @Test
    public void createFarm()
    {
        System.out.println("FARM constructor  Test");
        Farm f = new Farm("Prueba", "D25D632",  25631489);

        assertEquals("Prueba", f.getOwner());
        assertEquals("D25D632", f.getPostcode());
        assertEquals(25631489, f.getPhone());
    }

    @Test
    public void createFarm2()
    {
        System.out.println("FARM constructor Test");
        Farm f = new Farm("Prueba2", "D25S631",  85963214);
        assertEquals("Prueba2", f.getOwner());
        assertEquals("D25S631", f.getPostcode());
        assertEquals(85963214, f.getPhone());
    }





}