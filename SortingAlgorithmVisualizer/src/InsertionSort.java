public class InsertionSort implements SortingAlgorithm {
    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public void sort(int[] array, int target) {
        if (target >= array.length - 1)
            return;

        if (array[target+1] < array[target]) {
            for (int i = 0; i <= target; i++) {
                if (array[target+1] < array[i]) {
                    int temp = array[target+1];
                    array[target+1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}