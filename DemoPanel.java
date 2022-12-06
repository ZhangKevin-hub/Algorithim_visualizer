import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class DemoPanel extends JPanel {
    
    //SCREEN SETTINGS
    final int maxCol = 15;
    final int maxRow = 10;
    final int nodeSize = 30;
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;

    //NODE 
    Node[][] node = new Node[maxCol][maxRow];

    public DemoPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));

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
    }
}
