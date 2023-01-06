import Calisma.ListiImplementation.LinkedList;
import Calisma.ListiImplementation.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Tests {
    @Test
    void addTest() {
        List list = new LinkedList();
        int[] arr = new int[]{3, 5, 7};

        list.add(3);
        list.add(5);
        list.add(7);
        for (int i=0;i<3;i++){
            Assertions.assertEquals(arr[i],list.get(i));
        }
    }

    @Test
    void sizeTest() {
        List list = new LinkedList();

        list.add(3);
        list.add(5);
        list.add(7);
        Assertions.assertEquals(3,list.size());
    }

    @Test
    void removeTest() {
        List list = new LinkedList();

        list.add(3);
        list.add(5);
        list.add(7);

        list.remove(5);
        Assertions.assertEquals(3,list.get(0));
        Assertions.assertEquals(7,list.get(1));
    }

    @Test
    void containsTest() {
        List list = new LinkedList();

        list.add(3);
        list.add(5);
        list.add(7);

        Assertions.assertEquals(true,list.contains(3));
        Assertions.assertEquals(false,list.contains(10));
    }

    @Test
    void addToIndexTest() {
        List list = new LinkedList();

        list.add(3);
        list.add(5);
        list.add(7);

        list.add(2,11);

        Assertions.assertEquals(5,list.get(1));
        Assertions.assertEquals(11,list.get(2));
        Assertions.assertEquals(7,list.get(3));
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

        list.addAll(List.of(arr));

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
        //Assertions.assertTrue(list.contains(tonguc));
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
        //Assertions.assertTrue(list.remove(gonca));
        Assertions.assertEquals(0,list.size());

        //

    }
}
