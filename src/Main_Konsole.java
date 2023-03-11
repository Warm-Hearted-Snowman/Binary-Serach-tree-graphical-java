import java.util.Objects;
import java.util.Scanner;

public class Main_Konsole {
    static Scanner sc = new Scanner(System.in);
    static BinarySearchTree tree = new BinarySearchTree();
    static BinarySearchTree tempTree = new BinarySearchTree();

    public static void main(String[] args) throws Exception {

        String welcome = "\t\t===(Welcome to BINARY SEARCH TREE project)===\t\t\n\n" +
                "Press any key to continue...";
        System.out.println(welcome);
        sc.nextLine();

        showOptions();

        while (sc.hasNext()) {
            chooseOption(sc.nextLine());
            System.out.println("-------------------------------------------");
            showOptions();
        }
    }

    public static void showOptions() {

        String options = "" +
                "1.Add new number.\t\t\t\t\t" +
                "2.Remove a number.\n" +
                "3.Show number of Nodes.\t\t\t\t" +
                "4.Show Height of tree.\n" +
                "5.Show Number of leaves.\t\t\t" +
                "6.Show Minimum and Maximum elements of Tree.\n" +
                "7.Tree is complete or not.\t\t\t" +
                "8.Compare two Trees with each other\n" +
                "9.Find an element in Tree\t\t\t" +
                "10.Tree traversal.\n" +
                "11.Delete Tree.\t\t\t\t\t\t" +
                "12.Credits and Developers\n" +
                "0.Finish Program...\n" +
                "";

        System.out.println(options);
    }

    public static void chooseOption(String input) throws Exception {
        switch (input) {
            case "1":
                System.out.println("Input your NUMBER :");
                String in1 = sc.nextLine();
                try {
                    if (in1.contains(" ")) {
                        String[] newTree = in1.split("\\s+");
                        for (String s : newTree) {
                            tree.addK(Integer.parseInt(s));
                        }
                    } else {
                        tree.addK(Integer.parseInt(in1));
                    }
                    afterFunc();
                } catch (Exception exception) {
                    System.out.println("Enter available Integer value.");
                }
                break;
            case "2":
                System.out.println("Input your NUMBER :");
                String in2 = sc.nextLine();
                tree.delete(Integer.parseInt(in2));
                afterFunc();
                break;
            case "3":
                System.out.println("Number of Nodes : " + tree.numofElements);
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "4":
                System.out.println("Height of Tree : " + tree.calculateHeight(tree.rootNode));
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "5":
                System.out.println("Number of Leaves : " + tree.countLeafNodesRecursively());
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "6":
                System.out.println("Minimum number of tree : " + tree.minNode().key);
                System.out.println("Maximum number of tree : " + tree.maxNode().key);
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "7":
                System.out.println("Is Tree complete ? : " + tree.isCompleteBT(tree.rootNode));
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "8":
                System.out.println("your input TREE and current tree are equal : " + compareTrees());
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "9":
                try {
                    System.out.println("Input your NUMBER :");
                    String in9 = sc.nextLine();
                    System.out.println("Input node existed ? : " + tree.findNodePP(Integer.parseInt(in9)));
                    System.out.println();
                    System.out.println("press Enter to continue...");
                    sc.nextLine();
                } catch (Exception exception) {
                    System.out.println("Enter integer value.");
                }
                break;
            case "10":
                System.out.println("" +
                        "1.In-Order Traversal\n" +
                        "2.Pre-Order Traversal\n" +
                        "3.Post-Order Traversal\n" +
                        "4.Level-Order Traversal\n");
                String in10 = sc.nextLine();
                treeTraversal(in10);
                break;
            case "11":
                System.out.println("Are you sure about delete tree ? \n1.Yes\n2.No");
                String in11 = sc.nextLine();
                if (in11.charAt(0) == 'y' || in11.charAt(0) == '1' || in11.charAt(0) == 'Y')
                    tree.deleteAllNodes();
                else
                    System.out.println("Delete Canceled...");
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "12":
                Credits.credits();
                System.out.println();
                System.out.println("press Enter to continue...");
                sc.nextLine();
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("choose right option...");
                break;
        }
    }

    public static void treeTraversal(String input) throws Exception {
        switch (input) {
            case "1":
                tree.display("inOrder");
                break;
            case "2":
                tree.display("preOrder");
                break;
            case "3":
                tree.display("postOrder");
                break;
            case "4":
                tree.display("levelOrder");
                break;
            default:
                System.out.println("Choose correct option...");
                break;
        }
    }

    public static void printTree() throws Exception {
        if (tree.numofElements == 0) {
            return;
        }
        tree.display("inOrder");
        tree.display("preOrder");
        tree.display("postOrder");
        tree.display("levelOrder");
    }

    public static void afterFunc() throws Exception {
        System.out.println();
        printTree();
        System.out.println();
        System.out.println("press Enter to continue...");
        sc.nextLine();
    }

    public static boolean compareTrees() throws Exception {
        System.out.println("Input your tree Numbers : ");
        String inp = sc.nextLine();
        String[] newTree = inp.split("\\s+");
        boolean flag = true;
        for (String s : newTree) {
            int number = Integer.parseInt(s);
            Node newNode = new Node(number);
            if (flag) {
                tempTree.rootNode = newNode;
                tempTree.numofElements++;
                flag = false;
            } else {
                Node temp = tempTree.rootNode;
                while (temp != null) {
                    if (temp.key < number) {
                        if (temp.rightNode == null) {
                            temp.rightNode = newNode;
                            newNode.parentNode = temp;
                            tempTree.numofElements++;
                            break;
                        } else {
                            temp = temp.rightNode;
                            continue;
                        }
                    }
                    if (temp.key > number) {
                        if (temp.leftNode == null) {
                            temp.leftNode = newNode;
                            newNode.parentNode = temp;
                            tempTree.numofElements++;
                            break;
                        } else {
                            temp = temp.leftNode;
                        }
                    }
                }
            }
        }
        Compare cp = new Compare();
        String TTIO = cp.inOrderDisplay(tempTree.rootNode);
        String TTPO = cp.preOrderDisplay(tempTree.rootNode);
        cp.preOrder = "";
        cp.inOrder = "";
        String TIO = cp.inOrderDisplay(tree.rootNode);
        String TPO = cp.preOrderDisplay(tree.rootNode);
        tempTree.deleteAllNodesTMP();
        return Objects.equals(TIO, TTIO) && Objects.equals(TTPO, TPO);
    }
}