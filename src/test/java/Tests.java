import Calisma.AnimalInterface.Animal;
import Calisma.AnimalInterface.Cat;
import Calisma.AnimalInterface.Dog;
import Calisma.ListImplementation.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Tests {
    @Test
    void addTest() {
        List list = new LinkedList();
        Animal[] arr = new Animal[]{new Cat("kedi1"), new Cat("kedi2"), new Dog("kopek")};

        list.add(new Cat("kedi1"));
        list.add(new Cat("kedi2"));
        list.add(new Dog("kopek"));
        for (int i=0;i<3;i++){
            Assertions.assertEquals(true,list.get(i).equals(arr[i]));
        }
    }

    @Test
    void sizeTest() {
        List<Animal> list = new LinkedList();

        list.add(new Cat("kedi2"));
        list.add(new Cat("kedi2"));
        list.add(new Dog("kopek"));
        Assertions.assertEquals(3,list.size());
    }

    @Test
    void removeTest() {
        List list = new LinkedList();

        list.add(new Cat("kedi1"));
        list.add(new Cat("kedi2"));
        list.add(new Cat("kedi3"));

        list.remove(new Cat("kedi2"));
        Assertions.assertEquals(new Cat("kedi1"),list.get(0));
        Assertions.assertEquals(new Cat("kedi3"),list.get(1));
    }

    @Test
    void containsTest() {
        List list = new LinkedList();

        list.add(new Cat("kedi1"));
        list.add(new Cat("kedi2"));
        list.add(new Cat("kedi3"));

        Assertions.assertEquals(true,list.contains(new Cat("kedi1")));
        Assertions.assertEquals(false,list.contains(new Cat("kedi4")));
    }

    @Test
    void addToIndexTest() {
        List list = new LinkedList();

        list.add(new Cat("kedi1"));
        list.add(new Cat("kedi2"));
        list.add(new Cat("kedi3"));

        list.add(2,(new Cat("kedi4")));

        Assertions.assertEquals((new Cat("kedi2")),list.get(1));
        Assertions.assertEquals((new Cat("kedi4")),list.get(2));
        Assertions.assertEquals((new Cat("kedi3")),list.get(3));
    }

    @Test
    void toArrayTest() {
        List list = new LinkedList();

        list.add(3);
        list.add(5);
        list.add(7);

        Object[] arr = {3,5,7};

        Assertions.assertArrayEquals(arr,list.toArray());
    }

    @Test
    void addAllTest() {

        Object[] arr = {3,5,7};

        List list = new LinkedList();

        List<Object> arr1 = List.of(arr);
        list.addAll(arr1);
//
        Assertions.assertEquals(3,list.get(0));
        Assertions.assertEquals(5,list.get(1));
        Assertions.assertEquals(7,list.get(2));
    }

    @Test
    void tonguc() {

        //contains,size,add,remove
        List list = new LinkedList();
        String tonguc = new String("Tonguc");
        Assertions.assertFalse(list.contains(tonguc));
        Assertions.assertTrue(list.add(tonguc));
        Assertions.assertTrue(list.contains(tonguc));
        Assertions.assertEquals(1,list.size());
        list.remove(tonguc);
        Assertions.assertFalse(list.contains(tonguc));
        Assertions.assertEquals(0,list.size());


        //toArray
        list = new LinkedList();
        String emre = new String("Emre");
        String gonca = new String("Gonca");
        list.add(tonguc);
        list.add(emre);
        list.add(gonca);
        Assertions.assertEquals(3,list.size());
        Object[] objects = list.toArray();
        Assertions.assertEquals("Tonguc",objects[0]);
        Assertions.assertEquals("Emre",objects[1]);
        Assertions.assertEquals("Gonca",objects[2]);


        //remove
        list = new LinkedList();
        Assertions.assertFalse(list.remove(gonca));
        list.add(tonguc);
        list.add(gonca);
        Assertions.assertEquals(2,list.size());
        Assertions.assertEquals(2,list.size());
        Assertions.assertFalse(list.remove(emre));
        Assertions.assertTrue(list.remove(tonguc));
        Assertions.assertTrue(list.remove(gonca));
        Assertions.assertEquals(0,list.size());
        //

    }

    @Test
    void tonguc2() {

        //get set
        List list = new LinkedList();
        String tonguc = new String("Tonguc");
        String emre = new String("Emre");
        String gonca = new String("Gonca");
        list.add(tonguc);
        list.add(emre);
        list.add(gonca);
        Assertions.assertEquals(3,list.size());
        Assertions.assertEquals("Tonguc",list.get(0));
        Assertions.assertEquals("Emre",list.get(1));
        String yunus = new String("Yunus");
        list.set(2, yunus);
        Assertions.assertNotEquals("Gonca",list.get(2));
        Assertions.assertEquals("Yunus",list.get(2));


        //add,remove
        list = new LinkedList();
        list.add(0,tonguc);
        list.add(1,gonca);
        list.add(1,emre);
        list.add(1,yunus);

        Assertions.assertEquals(4,list.size());
        Assertions.assertTrue(list.remove(emre));
        Assertions.assertTrue(list.remove(tonguc));
        Assertions.assertEquals(2,list.size());
        Assertions.assertEquals(gonca,list.get(1));
        Assertions.assertEquals(yunus,list.get(0));

        list.remove(0);
        list.remove(0);
        Assertions.assertEquals(0,list.size());



    }
}
