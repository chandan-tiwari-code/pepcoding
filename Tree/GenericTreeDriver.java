package Tree;

public class GenericTreeDriver {
    public static void main(String[] args) {
        GenericTree gt = new GenericTree();
        gt.createGT(new int[] {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1});
        gt.displayGT(gt.root);
    }
}
