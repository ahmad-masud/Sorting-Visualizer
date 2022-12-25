import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        getContentPane().add(new Panel());
        setTitle("Sorting Algorithm Visualizer");
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}