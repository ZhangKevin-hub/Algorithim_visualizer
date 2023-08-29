import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;

public class DemoPanel extends JPanel {
    
    //SCREEN SETTINGS
    final int maxCol = 15;
    final int maxRow = 10;
    final int nodeSize = 100; //pixel
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;

    //NODES
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode;
    Node goalNode;
    Node currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();
    
    boolean goalReached = false;
    int step = 0;

    public DemoPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

        //Placing nodes
        int col = 0;
        int row = 0;
        while(col < maxCol && row < maxRow){
            node[col][row] = new Node(col, row);
            this.add(node[col][row]);

            col++;
            if(col == maxCol){
                col = 0;
                row++;
            }
        }
        //Set Start and Goal Node
        // Make A PreScreen(another Jpanel that transitions to this?) 
        //asking where start Node and goal Node should be located
        // Have prescreen contain input that gathers Solid node locations as arrays?List
        // Perform ForEach element in array(i+=2) make a startnode with i values
        // Make sure it doesn't have repeating dual values! perhaps contain it as List<Array(of two)<Integer>> or HashMap<Integer,Array<Integer>>
        setStartNode(4, 6);
        setAsGoalNode(11, 6);
        setSolidNode(5, 3);
        setSolidNode(5, 4);
        setSolidNode(5, 5);
        setSolidNode(5, 6);
        setSolidNode(5, 7);
        setSolidNode(5, 8);
        setSolidNode(5, 9);


        //Set Cost Node
        setCostOnNode();
    }
    private void setStartNode(int col, int row){
        node[col][row].setAsStartNode();
        startNode = node[col][row];
        currentNode = startNode;
    }
    private void setAsGoalNode(int col, int row){
        node[col][row].setAsGoalNode();
        goalNode = node[col][row];
    }
    private void setSolidNode(int col, int row){
        node[col][row].setAsSolidNode();
    }
    private void setCostOnNode(){
        int col = 0;
        int row = 0;
        while(col < maxCol && row < maxRow){
            getCost(node[col][row]);
            col++;
            if(col == maxCol){
                col = 0;
                row++;
            }
        }
    }
    private void getCost(Node node){
        //G Cost Start Cost
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;
        //H Cost Goal Cost
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;
        //F Cost Total Cost
        node.fCost = node.gCost + node.hCost;
        //Display Cost
        if(node != startNode && node != goalNode){
            node.setText("<html>F:" + node.fCost + "<br> G:" + node.gCost + "<br> H:" + node.hCost+"</html");
        }
    }
    public void autosearch() throws InterruptedException{
        if(goalReached == false && step < 400){
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsCheckedNode();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            // OPEN Node
            if(row - 1 >= 0){
                openNode(node[col][row-1]);
            }
            if(col - 1 >= 0){
                openNode(node[col-1][row]);
            }
            if(row + 1 < maxRow){
                openNode(node[col][row+1]);
            }
            if(col + 1 < maxCol){
                openNode(node[col+1][row]);
            }
            //Find best node
            int bestNodeIndex = 0;
            int bestNodefCost = 999;
            for(int i = 0; i<openList.size(); i++){
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }
                //If fCost is equal
                else if(openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                    if(openList.get(i).hCost < openList.get(bestNodeIndex).hCost){
                        bestNodeIndex = i;
                    }
                }
            }
            //Best Node should now be obtained.
            currentNode = openList.get(bestNodeIndex);
            if(currentNode == goalNode){
                goalReached = true;
                trackThePath();
            }
            step ++;
        }
    }
    
    private void openNode(Node node){
        if(node.open == false && node.checked == false && node.solid == false){
            node.setAsOpenNode();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void trackThePath(){
        //Back track and color in Pathing Nodes!
        Node current = goalNode;
        while(current != startNode){
            current = current.parent;
            if(current != startNode){
                current.setAsPathNode();
            }
        }
    }
}
