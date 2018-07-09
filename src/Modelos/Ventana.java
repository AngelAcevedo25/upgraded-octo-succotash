package Modelos;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;

/**
 *
 * @author user
 */
public class Ventana extends JFrame implements WindowListener{

    public Ventana(String title)
    {
        super(title);
        setSize(500,500);
        addWindowListener(this);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {System.exit(0);}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}
