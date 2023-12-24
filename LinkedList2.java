public class LinkedList2 {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  // add first in a linked List
  public void AddFirst(int data) {
    // create a new node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    // point this node to the head
    newNode.next = head;
    // declare this new Node as head
    head = newNode;
  }

  // add last in a linked List
  public void AddLast(int data) {

    // creating a new node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    // assign newNode next as tail
    tail.next = newNode;
    // because newNode next don't know what the tail is..so we know tail then we
    // give tail next as newNode
    // declaring tail as a newNode
    tail = newNode;
  }

  // adding in middle
  public void AddMiddle(int index, int data) {
    if (index == 0) {
      AddFirst(data);
      return;
    }
    // creating a newNode
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i = 0;
    while (i < index - 1) {
      temp = temp.next;// updating the temp
      i++;// the index count

    }
    // point the next of current node same as prev node
    newNode.next = temp.next;
    // point the next of prev node to the current newnode
    temp.next = newNode;
  }

  // printing the linked list
  public void PrintLL() {

    Node temp = head;
    if (head == null) {
      System.out.println("The linkedList is empty");
      return;
    }

    while (temp != null) {
      System.out.println(temp.data + "->");
      temp = temp.next;

    }
    System.out.println();

  }

  // detecting a loop/cycle in a linkedList
  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  // removing the cycle in a linked list
  /*
   * detect the cycle
   * set slow as head
   * a)slow:>+1
   * b)fast:>+1
   * (they will meet at the point of cycle creation )
   * find last node(using prev extra variable)
   * last node.next = null;
   */
  public static void removecycle() {
    // detetct cycle
    Node slow = head;
    Node fast = head;
    boolean cycle = false;// cycle not exist
    while (fast != null && fast.next == null) {
      slow = slow.next;
      fast = fast.next;
      if (fast == slow) {
        cycle = true;
        break;

      }
    }
    if (cycle == false) {
      return;
    }

    // find meeting point
    slow = head;
    Node prev = null;
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;

    }

    // remove cycle:> last.next = null
    prev.next = null;
  }

  // merge sort on linked list
  /*
   * 1)find the middle of the linked lsit
   * 2)a:> left half
   * b:> right half
   * ->mid.next = null
   * 3)merge both the linked list
   * :>merged linked list using temporary iterator
   * (dummy node)
   */
  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

    }
    return slow;

  }

  private Node merge(Node head1, Node head2) {
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;
    while (head1 != null || head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;

      } else {
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
      }

    }
    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;

    }
    while (head != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;

    }
    return mergedLL.next;

  }

  public Node mergSort(Node head) {
    if (head == null && head.next == null) {
      {
        return head;
      }
    }
    // finding mid
    Node mid = getMid(head);

    // left &right half MS
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergSort(head);
    Node newRight = mergSort(rightHead);

    // merge
    return merge(newLeft, newRight);

  }

  // zig zag fashion of linked list
  public void zigzag() {
    // finding the mid
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

    }
    Node mid = slow;

    // reversing the second half
    Node current = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    Node left = head;
    Node right = prev;
    Node nextLeft, nextRight;

    // alt-arrangement//zog-zag arrangement
    while (left != null && right != null) {
      nextLeft = left.next;
      left.next = right;
      nextRight = right.next;
      right.next = nextLeft;

      left = nextLeft;
      right = nextRight;
    }

  }

  public static void main(String args[]) {
    LinkedList2 ll2 = new LinkedList2();
    ll2.AddLast(1);
    ll2.AddLast(2);
    ll2.AddLast(3);
    ll2.AddLast(4);
    ll2.AddLast(5);

    ll2.PrintLL();
    ll2.zigzag();
    ll2.PrintLL();

  }
}