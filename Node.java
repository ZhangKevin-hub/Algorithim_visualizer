import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Node extends JButton{
    Node parent;
    int col;
    int row;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;

    public Node(int col, int row){
        this.col = col;
        this.row = row;
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false);
        setBackground(Color.white);
        setForeground(Color.black);
    }
    public void setAsStartNode(){
        setBackground(Color.green);
        setForeground(Color.white);
        setText("Start");
        start = true;
    }
    public void setAsGoalNode(){
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("Goal");
        goal = true;
    }
    public void setAsSolidNode(){
        setBackground(Color.black);
        setForeground(Color.white);
        solid = true;
    }
    public void setAsOpenNode(){
        open = true;
    }
    public void setAsCheckedNode(){
        if(start == false && goal == false){
            setBackground(Color.orange);
            setForeground(Color.black);
        }
        checked = true;
    }
    public void setAsPathNode(){
        setBackground(Color.gray);
        setForeground(Color.black);
    }
}
