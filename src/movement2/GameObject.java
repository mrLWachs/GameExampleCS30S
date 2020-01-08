
/** required package class namespace */
package movement2;

/** required imports */
import java.awt.Rectangle;
import javax.swing.JLabel;

 
/**
 * GameObject.java - represents a typical object in a game. This class was 
 * designed to work on any "non-moving" object in a game. It includes code to
 * store information about how to track the coordinates of the object and the
 * JLabel that is associated with the object on a design.
 *
 * @author Mr. Wachs
 * @since Jan. 8, 2020, 8:43:53 a.m.
 */
public class GameObject 
{
    
    public Rectangle hitbox;                    // imported class Rectangle
    public JLabel    label;                     // associated label from design
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param label label used on a user interface
     */
    public GameObject(JLabel label) {
        this.label = label;         // connect parameter with class property
        hitbox = new Rectangle(label.getX(), 
                               label.getY(), 
                               label.getWidth(), 
                               label.getHeight());  // rectangle from label
    }
    
    /**
     * Determines if colliding with another game object (the target)
     * 
     * @param target the other game object to check against
     * @return is colliding (true) or not (false)
     */
    public boolean isColliding(GameObject target) {
        if (this.hitbox.intersects(target.hitbox)) return true;
        else                                       return false;
    }

}
