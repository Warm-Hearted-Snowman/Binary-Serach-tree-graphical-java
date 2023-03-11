import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MenuController implements Initializable {
    static BinarySearchTree tree = new BinarySearchTree();

    static BinarySearchTree tempTree = new BinarySearchTree();

    static String inOrder = "";
    static String preOrder = "";
    static String postOrder = "";
    static String levelOrder = "";

    public List<Node> changed_nodes = new LinkedList<>();

    @FXML
    public Button addNumber;
    @FXML
    public Button NodeNumber;
    @FXML
    public Button TreeHeight;
    @FXML
    public Button LeavesNumber;
    @FXML
    public Button MinElement;
    @FXML
    public Button MaxElement;
    @FXML
    public Button CompleteTree;
    @FXML
    public Button CompareTree;
    @FXML
    public Button DeleteTree;
    @FXML
    public Button LOTraversal;
    @FXML
    public Button IOTraversal;
    @FXML
    public Button PreOTraversal;
    @FXML
    public Button FindNode;
    @FXML
    public Button PostOTraversal;
    @FXML
    public Button RemoveNumber;
    @FXML
    public Label ShowData;
    @FXML
    public TextField InputData;
    @FXML
    public StackPane stackPane;

    public Label[] labelOrder = new Label[31];
    @FXML
    public Label l1;
    @FXML
    public Label l2;
    @FXML
    public Label l3;
    @FXML
    public Label l4;
    @FXML
    public Label l5;
    @FXML
    public Label l6;
    @FXML
    public Label l7;
    @FXML
    public Label l8;
    @FXML
    public Label l9;
    @FXML
    public Label l10;
    @FXML
    public Label l11;
    @FXML
    public Label l12;
    @FXML
    public Label l13;
    @FXML
    public Label l14;
    @FXML
    public Label l15;
    @FXML
    public Label l16;
    @FXML
    public Label l17;
    @FXML
    public Label l18;
    @FXML
    public Label l19;
    @FXML
    public Label l20;
    @FXML
    public Label l21;
    @FXML
    public Label l22;
    @FXML
    public Label l23;
    @FXML
    public Label l24;
    @FXML
    public Label l25;
    @FXML
    public Label l26;
    @FXML
    public Label l27;
    @FXML
    public Label l28;
    @FXML
    public Label l29;
    @FXML
    public Label l30;
    @FXML
    public Label l31;

    @FXML
    public Circle c1;
    @FXML
    public Circle c2;
    @FXML
    public Circle c3;
    @FXML
    public Circle c4;
    @FXML
    public Circle c5;
    @FXML
    public Circle c6;
    @FXML
    public Circle c7;
    @FXML
    public Circle c8;
    @FXML
    public Circle c9;
    @FXML
    public Circle c10;
    @FXML
    public Circle c11;
    @FXML
    public Circle c12;
    @FXML
    public Circle c13;
    @FXML
    public Circle c14;
    @FXML
    public Circle c15;
    @FXML
    public Circle c16;
    @FXML
    public Circle c17;
    @FXML
    public Circle c18;
    @FXML
    public Circle c19;
    @FXML
    public Circle c20;
    @FXML
    public Circle c21;
    @FXML
    public Circle c22;
    @FXML
    public Circle c23;
    @FXML
    public Circle c24;
    @FXML
    public Circle c25;
    @FXML
    public Circle c26;
    @FXML
    public Circle c27;
    @FXML
    public Circle c28;
    @FXML
    public Circle c29;
    @FXML
    public Circle c30;
    @FXML
    public Circle c31;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Line line13;
    @FXML
    public Line line12;
    @FXML
    public Line line37;
    @FXML
    public Line line25;
    @FXML
    public Line line24;
    @FXML
    public Line line36;
    @FXML
    public Line line715;
    @FXML
    public Line line613;
    @FXML
    public Line line511;
    @FXML
    public Line line49;
    @FXML
    public Line line510;
    @FXML
    public Line line714;
    @FXML
    public Line line612;
    @FXML
    public Line line48;
    @FXML
    public Line line817;
    @FXML
    public Line line919;
    @FXML
    public Line line1021;
    @FXML
    public Line line1123;
    @FXML
    public Line line1225;
    @FXML
    public Line line1327;
    @FXML
    public Line line1429;
    @FXML
    public Line line1531;
    @FXML
    public Line line1530;
    @FXML
    public Line line1428;
    @FXML
    public Line line1326;
    @FXML
    public Line line1224;
    @FXML
    public Line line1122;
    @FXML
    public Line line1020;
    @FXML
    public Line line918;
    @FXML
    public Line line816;

    public static Color background_color = Color.valueOf("#04121e");
    public List<Node> all_nodes = new ArrayList<>();
    public List<String> all_lines = new ArrayList<>();
    public List<String> all_lables = new ArrayList<>();

    public void handleExit(ActionEvent e) throws IOException {
        ((Stage) stackPane.getScene().getWindow()).close();
    }

    public void handleAdd(ActionEvent e) {
        if (!changed_nodes.isEmpty()) {
            for (Node node : changed_nodes
            ) {
                change_color_add_node(String.valueOf(node.orderNum));
            }
        }
        try {
            if (InputData.getText().contains(" ")) {
                String inp = InputData.getText();
                String[] newTree = inp.split("\\s+");
                for (String s : newTree) {
                    add_graphical(Integer.parseInt(s));
                }
                ShowData.setText(inp + " ...added.");
            } else {
                add_graphical(Integer.parseInt(InputData.getText()));
            }
            InputData.clear();
            InputData.requestFocus();
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
            InputData.clear();
            InputData.requestFocus();
            System.out.println("ADD_FUNC : " + exception.getMessage());
        }

    }

    public void handleRemove(ActionEvent e) {
        try {
            delete_graphical(Integer.parseInt(InputData.getText()));
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void delete_graphical(int value) {
        tree.delete(value);
        AltFuncs.levelOrderDisplay(tree.rootNode);
        tree.deleteAllNodes();
        tree.numofElements = 0;
        clear_tree();
        draw_tree();
        levelOrder = "";
        InputData.clear();
    }

    public void draw_tree() {
        String[] newTree = levelOrder.split("\\s+");
        for (String s : newTree) {
            add_graphical(Integer.parseInt(s));
        }
    }

    public void clear_tree() {
        for (String label : all_lables
        ) {
            change_label_delete(label);
        }
        for (String line : all_lines
        ) {
            change_line_color_delete(line);
        }
        for (Node node : all_nodes
        ) {
            change_color_delete_node(String.valueOf(node.orderNum));
        }
    }

    public void handleNodeNum(ActionEvent e) {
        try {
            ShowData.setText("Number of Nodes : " + tree.numofElements);
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleTreeHeight(ActionEvent e) {
        try {
            ShowData.setText("Height of Tree : " + tree.calculateHeight(tree.rootNode));
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleLeavesNum(ActionEvent e) {
        try {
            ShowData.setText("Number of Leaves : " + tree.countLeafNodesRecursively());
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleMinVal(ActionEvent e) {
        try {
            ShowData.setText("Minimum number of tree : " + tree.minNode().key);
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleMaxVal(ActionEvent e) {
        try {
            ShowData.setText("Maximum number of tree : " + tree.maxNode().key);
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleIsComplete(ActionEvent e) {
        try {
            ShowData.setText("Is Tree complete ? : " + tree.isCompleteBT(tree.rootNode));
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleCompareTrees(ActionEvent e) {
        try {
            String inp = InputData.getText();
            String[] newTree = inp.split("\\s+");
            boolean flag = true;
            for (String s : newTree) {
                int number = Integer.parseInt(s);
                Node newNode = new Node(number);
                if (flag) {
                    tempTree.rootNode = newNode;
                    flag = false;
                } else {
                    Node temp = tempTree.rootNode;
                    while (temp != null) {
                        if (temp.key < number) {
                            if (temp.rightNode == null) {
                                temp.rightNode = newNode;
                                newNode.parentNode = temp;
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
            boolean result = Objects.equals(TIO, TTIO) && Objects.equals(TTPO, TPO);
            ShowData.setText("your input TREE and current tree are equal : " + result);
            InputData.clear();
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleFindNode(ActionEvent e) {
        try {
            List<Object> find_res = tree.findNodeG(Integer.parseInt(InputData.getText()));
            changed_nodes.add((Node) find_res.get(0));
            boolean res = (boolean) find_res.get(1);
            int ord = (int) find_res.get(2);
            ShowData.setText("Input node existed ? : " + res);
            change_color_find_node(String.valueOf(ord));
        } catch (Exception ignored) {
            ShowData.setText("Input node existed ? : false");
        }
    }

    public void handleLevelOrderTraversal(ActionEvent e) {
        try {
            AltFuncs.levelOrderDisplay(tree.rootNode);
            ShowData.setText("Level-Order traversal : " + levelOrder);
            levelOrder = "";
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handlePreOrderTraversal(ActionEvent e) {
        try {
            AltFuncs.preOrderDisplay(tree.rootNode);
            ShowData.setText("Pre-Order traversal : " + preOrder);
            preOrder = "";
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleInOrderTraversal(ActionEvent e) {
        try {
            AltFuncs.inOrderDisplay(tree.rootNode);
            ShowData.setText("In-Order traversal : " + inOrder);
            inOrder = "";
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handlePostOrderTraversal(ActionEvent e) {
        try {
            AltFuncs.postOrderDisplay(tree.rootNode);
            ShowData.setText("Post-Order traversal : " + postOrder);
            postOrder = "";
        } catch (Exception exception) {
            AlertMaker.showErrorMessage("Invalid Value", "Enter available Integer value.");
        }
    }

    public void handleDeleteTree(ActionEvent e) {
        tree.deleteAllNodes();
        tree.numofElements = 0;
        MenuController.levelOrder = MenuController.inOrder = MenuController.postOrder = MenuController.preOrder = "";
        clear_tree();
        AlertMaker.showSuccessMessage("success", "Tree deleted successfully.");
    }

    public void change_color_add_node(String circleId) {
        Circle circle = (Circle) stackPane.lookup("#c" + circleId);
        circle.setFill(Color.valueOf("#EF5B0C"));
    }

    public void change_color_delete_node(String circleId) {
        Circle circle = (Circle) stackPane.lookup("#c" + circleId);
        circle.setFill(background_color);
    }

    public void change_color_find_node(String circleId) {
        Circle circle = (Circle) stackPane.lookup("#c" + circleId);
        circle.setFill(Color.GREEN);
    }

    public void change_label_add(String label_id, String label_text) {
        Label label = (Label) stackPane.lookup("#l" + label_id);
        label.setText(label_text);
    }

    public void change_label_delete(String label_id) {
        Label label = (Label) stackPane.lookup("#l" + label_id);
        label.setText("");
    }

    public void change_line_color_add(String line_name) {
        try {
            Line line = (Line) stackPane.lookup("#line" + line_name);
            line.setStroke(Paint.valueOf("#ffff8d"));
        } catch (Exception ignored) {
            ;
        }
    }

    public void change_line_color_delete(String line_name) {
        try {
            Line line = (Line) stackPane.lookup("#line" + line_name);
            line.setStroke(background_color);
        } catch (Exception ignored) {
            ;
        }
    }

    public void add_graphical(int number) {
        try {
            Node node = tree.addG(number);
            String node_order = String.valueOf(node.orderNum);
            change_color_add_node(node_order);
            change_label_add(node_order, String.valueOf(number));
            all_nodes.add(node);
            all_lables.add(node_order);
            String line = String.valueOf(node.parentNode.orderNum) + node.orderNum;
            change_line_color_add(line);
            all_lines.add(line);
        } catch (Exception e) {
            System.out.println("ADD_G_FUNC : " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

class AltFuncs {
    public static Node inOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplay(root.leftNode);
        MenuController.inOrder += (root.key + " ");
        inOrderDisplay(root.rightNode);
        return root;
    }

    public static Node inOrderDisplayFPost(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplayFPost(root.leftNode);
        MenuController.postOrder += (root.key + " ");
        inOrderDisplayFPost(root.rightNode);
        return root;
    }

    public static Node inOrderDisplayFPre(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplayFPre(root.leftNode);
        MenuController.preOrder += (root.key + " ");
        inOrderDisplayFPre(root.rightNode);
        return root;
    }


    //function for PreOrder Traversal of the Tree.
    public static Node preOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        MenuController.preOrder += (root.key + " ");
        inOrderDisplayFPre(root.leftNode);
        inOrderDisplayFPre(root.rightNode);
        return root;
    }

    //function for PostOrder Traversal of the Tree.
    public static Node postOrderDisplay(Node root) {
        if (root == null) {
            return null;
        }
        inOrderDisplayFPost(root.leftNode);
        inOrderDisplayFPost(root.rightNode);
        MenuController.postOrder += (root.key + " ");
        return root;
    }

    //function for Level-Order Traversal of the Tree.
    public static Node levelOrderDisplay(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            MenuController.levelOrder += (temp.key + " ");
            if (temp.leftNode != null) {
                queue.add(temp.leftNode);
            }
            if (temp.rightNode != null) {
                queue.add(temp.rightNode);
            }
        }
        return root;
    }
}
