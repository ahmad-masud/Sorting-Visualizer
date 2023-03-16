import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingVisualizer extends JPanel implements ActionListener {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BAR_WIDTH = 0x2;
    
    private int[] list;
    private boolean[] highlighted;
    private boolean[] sorted;
    private SortingAlgorithm algorithm;
    private Thread sortingThread;
    private final String[] algorithms = {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort", "QuickSort"};
    
    public JButton buttonRun = new JButton("Run");
    public JButton buttonCancel = new JButton("Cancel");
    public JButton buttonReset = new JButton("Reset");
    public JComboBox<String> comboBox = new JComboBox<>(algorithms);

    public SortingVisualizer() {  
        list = new int[WINDOW_WIDTH / BAR_WIDTH];
        highlighted = new boolean[list.length];
        sorted = new boolean[list.length];
        algorithm = new BubbleSort(this); // Change this to use a different algorithm
        sortingThread = null;
        initList();
        
    }
    
    public void initialize() {
        JPanel buttonPanel = new JPanel();

        buttonRun.addActionListener(this);
        buttonCancel.addActionListener(this);
        buttonReset.addActionListener(this);
        comboBox.addActionListener(this);

        buttonPanel.add(buttonRun);
        buttonPanel.add(buttonCancel);
        buttonPanel.add(buttonReset);
        buttonPanel.add(comboBox);

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void initList() {
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(WINDOW_HEIGHT);
        }
    }
    
    private void resetList() {
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(WINDOW_HEIGHT);
            highlighted[i] = false;
            sorted[i] = false;
            repaint();
        }
    }
    
    public void buttonsEnabled(boolean enabled) {
        if (enabled) {
            buttonRun.setEnabled(true);
            buttonReset.setEnabled(true);
            comboBox.setEnabled(true);
        } else {
            buttonRun.setEnabled(false);
            buttonReset.setEnabled(false);
            comboBox.setEnabled(false);
        }
    }

    public void startSorting() {
        if (sortingThread != null) {
            return;
        }
        sortingThread = new Thread(() -> {
            algorithm.sort(list);
            sortingThread = null;
        });
        sortingThread.start();
        buttonsEnabled(false);
    }

    public void stopSorting() {
        if (sortingThread == null) {
            return;
        }
        sortingThread.interrupt();
        sortingThread = null;
        buttonsEnabled(true);
    }
    
    public boolean threadInterrupted() {
        return sortingThread == null;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        for (int i = 0; i < list.length; i++) {
            int x = i * BAR_WIDTH;
            int y = WINDOW_HEIGHT - list[i];
            int height = list[i];
            if (sorted[i]) {
                g.setColor(Color.BLUE);
            } else if (highlighted[i]) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            g.fillRect(x, y, BAR_WIDTH, height);
        }
    }

    public interface SortingAlgorithm {
        void sort(int[] list);
    }
    
    public boolean checkSorted(int list[]) {
        sorted[0] = true;
        for (int i = 1; i < list.length; i++) {
            if (list[i]<list[i-1]) {
                return false;
            }
            sorted[i] = true;
            animate(i, 1000000);
        }
        return true;
    }
    
    public void animate(int j, long delay) {
        highlighted[j] = true;
        if (j+1 < highlighted.length) {
            highlighted[j+1] = true;
        }
        repaint();
        long startTime = System.nanoTime();
        while (System.nanoTime() - startTime < delay) {
            Thread.onSpinWait();
        }
        highlighted[j] = false;
        if (j+1 < highlighted.length) {
            highlighted[j+1] = false;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRun) {
            startSorting();
        } else if (e.getSource() == buttonCancel) {
            stopSorting();
        } else if (e.getSource() == buttonReset) {
            resetList();
        } else if (e.getSource() == comboBox) {
            String selected = (String)comboBox.getSelectedItem();
            switch (selected) {
                case "BubbleSort" -> algorithm = new BubbleSort(this);
                case "MergeSort" -> algorithm = new MergeSort(this);
                case "SelectionSort" -> algorithm = new SelectionSort(this);
                case "InsertionSort" -> algorithm = new InsertionSort(this);
                case "QuickSort" -> algorithm = new QuickSort(this);
                default -> throw new IllegalArgumentException("Invalid Algorithm: " + selected);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();
        visualizer.initialize();
        frame.setContentPane(visualizer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
