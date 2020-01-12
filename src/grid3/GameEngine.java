
/** required package class namespace */
package grid3;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import tools.Dialogs;
import tools.FileHandler;

 
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
    
    public JLabel scoreLabel;
    public SnakeUI snakeUI;
    
    private DefaultListModel model;
    private SnakeLogic logic;
    private FileHandler file;

    
    public GameEngine(JPanel panel, JList<String> list, 
            JScrollPane scroll, JLabel scoreLabel, SnakeUI snakeUI) {         
        this.panel      = panel;
        this.list       = list;
        this.scroll     = scroll;
        this.scoreLabel = scoreLabel;
        this.snakeUI    = snakeUI;
        model           = new DefaultListModel();
        file            = new FileHandler(Globals.DATA_FILE);
        list.setModel(model);
        list.setFocusable(false);
        panel.requestFocus();
        getScores();
        setFrame();
        logic = new SnakeLogic(panel, this);
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
            int index = list.getSelectedIndex();
            String text = list.getSelectedValue();
            int start  = text.indexOf(" ") + 1;
            text = text.substring(start);
            if (Dialogs.yesNo("Are you sure you want to delete " + text)) {
                model.remove(index);
            }
        }
    }

    public void add(String score) {
        model.addElement(score);
        int length = list.getModel().getSize() - 1;
        list.ensureIndexIsVisible(length);
        list.clearSelection();
    }

    private void getScores() {        
        String[] scores = file.read();
        if (scores == null) return;
        for (int i = 0; i < scores.length; i++) {
            add(scores[i]);
        }
    }

    public void saveScores() {
        int length = list.getModel().getSize();
        String[] scores = new String[length];
        for (int i = 0; i < length; i++) {
            list.setSelectedIndex(i);
            String text = list.getSelectedValue();
            scores[i] = text;
        }        
        file.write(scores);
    }
    
}
