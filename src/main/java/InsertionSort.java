public class InsertionSort implements Panel.SortingAlgorithm {
    
    private final Panel visualizer;
    private final boolean test;

    public InsertionSort() {
        test = true;
        this.visualizer = null;
    }
    public InsertionSort(Panel visualizer) {
        test = false;
        this.visualizer = visualizer;
    }
    
    @Override
    public void sort(int[] list) {
        int n = list.length;  
        for (int j = 1; j < n; j++) {  
            int key = list[j];  
            int i = j-1;  
            while ( (i > -1) && ( list[i] > key ) ) {  
                list[i+1] = list[i];
                if (!test && visualizer != null) {
                    if (visualizer.threadInterrupted()) return;
                    visualizer.animate(i, 250000);
                }
                i--;  
            }  
            list[i+1] = key;  
        }
        if (!test && visualizer != null) {
            visualizer.checkSorted(list);
            visualizer.buttonsEnabled(true);
        }
    }   
}
