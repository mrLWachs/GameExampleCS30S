
/** required package class namespace */
package grid2;


/**
 * UserInterface.java - This is the "level 2" gaming grid example which 
 * uses the NetBeans designer to help with building a layout but then transfers
 * a lot of the logic to another class (the GameEngine class) along with 
 * references to some of the objects on this design so it can "update" the
 * design from the other class.
 *
 * @author Mr. Wachs
 * @since Jan. 9, 2020, 8:17:09 a.m.
 */
public class UserInterface extends javax.swing.JFrame 
{

    // the class which contains the logic for the design 
    private GameEngine engine;
    
    /** 
     * Default constructor, creates new form UserInterface 
     */
    public UserInterface() {
        initComponents();
        // the engine is instantiate and then all logic proceeds in that class
        // I pass references to the JPanel where the grid of labels will be 
        // created inside of and the user interface itself. If I added other
        // objects to the design (e.g. a label) then I would pass a reference
        // to the other class through the parameter to the constructor method
        // so the other class could modify them as well
        engine = new GameEngine(jPanel1,this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 1200, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
