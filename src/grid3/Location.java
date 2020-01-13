
/** required package class namespace */
package grid3;

 
/**
 * Location.java - stores and adjusts an object's location
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 3:49:42 p.m.
 */
public class Location 
{

    /** The row location on the grid */
    public int row;    
    /** The column location on the grid */
    public int column;
    /** The direction of travel */
    public int direction;
    
    /**
     * Class constructor, sets class properties to the parameters
     * 
     * @param row the row location
     * @param column the column location
     * @param direction the direction of travel
     */
    public Location(int row, int column, int direction) {
        this.row       = row;
        this.column    = column;
        this.direction = direction;
    }

}
