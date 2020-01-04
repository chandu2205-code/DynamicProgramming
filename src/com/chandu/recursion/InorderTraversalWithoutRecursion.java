package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        constructTree(nodeCount);
    }

    private static void constructTree(int nodeCount) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter root node data");
        int nodeData = Integer.parseInt(br.readLine());
        TreeNode rootNode = createNode(nodeData);
        while(true) {
            System.out.println("Enter node data and enter -1 if no data");
            int data = Integer.parseInt(br.readLine());
            if(data == -1) break;
            createBst(rootNode, createNode(data));
        }
        inOrderTraversal(rootNode);
    }

    private static void inOrderTraversal(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<>();

        while(rootNode != null || !stack.empty()) {

            if(rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.left;
            }
            if(rootNode == null && !stack.empty()) {
                System.out.println(stack.peek().data);
                TreeNode topElement = stack.pop();
                rootNode = topElement.right;
            }
        }
    }

    private static TreeNode createNode(int data) {
        return new TreeNode(data, null, null);
    }

    private static void createBst(TreeNode rootNode, TreeNode node) {
        TreeNode prev = null;
        while(rootNode != null) {
            prev = rootNode;
            if(rootNode.data > node.data) {
                rootNode = rootNode.left;
            }else {
                rootNode = rootNode.right;
            }
        }

        if(prev != null && prev.data > node.data) {
           prev.left = node;
        } else if (prev != null) {
            prev.right = node;
        }
    }
}
