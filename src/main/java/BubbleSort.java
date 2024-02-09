public class BubbleSort implements Panel.SortingAlgorithm {

    private final Panel visualizer;
    private final boolean test;

    public BubbleSort() {
        this.test = true;
        this.visualizer = null;
    }
    public BubbleSort(Panel visualizer) {
        this.test = false;
        this.visualizer = visualizer;
    }

    @Override
    public void sort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    if (!test && visualizer != null) {
                        if (visualizer.threadInterrupted()) return;
                        visualizer.animate(j, 100000);
                    }
                }
            }
        }
        if (!test && visualizer != null) {
            visualizer.checkSorted(list);
            visualizer.buttonsEnabled(true);
        }
    }
}
