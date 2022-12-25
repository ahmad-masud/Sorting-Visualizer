public class SelectionSort implements SortingAlgorithm {
    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    public void sort(int[] array, int target) {
        int min = target;
        for (int i = target+1; i < array.length; i++) {
            if (array[min] > array[i])
                min = i;
        }
        if (min != target) {
            int temp = array[target];
            array[target] = array[min];
            array[min] = temp;
        }
    }
}