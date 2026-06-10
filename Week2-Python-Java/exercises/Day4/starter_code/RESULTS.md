# Linear vs binary — results (rename to RESULTS.md)

## Round 1 (N = 100_000) (Target = 20_000)

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear |      0.3228ms|       | 
| Binary |  0.0013ms    |       | 

## Round 2 (N = 5_000_000) (Target = 1_580_040)

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear |2.2609ms | |
| Binary | 0.0049ms| |

## Big-O discussion
### Linear Search
Linear search is O(n) and in the worst case it must inspect every element before finding the target. With a target closer to the beginning, we expected the search to access only the first portion of the array, and vice-versa. Thus, we expected the execution time to grow with the size. In practice, the actual results were consistent with the prediction that work grows proportionally to the input size

### Binary Search
Binary search is O(log n): each iteration cuts the remaining search space in half. We expected a near-instant result, and that is exactly what the test results showed. It was about 100-1000x faster than linear search on the same input.

## Caveats (JVM, cache, warmup)
The JVM starts in interpreted mode and only JIT-compiles hot code after enough invocations, so the first call to either method is slower than it would be after warmup. CPU caches also favor linear search more than Big-O suggests — scanning a contiguous array is cache-friendly, while binary search jumps around in memory at larger sizes. Finally, for very small arrays the constant-factor overhead of binary search's bookkeeping can actually make it slower than linear search in wall time. However,  Big-O describes growth rate, not absolute speed. As n scales toward millions and billions, the 20-comparison ceiling of binary search dominates every hardware or JVM advantage linear search might have at small sizes, and the gap only widens.