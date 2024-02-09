public class QuickSort implements Panel.SortingAlgorithm {
    
    private final Panel visualizer;
    private final boolean test;

    public QuickSort() {
        test = true;
        this.visualizer = null;
    }
    public QuickSort(Panel visualizer) {
        test = false;
        this.visualizer = visualizer;
    }
    
    public int partition(int[] list, int low, int high) {  
        int pivot = list[high];
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
            if (list[j] < pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                if (!test && visualizer != null) {
                    visualizer.animate(i, 2500000);
                }
            }
        }
        int temp = list[i+1];
        list[i+1] = list[high];
        list[high] = temp;
        if (!test && visualizer != null) {
            visualizer.animate(i + 1, 2500000);
        }
        return (i + 1);
    }
    
    public void sortList(int[] list, int low, int high) {
        if (low < high) {
            if (!test && visualizer != null) {
                if (visualizer.threadInterrupted()) return;
            }
            int pi = partition(list, low, high);
  
            sortList(list, low, pi - 1);
            sortList(list, pi + 1, high);
        }
    }
    
    @Override
    public void sort(int[] list) {
        sortList(list, 0, list.length-1);
        if (!test && visualizer != null) {
            if (visualizer.threadInterrupted()) return;
            visualizer.checkSorted(list);
            visualizer.buttonsEnabled(true);
        }
    }
}
