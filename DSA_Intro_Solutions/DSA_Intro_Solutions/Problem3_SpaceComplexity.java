/*
 * ============================================================
 * Problem 3: Space Complexity and Space-Time Tradeoffs
 * ============================================================
 * Scenario: E-learning platform checks if a student has
 * completed all prerequisite courses before enrollment.
 *
 * Implementation A: Nested Loop  → O(n×m) time, O(1) space
 * Implementation B: Hash Set     → O(n+m) time, O(n) space
 *
 * This file contains:
 *  a) Time complexity analysis of both implementations
 *  b) Space complexity analysis of both implementations
 *  c) Concrete calculations for typical/daily usage
 *  d) Infrastructure constraint analysis & recommendation
 *  e) Hybrid approach proposal with threshold
 * ============================================================
 */

import java.util.HashSet;

public class Problem3_SpaceComplexity {

    // ── Implementation A: Nested Loop ────────────────────────────────
    static boolean implA(int[] completedCourses, int[] prerequisites) {
        int n = completedCourses.length;
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (prerequisites[i] == completedCourses[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    // ── Implementation B: Hash Set ────────────────────────────────────
    static boolean implB(int[] completedCourses, int[] prerequisites) {
        HashSet<Integer> completedSet = new HashSet<>();
        for (int course : completedCourses) {
            completedSet.add(course);           // O(n) to build hash set
        }
        for (int prereq : prerequisites) {
            if (!completedSet.contains(prereq)) // O(1) per lookup
                return false;
        }
        return true;
    }

    // ── Hybrid: use A for small m, B for large m ──────────────────────
    static boolean hybrid(int[] completedCourses, int[] prerequisites, int threshold) {
        if (prerequisites.length <= threshold) {
            return implA(completedCourses, prerequisites);
        }
        return implB(completedCourses, prerequisites);
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println(" Problem 3: Space Complexity and Space-Time Tradeoffs");
        System.out.println("============================================================\n");

        // ── a) Time Complexity Analysis ──────────────────────────────
        System.out.println("(a) TIME COMPLEXITY ANALYSIS");
        System.out.println("─".repeat(60));
        System.out.println("""
            Variables:
              n = number of completed courses
              m = number of prerequisite courses required

            Implementation A (Nested Loop):
              Outer loop: runs m times (for each prerequisite)
              Inner loop: runs up to n times (scan completed courses)
              Worst case: no early break found — full inner scan for each prereq
              Total operations: m × n comparisons

              Step-by-step count:
                i=0: up to n comparisons
                i=1: up to n comparisons
                ...
                i=m-1: up to n comparisons
                Total = m × n

              Time Complexity: O(n × m)

            Implementation B (Hash Set):
              Phase 1 — Build hash set: loop over n completed courses
                → n hash insertions = O(n)
              Phase 2 — Check prerequisites: loop over m prerequisites
                → m hash lookups, each O(1) average = O(m)
              Total = O(n) + O(m) = O(n + m)

              Step-by-step count:
                Build set: n operations
                Check prereqs: m operations
                Total = n + m

              Time Complexity: O(n + m)

            Comparison:
              For n=40, m=5: A = 40×5 = 200 ops  |  B = 40+5 = 45 ops
              B is 200/45 ≈ 4.4× faster in this typical case.
              Gap grows as n and m increase.
            """);

        // ── b) Space Complexity Analysis ─────────────────────────────
        System.out.println("(b) SPACE COMPLEXITY ANALYSIS");
        System.out.println("─".repeat(60));
        System.out.println("""
            Implementation A (Nested Loop):
              Variables used: i (int), j (int), found (boolean)
              All are single, fixed-size variables.
              No extra data structures created.
              Space = 3 variables (constant)
              Auxiliary Space Complexity: O(1)

            Implementation B (Hash Set):
              Creates a HashSet with one entry per completed course.
              Size of hash set = n entries
              Each entry: key (int/Integer object ≈ 16 bytes in Java)
              Total auxiliary space = n × overhead per entry
              Auxiliary Space Complexity: O(n)

            Note: Both receive the same input arrays — those are input space,
            not counted in auxiliary space complexity.
            """);

        // ── c) Concrete Calculations ─────────────────────────────────
        System.out.println("(c) CONCRETE CALCULATIONS");
        System.out.println("─".repeat(60));

        int n = 40;     // completed courses per student
        int m = 5;      // prerequisites
        int studentsPerDay = 100_000;
        int bytesPerEntry  = 8;

        long comparisonsA_perCheck = (long) n * m;
        long comparisonsA_perDay   = comparisonsA_perCheck * studentsPerDay;

        long memB_perCheck_bytes   = (long) n * bytesPerEntry;
        long memB_perDay_bytes     = memB_perCheck_bytes * studentsPerDay;
        double memB_perDay_MB      = memB_perDay_bytes / (1024.0 * 1024.0);
        double memB_perDay_GB      = memB_perDay_MB / 1024.0;

        System.out.printf("Given: n=%d completed, m=%d prerequisites, %,d students/day%n%n",
                n, m, studentsPerDay);

        System.out.println("Implementation A — Total comparisons per day:");
        System.out.printf("  Per check  = %d × %d = %d comparisons%n", n, m, comparisonsA_perCheck);
        System.out.printf("  Per day    = %d × %,d = %,d comparisons%n",
                comparisonsA_perCheck, studentsPerDay, comparisonsA_perDay);

        System.out.printf("%nImplementation B — Memory usage per day:%n");
        System.out.printf("  Per check  = %d entries × %d bytes = %d bytes%n",
                n, bytesPerEntry, memB_perCheck_bytes);
        System.out.printf("  Per day (sequential) = %d × %,d = %,d bytes = %.2f MB%n",
                memB_perCheck_bytes, studentsPerDay, memB_perDay_bytes, memB_perDay_MB);
        System.out.println("  Note: Hash sets are created and discarded per request.");
        System.out.println("        Peak concurrent usage matters more than total/day.\n");

        // ── d) Infrastructure Constraint Analysis ────────────────────
        System.out.println("(d) INFRASTRUCTURE CONSTRAINT ANALYSIS");
        System.out.println("─".repeat(60));

        int concurrentRequests = 10_000;
        double usPerComparison = 0.1;  // microseconds per comparison
        double maxResponseMs   = 10.0; // 10ms limit
        double maxMemoryGB     = 1.0;  // 1 GB limit

        // Implementation A timing
        double opsA         = (double) n * m;
        double timeA_us     = opsA * usPerComparison;
        double timeA_ms     = timeA_us / 1000.0;

        // Implementation B timing
        double opsB         = n + m;
        double timeB_us     = opsB * usPerComparison;
        double timeB_ms     = timeB_us / 1000.0;

        // Implementation B memory for all concurrent requests
        double memB_concurrent_bytes = (long) concurrentRequests * n * bytesPerEntry;
        double memB_concurrent_MB    = memB_concurrent_bytes / (1024.0 * 1024.0);
        double memB_concurrent_GB    = memB_concurrent_MB / 1024.0;

        System.out.printf("Constraints: Response < %.0f ms | Memory < %.0f GB | %,d concurrent%n%n",
                maxResponseMs, maxMemoryGB, concurrentRequests);

        System.out.printf("Implementation A:%n");
        System.out.printf("  Operations = %d × %d = %d ops per check%n", n, m, (int)opsA);
        System.out.printf("  Response time = %.0f ops × %.1f µs = %.1f µs = %.3f ms%n",
                opsA, usPerComparison, timeA_us, timeA_ms);
        System.out.printf("  Within 10ms limit? %s%n", timeA_ms <= maxResponseMs ? "✅ YES" : "❌ NO");
        System.out.println("  Memory = O(1) — only fixed variables → negligible ✅");

        System.out.printf("%nImplementation B:%n");
        System.out.printf("  Operations = %d + %d = %d ops per check%n", n, m, (int)opsB);
        System.out.printf("  Response time = %.0f ops × %.1f µs = %.1f µs = %.4f ms%n",
                opsB, usPerComparison, timeB_us, timeB_ms);
        System.out.printf("  Within 10ms limit? %s%n", timeB_ms <= maxResponseMs ? "✅ YES" : "❌ NO");
        System.out.printf("  Concurrent memory = %,d × %d × %d bytes = %.2f MB%n",
                concurrentRequests, n, bytesPerEntry, memB_concurrent_MB);
        System.out.printf("  Within 1GB limit? %s (%.2f GB used)%n",
                memB_concurrent_GB <= maxMemoryGB ? "✅ YES" : "❌ NO", memB_concurrent_GB);

        System.out.println("""

            RECOMMENDATION: Use Implementation B (Hash Set)
              1. Response time: A=0.200ms, B=0.045ms — both within 10ms,
                 but B is 4.4× faster, leaving more headroom for growth.
              2. Memory: B uses only ~3.05 MB for 10,000 concurrent requests,
                 far below the 1GB limit.
              3. As n or m grows, B's O(n+m) will continue to win over A's O(n×m).
              4. Both constraints are met by B with significant margin.
            """);

        // ── e) Hybrid Approach ───────────────────────────────────────
        System.out.println("(e) HYBRID APPROACH PROPOSAL");
        System.out.println("─".repeat(60));
        System.out.println("""
            Strategy:
              - For very small m (few prerequisites): use Implementation A.
                Reason: Overhead of creating a HashSet is not worth it for
                tiny m. The hash set creation cost O(n) dominates when m ≈ 1-2.
              - For large m: use Implementation B (Hash Set).
                Reason: O(n+m) vs O(n×m) difference is massive.

            Break-even analysis:
              Cost of A = n × m
              Cost of B = n + m   (build set O(n) + lookups O(m))

              A ≤ B when: n × m ≤ n + m
                → nm - n - m ≤ 0
                → nm - n - m + 1 ≤ 1
                → (n-1)(m-1) ≤ 1
                → m ≤ 1 + 1/(n-1)

              For n = 40: m ≤ 1 + 1/39 ≈ 1.026 → effectively m = 1

            THRESHOLD RECOMMENDATION: m_threshold = 2
              • If m ≤ 2: Use Implementation A (avoid hash set overhead)
              • If m > 2: Use Implementation B (hash set pays off quickly)

            Practical hybrid code:
              if (prerequisites.length <= 2) {
                  return nestedLoopCheck(completedCourses, prerequisites);
              } else {
                  return hashSetCheck(completedCourses, prerequisites);
              }
        """);

        // Live demo
        System.out.println("─".repeat(60));
        System.out.println("LIVE DEMO");
        int[] completed    = {101, 102, 103, 104, 105, 106};
        int[] prereqs5     = {101, 102, 103, 104, 105};  // all satisfied
        int[] prereqsMiss  = {101, 102, 107};             // 107 missing

        System.out.println("Completed courses : [101, 102, 103, 104, 105, 106]");
        System.out.println("Prerequisites A   : [101, 102, 103, 104, 105]");
        System.out.println("Prerequisites B   : [101, 102, 107]  ← 107 missing");

        System.out.printf("%nImpl A check (prereqs A): %s%n", implA(completed, prereqs5));
        System.out.printf("Impl B check (prereqs A): %s%n", implB(completed, prereqs5));
        System.out.printf("Impl A check (prereqs B): %s%n", implA(completed, prereqsMiss));
        System.out.printf("Impl B check (prereqs B): %s%n", implB(completed, prereqsMiss));
        System.out.printf("Hybrid(thresh=2, A):      %s%n", hybrid(completed, prereqs5, 2));
    }
}
