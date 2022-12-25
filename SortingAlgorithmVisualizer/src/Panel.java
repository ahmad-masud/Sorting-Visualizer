import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class Panel extends JPanel {
    
    private static final int
        WIN_WIDTH = 800, WIN_HEIGHT = 800,
        RANGE = WIN_HEIGHT - 100,
        ELEMENTS = 800;

    private int delay = 5;
    
    private final Random rand = new Random();

    private final int[] array =
        IntStream.generate(() -> rand.nextInt(RANGE))
        .limit(ELEMENTS)
        .toArray();

    private final SortingAlgorithm[] algorithms = {
        new SelectionSort(), new InsertionSort(), new BubbleSort()
    };

    private final List<JButton> algorithmButtons =
        Arrays.stream(algorithms)
        .map(algorithm -> {
            JButton button = new JButton(algorithm.getName());
            button.addActionListener(event -> initSort(algorithm));
            return button;
        })
        .toList();

    private final JButton shuffleButton = new JButton("Shuffle");
    private final JSlider slider = new JSlider(1, 10);
    
    public Panel() {
        setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        setOpaque(true);  // otherwise, backgroundcolor won't be visible

        algorithmButtons.forEach(this::add);
        shuffleButton.addActionListener(this::shuffleArray);
        slider.addChangeListener(this::changeTime);
        slider.setValue(delay);
        add(shuffleButton);
        add(slider);
        style(shuffleButton);
        algorithmButtons.forEach(this::style);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        setBackground(Color.white);
        for (int i = 0; i < array.length; i++) {
            g.drawRect(i, 800 - array[i], 1, array[i]);
            g.fillRect(i, 800 - array[i], 1, array[i]);
        }
    }

    public int[] getArray() {
        return array;
    }

    public void render(int time) {
        repaint();
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enableButtons(boolean enabled) {
        shuffleButton.setEnabled(enabled);
        slider.setEnabled(enabled);
        for (JButton button: algorithmButtons)
            button.setEnabled(enabled);
    }

    private void animate(IntConsumer consume, int time) {
        enableButtons(false);
        new Thread(() -> {
            for (int i = 0; i < getArray().length; i++) {
                consume.accept(i);
                render(time);
            }
            enableButtons(true);
        }).start();
    }

    private void shuffleArray(ActionEvent e) {
        animate(i -> array[i] = rand.nextInt(RANGE), 1);
    }

    public void initSort(SortingAlgorithm algorithm) {
        animate(i -> algorithm.sort(array, i),delay);
    }
    
    public void changeTime(ChangeEvent e) {
        delay=slider.getValue();
    }
    
    public void style(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.blue);
        button.setForeground(Color.white);
    }
}