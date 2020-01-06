package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * PostOrder tree traversal without Recursion
 */
public class PostOrderTraversalWithoutRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine());
        TreeNode node = createNode(data);
        constructTree(node);
        postOrderTraversal(node);
    }

    private static void constructTree(TreeNode rootNode) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter data to enter into tree to terminate enter -1");
            int data = Integer.parseInt(br.readLine());
            if(data == -1)return;
            TreeNode dataNode = createNode(data);
            createBST(rootNode, dataNode);
        }
    }

    private static void createBST(TreeNode rootNode, TreeNode dataNode) {
        TreeNode prev = null;
        while(rootNode != null) {
            prev = rootNode;
            if(rootNode.data > dataNode.data) {
                rootNode = rootNode.left;
            } else {
                rootNode = rootNode.right;
            }
        }
        if(prev != null && prev.data > dataNode.data) {
            prev.left = dataNode;
        } else if(prev != null) {
            prev.right = dataNode;
        }
    }

    private static TreeNode createNode(int data) {
        return new TreeNode(data, null, null);
    }

    public static void postOrderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode stackTopNode = stack.peek().right;
                if(stackTopNode != null) {
                    node = stack.peek().right;
                } else{
                    TreeNode rightNode = stack.pop();
                    System.out.println(rightNode.data);
                    while(!stack.isEmpty() && rightNode == stack.peek().right) {
                        rightNode = stack.pop();
                        System.out.println(rightNode.data);
                    }
                }
            }
        }
    }
}
