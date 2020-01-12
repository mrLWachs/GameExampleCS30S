
/** required package class namespace */
package grid3;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

 
/**
 * Globals.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 10, 2020, 3:27:54 p.m.
 */
public class Globals 
{

    public static final String TITLE = "Snake...";
    public static final int FRAME_WIDTH  = 955;
    public static final int FRAME_HEIGHT = 710;
    
    public static final Color DARK_GREEN  = new Color(0,89,6);
    public static final Color LIGHT_GREEN = new Color(153,255,102);
    
    public static final int    TIMER_DELAY           = 100;
    public static final int    STOP                  = 0;
    public static final int    LEFT                  = 1;
    public static final int    RIGHT                 = 2;
    public static final int    UP                    = 3;
    public static final int    DOWN                  = 4;
    public static final Color  SQUARE_COLOR          = DARK_GREEN;
    public static final Color  SQUARE_BORDER_COLOR   = Color.darkGray;    
    public static final Color  SNAKE_HEAD_COLOR      = Color.red;
    public static final Color  SNAKE_BODY_COLOR      = Color.pink;    
    public static final Color  POWER_UP_COLOR        = Color.blue;
    public static final int    SQUARE_SIZE           = 30;
    public static final Border SQUARE_BORDER         = 
                            BorderFactory.createLineBorder(SQUARE_BORDER_COLOR);    
    public static final int    BLANK                 = -1;    
    public static final int    HEAD                  = 0;
    public static final String PATH                  = "/grid3/";
    public static final String DATA_FILE             = PATH + "data.txt";
    
}
