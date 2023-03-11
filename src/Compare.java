public class Compare {
    String inOrder="";
    String preOrder="";
    public String inOrderDisplay(Node root) {
//        root=Main
        if (root == null) {
            return null;
        }
        inOrderDisplay(root.leftNode);
        inOrder+=root.key+" ";
        inOrderDisplay(root.rightNode);
        return inOrder;
    }

    //function for PreOrder Traversal of the Tree.
    public String preOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        preOrder+=root.key+" ";
        inOrderDisplay(root.leftNode);
        inOrderDisplay(root.rightNode);
        return preOrder;
    }
}
