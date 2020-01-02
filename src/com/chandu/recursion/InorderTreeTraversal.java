package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Print inorder traversal of tree using recursion
 * Try the same without using recursion
 */
public class InorderTreeTraversal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter data to root node , if nothing is present enter -1 ");
        int input = Integer.parseInt(br.readLine());
        if(input == -1){
            System.exit(1);
        }
        TreeNode rootNode = createNode(input);
        constructTree(rootNode);
        inorderTraversal(rootNode);
    }

    private static void inorderTraversal(TreeNode rootNode) {
        if (rootNode != null) {
            inorderTraversal(rootNode.left);
            System.out.println(rootNode.data);
            inorderTraversal(rootNode.right);
        }
    }

    public static void  constructTree(TreeNode rootNode) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter data to Tree node , if nothing is present enter -1 ");
            int input = Integer.parseInt(br.readLine());
            if (input == -1) break;
            TreeNode currentNode = createNode(input);
            createBst(rootNode, currentNode);
        }

    }

    private static void createBst(TreeNode rootNode, TreeNode currentNode) {

        TreeNode prev = null;
        while(rootNode != null) {
            prev = rootNode;
            if (rootNode.data > currentNode.data) {
                rootNode = rootNode.left;
            } else {
                rootNode = rootNode.right;
            }
        }
        if (prev != null && prev.data > currentNode.data) {
            prev.left = currentNode;
        } else if (prev != null) {
            prev.right = currentNode;
        }
    }

    public static TreeNode createNode(int data) {
        return new TreeNode(data,null,null);
    }


}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
