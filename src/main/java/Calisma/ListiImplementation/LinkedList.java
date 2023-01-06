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
        if (head == null) {
            return false;
        }
        if (head.data.equals(o)) {
            return true;
        }
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
        Object[] arr = new Object[size()];

        Node last = head;
        int x=0;
        while (last.next != null){
            arr[x] = last.data;
            last = last.next;
            x++;
        }
        arr[x] = last.data;

        return arr;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o);


        if (isEmpty()){
            head = node;
            return true;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node last = head;
        if (head == null){
            return false;
        }
        if (head.data.equals(o) && head.next==null){
            head = null;
            return true;
        }
        else if(head.data.equals(o) && head.next!=null){
            head = head.next;
            return true;
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
            Iterator it = c.iterator();
            Node node = new Node(it.next());
            head = node;
            Node last = head;
            while (it.hasNext()){
                last.next = new Node(it.next());
                last = last.next;
            }
        }
        else {
            Iterator it = c.iterator();
            Node last = head;
            while (it.hasNext()) {
                last.next = new Node(it.next());
                last = last.next;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c.isEmpty()){
            return false;
        }
        if (head == null && index == 0){
            Iterator it = c.iterator();
            Node node = new Node(it.next());
            head = node;
            Node last = head;
            while (it.hasNext()){
                last.next = new Node(it.next());
                last = last.next;
            }
        }
        else {
            Node last = head;
            for (int i=0;i<index;i++) {
                last = last.next;
            }
            Node temp = last.next;
            Iterator it = c.iterator();
            while (it.hasNext()){
                last.next = new Node(it.next());
                last = last.next;
            }
            last.next = temp;
        }
        return true;
    }

    @Override
    public void clear() {
        head.next = null;
        head.data = null;
    }

    @Override
    public Object get(int index) {
        Node last = head;
        for (int i=0;i<index;i++) {
            last = last.next;
        }
        return last.data;
    }

    @Override
    public Object set(int index, Object element) {
        Node last = head;
        for (int i=0;i<index;i++) {
            last = last.next;
        }
        Object temp = last.data;
        last.data = element;
        return temp;
    }

    @Override
    public void add(int index, Object element) {
        Node node = new Node(element);

        if (head == null && index == 0){
            head = node;
        }
        else {
            Node last = head;
            for (int i=0;i<index-1;i++) {
                last = last.next;
            }
            Node temp = last.next;
            last.next = node;
            node.next = temp;
        }
    }

    @Override
    public Object remove(int index) {
        Node last = head;
        if (head.next==null && index==0){
            Object temp = head.data;
            head = null;
            return temp;
        }
        Node last2 = last.next;
        for (int i=0;i<index-1;i++) {
            last = last.next;
            last2 = last2.next;
        }
        last.next = last2.next;
        return last2.data;
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
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
