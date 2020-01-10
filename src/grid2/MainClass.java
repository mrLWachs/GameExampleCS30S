
/** required package class namespace */
package grid2;


/**
 * MainClass.java - This is the "level 2" gaming grid example which uses the 
 * NetBeans designer to help with building a simple layout. This also uses 
 * other classes to help manage the logic. It uses a "main" class with a main
 * method to then launch the designer JFrame class. This is so that any other 
 * JFrame classes (like a character select screen, etc.) can be managed first 
 * and not use the main method built into the NetBeans designer JFrame classes.
 *
 * @author Mr. Wachs
 * @since Jan. 9, 2020, 12:56:26 p.m.
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
