
/** required package class namespace */
package example;

/** required imports */
import tools.Dialogs;


/**
 * GameExampleCS30S.java - a few gaming examples that could be adapted into a 
 * final project. The different levels represent complexity of the examples and
 * you should adapt the one that might best suit your needs. Some of the 
 * examples use fairly advanced code, but most is code at the level learned in 
 * this course. This is expected to be a starting point for a project (not a
 * complete project) and therefore needs to be adapted. As well, it might still 
 * not completely meet your needs for what you were looking for (sorry).
 *
 * @author Mr. Wachs
 * @since Jan. 8, 2020, 3:25:57 p.m.
 */
public class GameExampleCS30S 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dialogs.title = "Final Project Gaming Examples...";
        final String TEXT = "Please select which level of example to try";
        final String[] CHOICES = { 
            "Level 1 Movement Example",
            "Level 2 Movement Example",
            "Level 3 Movement Example",
            "Level 1 Grid Example"            
        };
        String choice = Dialogs.choices(TEXT, CHOICES);
        if (choice.equals(CHOICES[0])) {
            new movement1.UserInterface().main(args);
        }
        else if (choice.equals(CHOICES[1])) {
            new movement2.MainClass().main(args);
        }
        else if (choice.equals(CHOICES[2])) {
            new movement3.MainClass().main(args);
        }
        else if (choice.equals(CHOICES[3])) {
            new grid1.UserInterface().main(args);
        }
    }

}
