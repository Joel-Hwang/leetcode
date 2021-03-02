package CS;

public class Node {
    int data;
    Node next;
    public Node(int d){
        this.data = d;
    }
    public void append(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int d){
        Node n = this;
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }

    public void retrieve(){
        Node n = this;
        while(n.next != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data); //last node
    }
}

/*

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.delete(3);
        head.retrieve();
    }

*/