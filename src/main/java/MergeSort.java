public class MergeSort implements Panel.SortingAlgorithm {
    
    private final Panel visualizer;
    private final boolean test;

    public MergeSort() {
        test = true;
        this.visualizer = null;
    }
    public MergeSort(Panel visualizer) {
        test = false;
        this.visualizer = visualizer;
    }
    
    private void merge(int[] list, int l, int m, int r) {
        
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(list, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = list[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                if (!test && visualizer != null) {
                    if (visualizer.threadInterrupted()) return;
                    visualizer.animate(k, 2500000);
                }
                i++;
            }
            else {
                list[k] = R[j];
                if (!test && visualizer != null) {
                    if (visualizer.threadInterrupted()) return;
                    visualizer.animate(k, 2500000);
                }
                j++;
            }
            k++;
        }

        while (i < n1) {
            list[k] = L[i];
            if (!test && visualizer != null) {
                if (visualizer.threadInterrupted()) return;
                visualizer.animate(k, 2500000);
            }
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = R[j];
            if (!test && visualizer != null) {
                if (visualizer.threadInterrupted()) return;
                visualizer.animate(k, 2500000);
            }
            j++;
            k++;
        }
    }

    private void sortList(int[] list, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sortList(list, l, m);
            sortList(list, m + 1, r);

            // Merge the sorted halves
            merge(list, l, m, r);
        }
    }

    @Override
    public void sort(int[] list) {
        sortList(list, 0, list.length - 1);
        if (!test && visualizer != null) {
            if (visualizer.threadInterrupted()) return;
            visualizer.checkSorted(list);
            visualizer.buttonsEnabled(true);
        }
    }
}
