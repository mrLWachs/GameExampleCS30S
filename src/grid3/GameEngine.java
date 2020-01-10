
/** required package class namespace */
package grid3;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import tools.Dialogs;

 
/**
 * GameEngine.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 2:50:33 p.m.
 */
public class GameEngine 
{
    
    private JPanel panel;
    private JList<String> list;
    private JScrollPane scroll;
    private SnakeUI snakeUI;
    
    private SnakeLogic logic;

    
    public GameEngine(JPanel panel, JList<String> list, 
            JScrollPane scroll, SnakeUI snakeUI) {         
        this.panel   = panel;
        this.list    = list;
        this.scroll  = scroll;
        this.snakeUI = snakeUI;
        setFrame();
        logic = new SnakeLogic(panel,this);
        snakeUI.setVisible(true);
    }

    private void setFrame() {
        snakeUI.setTitle(Globals.TITLE);
        snakeUI.setResizable(false);
        snakeUI.setSize(Globals.FRAME_WIDTH, Globals.FRAME_HEIGHT);
        snakeUI.setLocationRelativeTo(null);
        snakeUI.getContentPane().setBackground(Globals.LIGHT_GREEN);
        snakeUI.setBackground(Globals.LIGHT_GREEN);
    }

    public void keyPress(KeyEvent event) {
        logic.keyPress(event);
    }

    public void mouseClicked(MouseEvent event) {
        
        if (event.getClickCount() == 2) {
            Dialogs.yesNo("Do you want to delete...");
        }
    }
    
}
