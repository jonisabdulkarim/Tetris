// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code provided by Professor Ian Daly


import javax.swing.*;
import java.awt.*;

class JEasyFrame extends JFrame {
    JEasyFrame(Component comp, String title) {
        super(title);
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        repaint();
    }
}
