public class DoubleLL {
  public class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static Node head;

  public static Node tail;
  public static int size;

  // add
  public void addfirst(int data) {
    // creating a new Node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "<->");
      temp = temp.next;

    }
    System.out.println("null");
  }

  public int removeFirst() {
    if (head == null) {
      System.out.println("DLL IS EMPTY");
      size--;
      return Integer.MIN_VALUE;
    }
    if (size == 1) {
      int val = head.data;
      head = tail = null;
      size--;
      return val;
    }
    int val = head.data;
    head = head.next;
    head.prev = null;
    size--;
    return val;
  }

  // reverse a doubly linked list
  public void reverse() {
    Node current = head;
    Node prev = null;
    Node next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      current.prev = next;
      prev = current;
      current = next;
    }
    head = prev;
  }

  public static void main(String args[]) {
    DoubleLL dll = new DoubleLL();
    dll.addfirst(3);
    dll.addfirst(2);
    dll.addfirst(1);
    dll.addfirst(0);
    dll.print();
    System.out.println(dll.size);
    dll.reverse();
    dll.print();

  }

}
