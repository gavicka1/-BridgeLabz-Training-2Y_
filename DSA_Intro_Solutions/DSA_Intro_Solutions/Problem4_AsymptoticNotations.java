/*
 * ============================================================
 * Problem 4: Asymptotic Notation Applications
 * ============================================================
 * Scenario: Data analytics company evaluates sorting algorithms
 * for a big data processing pipeline.
 *
 * Algorithms compared:
 *   1. Bubble Sort  — Best: O(n), Worst/Avg: O(n²)
 *   2. Merge Sort   — All cases: Θ(n log n)
 *   3. Quick Sort   — Best/Avg: O(n log n), Worst: O(n²)
 *   4. Insertion Sort — Best: O(n), Worst/Avg: O(n²)
 *
 * This file contains:
 *  a) Formal Big-O proof for worst-case complexities
 *  b) Algorithm matching for data types A, B, C
 *  c) Θ vs O distinction: Merge Sort vs Quick Sort
 *  d) Decision tree for algorithm selection
 *  e) Break-even: Mystery Sort vs Merge Sort
 * ============================================================
 */

public class Problem4_AsymptoticNotations {

    static double log2(double n) { return Math.log(n) / Math.log(2); }

    // ── Sorting Implementations (for live demo) ───────────────────────
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) { int t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t; }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    static java.util.Arrays arrays = null; // just to import

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println(" Problem 4: Asymptotic Notation Applications");
        System.out.println("============================================================\n");

        // ── a) Formal Big-O Proofs ───────────────────────────────────
        System.out.println("(a) FORMAL BIG-O PROOFS FOR WORST-CASE COMPLEXITY");
        System.out.println("─".repeat(60));
        System.out.println("""
            ═══ PROOF 1: Bubble Sort is O(n²) ═══

            Algorithm performs comparisons:
              Pass 1: n-1 comparisons
              Pass 2: n-2 comparisons
              ...
              Pass n-1: 1 comparison
              Total: (n-1) + (n-2) + ... + 1 = n(n-1)/2

            f(n) = n(n-1)/2 = n²/2 - n/2

            To prove: f(n) = O(n²)
            Need to find c, n₀ such that f(n) ≤ c × n² for all n ≥ n₀

            For n ≥ 1:
              n²/2 - n/2 ≤ n²/2 ≤ n²
              Choose c = 1, n₀ = 1

            Verification: n²/2 - n/2 ≤ 1 × n²?
              n²/2 ≤ n² + n/2  → TRUE for all n ≥ 1 ✓

            ∴ Bubble Sort is O(n²) with c=1, n₀=1

            ═══ PROOF 2: Merge Sort is O(n log n) ═══

            Recurrence relation: T(n) = 2T(n/2) + cn
              where cn is the merge step cost

            Solving by recurrence tree:
              Level 0 (root): cn work, 1 node
              Level 1: cn/2 work each, 2 nodes → total cn
              Level 2: cn/4 work each, 4 nodes → total cn
              ...
              Level k: cn/2^k work each, 2^k nodes → total cn
              ...
              Level log₂n (leaves): c work each, n nodes → total cn

            Total levels = log₂n + 1
            Total work = cn × (log₂n + 1) = cn log₂n + cn

            f(n) = cn log n + cn

            To prove f(n) = O(n log n):
              cn log n + cn ≤ C × n log n  for large n?
              Choose C = 2c, n₀ = 2:
                cn log n + cn ≤ 2c × n log n
                cn ≤ cn log n
                1 ≤ log n → true for n ≥ 2 ✓

            ∴ Merge Sort is O(n log n) with c₂=2c, n₀=2

            Also: Merge Sort always does EXACTLY this work regardless of input
            → Lower bound also Ω(n log n) → Tight bound: Θ(n log n)

            ═══ PROOF 3: Binary Search is O(log n) (bonus reference) ═══
            Each step halves search space: n, n/2, n/4, ..., 1
            Steps until 1: n/2^k = 1 → k = log₂n
            f(n) = log₂n ≤ 1 × log₂n for c=1, n₀=1 ✓
            """);

        // ── b) Algorithm Matching for Data Types ─────────────────────
        System.out.println("(b) ALGORITHM MATCHING FOR DATA TYPES");
        System.out.println("─".repeat(60));
        System.out.println("""
            Type A: NEARLY SORTED (90% in order) → Use INSERTION SORT
            ─────────────────────────────────────────────────────────
            • Best case: O(n) — when data is already sorted,
              inner while loop never executes (just compares).
            • Nearly sorted input approaches best case.
            • Each element is only slightly out of place → very few swaps.
            • Bubble Sort also has O(n) best case (with early termination),
              but Insertion Sort has lower constant factors in practice.
            • Why not Merge/Quick Sort? They're always Θ(n log n) or O(n log n)
              — they don't take advantage of existing order.
            Notation: Best case Ω(n), nearly sorted ≈ O(kn) where k is
            average displacement — effectively linear.

            Type B: COMPLETELY RANDOM → Use MERGE SORT
            ─────────────────────────────────────────────────────────
            • Merge Sort guarantees Θ(n log n) for ALL cases — no bad inputs.
            • Quick Sort is O(n log n) average but O(n²) worst case on some
              random inputs (rare but possible without randomization).
            • For production big-data pipelines, guaranteed performance is
              more valuable than slightly better average-case constants.
            • Merge Sort is stable (preserves relative order of equal keys).
            Notation: Θ(n log n) — exactly this, always.

            Type C: REVERSE SORTED (worst case ordering) → Use MERGE SORT
            ─────────────────────────────────────────────────────────
            • Bubble Sort: O(n²) — every element must move to opposite end.
            • Insertion Sort: O(n²) — each insertion requires full backward scan.
            • Quick Sort: O(n²) worst case — pivot is always smallest/largest
              with naive pivot selection on sorted/reverse-sorted data.
            • Merge Sort: Θ(n log n) always — unaffected by input order.
            • Merge Sort is the clear winner; it has no worst-case data pattern.
            Notation: Θ(n log n) even for reverse sorted data.

            Summary Table:
            ┌────────────────────┬──────────────────┬────────────────────────┐
            │ Data Type          │ Best Algorithm   │ Complexity             │
            ├────────────────────┼──────────────────┼────────────────────────┤
            │ A: Nearly Sorted   │ Insertion Sort   │ ~O(n) to O(n²)         │
            │ B: Random          │ Merge Sort       │ Θ(n log n) guaranteed  │
            │ C: Reverse Sorted  │ Merge Sort       │ Θ(n log n) guaranteed  │
            └────────────────────┴──────────────────┴────────────────────────┘
            """);

        // ── c) Θ vs O: Merge Sort vs Quick Sort ─────────────────────
        System.out.println("(c) Θ vs O: WHY MERGE SORT IS Θ(n log n) BUT QUICK SORT IS O(n log n)");
        System.out.println("─".repeat(60));
        System.out.println("""
            Big-O (O):    Upper bound — "at most this fast"
            Big-Theta (Θ): Tight bound — "exactly this rate (upper AND lower)"

            MERGE SORT — Θ(n log n):
              • Always divides array into exactly two halves.
              • Always merges both halves completely.
              • Every input of size n requires EXACTLY the same work pattern.
              • Best case = Worst case = Average case = n log n operations.
              → Both O(n log n) AND Ω(n log n) hold → Θ(n log n)

            QUICK SORT — O(n log n) for average, NOT Θ(n log n):
              • Performance depends critically on pivot selection.
              • Best/Average case: pivot splits array into two roughly equal halves
                → O(n log n) divisions
              • Worst case: pivot is always the minimum or maximum element
                → O(n) levels of recursion, each O(n) → O(n²) total
              • On reverse-sorted input with naive pivot, worst case occurs.
              • Lower bound: Ω(n log n) holds for average, but since worst case
                is Ω(n²), we CANNOT claim Θ(n log n) across all inputs.
              → Only O(n log n) (upper bound for average case), NOT Θ(n log n)

            The distinction in this context:
              Saying Merge Sort is Θ(n log n) means:
                "I guarantee you — no matter what — it costs EXACTLY n log n."
              Saying Quick Sort is O(n log n) means:
                "In the best and average case it's n log n, but it CAN be n²."
              This makes Merge Sort more PREDICTABLE for production pipelines.
            """);

        // ── d) Decision Tree ─────────────────────────────────────────
        System.out.println("(d) DECISION TREE FOR ALGORITHM SELECTION");
        System.out.println("─".repeat(60));
        System.out.println("""
            START: What is n (number of records)?
            │
            ├── n < 50  (SMALL)
            │   ├── Nearly sorted?    → Insertion Sort  O(n) best case
            │   ├── Random?           → Insertion Sort  Simple, low overhead
            │   └── Reverse sorted?  → Insertion Sort  Still fast for tiny n
            │       Reason: For tiny n, constant factors dominate.
            │               Insertion Sort has very low overhead and is cache-friendly.
            │
            ├── 50 ≤ n < 10,000  (MEDIUM)
            │   ├── Nearly sorted?    → Insertion Sort  O(n) ≈ near-linear
            │   ├── Random?           → Merge Sort or Quick Sort (n log n)
            │   └── Reverse sorted?  → Merge Sort       Avoids O(n²) edge case
            │       Reason: At medium size, asymptotic complexity begins to matter.
            │               Insertion Sort still viable for nearly sorted.
            │               Quick Sort risks O(n²) on bad pivot — use Merge Sort.
            │
            └── n ≥ 10,000  (LARGE)
                ├── Nearly sorted?    → Merge Sort or Timsort (hybrid)
                │                       (Timsort exploits existing runs)
                ├── Random?           → Merge Sort      Guaranteed Θ(n log n)
                └── Reverse sorted?  → Merge Sort       NEVER use Bubble/Insertion/QuickSort
                    Reason: Only algorithms with guaranteed O(n log n) worst case
                            are acceptable. Bubble/Insertion are O(n²) — catastrophic.
                            Quick Sort with random pivot is safe but less predictable.

            Final flowchart pseudocode:
              if n < 50:            use InsertionSort
              else if n < 10,000:
                if nearly_sorted:   use InsertionSort
                else:               use MergeSort
              else:  // n >= 10,000
                                    use MergeSort (or Timsort for mixed data)
            """);

        // ── e) Mystery Sort Break-Even ───────────────────────────────
        System.out.println("(e) MYSTERY SORT vs MERGE SORT: BREAK-EVEN ANALYSIS");
        System.out.println("─".repeat(60));

        System.out.println("""
            Given:
              Mystery Sort:  T_mystery(n) = 5n² + 100n + 1000
              Merge Sort:    T_merge(n)   = 10n × log₂(n)

            Find n where Mystery Sort is FASTER than Merge Sort:
              5n² + 100n + 1000 < 10n × log₂(n)

            Rearranging:
              5n² + 100n + 1000 - 10n × log₂(n) < 0

            This is not algebraically solvable in closed form — we use
            numerical analysis to find the crossover point.

            Checking values:
        """);

        System.out.printf("  %-10s | %-22s | %-22s | %s%n",
                "n", "Mystery(5n²+100n+1000)", "Merge(10n·log₂n)", "Mystery faster?");
        System.out.println("  " + "-".repeat(75));

        int[] checkPoints = {1, 2, 3, 4, 5, 6, 7, 8, 10, 15, 20, 50, 100};
        int crossover = -1;
        for (int n : checkPoints) {
            double mystery = 5.0 * n * n + 100.0 * n + 1000;
            double merge   = (n > 1) ? 10.0 * n * log2(n) : 0;
            boolean faster = mystery < merge;
            if (faster && crossover == -1) crossover = n;
            System.out.printf("  %-10d | %-22.1f | %-22.1f | %s%n",
                    n, mystery, merge, faster ? "✅ Yes" : "❌ No");
        }

        System.out.println("""

            Graphical Analysis:
              - For very small n (< ~4), Merge Sort's 10n·log₂n is very small
                (near 0 for n=1,2) and Mystery Sort's constant 1000 term dominates.
              - As n increases, the n² term in Mystery Sort grows quadratically
                and quickly overtakes 10n·log₂n.
              - The crossover point is around n ≈ 3–5.

            CONCLUSION:
              Mystery Sort (5n²+100n+1000) is ONLY faster for n ≤ ~3-4.
              For n ≥ 5, Merge Sort (10n log n) is definitively faster.
              For large n (thousands or millions), Mystery Sort is astronomically
              slower: at n=1,000, Mystery ≈ 5,100,000 vs Merge ≈ 99,657 operations.

              In asymptotic terms:
                Mystery Sort is O(n²) — the 5n² term dominates.
                Merge Sort is Θ(n log n).
                Since n² grows faster than n log n, Merge Sort wins for all
                sufficiently large n regardless of constants.
        """);

        // ── Live Sorting Demo ────────────────────────────────────────
        System.out.println("─".repeat(60));
        System.out.println("LIVE DEMO: Sorting algorithms on sample data");
        int[] data1 = {64, 34, 25, 12, 22, 11, 90};
        int[] data2 = data1.clone();
        int[] data3 = data1.clone();

        System.out.print("Input:          ");
        for (int x : data1) System.out.print(x + " ");
        System.out.println();

        bubbleSort(data1);
        System.out.print("Bubble Sort:    ");
        for (int x : data1) System.out.print(x + " ");
        System.out.println();

        mergeSort(data2, 0, data2.length - 1);
        System.out.print("Merge Sort:     ");
        for (int x : data2) System.out.print(x + " ");
        System.out.println();

        insertionSort(data3);
        System.out.print("Insertion Sort: ");
        for (int x : data3) System.out.print(x + " ");
        System.out.println();
    }
}
