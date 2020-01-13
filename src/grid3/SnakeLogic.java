
/** required package class namespace */
package grid3;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import tools.Dialogs;
import tools.Numbers;

 
/**
 * SnakeLogic.java - the logic engine for the snake game 
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 3:38:58 p.m.
 */
public class SnakeLogic 
{

    private UIEngine   engine;          // the logic engine for the UI
    private JLabel[][] grid;            // a matrix of labels for the game
    private Location[] snake;           // an array for all the snake parts
    private Location   powerUp;         // location of the power up
    private int        maxRows;         // the total number of rows and columns 
    private int        maxColumns;      // able to be drawn in the panel
    private Timer      timer;           // game timer
    private int        length;          // length of the snake parts
    private int        score;           // score of power ups eaten
        
    /**
     * Constructor, sets class properties
     * 
     * @param panel the UI panel to draw the game inside of
     * @param engine the user interface logic engine
     */
    public SnakeLogic(JPanel panel, UIEngine engine) {
        this.engine = engine;           // connect parameter to property
        Dialogs.title = Globals.TITLE;  // set dialog title
        timer = new Timer(Globals.TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                action();               // timer action
            }
        });
        setGrid(panel);                 // set up the panel for snake
        newGame();                      // set up a new game
    }

    /**
     * Set the properties for a new game, but do not start the timer
     */
    private void newGame() {
        timer.stop();               // stop timer if running
        setSnake();                 // set up the snake 
        newPowerUp();               // create new power up
        redraw();                   // draw the screen
        score = 0;                  // reset score
        engine.scoreLabel.setText("Current Score: " + score);   // show score
    }
        
    /**
     * When a key is pressed, move the snake head's direction
     * 
     * @param event this keys event
     */
    public void keyPress(KeyEvent event) {
        if (!timer.isRunning()) timer.start();      
        if (event.getKeyCode() == KeyEvent.VK_UP)    
            snake[Globals.HEAD].direction = Globals.UP;
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)  
            snake[Globals.HEAD].direction = Globals.DOWN;
        else if (event.getKeyCode() == KeyEvent.VK_LEFT)  
            snake[Globals.HEAD].direction = Globals.LEFT;
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
            snake[Globals.HEAD].direction = Globals.RIGHT;
    }

    /**
     * Set up the grid for the game of snake in the UI panel area
     * 
     * @param panel the UI panel to draw the game inside of
     */
    private void setGrid(JPanel panel) {
        maxRows    = panel.getHeight() / Globals.SQUARE_SIZE;   // calculate 
        maxColumns = panel.getWidth()  / Globals.SQUARE_SIZE;   // sizes
        grid = new JLabel[maxRows][maxColumns];                 // create matrix
        int y = (panel.getHeight() - (maxRows * Globals.SQUARE_SIZE)) / 2;
        for (int row = 0; row < maxRows; row++) {               // traverse rows
            int x = (panel.getWidth() - (maxColumns * Globals.SQUARE_SIZE)) / 2;
            for (int column = 0; column < maxColumns; column++) {   
                createSquare(x,y,row,column,panel);             // create square
                x += Globals.SQUARE_SIZE;                       // advance x
            }
            y += Globals.SQUARE_SIZE;                           // advance y
        } 
    }

    /** 
     * Ends the current game 
     */
    private void gameOver() {
        timer.stop();                       // stop the timer
        String name = Dialogs.input("Game Over!\n\nEnter your name");
        engine.add(score + " " + name);     // add entered score to UI list
        newGame();                          // set up a new game
    }
    
    /**
     * Creates each individual square on the grid
     * 
     * @param x the x coordinate of the square
     * @param y the y coordinate of the square
     * @param row this squares row
     * @param column this squares column
     */
    private void createSquare(int x, int y, int row, int column, JPanel panel) {
        grid[row][column] = new JLabel();
        grid[row][column].setOpaque(true);
        grid[row][column].setBackground(Globals.SQUARE_COLOR);
        grid[row][column].setBorder(Globals.SQUARE_BORDER);
        panel.add(grid[row][column]);
        grid[row][column].setBounds(x,y,Globals.SQUARE_SIZE,Globals.SQUARE_SIZE);
    }
    
    /** 
     * Sets up the snake at the start of the game 
     */
    private void setSnake() {
        length = 1;                                 // starting length
        snake = new Location[maxRows*maxColumns];   // create array
        for (int i = 0; i < snake.length; i++) {    // traerse array
            snake[i] = new Location(Globals.BLANK,Globals.BLANK,Globals.STOP);
        }
        int startRow        = maxRows    / 2;       // center snake head 
        int startColumn     = maxColumns / 2;
        snake[Globals.HEAD] = new Location(startRow,startColumn,Globals.STOP);
    }

    /** 
     * The timers action for each cycle 
     */
    private void action() {
        moveSnake();
        if (hasEatenPowerUp() == false) checkForCollisionWithSelf();
        if (hasHitBoundry()   == false) redraw();
    }
    
    /** 
     * Redraw the game grid for this time cycle 
     */
    private void redraw() {
        for (int row = 0; row < maxRows; row++) {
            for (int column = 0; column < maxColumns; column++) {
                grid[row][column].setBackground(Globals.SQUARE_COLOR);
            }
        }
        grid[snake[Globals.HEAD].row][snake[Globals.HEAD].column].setBackground(
                Globals.SNAKE_HEAD_COLOR);
        for (int i = 1; i < length; i++) {
            grid[snake[i].row][snake[i].column].setBackground(Globals.SNAKE_BODY_COLOR);
        }
        grid[powerUp.row][powerUp.column].setBackground(Globals.POWER_UP_COLOR);
    }
        
    /** 
     * Moves all the snake positions for this time cycle 
     */
    private void moveSnake() {        
        for (int i = length; i > 0; i--) {
            snake[i].row       = snake[i-1].row;
            snake[i].column    = snake[i-1].column;   
            snake[i].direction = snake[i-1].direction;               
        }
        if      (snake[Globals.HEAD].direction == Globals.UP)    snake[Globals.HEAD].row--;
        else if (snake[Globals.HEAD].direction == Globals.DOWN)  snake[Globals.HEAD].row++;
        else if (snake[Globals.HEAD].direction == Globals.LEFT)  snake[Globals.HEAD].column--;
        else if (snake[Globals.HEAD].direction == Globals.RIGHT) snake[Globals.HEAD].column++;
    }

    /**
     * Checks if the head of the snake has gone outside the boundry
     * 
     * @return has hit the boundry (true) or not (false)
     */
    private boolean hasHitBoundry() {
        if (snake[Globals.HEAD].row    < 0        || 
            snake[Globals.HEAD].row    >= maxRows ||
            snake[Globals.HEAD].column < 0        ||
            snake[Globals.HEAD].column >= maxColumns) {
            gameOver();
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the head of the snake has eaten a power up
     * 
     * @return has eaten a power up (true) or not (false)
     */
    private boolean hasEatenPowerUp() {
        if (snake[Globals.HEAD].row    == powerUp.row && 
            snake[Globals.HEAD].column == powerUp.column) {            
            growSnake();
            newPowerUp();
            score++;
            engine.scoreLabel.setText("Current Score: " + score);
            return true;
        }
        return false;
    }
    
    /** 
     * Adds a new segment to the snake body 
     */
    private void growSnake() {    
        length++;
        snake[length-1].row    = snake[length-2].row;
        snake[length-1].column = snake[length-2].column;
        if      (snake[length-2].direction == Globals.UP)    snake[length-1].row++;
        else if (snake[length-2].direction == Globals.DOWN)  snake[length-1].row--;
        else if (snake[length-2].direction == Globals.LEFT)  snake[length-1].column++;
        else if (snake[length-2].direction == Globals.RIGHT) snake[length-1].column--;               
    }
        
    /** 
     * Checks to see if the snake head s hitting the snake body 
     */
    private void checkForCollisionWithSelf() {
        if (isInSnake(snake[0].row,snake[0].column,true)) {
            gameOver();
        }
    }
    
    /** 
     * Generates a new power up in a random location 
     */
    private void newPowerUp() {
        int row    = 0;
        int column = 0;
        do {
            row    = Numbers.random(0,maxRows-1);
            column = Numbers.random(0,maxColumns-1);
        } while(isInSnake(row,column,false));
        powerUp = new Location(row,column,Globals.STOP);
        grid[powerUp.row][powerUp.column].setBackground(Globals.POWER_UP_COLOR);
    }
    
    /**
     * Determines is this location is touching any part of the snake
     * 
     * @param row the row to check
     * @param column the column to check
     * @param isHead do I check the head location or not
     * @return is hitting a part of the snake (true) or not (false)
     */
    private boolean isInSnake(int row, int column, boolean isHead) {
        int i = 0;
        if (isHead) i = 1;
        while (i < length) {
            if (snake[i].row    == row && 
                snake[i].column == column) 
                return true;
            i++;
        }
        return false;
    } 

}
