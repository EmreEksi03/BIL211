package Calisma.ListiImplementation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList implements List {
    public Node head;
    public static void main(String[] args) {

    }
    @Override
    public int size() {
        if (isEmpty()){
            return 0;
        }

        int x = 1;

        Node last = head;
        while (last.next != null){
            last = last.next;
            x++;
        }
        return x;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node last = head;
        while (last.next != null) {
            if (last.data.equals(o)){
                return true;
            }
            last = last.next;
        }
        return false;
    }



    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size()];

        Node last = head;
        int x=0;
        while (last.next != null){
            arr[x] = last.data;
            last = last.next;
            x++;
        }

        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o);

        Node last = head;
        if (isEmpty()){
            head = node;
            return false;
        }

        while (last.next != null) {
            last = last.next;
        }
        last.next = node;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node last = head;
        if (last.data.equals(o)){
            head = null;
            return true;
        }
        if (last.next==null){
            return false;
        }
        Node last2 = last.next;
        while (last2 != null) {
            if (last2.data.equals(o) && last2.next!=null){
                Node last3 = last2.next;
                last.next = last3;
                return true;
            }
            else if (last2.data.equals(o) && last2.next==null){
                last.next = null;
                return true;
            }
            last = last.next;
            last2 = last2.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.isEmpty()){
            return false;
        }
        if (isEmpty()){
            Node node = new Node(c.iterator().next());
            head = node;
            Node last = head;
            while (c.iterator().hasNext()){
                last.next = new Node(c.iterator().next());
                last = last.next;
            }
        }
        Node last = head;
        while (c.iterator().hasNext()){
            last.next = new Node(c.iterator().next());
            last = last.next;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {

        return false;
    }

    @Override
    public void clear() {
        head.next = null;
        head.data = null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
        /*
        if (size()<=index){
            System.out.println("Index too large!!");
            return;
        }
        if (index<=0){
            System.out.println("Index too small!!");
            return;
        }*/

        Node node = new Node(element);

        if (head == null && index == 0){
            head = node;
        }
        else {
            Node last = head;
            for (int i=0;i<index;i++)
            {
                last = last.next;
            }
            Node temp = last.next;
            last.next = node;
            node.next = temp;
        }
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }










    @Override
    public Iterator iterator() {
        return null;
    }
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }
}
