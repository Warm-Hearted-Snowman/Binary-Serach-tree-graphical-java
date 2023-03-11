public class Node {
    Node rootNode; //root of the tree.

    int key;   //data value

    Node parentNode;  //points to the parent.
    Node leftNode;    //points to left child.
    Node rightNode;   //points to right child.

    int orderNum=0;

    public Node() {
        parentNode = null;
        leftNode = null;
        rightNode = null;
    }

    public Node(int value) {
        this.key = value;
        parentNode = null;
        leftNode = null;
        rightNode = null;
    }

    protected boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }
}
