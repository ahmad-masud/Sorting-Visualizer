public class BubbleSort implements Panel.SortingAlgorithm {
    
    private Panel visualizer;
    
    public BubbleSort(Panel visualizer) {
        this.visualizer = visualizer;
    }
    
    public void sort(int list[]) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    if (visualizer.threadInterrupted()) return;
                    visualizer.animate(j, 100000);
                }
            }
        }
        visualizer.checkSorted(list);
        visualizer.buttonsEnabled(true);
    }
}
