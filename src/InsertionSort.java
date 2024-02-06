public class InsertionSort implements Panel.SortingAlgorithm {
    
    private final Panel visualizer;

    public InsertionSort(Panel visualizer) {
        this.visualizer = visualizer;
    }
    
    @Override
    public void sort(int list[]) {  
        int n = list.length;  
        for (int j = 1; j < n; j++) {  
            int key = list[j];  
            int i = j-1;  
            while ( (i > -1) && ( list[i] > key ) ) {  
                list[i+1] = list[i]; 
                if (visualizer.threadInterrupted()) return;
                visualizer.animate(i, 250000);
                i--;  
            }  
            list[i+1] = key;  
        }  
        visualizer.checkSorted(list);
        visualizer.buttonsEnabled(true);
    }   
}