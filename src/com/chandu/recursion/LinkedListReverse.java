package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Print linked list in reverse order using recursion
 * This is head recursion where recursive call is made before
 * (before it performs its own function)
 */
public class LinkedListReverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine());
        Node head = constructLinkedList(nodes);
        printLinkedListReverse(head);
    }

    private static void printLinkedListReverse(Node head) {
        if(head != null) {
            printLinkedListReverse(head.next);
            System.out.println(head.data);
        }
    }

    private static Node constructLinkedList(int nodes) throws IOException {

        Node head = null;
        Node temp;
        Node prev = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<nodes;i++) {
            System.out.println("Enter data for linked list");
            int data = Integer.parseInt(br.readLine());
            temp = new Node(data , null);
            if(i == 0) {
                head = temp;
                prev = head;
            } else {
                prev.next = temp;
                prev = temp;
            }
        }
        return head;
    }

}

/**
 * Entity which represents actual Linked List
 * which consists
 * <ul>
 *     <li>data : integer</li>
 *     <li>next : pointer to next node</li>
 * </ul>
 */
class Node {
    public int data;
    public Node next;

    Node() {}
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
