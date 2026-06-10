/**
 * Pair exercise — build sorted array, pick target, time both searches.
 * 
 */
public class SearchBenchmark {

    public static void main(String[] args) {

        int size = 5_000_000 ;
        int target = 1_580_040;
        int [] sortedEven = buildSortedEvens(size);

        long start = System.nanoTime();
        int linearResult = SearchLib.linearSearch(sortedEven, target);
        long linearElapsed = System.nanoTime() - start;

        start = System.nanoTime();
        int binaryResult = SearchLib.binarySearch(sortedEven, target);
        long binaryElapsed = System.nanoTime() - start;

        System.out.println("Array size : " + size);
        System.out.println("Target     : " + target);
        System.out.println("Linear Search -> index: " + linearResult + "| time: " + linearElapsed / 1_000_000.0 + "ms");
        System.out.println("Binary Search -> index: " + binaryResult + "| time: " + binaryElapsed / 1_000_000.0 + "ms");
    }

    static int[] buildSortedEvens(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
}