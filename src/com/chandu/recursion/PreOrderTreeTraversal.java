package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreOrderTreeTraversal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter data to be entered into root node , if no data enter -1");
        int input = Integer.parseInt(br.readLine());
        if (input == -1) {
            System.exit(1);
        }
        TreeNode rootNode = createNode(input);
        constructTree(rootNode);
        preOrderTraversal(rootNode);
    }

    public static TreeNode createNode(int data) {
        return  new TreeNode(data,null,null);
    }

    public static void constructTree(TreeNode rootNode) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter data to be entered into root node , if no data enter -1");
            int input = Integer.parseInt(br.readLine());
            if (input == -1) break;
            TreeNode currentNode = createNode(input);
            createBST(rootNode, currentNode);
        }
    }

    public static void createBST(TreeNode rootNode, TreeNode currentNode) {

        TreeNode prev = null;
        while (rootNode != null) {
            prev = rootNode;
            if (rootNode.data > currentNode.data) {
                rootNode = rootNode.left;
            } else {
                rootNode = rootNode.right;
            }
        }
        if (prev != null && prev.data > currentNode.data) {
            prev.left = currentNode;
        } else if (prev != null) prev.right = currentNode;
    }

    public static void  preOrderTraversal(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.data);
            preOrderTraversal(rootNode.left);
            preOrderTraversal(rootNode.right);
        }
    }
}
