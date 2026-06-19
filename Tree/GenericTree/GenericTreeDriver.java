package Tree.GenericTree;

import java.util.List;

public class GenericTreeDriver {
    public static void main(String[] args) {
        CustomGenericTree<Integer> customGenericTree = new CustomGenericTree<>();
        //CustomGenericTree<Character> customGenericTree = new CustomGenericTree<>();
        customGenericTree.construct(new Integer[]{10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null});
        //customGenericTree.construct(new Character[]{'A', 'B', 'E', null, 'F', null, 'G', 'K', null, null, null, 'C', 'H', null, null, 'D', 'I', 'L', null, 'M', null, null, 'J', null, null, null});
        //customGenericTree.displayTree();
        //List<Integer> list = customGenericTree.genericDisplay();
        //System.out.println(list);
        //System.out.println(customGenericTree.dfsPreorder());
        //System.out.println(customGenericTree.dfsPostOrderDoubleStackIteration());
        //System.out.println(customGenericTree.dfsPostOrderSingleStack());
        //System.out.println(customGenericTree.bfsBasic());
        //System.out.println(customGenericTree.bfsNewline());
        customGenericTree.bfsNewLineDisplay();
        //customGenericTree.bfsNewLineDisplayUsingMarker();
        //System.out.println(customGenericTree.bfsNewLineUsingMarker());
        //customGenericTree.bfsCountApproachDisplay();
        //System.out.println(customGenericTree.bfsCountApproach());
        //customGenericTree.bfsPairApproachDisplay();
        //System.out.println(customGenericTree.getProperty());
        //System.out.println(customGenericTree.bfsPairApproach());
        //System.out.println(customGenericTree.zigzag());
        //customGenericTree.bfsZigZagDisplayDoubleStack();
        //customGenericTree.mirror();
        //customGenericTree.removeLeaves();
        //customGenericTree.linearizeTree();
        //System.out.println(customGenericTree.find(110));
        System.out.println(customGenericTree.diameter());
    }
}
