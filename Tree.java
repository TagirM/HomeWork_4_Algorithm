// Сделать сбалансированное дерево поиска по имеющемуся массиву чисел.

import java.util.Arrays;

public class Tree {
    static int[] values = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 20, 15, 17, 23, 21, 25, 19 };    

    public static void main(String[] args) {
        Node root = new Node();
        ChoseSort.sort(values);        
        System.out.println(Arrays.toString(values));
        root = buildBalanceTree(values);
        // System.out.println(isBalance(root));
        System.out.println();
        printTree(root, "");
    }

    static void printTree(Node tree, String sp) {
        if (tree != null) {
            System.out.println(sp + tree.value);
            printTree(tree.left, sp + "  ");
            printTree(tree.right, sp + "  ");
        }
    }

    static int high(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(high(root.left), high(root.right));
    }

    static boolean isBalance(Node root) {
        int i = 0;
        if (root == null) {
            return true;
        }
        i = Math.abs(high(root.left) - high(root.right));
        if (i < 2) {
            return true;
        } else {
            return false;
        }
    }

    static Node buildBalanceTree(int[] valuesArr, int count, int startPosition, int endPosition) {
        if (count <= 0) {
            return null;
        } 
        Node root;
        int childLeft = 0;
        int childRight = 0;
        int middlePosition;
        root = new Node(); 
        childLeft = count / 2;
        childRight = (count +1)/ 2 -1;
        middlePosition = (startPosition + endPosition +1)/2;
        root.value = valuesArr[middlePosition];
        root.left = buildBalanceTree(valuesArr, childLeft, startPosition, middlePosition - 1);
        root.right = buildBalanceTree(valuesArr, childRight, middlePosition + 1, endPosition);
        return root;
    }

    static Node buildBalanceTree(int[] valuesArr) {
        return buildBalanceTree(valuesArr, valuesArr.length, 0, valuesArr.length-1);
    }    
}

class Node {
    int value;
    Node left;
    Node right;
}