public class QuickSort implements SortingVisualizer.SortingAlgorithm {
    
    private SortingVisualizer visualizer;
    
    public QuickSort(SortingVisualizer visualizer) {
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
                visualizer.animate(i, 2500000);
            }
        }
        int temp = list[i+1];
        list[i+1] = list[high];
        list[high] = temp;
        visualizer.animate(i+1, 2500000);
        return (i + 1);
    }
    
    public void sortList(int[] list, int low, int high) {
        if (low < high) {
            if (visualizer.threadInterrupted()) return;
            int pi = partition(list, low, high);
  
            sortList(list, low, pi - 1);
            sortList(list, pi + 1, high);
        }
    }
    
    public void sort(int list[]) {
        sortList(list, 0, list.length-1);
        if (visualizer.threadInterrupted()) return;
        visualizer.checkSorted(list);
        visualizer.buttonsEnabled(true);
    }
}
