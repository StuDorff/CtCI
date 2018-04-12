public class LinkedList
{
    Node first;

    LinkedList(){
        first = null;
    }

    void printAllDataInNodes(){
        Node current = first;

        System.out.print("[");
        while(current != null){
            System.out.print( " " + current.data);
            current = current.next;
        }
        System.out.println(" ]");
    }

    void insertNode(int data)
    {
        Node newNode = new Node(data);

        if (first == null){
            first = newNode;
        }
        else
        {
            Node current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // At certain node, place new node after
    void insertNodeAfterData(int data, int prevNodeData){
        Node newNode = new Node(data);

        Node current = first;
        Node after = first.next;

        while (current.data != prevNodeData){
            current = current.next;
            after = current.next;
        }

        current.next = newNode;
        newNode.next = after;
    }

    // Given: a1,a2,a3,b1,b2,b3 (even num of elements)
    // Output: a1,b1,a2,b2,a3,b3
    void Weave(){
        int iterations = 1;

        Node p2 = first.next;
        Node p1 = first;

        while(p2.next != null) // Must be even or else problem with p2.nexts'...
        {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
            ++iterations;
        }

        // Now p2 at end and p1 at middle; can start weaving
        p2 = first;
        Node temp1 = p2.next;
        Node temp2 = p1.next;

        for (int i = 0; i < iterations-1; ++i) {
            p2.next = temp2;
            p1 = temp2;
            temp2 = temp2.next;
            p1.next = temp1;
            p2 = temp1;
            temp1 = temp1.next;
        }

        p2.next = temp2;
    }
}
class Node{
    int data;
    Node next = null;

    Node (int d){
        data = d;
    }
}

class Test
{
    public static void main(String[] args){

        System.out.println("----------Insertion Testing-------------");
        LinkedList linkList = new LinkedList();

        linkList.insertNode(1);
        linkList.insertNode(2);
        linkList.insertNode(3);

        linkList.printAllDataInNodes();

        linkList.insertNodeAfterData(1000,2);

        linkList.printAllDataInNodes();

        linkList.insertNodeAfterData(10000,3);

        linkList.printAllDataInNodes();

        System.out.println("--------------Weave---------------------");

        System.out.println("Weave 1");
        LinkedList weave1 = new LinkedList();

        weave1.insertNode(1);
        weave1.insertNode(3);
        weave1.insertNode(5);
        weave1.insertNode(2);
        weave1.insertNode(4);
        weave1.insertNode(6);

        System.out.print("Original:    ");
        weave1.printAllDataInNodes();

        weave1.Weave();

        System.out.print("After Weave: ");
        weave1.printAllDataInNodes();

        System.out.println("Weave 2");
        LinkedList weave2 = new LinkedList();

        weave2.insertNode(1);
        weave2.insertNode(3);
        weave2.insertNode(2);
        weave2.insertNode(4);

        System.out.print("Original:    ");
        weave2.printAllDataInNodes();

        weave2.Weave();

        System.out.print("After Weave: ");
        weave2.printAllDataInNodes();

        System.out.println("Weave 3");
        LinkedList weave3 = new LinkedList();

        weave3.insertNode(1);
        weave3.insertNode(3);
        weave3.insertNode(5);
        weave3.insertNode(7);
        weave3.insertNode(9);
        weave3.insertNode(11);
        weave3.insertNode(2);
        weave3.insertNode(4);
        weave3.insertNode(6);
        weave3.insertNode(8);
        weave3.insertNode(10);
        weave3.insertNode(12);

        System.out.print("Original:    ");
        weave3.printAllDataInNodes();

        weave3.Weave();
        System.out.print("After Weave: ");
        weave3.printAllDataInNodes();




    }
}
