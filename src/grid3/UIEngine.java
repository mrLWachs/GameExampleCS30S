
/** required package class namespace */
package grid3;

/** required imports */
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tools.Dialogs;
import tools.FileHandler;

 
/**
 * GameEngine.java - the logic engine that runs the main logic of the snake 
 * game user interface
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 2:50:33 p.m.
 */
public class UIEngine 
{
    
    private JPanel           panel; // the UI panel to draw the game inside of
    private JList<String>    list;  // the UI list of high scores
    private DefaultListModel model; // the model for changing the UI list    
    private SnakeLogic       logic; // the game logic engine
    private FileHandler      file;  // the file handler class 
    
    public JLabel scoreLabel;       // the label the score shows on the UI
    public SnakeUI snakeUI;         // the user interface for the application
    
    
    /**
     * Constructor, sets class properties
     * 
     * @param panel the UI panel to draw the game inside of
     * @param list the UI list of high scores
     * @param scoreLabel the label the score shows on the UI
     * @param snakeUI the user interface for the application
     */
    public UIEngine(JPanel panel, JList<String> list, 
            JLabel scoreLabel, SnakeUI snakeUI) {         
        this.panel      = panel;            // associate paraemts with globa
        this.list       = list;             // class properties
        this.scoreLabel = scoreLabel;
        this.snakeUI    = snakeUI;
        model           = new DefaultListModel();   // instantiate model
        file            = new FileHandler(Globals.DATA_FILE);   // instantiate 
        list.setModel(model);                       // set to the model
        list.setFocusable(false);                   // make not focusable
        panel.requestFocus();                       // set focus to panel
        getScores();                                // get scores from file
        setFrame();                                 // set frame look and feel
        logic = new SnakeLogic(panel, this);        // build game logic
        snakeUI.setVisible(true);                   // make UI visible
    }

    /**
     * Sets the look and feel of the main user interface for the application
     */
    private void setFrame() {
        snakeUI.setTitle(Globals.TITLE);
        snakeUI.setResizable(false);
        snakeUI.setSize(Globals.FRAME_WIDTH, Globals.FRAME_HEIGHT);
        snakeUI.setLocationRelativeTo(null);
        snakeUI.getContentPane().setBackground(Globals.LIGHT_GREEN);
        snakeUI.setBackground(Globals.LIGHT_GREEN);
    }

    /**
     * User has pressed a key on the user interface, pass the data on to the 
     * game logic engine
     * 
     * @param event the user's specific keyboard event
     */
    public void keyPress(KeyEvent event) {
        logic.keyPress(event);
    }

    /**
     * The mouse click event for the list to ask to remove a score from the list
     * 
     * @param event the mouse event from the user
     */
    public void mouseClicked(MouseEvent event) {        
        if (event.getClickCount() == 2) {           // user has double clicked
            int index = list.getSelectedIndex();    // get the index clicked on
            String text = list.getSelectedValue();  // get the score from list
            int start  = text.indexOf(" ") + 1;     // get start of name
            text = text.substring(start);           // concatinate out the name
            if (Dialogs.yesNo("Are you sure you want to delete " + text)) {
                model.remove(index);                // remove from list
            }
        }
    }

    /**
     * Adds a score to the UI list and drops the list to the bottom
     * 
     * @param score the score to add
     */
    public void add(String score) {
        model.addElement(score);                        // add to list
        int length = list.getModel().getSize() - 1;     // get list size
        list.ensureIndexIsVisible(length);              // move to last index
        list.clearSelection();                          // clear any selections
    }

    /**
     * Gets the high scores from the data file and populates the UI list
     */
    private void getScores() {        
        String[] scores = file.read();              // read array from file
        if (scores == null) return;                 // some scores in file
        for (int i = 0; i < scores.length; i++) {   // traverse array
            add(scores[i]);                         // add to UI list
        }
    }

    /**
     * Save the list of scores from the user interface to a permanent file
     */
    public void saveScores() {
        int length = list.getModel().getSize();     // get size of UI list
        String[] scores = new String[length];       // create array of same size
        for (int i = 0; i < length; i++) {          // traverse array
            list.setSelectedIndex(i);               // select item in list
            String text = list.getSelectedValue();  // get value from list
            scores[i] = text;                       // add into array
        }        
        file.write(scores);                         // write array to data file
    }
    
}
