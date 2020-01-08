
/** required package class namespace */
package movement2;


/**
 * NewMain.java - This is the "level 2" gaming example which uses the 
 * NetBeans designer to help with building a layout quicker. This also uses 
 * other classes to help manage the logic. It uses a "main" class with a main
 * method to then launch the designer JFrame class. This is so that any other 
 * JFrame classes (like a character select screen, etc.) can be managed first 
 * and not use the main method built into the NetBeans designer JFrame classes.
 *
 * @author Mr. Wachs
 * @since Jan. 8, 2020, 7:28:19 a.m.
 */
public class MainClass 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
    }

}
