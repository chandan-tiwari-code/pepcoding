package Tree.GenericTree;

import java.util.*;

public class CustomGenericTree<T> {
    private int diameter = 0;
    private Node<T> root;

    private static class Node<T> {
        private final T data;
        private final List<Node<T>> children;

        // The final final List<Node<T>> children; never means we can not add new element like children.add(node)).. It means we can not do children  = new ArrayList<>();
        private Node(T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    private static class Pair<T> {
        private Node<T> node;
        private int level;

        private Pair(Node<T> node) {
            this.node = node;
            level = -1;
        }

        private Pair(Node<T> node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void construct(T[] input) {
        if (root != null) throw new IllegalStateException("Tree is already populated");
        Stack<Node<T>> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] != null) {
                Node<T> node = new Node<>(input[i]);
                if (stack.isEmpty()) {
                    this.root = node;
                } else {
                    stack.peek().children.add(node);
                }
                stack.push(node);
            } else {
                if (stack.isEmpty()) throw new IllegalStateException("Invalid data");
                stack.pop();
            }
        }
    }

    //No need of adding base condition as for the for the node have no children recursive method will not be called
    public int getProperty() {
        if (root == null) return 0;
        // return findMaxHeight(root);
        // return findMaxValue(root);
        // return findMinValue(root);
        return findSize(root);
        //return sum(root);
    }

    public int findSize(Node<T> root) {
       int size = 0;
       if(root == null) return size;
       for(Node<T> node: root.children) {
            int childSize = findSize(node);
            size += childSize;
        }
        return size+1;
    }

    private int sum(Node<T> root) {
        int sum = 0;
        for (Node<T> child : root.children) {
            int childSum = sum(child);
            sum += childSum;
        }
        return sum += (Integer) root.data;
    }

    private int findMaxHeight(Node<T> root) {
        int height = 0;
        for (Node<T> node : root.children) {
            int deepestChild = findMaxHeight(node);
            height = Math.max(deepestChild, height);
        }
        return height + 1;
    }

    private int findMaxValue(Node<T> root) {
        int max = 0;
        for (Node<T> node : root.children) {
            int childMax = findMaxValue(node);
            max = Math.max(max, childMax);
        }
        return Math.max(max, (Integer) root.data);
    }

    private int findMinValue(Node<T> root) {
        int min = 0;
        for (Node<T> node : root.children) {
            int childMin = findMinValue(node);
            min = Math.min(min, childMin);
        }
        return Math.min(min, (Integer) root.data);
    }


    public void clear() {
        root = null;
    }

    public void displayTree() {
        if (root == null) throw new IllegalStateException("Tree is empty!!!");
        defaultDisplay(root);
    }

    private void defaultDisplay(Node<T> root) {
        if (root == null) return;
        String str = root.data + "-->";
        for (Node<T> node : root.children) {
            str += node.data + " ";
        }
        str += ".";
        System.out.println(str);
        for (Node<T> node : root.children) {
            defaultDisplay(node);
        }
    }

    private void display(Node<T> root) {
        this.root = root;
        bfsNewLineDisplay();
    }

    //DFS using recursive Pre Order; Post Order is easy in any recursion method just need to add data to list after the loop
    public List<T> genericDisplay() {
        //return displayList(root);
        List<T> result = new ArrayList<>();
        displayList(root, result);
        return result;
    }

    //New List at every recursion
    private List<T> displayList(Node<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.data);
        for (Node<T> node : root.children) {
            List<T> list = displayList(node);
            result.addAll(list);
        }
        return result;
    }

    //Using a common list
    private void displayList(Node<T> root, List<T> result) {
        if (root == null) return;
        result.add(root.data);
        for (Node<T> node : root.children) {
            displayList(node, result);
        }
    }

    //DFS using Iteration Pre Order
    public List<T> dfsPreorder() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            result.add(node.data);
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return result;
    }

    //DFS using Iteration Post Order
    public List<T> dfsPostOrderDoubleStackIteration() {
        List<T> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node<T>> main = new Stack<>();
        Stack<Node<T>> child = new Stack<>();
        main.push(root);
        while (!main.isEmpty()) {
            Node<T> node = main.pop();
            child.push(node);
            for (Node<T> node1 : node.children) {
                main.push(node1);
            }
        }
        while (!child.isEmpty()) {
            list.add(child.pop().data);
        }
        return list;
    }

    public List<T> dfsPostOrderSingleStack() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Pair<T>> stack = new Stack<>();
        stack.push(new Pair<>(root));
        while (!stack.isEmpty()) {
            Pair<T> top = stack.peek();
            top.level++;
            if (top.level == top.node.children.size()) {
                result.add(top.node.data);
                stack.pop();
            } else {
                Node<T> node = top.node.children.get(top.level);
                stack.push(new Pair<>(node));
            }
        }
        return result;
    }

    public List<T> bfsBasic() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            result.add(node.data);
            queue.addAll(node.children);
        }
        return result;
    }

    public List<List<T>> bfsNewline() {
        List<List<T>> result = new ArrayList<>();
        if (root == null) return result;
        List<T> list = new ArrayList<>();
        Queue<Node<T>> main = new LinkedList<>();
        Queue<Node<T>> child = new LinkedList<>();
        main.add(root);
        while (!main.isEmpty()) {
            Node<T> node = main.remove();
            child.addAll(node.children);
            list.add(node.data);
            if (main.isEmpty()) {
                result.add(list);
                if (!child.isEmpty()) {
                    list = new ArrayList<>();
                    main = child;
                    child = new LinkedList<>();
                }
            }
        }
        return result;
    }

    public void bfsNewLineDisplay() {
        if (root == null) return;
        Queue<Node<T>> main = new LinkedList<>();
        Queue<Node<T>> child = new LinkedList<>();
        main.add(root);
        while (!main.isEmpty()) {
            Node<T> node = main.remove();
            System.out.print(node.data + " ");
            child.addAll(node.children);
            if (main.isEmpty() && !child.isEmpty()) {
                main = child;
                child = new LinkedList<>();
                System.out.println();
            }
        }
    }


    public void bfsNewLineDisplayUsingMarker() {
        if (root == null) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.data + " ");
                queue.addAll(node.children);
            }
        }
    }

    public List<List<T>> bfsNewLineUsingMarker() {
        List<List<T>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<T> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if (node == null) {
                result.add(list);
                if (!queue.isEmpty()) {
                    queue.add(null);
                    list = new ArrayList<>();
                }
            } else {
                list.add(node.data);
                queue.addAll(node.children);
            }
        }
        return result;
    }

    public void bfsCountApproachDisplay() {
        if (root == null) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node<T> node = queue.remove();
                System.out.print(node.data + " ");
                queue.addAll(node.children);
            }
            System.out.println();
        }
    }

    public List<List<T>> bfsCountApproach() {
        List<List<T>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<T> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node<T> node = queue.remove();
                list.add(node.data);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }

    public void bfsPairApproachDisplay() {
        if (root == null) return;
        Queue<Pair<T>> queue = new LinkedList<>();
        Pair<T> rootPair = new Pair<>(root, 0);
        queue.add(rootPair);
        int level = 0;
        while (!queue.isEmpty()) {
            Pair<T> pair = queue.remove();
            Node<T> node = pair.node;
            if (level < pair.level) {
                level = pair.level;
                System.out.println();
            }
            System.out.print(node.data + " ");
            for (Node<T> child : node.children) {
                queue.add(new Pair<>(child, level++));
            }
        }
    }

    public List<List<T>> bfsPairApproach() {
        List<List<T>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Pair<T>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        List<T> list = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            Pair<T> pair = queue.remove();
            Node<T> node = pair.node;
            if (level < pair.level) {
                level = pair.level;
                result.add(list);
                list = new ArrayList<>();
            }
            list.add(node.data);
            for (Node<T> child : node.children) {
                queue.add(new Pair<>(child, level + 1));
            }
        }
        return result;
    }


    public void bfsZigZagDisplayQue() {
        Queue<Node<T>> main = new LinkedList<>();
        Queue<Node<T>> child = new LinkedList<>();
        if (root == null) return;
        main.add(root);
        boolean dir = true;
        while (!main.isEmpty()) {
            Node<T> node = main.remove();
            System.out.println(node.data);
            if (dir) {
                child.addAll(node.children);
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    child.add(node.children.get(i));
                }
            }
            if (main.isEmpty() && !child.isEmpty()) {
                Stack<Node<T>> stack = new Stack<>();
                while(!child.isEmpty()) {
                    stack.push(child.poll());
                }
                while(!stack.isEmpty()) {
                    main.add(stack.pop());
                }
                dir = !dir;
            }
        }
    }

    public void bfsZigZagDisplayMis() {
        Queue<Node<T>> queue = new LinkedList<>();
        Stack<Node<T>> stack = new Stack<>();
        if (root == null) return;
        queue.add(root);
        boolean dir = true;
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            System.out.println(node.data);
            if (dir) {
                stack.addAll(node.children);
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }
            }
            if (queue.isEmpty() && !stack.isEmpty()) {
                while(!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                dir = !dir;
            }
        }
    }

    public void bfsZigZagDisplayDoubleStack() {
        Stack<Node<T>> main = new Stack<>();
        Stack<Node<T>> child = new Stack<>();
        if (root == null) return;
        main.add(root);
        boolean dir = true;
        while (!main.isEmpty()) {
            Node<T> node = main.pop();
            System.out.println(node.data);
            if (dir) {
                child.addAll(node.children);
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    child.add(node.children.get(i));
                }
            }
            if (main.isEmpty() && !child.isEmpty()) {
                main = child;
                child = new Stack<>();
                dir = !dir;
            }
        }
    }

    public void mirror() {
        Node<T> mirror = root;
        mirroring(mirror);
        System.out.println();
        display(mirror);
        bfsNewLineDisplay();
    }

    public void mirroring(Node<T> root) {
        if(root == null) return;
        for(Node<T> node: root.children){
            mirroring(node);
        }
        Collections.reverse(root.children);
    }

    public void removeLeaves() {
        if (root == null) return;
        removeLeaves(root);
        System.out.println();
        bfsNewLineDisplay();
    }

    private void removeLeaves(Node<T> root) {
        for(int i = root.children.size()-1; i >= 0; i--){
            if(root.children.get(i).children.isEmpty()) {
                root.children.remove(i);
            }
        }
        for(Node<T> node : root.children) {
            removeLeaves(node);
        }
    }

    public void linearizeTree() {
        if(root == null) return;
        //linearize(root);
        linearizeOptimize(root);
        System.out.println();
        bfsNewLineDisplay();
    }

    //No need of base case as, it wll not enter to loop if no child
    private void linearize(Node<T> root) {
        for(Node<T> node : root.children) {
            linearize(node);
        }
        for(int i = root.children.size()-1; i>=1; i--) {
            Node<T> lastNode = root.children.remove(i);
            Node<T> secondLastNode = root.children.get(i-1);
            Node<T> tail = getTail(secondLastNode);
            tail.children.add(lastNode);
        }
    }

    //in the post node ops node is linearize (there will be only one child)
    private Node<T> getTail(Node<T> child){
        while(child.children.size() == 1) {
            child = child.children.get(0);
        }
        return child;
    }

    //Base Condition: if its leaf (root.children.isEmpty()) instead of null return that node
    //Line 541: remove till size is greater than 1 (at-least 2 children)
    private Node<T> linearizeOptimize(Node<T> node) {
        if(node.children.isEmpty()) return node;
        Node<T> lastNodeTail = linearizeOptimize(node.children.get(node.children.size()-1));
        while (node.children.size() > 1) {
            Node<T> lastNode = node.children.remove(node.children.size()-1);
            Node<T> secondLastNode = node.children.get(node.children.size()-1);
            Node<T> secondLastNodeTail = linearizeOptimize(secondLastNode);
            secondLastNodeTail.children.add(lastNode);
        }
        return lastNodeTail;
    }

    public boolean find(T t) {
        if(root == null) throw new RuntimeException("Tree is empty!!!");
        return find(root, t);
    }

    private boolean find(Node<T> root, T t) {
        if(root.data.equals(t)) return true;
        for(Node<T> node : root.children) {
            boolean res = find(node, t);
            if(res) return true;
        }
        return false;
    }

    public List<T> nodeToRootPath(T t) {

        return null;
    }

    public int diameter(){
        if(root == null) return diameter;
        getDiameter(root);
        System.out.println();
        return this.diameter;
    }

    //line 584 else is imp. if not put else and put only if(childDeepest > secondDeepestChild) and if childDeepest value is higher than deepest then both if will be executed
    //first if will put deepest to childDeepest, secondDeepest to deepest, now we don't have else and only if is present second if also executed and secondDeepest will also be set to deepest
    private int getDiameter(Node<T> root) {
        int deepestChild = -1;
        int secondDeepestChild = -1;
        for(Node<T> node : root.children) {
            int childDeepest = getDiameter(node);
            if(childDeepest > deepestChild) {
                secondDeepestChild = deepestChild;
                deepestChild = childDeepest;
            }
            else if(childDeepest > secondDeepestChild) {
                secondDeepestChild = childDeepest;
            }
        }
        int diameter = deepestChild + secondDeepestChild + 2;
        if(diameter > this.diameter) this.diameter = diameter;
        return deepestChild+1;
    }

}