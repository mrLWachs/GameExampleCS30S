
/** required package class namespace */
package movement2;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * UserInterface.java - The designer is used and a number of JLabels are added 
 * and the properties of each are set to have an etched border, horizontal 
 * alignment set to center, opaque set to true, and a background color and/or 
 * text added. I will not be naming all the labels and instead doing that 
 * with the code below. I also right clicked on the JFrame and set the layout 
 * to null. I deleted the main method that NetBeans provides for this class in
 * favor of the main method in the other class (NewMain.java)
 *
 * @author Mr. Wachs
 * @since Jan. 8, 2020, 7:28:43 a.m.
 */
public class UserInterface extends javax.swing.JFrame 
{

    /** 
     * Default constructor, creates new form UserInterface 
     */
    public UserInterface() {
        initComponents();
        // The method below is called in the constructor that NetBeans wrote 
        // to jump to my own custom method to complete the process of setting 
        // up the inital frame
        startUp();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WALL");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 40, 670);

        jLabel2.setBackground(new java.awt.Color(255, 255, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OBJECTIVE");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 40, 100, 100);

        jLabel3.setBackground(new java.awt.Color(0, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WALL");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(630, 10, 40, 670);

        jLabel4.setBackground(new java.awt.Color(0, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("WALL");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 10, 580, 30);

        jLabel5.setBackground(new java.awt.Color(0, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WALL");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 650, 580, 30);

        jLabel6.setBackground(new java.awt.Color(0, 153, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WALL");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 460, 50, 190);

        jLabel7.setBackground(new java.awt.Color(0, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("WALL");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(410, 40, 50, 180);

        jLabel8.setBackground(new java.awt.Color(0, 153, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("WALL");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 280, 210, 40);

        jLabel9.setBackground(new java.awt.Color(0, 153, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("WALL");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(420, 390, 210, 40);

        jLabel10.setBackground(new java.awt.Color(51, 204, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ENEMY");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 540, 50, 50);

        jLabel11.setBackground(new java.awt.Color(51, 204, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("HERO");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(80, 550, 70, 70);

        jLabel12.setBackground(new java.awt.Color(51, 204, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ENEMY");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(90, 80, 50, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // You also need to right click the JFrame (form) and go to 
        // Events -> Key -> KeyPressed to access this method which then again
        // jumps to my own method below. All further code is not below the
        // code that the NetBeans designer wrote for us
        keyPress(evt);
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    
    // GLOBAL VARIABLES:
    // =================
    // Usially these are made at the top of the class (and they still can), but
    // I have made them here (under the NetBeans generated code) so all our 
    // added code is in one place. As well, this code will use objects from the 
    // other classes in this project. These other classes will have to be 
    // added to the project (right click and add new class to the project
    // "package") for GameObject and GameCharacter. Also a timer object is 
    // used (which must be imported from javax.swing.Timer).
    
    private GameCharacter   hero;       // for the hero, it is a "character"
    private GameObject      objective;  // the objective is just a "object"
    private GameCharacter[] enemies;    // an array of the enemies
    private GameObject[]    walls;      // an array of all walls
    private Timer           timer;      // game timer controls game loop
    
    private final int FRAME_WIDTH  = 690;   // constants for frame (form) size 
    private final int FRAME_HEIGHT = 725;
    private final int DELAY        = 100;   // the delay for the game timer
    
        
    /**
     * When the form (frame) starts up, after the NetBeans constructor, it 
     * runs this code to complete the look and feel of the form and also 
     * sets up some of the other class objects for the game
     */
    private void startUp() {
        setSize(FRAME_WIDTH,FRAME_HEIGHT);  // make the correct size
        setLocationRelativeTo(null);        // center on the screen
        setResizable(false);                // remove maximize button
        setObjects();                       // prepare game class objects
        setVisible(true);                   // finally, make frame visible
    }

    /**
     * When a key is pressed on the frame it transfers the logic of what to
     * do to the hero object to take care of what to do
     * 
     * @param event the keyboard event the user did
     */
    private void keyPress(KeyEvent event) {
        hero.keyPress(event.getKeyCode());      // transfer the key code logic
    }

    /**
     * Sets the other class objects to instances of those classes to help
     * divide up the logic into those other classes
     */
    private void setObjects() {        
        // create names for the exisiting labels from the designer by 
        // importing the JLabel class (use lightbulb) and then assign the
        // name to that object. As well, for groups of labels (like the 
        // walls) I will use a JLabel array
        JLabel   heroLabel      = jLabel11;
        JLabel   objectiveLabel = jLabel2;
        JLabel[] enemyLabels    = { jLabel12, jLabel10 };        
        JLabel[] wallLabels     = { jLabel1,jLabel3,jLabel4,jLabel5,
                                    jLabel6,jLabel7,jLabel8,jLabel9 };        
        // Now instantiate the objects passing the label as a parameter to
        // the class. This will show up as an error initially, but then you can 
        // use the lightbulb to create the method in the other class.
        hero      = new GameCharacter(heroLabel);
        objective = new GameObject(objectiveLabel);
        // Arrays of these objects are set up and set to the same sizes as the 
        // matching label arrays
        enemies = new GameCharacter[enemyLabels.length];
        walls   = new GameObject[wallLabels.length];
        // Now traverse (loop) through the arrays and instantiate the objects
        // in the arrays and pass the JLabel from the other array for that 
        // object
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new GameCharacter(enemyLabels[i]);
            // Start the enemies off in a random direction, use the lightbulb
            // to auto create this method in the other GameCharacter class
            enemies[i].randomDirection();   
        }
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new GameCharacter(wallLabels[i]);
        }        
        // now the timer is set up to run the entire game loop
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // The "tick" method is written (do not use lightbulb) below 
                // this method
                tick();
            }
        });
        // now start the timer running
        timer.start();
    }
    
    /**
     * The actions that take place every "tick" of the game timer (sometimes 
     * called a game loop) which moves all objects and checks for collisions
     */
    private void tick() {
        // Make the hero move it's coordinates by using the lightbulb to 
        // create a method in the GameCharacter class
        hero.move();        
        // Now check for collison with objective (again use lightbulb to
        // create a method in the other class)
        if (hero.isColliding(objective)) {            
            // collision occured, stick to the objective (auto create method)
            hero.stickTo(objective);
            // auto create method to update position on screen
            hero.redraw(); 
            timer.stop();                                   // stop the timer           
            JOptionPane.showMessageDialog(this, "You win!"); 
            System.exit(0);                                 // end program
        }        
        // Now check for collison with all walls by traversing the array
        for (int i = 0; i < walls.length; i++) {
            if (hero.isColliding(walls[i])) {       // check for wall collision
                hero.bounceOff(walls[i]);           // auto create method
                i = walls.length;                   // leave loop early
            }
        }
        // Now traverse through all enemies
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].move();                      // move that enemy            
            if (hero.isColliding(enemies[i])) {     // check if hit hero
                hero.stickTo(enemies[i]);           // stick to hero
                timer.stop();                       // stop timer
                JOptionPane.showMessageDialog(this, "You lose!");
                System.exit(0);                     // end program
            }
            // Now traverse all walls for this enemy (nested loop)
            for (int j = 0; j < walls.length; j++) {
                if (enemies[i].isColliding(walls[j])) { // wall collision
                    enemies[i].bounceOff(walls[j]);     // bounce off wall
                    enemies[i].randomDirection();       // change direction
                    j = walls.length;                   // leave loop early
                }
            }
            enemies[i].redraw();                        // reposition enemy
        }     
        hero.redraw();                                  // reposition hero
    }

}
