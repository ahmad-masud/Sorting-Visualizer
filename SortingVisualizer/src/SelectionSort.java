public class SelectionSort implements Panel.SortingAlgorithm {
    
    private final Panel visualizer;

    public SelectionSort(Panel visualizer) {
        this.visualizer = visualizer;
    }
    
    @Override
    public void sort(int[] list){  
        for (int i = 0; i < list.length - 1; i++)  {  
            int index = i;  
            for (int j = i + 1; j < list.length; j++){  
                if (list[j] < list[index]){  
                    index = j;
                    if (visualizer.threadInterrupted()) return;
                    visualizer.animate(i, 2500000);
                }  
            }  
            int smallerNumber = list[index];   
            list[index] = list[i];  
            list[i] = smallerNumber;  
        }
        visualizer.checkSorted(list);   
        visualizer.buttonsEnabled(true);
    }  
}
