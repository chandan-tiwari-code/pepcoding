
package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {

    public Node root;
    
    private class Node {
        private int data;
        private ArrayList<Node> children;
    }

    public void createGT(int[] data) {
        int len= data.length;
        Stack<Node> stack = new Stack<>();

        for(int i=0; i<len; i++) {
            Node temp = new Node();
            if(data[i] != -1) {
                temp.data=data[i];
                temp.children= new ArrayList<>();
                if(stack.size() == 0) {
                    root = temp;
                } else {
                    stack.peek().children.add(temp);
                }
                stack.push(temp);
            } else {
                stack.pop();
            }
        }
        System.out.println("Generic Tree created successfully!!!");
    }

    public void displayGT(Node node) {
        String str = node.data + "-->";
        for(Node child: node.children) {
            str += child.data + ",";
        }
        System.out.println(str + ".");
        for(Node child: node.children) {
            displayGT(child);
        }
    }

}