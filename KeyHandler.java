import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    DemoPanel dp;
    public KeyHandler(DemoPanel dp){
        this.dp = dp;
    }
    @Override
    public void keyTyped(KeyEvent e) {        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_ESCAPE){
           try {
            dp.autosearch();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {        
    }
    
}
