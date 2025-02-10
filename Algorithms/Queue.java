
public class Queue {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Queue ENQUEUE(Queue list, int data){
        Node newNode = new Node(data);
        Node tmp = list.head;
        if(tmp == null){
            list.head = newNode;
        }
        else{
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        return list;
    }

    public static void DEQUEUE(Queue list){
        Node tmp = list.head;
        if(tmp != null){
            list.head = tmp.next;
            System.out.println("The element deleted is: "+tmp.data);
        }
        else{
            System.out.println("The list is empty");
        }
    }
}

