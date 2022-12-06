import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Node extends JButton implements ActionListener{
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
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.orange);
    }

}
