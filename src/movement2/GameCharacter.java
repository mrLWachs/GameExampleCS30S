
/** required package class namespace */
package movement2;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

 
/**
 * GameCharacter.java - representation of a character in a game. This class was 
 * designed to work on any "moving" object in a game. It inherits from the 
 * GameObject class all public properties and methods (it "is a" game object)
 * and adds properties and methods for movement.
 *
 * @author Mr. Wachs
 * @since Jan. 8, 2020, 8:43:46 a.m.
 */
public class GameCharacter extends GameObject
{

    private int direction;          // encapsulated property stores direction
    
    private final int AMOUNT = 10;  // constant for how much it moves
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param label label used on a user interface
     */
    public GameCharacter(JLabel label) {
        super(label);                   // passes label reference to super class
        direction = Directions.STOP;    // start in a stop state
    }
    
    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param key the keyboard code registered
     */
    public void keyPress(int key) {
        if      (key == KeyEvent.VK_LEFT)  direction = Directions.LEFT;
        else if (key == KeyEvent.VK_RIGHT) direction = Directions.RIGHT;
        else if (key == KeyEvent.VK_UP)    direction = Directions.UP;
        else if (key == KeyEvent.VK_DOWN)  direction = Directions.DOWN;
        else                               direction = Directions.STOP;
    }

    /**
     * Set the game character to move a random direction
     */
    public void randomDirection() {
        direction = (int)(4d * Math.random() + 1d);
    }
    
    /**
     * Moves the game object based on the remembered direction
     */
    public void move() {
        if      (direction == Directions.UP)    hitbox.y -= AMOUNT;
        else if (direction == Directions.DOWN)  hitbox.y += AMOUNT;
        else if (direction == Directions.LEFT)  hitbox.x -= AMOUNT;
        else if (direction == Directions.RIGHT) hitbox.x += AMOUNT;
    }

    /**
     * Positions this character correctly against (sticks to) the target
     * 
     * @param target the other game object to stick to
     */
    public void stickTo(GameObject target) {
        if (direction == Directions.UP) {
            hitbox.y = target.hitbox.y + target.hitbox.height + 1;
        }
        else if (direction == Directions.DOWN) {
            hitbox.y = target.hitbox.y - hitbox.height - 1;
        }
        else if (direction == Directions.LEFT) {
            hitbox.x = target.hitbox.x + target.hitbox.width + 1;
        }
        else if (direction == Directions.RIGHT) {
            hitbox.x = target.hitbox.x - hitbox.width - 1;
        }
        direction = Directions.STOP;
    }

    /**
     * Changes current direction and bounces off the target 
     * 
     * @param target the other game object to bounces off
     */
    public void bounceOff(GameObject target) {
        stickTo(target);
        if      (direction == Directions.UP)    direction = Directions.DOWN;
        else if (direction == Directions.DOWN)  direction = Directions.UP;
        else if (direction == Directions.LEFT)  direction = Directions.RIGHT;
        else if (direction == Directions.RIGHT) direction = Directions.LEFT;        
    }

    /**
     * Updates the position of the label in the frame design based on the
     * newly updated coordinates in the rectangle hit box
     */
    public void redraw() {
        label.setBounds(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

}
