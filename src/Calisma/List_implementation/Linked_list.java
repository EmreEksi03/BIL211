package Calisma.List_implementation;

public class Linked_list {
    Node head;
    public static void main(String[] args) {

    }
    public void  insert(Linked_list list,int data){
        Node node = new Node(data);

        if (list.head == null){
            list.head = node;
        }
        else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = node;
        }
    }
}
