import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        //Set Start and Goal Node
        // Make A PreScreen(another Jpanel that transitions to this?) 
        //asking where start Node and goal Node should be located
        // Have prescreen contain input that gathers Solid node locations as arrays?List
        // Perform ForEach element in array(i+=2) make a startnode with i values
        // Make sure it doesn't have repeating dual values! perhaps contain it as List<Array(of two)<Integer>> or HashMap<Integer,Array<Integer>>
        
        //Setting Frame
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(new DemoPanel());
        window.pack();
         
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
}
