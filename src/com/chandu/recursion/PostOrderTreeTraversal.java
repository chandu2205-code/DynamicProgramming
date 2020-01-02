package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostOrderTreeTraversal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter data to be entered into root node , if no data enter -1");
        int data = Integer.parseInt(br.readLine());
        if (data == -1) System.exit(1);
        TreeNode rootNode = createNode(data);
        constructTree(rootNode);
        postOrderTraversal(rootNode);
    }

    private static void postOrderTraversal(TreeNode rootNode) {
        if (rootNode != null) {
            postOrderTraversal(rootNode.left);
            postOrderTraversal(rootNode.right);
            System.out.println(rootNode.data);
        }
    }

    public static TreeNode createNode(int data) {
        return new TreeNode(data, null ,null);
    }

    public static void constructTree(TreeNode rootNode) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter data to be entered into root node , if no data enter -1");
            int data = Integer.parseInt(br.readLine());
            if (data == -1) break;
            TreeNode currentNode = createNode(data);
            createBST(currentNode, rootNode);
        }
    }

    public static void createBST(TreeNode currentNode, TreeNode rootNode) {
        TreeNode prev = null;
        while (rootNode != null) {
            prev = rootNode;
            if( prev.data > currentNode.data) {
                rootNode = prev.left;
            } else {
                rootNode = prev.right;
            }
        }
        if(prev != null && prev.data > currentNode.data) {
            prev.left = currentNode;
        } else if (prev != null) {
            prev.right = currentNode;
        }
    }
}
