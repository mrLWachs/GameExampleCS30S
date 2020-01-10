
/** required package class namespace */
package grid2;

/** required imports */
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tools.Numbers;

 
/**
 * GameEngine.java - this class runs all the logic for this "game". It received
 * references from the other class to modify those objects from this class. 
 * This isn't a "game" example exactly, but I did try to use code to create a 
 * large grid and incorporate mouse events into the grid to show how you can 
 * use code to create the entire grid and then add action events to all the
 * objects in the matrix.
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 1:24:55 p.m.
 */
class GameEngine 
{
    
    // GLOBAL VARIABLES
    // ================
        
    private JLabel[][] matrix;          // the 2D array of JLabel objects
    private Color color;                // the color used when "drawing"
    private final int WIDTH  = 6;
    private final int HEIGHT = WIDTH;   // the set sizes of the labels
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param panel the panel to draw labels inside of
     * @param userInterface the user interface frame 
     */
    public GameEngine(JPanel panel, UserInterface userInterface) {        
        setFrame(userInterface,panel);          // set up the frame properties
        setGrid(panel);                         // create a JLabel grid (matrix)
        color = new Color(Numbers.random(0, 255),
                          Numbers.random(0, 255),
                          Numbers.random(0, 255));  // start a random color
        userInterface.setVisible(true);             // make interface visible
    }
    
    /**
     * Sets the frame user interface properties
     * 
     * @param userInterface the user interface frame 
     * @param panel the panel to draw labels inside of
     */
    private void setFrame(UserInterface userInterface, JPanel panel) {
        // get the size of the panel to draw inside of, and adjust the frame 
        // size to match that with a few pixels as a buffer
        int frameWidth  = panel.getWidth()  + 40;
        int frameHeight = panel.getHeight() + 60;
        // set the frame look and feel
        userInterface.setSize(frameWidth, frameHeight);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
    }
          
    /**
     * Initialize all objects in the solution
     */
    private void setGrid(JPanel panel) {        
        // calculate how many rows and columns we can draw of that size
        int rows   = panel.getHeight() / HEIGHT;
        int colums = panel.getWidth()  / WIDTH;
        // instantiate the matrix
        matrix = new JLabel[rows][colums];
        // now loop through and build all the labels
        int y = 0;
        // traverse all the rows
        for (int row = 0; row < matrix.length; row++) {
            int x = 0;
            // traverse all the columns
            for (int column = 0; column < matrix[row].length; column++) {
                createLabel(matrix, row, column, x, y, WIDTH, HEIGHT, panel);
                // move x location past this label
                x += WIDTH;
            }
            // move y location past this row for the next row
            y += HEIGHT;
        }        
    }

    /**
     * Creates a label object at this location in the matrix on the panel
     * of the passed size
     * 
     * @param matrix the matrix to add the label to
     * @param row the row in the matrix for the label
     * @param column the column in the matrix for the label
     * @param x the x coordinate to draw the label in the panel
     * @param y the y coordinate to draw the label in the panel
     * @param width the width to draw the label to
     * @param height the height to draw the label to 
     * @param panel the panel to draw labels inside of
     */
    private void createLabel(JLabel[][] matrix, int row, int column, 
                             int x, int y, int width, 
                             int height, JPanel panel) {
        matrix[row][column] = new JLabel();             // create label
        panel.add(matrix[row][column]);                 // add label to panel
        matrix[row][column].setOpaque(true);            // make color fillable
        matrix[row][column].setBackground(Color.white); // starting color
        matrix[row][column].addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                mouseClick();                           // mouse click event
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) { 
                mouseMove(row,column);                  // mouse moves over
            }
            public void mouseExited(MouseEvent e) { }
        });
        matrix[row][column].setBounds(x, y, width, height); // position label
    }

    /**
     * Create a new random color when the user clicks on a spot of the grid
     */
    private void mouseClick() {
        color = new Color(Numbers.random(0, 255),
                          Numbers.random(0, 255),
                          Numbers.random(0, 255));
    }
    
    /**
     * When the mouse moves over a grid location, that location fills with the
     * current random color
     * 
     * @param row the row the mouse is passing over
     * @param column the column the mouse is passing over
     */
    private void mouseMove(int row, int column) {
        matrix[row][column].setBackground(color);
    }

}
