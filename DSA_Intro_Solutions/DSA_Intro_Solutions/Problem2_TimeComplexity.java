/*
 * ============================================================
 * Problem 2: Time Complexity Analysis and Comparison
 * ============================================================
 * Scenario: Social media platform (10M → 100M users) needs
 * username verification. Three algorithms are compared:
 *   A: Linear Search   O(n)
 *   B: Binary Search   O(log n)
 *   C: Hash Table      O(1)
 *
 * This file contains:
 *  a) Exact worst-case operations for 10M users
 *  b) Big-O notation with mathematical justification
 *  c) Comparison table across varying n values
 *  d) Load calculation at 50,000 checks/second
 *  e) Break-even analysis for sort + binary search
 * ============================================================
 */

public class Problem2_TimeComplexity {

    // ── Algorithm A: Linear Search ────────────────────────────────────
    static int linearSearch(String[] userList, String target) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].equals(target)) return i;
        }
        return -1;
    }

    // ── Algorithm B: Binary Search ────────────────────────────────────
    static boolean binarySearch(String[] sortedList, String target) {
        int left = 0, right = sortedList.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sortedList[mid].compareTo(target);
            if (cmp == 0)      return true;
            else if (cmp < 0)  left = mid + 1;
            else               right = mid - 1;
        }
        return false;
    }

    // ── Algorithm C: Hash Table ──────────────────────────────────────
    static boolean hashTableLookup(java.util.HashSet<String> table, String target) {
        return table.contains(target);  // O(1) average
    }

    // ── Helper: log base 2 ───────────────────────────────────────────
    static double log2(double n) { return Math.log(n) / Math.log(2); }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println(" Problem 2: Time Complexity Analysis and Comparison");
        System.out.println("============================================================\n");

        // ── a) Exact Operations for 10 Million Users ─────────────────
        System.out.println("(a) EXACT WORST-CASE OPERATIONS FOR n = 10,000,000 USERS");
        System.out.println("─".repeat(60));

        long n = 10_000_000L;
        long opsA = n;                           // Linear: n comparisons
        long opsB = (long) Math.ceil(log2(n));   // Binary: log2(n) comparisons
        long opsC = 1;                           // Hash:   1 lookup

        System.out.println("Algorithm A (Linear Search):");
        System.out.println("  Worst case = key not found → scan entire list");
        System.out.println("  Operations = n = " + String.format("%,d", opsA) + " comparisons");

        System.out.printf("%nAlgorithm B (Binary Search):%n");
        System.out.println("  Worst case = key not found after exhausting search space");
        System.out.printf("  Iterations = ⌈log₂(%,d)⌉ = ⌈%.3f⌉ = %d comparisons%n",
                n, log2(n), opsB);
        System.out.println("  (Each step halves the remaining search space)");

        System.out.printf("%nAlgorithm C (Hash Table):%n");
        System.out.println("  Hash function maps key → bucket → O(1) lookup");
        System.out.println("  Operations = " + opsC + " (constant, independent of n)");

        System.out.printf("%nSummary: A=%,d ops  |  B=%d ops  |  C=%d op%n%n",
                opsA, opsB, opsC);

        // ── b) Big-O Justification ───────────────────────────────────
        System.out.println("(b) BIG-O NOTATION WITH MATHEMATICAL JUSTIFICATION");
        System.out.println("─".repeat(60));
        System.out.println("""
            Algorithm A — O(n):
              f(n) = number of comparisons in worst case = n
              Show: n ≤ c × n for all n ≥ n₀
              Choose c = 1, n₀ = 1 → n ≤ 1 × n ✓
              ∴ Linear Search is O(n)

            Algorithm B — O(log n):
              Each iteration halves the search space:
                Iteration 1: n elements
                Iteration 2: n/2 elements
                Iteration k: n/2^k elements
              Algorithm stops when n/2^k = 1 → k = log₂(n)
              f(n) = log₂(n)
              Show: log₂(n) ≤ c × log₂(n) for c = 1, n₀ = 1 ✓
              ∴ Binary Search is O(log n)

            Algorithm C — O(1):
              Hash function: index = hash(key) % table_size
              Direct access to bucket: constant regardless of n
              f(n) = k (constant, typically 1-3 steps)
              Show: k ≤ c × 1 for c = k, n₀ = 1 ✓
              ∴ Hash Table Lookup is O(1)
            """);

        // ── c) Comparison Table ──────────────────────────────────────
        System.out.println("(c) COMPARISON TABLE: Operations vs Input Size");
        System.out.println("─".repeat(60));
        long[] sizes = {100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000};

        System.out.printf("  %-15s | %-18s | %-12s | %-8s%n",
                "n (users)", "A: Linear O(n)", "B: Binary O(log n)", "C: Hash O(1)");
        System.out.println("  " + "-".repeat(65));
        for (long sz : sizes) {
            System.out.printf("  %-15s | %-18s | %-18s | %-8d%n",
                    String.format("%,d", sz),
                    String.format("%,d", sz),
                    String.format("%d", (long) Math.ceil(log2(sz))),
                    1);
        }
        System.out.println("""

            Patterns observed:
              • Algorithm A grows LINEARLY — 10x more users = 10x more ops.
              • Algorithm B grows LOGARITHMICALLY — going from 100 to 10M users
                only increases operations from ~7 to ~24. Extremely scalable.
              • Algorithm C stays CONSTANT at 1 regardless of user count.
              • At 10M users, A needs 10,000,000x more work than C.
            """);

        // ── d) Load Analysis at 50,000 checks/second ────────────────
        System.out.println("(d) LOAD ANALYSIS: 50,000 username checks/second");
        System.out.println("─".repeat(60));

        long checksPerSec  = 50_000L;
        double nsPerComp   = 1.0;          // 1 nanosecond per comparison

        double timeA_ns    = checksPerSec * n * nsPerComp;
        double timeA_ms    = timeA_ns / 1_000_000.0;
        double timeA_s     = timeA_ms / 1000.0;

        long   binaryOps   = (long) Math.ceil(log2(n));
        double timeB_ns    = checksPerSec * binaryOps * nsPerComp;
        double timeB_ms    = timeB_ns / 1_000_000.0;

        double timeC_ns    = checksPerSec * 1 * nsPerComp;
        double timeC_ms    = timeC_ns / 1_000_000.0;

        System.out.println("Given: 50,000 checks/second, 1 ns per comparison, n = 10,000,000");
        System.out.printf("%nAlgorithm A (Linear):%n");
        System.out.printf("  Time = 50,000 × %,d ops × 1ns = %.2e ns = %.2f ms/sec%n",
                n, timeA_ns, timeA_ms);
        System.out.printf("  = %.2f seconds of CPU time per second → CANNOT keep up ❌%n", timeA_s);

        System.out.printf("%nAlgorithm B (Binary):%n");
        System.out.printf("  Time = 50,000 × %d ops × 1ns = %.0f ns = %.4f ms/sec%n",
                binaryOps, timeB_ns, timeB_ms);
        System.out.printf("  = %.6f seconds of CPU time per second → Can handle load ✅%n",
                timeB_ns / 1_000_000_000.0);

        System.out.printf("%nAlgorithm C (Hash):%n");
        System.out.printf("  Time = 50,000 × 1 op × 1ns = %.0f ns = %.4f ms/sec%n",
                timeC_ns, timeC_ms);
        System.out.println("  Fastest by far — trivially handles load ✅");

        System.out.printf("%n→ Recommendation: Use Algorithm C (Hash Table) or B (Binary Search).%n");
        System.out.println("  Algorithm A is completely infeasible at this scale.\n");

        // ── e) Break-even for Sort + Binary Search ───────────────────
        System.out.println("(e) BREAK-EVEN: When is Sort + Binary Search worthwhile?");
        System.out.println("─".repeat(60));
        System.out.println("""
            Total cost of k searches:
              With Linear Search:    k × n
              With Sort + Binary:    n×log(n)  +  k × log(n)
                                     (sort once)  (each search)

            Break-even point: when Sort+Binary costs ≤ Linear cost
              n×log(n) + k×log(n) ≤ k×n
              n×log(n) ≤ k×n - k×log(n)
              n×log(n) ≤ k × (n - log(n))
              k ≥ n×log(n) / (n - log(n))

            Formula:
              k_breakeven = ⌈ n × log₂(n) / (n - log₂(n)) ⌉

            Calculation for n = 10,000,000:
        """);

        double logN     = log2(n);
        double breakEven = n * logN / (n - logN);
        System.out.printf("  k_breakeven = %,d × %.2f / (%,d - %.2f)%n", n, logN, n, logN);
        System.out.printf("             = %.0f / %.0f%n", n * logN, n - logN);
        System.out.printf("             ≈ %.2f%n%n", breakEven);
        System.out.println("  → If you need just ~24 or more searches on 10M users,");
        System.out.println("    sorting once and using binary search is already worthwhile.");
        System.out.println("  → In practice (50,000 checks/sec), sorting is ALWAYS worth it.");
        System.out.println("  → But Hash Table (Algorithm C) is still the best choice overall.");
    }
}
