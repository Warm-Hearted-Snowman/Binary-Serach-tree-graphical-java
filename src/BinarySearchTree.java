import java.util.*;

public class BinarySearchTree extends Node {
    int numofElements = 0;

    static int orderCounter = 0;

    // For storing the Height of the root,left and right child height.
    private static class Height {
        int root, left, right;

        Height() {
            this.root = 0;
            this.left = 0;
            this.right = 0;
        }

        Height(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(this.root);
        }
    }

    //function to add elements in the Tree.
    public void addK(int number) throws Exception {
        System.out.print("Inserting data : " + number);
        Node newNode = new Node(number);
        if (isExisted(number)) return;
        add(number, newNode);
    }

    public Node addG(int number) throws Exception {
        System.out.print("Inserting data : " + number);
        Node newNode = new Node(number);
        if (isExisted(number)) return null;
        add(number, newNode);
        return newNode;
    }

    private void add(int number, Node newNode) {
        if (numofElements == 0) {
            rootNode = newNode;
            newNode.orderNum = 1;
        } else {
            Node temp = rootNode;
            while (temp != null) {
                if (temp.key < number) {
                    newNode.orderNum++;
                    if (temp.rightNode == null) {
                        temp.rightNode = newNode;
                        newNode.parentNode = temp;
                        newNode.orderNum = (newNode.parentNode.orderNum * 2) + 1;
                        break;
                    } else {
                        temp = temp.rightNode;
                        newNode.orderNum++;
                        continue;
                    }
                }
                if (temp.key > number) {
                    if (temp.leftNode == null) {
                        temp.leftNode = newNode;
                        newNode.parentNode = temp;
                        newNode.orderNum++;
                        newNode.orderNum = newNode.parentNode.orderNum * 2;
                        break;
                    } else {
                        temp = temp.leftNode;
                        orderCounter++;
                    }
                }
            }
        }
        numofElements++;
        System.out.println("...data Added.");
    }

    //function to display the tree. Pattern can be = InOrder Traversal, PreOrder Traversal, PostOrder Traversal, Level-Order Traversal.
    public void display(String pattern) throws Exception {
        if (rootNode == null) {
//            throw new Exception("Empty tree!");
            System.out.println("tree is empty");
            return;
        }

        switch (pattern) {
            case "inOrder":
                System.out.print("In-Order traversal : ");
                inOrderDisplay(rootNode);
                System.out.println();
                break;
            case "preOrder":
                System.out.print("Pre-Order traversal : ");
                preOrderDisplay(rootNode);
                System.out.println();
                break;
            case "postOrder":
                System.out.print("Post-Order traversal : ");
                postOrderDisplay(rootNode);
                System.out.println();
                break;
            case "levelOrder":
                System.out.print("Level-Order traversal : ");
                levelOrderDisplay(rootNode);
                System.out.println();
                break;
            default:
                System.out.println("Choose correct option...");
                break;
        }
    }

    //function for InOrder Traversal of Tree.
    public Node inOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplay(root.leftNode);
        System.out.print(root.key + " ");
        inOrderDisplay(root.rightNode);
        return root;
    }

    //function for PreOrder Traversal of the Tree.
    public Node preOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        System.out.print(root.key + " ");
        inOrderDisplay(root.leftNode);
        inOrderDisplay(root.rightNode);
        return root;
    }

    //function for PostOrder Traversal of the Tree.
    private Node postOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplay(root.leftNode);
        inOrderDisplay(root.rightNode);
        System.out.print(root.key + " ");
        return root;
    }

    //function for Level-Order Traversal of the Tree.
    private Node levelOrderDisplay(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.key + " ");
            if (temp.leftNode != null) {
                queue.add(temp.leftNode);
            }
            if (temp.rightNode != null) {
                queue.add(temp.rightNode);
            }
        }
        return root;
    }

    // Calculate Height of BST using recursive method.
    public Height calculateHeight(Node root) {
        if (root == null) {
            return new Height();
        }
        Height leftChild = calculateHeight(root.leftNode);
        Height rightChild = calculateHeight(root.rightNode);
        Height current = new Height(leftChild.root, rightChild.root);
        current.root = 1 + Math.max(leftChild.root, rightChild.root);
        return current;
    }

    //function to find specific data in the Tree.
    public boolean findNode(int number) throws Exception {
        if (rootNode == null) {
            throw new Exception("Empty tree!");
        }
        Node temp = rootNode;
        boolean result = false;
        while (temp != null) {
            if (temp.key == number) {
                result = true;
                break;
            }
            if (temp.key > number) {
                temp = temp.leftNode;
                continue;
            }
            temp = temp.rightNode;
        }
        return result;
    }

    public List<Object> findNodeG(int number) throws Exception {
        if (rootNode == null) {
            throw new Exception("Empty tree!");
        }
        Node temp = rootNode;
        boolean result = false;
        int node_ordernum = 0;
        while (temp != null) {
            if (temp.key == number) {
                result = true;
                break;
            }
            if (temp.key > number) {
                temp = temp.leftNode;
                continue;
            }
            temp = temp.rightNode;
        }
        assert temp != null;
        return Arrays.asList(temp, result, temp.orderNum);
    }

    public boolean findNodePP(int number) throws Exception {
        if (rootNode == null) {
            throw new Exception("Empty tree!");
        }
        Node temp = rootNode;
        boolean result = false;
        Stack<String> showNodes = new Stack<String>();
        System.out.print("Node traversal : ");
        while (temp != null) {
            if (temp.key == number) {
                result = true;
                showNodes.add(String.valueOf(temp.key));
                break;
            }
            if (temp.key > number) {
                showNodes.add(String.valueOf(temp.key));
                temp = temp.leftNode;
                continue;
            }
            if (temp.key < number) {
                showNodes.add(String.valueOf(temp.key));
                temp = temp.rightNode;
                continue;
            }
        }
        while (result && !showNodes.isEmpty()) {
            System.out.print("->" + showNodes.pop());
        }
        System.out.println(" (ROOT)");
        System.out.println();
        return result;

    }

    public Node find(int data) {
        Node temp = rootNode;
        Node prev = null;
        if (temp == null) {
            return null;
        }

        while (temp != null) {
            if (temp.key == data) {
                return temp;
            }

            if (data > temp.key) {
                prev = temp;
                temp = temp.rightNode;
                continue;
            }
            prev = temp;
            temp = temp.leftNode;
        }
        return prev;
    }

    public Node findNext(int data) {
        Node temp = find(data);
        if (temp.key != data) {
            System.out.println(data + " not present in the tree.");
            return null;
        }
        Node right = temp.rightNode;
        Node parent = temp.parentNode;

        if (right != null) {
            while (right.leftNode != null) {
                right = right.leftNode;
            }
            return right;
        }

        while (parent != null) {
            if (parent.key > temp.key) {
                return parent;
            }
            parent = parent.parentNode;
        }
        return temp;
    }

    public int delete_grapical(int key) {
        rootNode = deleteRecursively(rootNode, key);

        return rootNode.orderNum;
    }

    public void delete(int key) {
        rootNode = deleteRecursively(rootNode, key);
    }

    public Node deleteRecursively(Node root, int value) {
        if (root == null)
            return root;

        if (value < (int) root.key) {
            root.leftNode = deleteRecursively(root.leftNode, value);
        } else if (value > (int) root.key) {
            root.rightNode = deleteRecursively(root.rightNode, value);
        } else {

            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null)
                return root.leftNode;

            root.key = inOrderSuccessor(root.rightNode);
            root.rightNode = deleteRecursively(root.rightNode, (int) root.key);
        }

        return root;
    }

    public static int inOrderSuccessor(Node root) {
        int minimum = (int) root.key;
        while (root.leftNode != null) {
            minimum = (int) root.leftNode.key;
            root = root.leftNode;
        }
        return minimum;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.leftNode != null) {
            minv = root.leftNode.key;
            root = root.leftNode;
        }
        return minv;
    }

    public void deleteTMP(int data) {
        Node temp = find(data);

        if (temp == null) {
            return;
        }

        if (temp.key != data) {
            return;
        }
        numofElements--;
        if (temp.rightNode == null) {
            if (temp.parentNode == null) {
                rootNode = temp.leftNode;
                if (rootNode != null) {
                    rootNode.parentNode = null;
                }
                temp = null;
                return;
            }
            if (temp.leftNode != null) {
                temp.leftNode.parentNode = temp.parentNode;
            }
            if (temp.parentNode.rightNode == temp) {
                temp.parentNode.rightNode = temp.leftNode;
                temp = null;
                return;
            } else {
                temp.parentNode.leftNode = temp.leftNode;
                temp = null;
                return;
            }
        }

        Node nextTemp = findNext(temp.key);
        if (nextTemp.rightNode != null) {
            nextTemp.rightNode.parentNode = nextTemp.parentNode;
        }
        if (nextTemp.parentNode == null) {
            rootNode = nextTemp.rightNode;
        }
        if (nextTemp.parentNode != null && nextTemp.parentNode.leftNode == nextTemp) {
            nextTemp.parentNode.leftNode = nextTemp.rightNode;
        }
        if (nextTemp.parentNode != null && nextTemp.parentNode.rightNode == nextTemp) {
            nextTemp.parentNode.rightNode = nextTemp.rightNode;
        }


        if (temp.leftNode != null) {
            temp.leftNode.parentNode = nextTemp;
        }
        if (temp.rightNode != null) {
            temp.rightNode.parentNode = nextTemp;
        }
        nextTemp.leftNode = temp.leftNode;
        nextTemp.rightNode = temp.rightNode;
        nextTemp.parentNode = temp.parentNode;


        if (temp.parentNode == null) {
            rootNode = nextTemp;
            temp = null;
            return;
        }
        if (temp.parentNode.rightNode == temp) {
            temp.parentNode.rightNode = nextTemp;
            temp = null;
            return;
        }
        temp.parentNode.leftNode = nextTemp;
        temp = null;
    }


    //function to find the max data value in the tree.
    public Node maxNode() {
        if (rootNode == null) {
            return null;
        }
        Node temp = rootNode;
        while (temp.rightNode != null) {
            temp = temp.rightNode;
        }
        return temp;
    }

    //function to find the min data value in the tree.
    public Node minNode() {
        if (rootNode == null) {
            return null;
        }
        Node temp = rootNode;
        while (temp.leftNode != null) {
            temp = temp.leftNode;
        }
        return temp;
    }

    public int countLeafNodesRecursively() {
        return countLeaves(rootNode);
    }

    private int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.isLeaf()) {
            return 1;
        } else {
            return countLeaves(node.leftNode) + countLeaves(node.rightNode);
        }
    }

    public boolean isCompleteBT(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (!temp.isLeaf() && (temp.rightNode == null || temp.leftNode == null)) {
                return false;
            }
            if (temp.leftNode != null)
                queue.add(temp.leftNode);
            if (temp.rightNode != null)
                queue.add(temp.rightNode);
        }
        return true;
    }

    public boolean compareTrees(String POFirstTree, String POSecondTree, String IOFirstTree, String IOSecondTree) {
        return Objects.equals(POFirstTree, POSecondTree) && Objects.equals(IOFirstTree, IOSecondTree);
    }

    public void deleteAllNodes() {
        while (rootNode != null) {
            delete(rootNode.key);
        }
        System.out.println("Tree deleted completely!");
    }

    public void deleteAllNodesTMP() {
        while (rootNode != null) {
            deleteTMP(rootNode.key);
        }
    }

    public boolean isExisted(int num) throws Exception {
//        System.out.println();
//        System.out.println("num of : "+numofElements);
        if (numofElements != 0 && findNode(num)) {
            System.out.println("...is Existed already.");
            return true;
        }
        return false;
    }
}






