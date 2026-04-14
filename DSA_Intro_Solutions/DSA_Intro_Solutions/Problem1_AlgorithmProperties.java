/*
 * ============================================================
 * Problem 1: Algorithm Properties and Correctness
 * ============================================================
 * Scenario: A weather forecasting system calculates average
 * temperature over n days. Two algorithms are proposed.
 *
 * This file contains:
 *  a) Evaluation of both algorithms against 5 properties
 *  b) Step-by-step execution with test input
 *  c) Identification of logical error in Algorithm B
 *  d) Comparison and recommendation
 *  e) Test strategy with 5+ test cases
 * ============================================================
 */

public class Problem1_AlgorithmProperties {

    // ── Algorithm A Implementation ────────────────────────────────────
    static double algorithmA(double[] temperature, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total = total + temperature[i];
        }
        double average = total / n;
        return average;
    }

    // ── Algorithm B Implementation (has a logical error) ─────────────
    static double algorithmB(double[] temperature, int n) {
        double sum = temperature[0];
        for (int i = 1; i < n; i++) {
            sum = sum + temperature[i];       // Step: sum all temperatures
        }
        for (int i = 0; i < n; i++) {
            sum = sum / n;                    // BUG: divides by n, n times!
        }
        return sum;
    }

    // ── Algorithm A (Corrected version of B) ─────────────────────────
    static double algorithmB_Fixed(double[] temperature, int n) {
        double sum = temperature[0];
        for (int i = 1; i < n; i++) {
            sum = sum + temperature[i];
        }
        sum = sum / n;                        // Divide ONCE — correct
        return sum;
    }

    // ── Step-by-step trace of Algorithm A ────────────────────────────
    static void traceAlgorithmA(double[] temps, int n) {
        System.out.println("  --- Algorithm A Trace ---");
        double total = 0;
        System.out.println("  Step 0: total = 0");
        for (int i = 0; i < n; i++) {
            total += temps[i];
            System.out.printf("  Step %d: total = total + %.1f = %.1f%n",
                    i + 1, temps[i], total);
        }
        double avg = total / n;
        System.out.printf("  Step %d: average = %.1f / %d = %.4f%n",
                n + 1, total, n, avg);
        System.out.printf("  Result: %.4f%n%n", avg);
    }

    // ── Step-by-step trace of Algorithm B ────────────────────────────
    static void traceAlgorithmB(double[] temps, int n) {
        System.out.println("  --- Algorithm B Trace ---");
        double sum = temps[0];
        System.out.printf("  Step 0: sum = %.1f%n", sum);
        for (int i = 1; i < n; i++) {
            sum += temps[i];
            System.out.printf("  Step %d (loop1): sum = sum + %.1f = %.1f%n",
                    i, temps[i], sum);
        }
        System.out.printf("  After Loop 1: sum = %.1f%n", sum);
        System.out.println("  Loop 2 (THE BUG — divides n times instead of once):");
        for (int i = 0; i < n; i++) {
            sum = sum / n;
            System.out.printf("  Step %d (loop2): sum = sum / %d = %.6f%n",
                    i + 1, n, sum);
        }
        System.out.printf("  Result: %.6f  ← WRONG!%n%n", sum);
    }

    // ── Test Runner ───────────────────────────────────────────────────
    static void runTest(String label, double[] temps, int n, double expected) {
        if (n == 0) {
            System.out.printf("  %-35s | Expected: %-10s | AlgoA: Division by zero (handle edge case)%n",
                    label, expected);
            return;
        }
        double resultA = algorithmA(temps, n);
        System.out.printf("  %-35s | Expected: %-10.4f | AlgoA: %-10.4f | Pass: %s%n",
                label, expected, resultA,
                Math.abs(resultA - expected) < 0.001 ? "YES" : "NO");
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println(" Problem 1: Algorithm Properties and Correctness");
        System.out.println("============================================================\n");

        // ── a) Five Properties Evaluation ───────────────────────────
        System.out.println("(a) EVALUATION AGAINST 5 FUNDAMENTAL PROPERTIES");
        System.out.println("─".repeat(60));

        System.out.println("""
            ALGORITHM A:
            ┌─────────────┬────────────────────────────────────────────────┐
            │ Property    │ Evaluation                                     │
            ├─────────────┼────────────────────────────────────────────────┤
            │ Input       │ ✅ Takes temperature array and n (well-defined) │
            │ Output      │ ✅ Returns average (single, well-defined value) │
            │ Definiteness│ ✅ Every step is clear and unambiguous          │
            │ Finiteness  │ ✅ Loop runs exactly n times then stops         │
            │ Effectiveness│ ✅ All steps (add, divide) are basic ops       │
            └─────────────┴────────────────────────────────────────────────┘
            → Algorithm A SATISFIES all 5 properties.

            ALGORITHM B:
            ┌─────────────┬────────────────────────────────────────────────┐
            │ Property    │ Evaluation                                     │
            ├─────────────┼────────────────────────────────────────────────┤
            │ Input       │ ✅ Takes temperature array and n               │
            │ Output      │ ✅ Returns a value (but incorrect)             │
            │ Definiteness│ ✅ Each step is clear                          │
            │ Finiteness  │ ✅ Both loops terminate after finite steps      │
            │ Effectiveness│ ✅ All steps are basic operations             │
            └─────────────┴────────────────────────────────────────────────┘
            → Algorithm B SATISFIES all 5 structural properties,
              BUT produces INCORRECT output due to a logical error.
              (Satisfying properties ≠ Correctness!)
            """);

        // ── b) Step-by-step execution ────────────────────────────────
        System.out.println("(b) STEP-BY-STEP EXECUTION");
        System.out.println("─".repeat(60));
        double[] temps = {20, 25, 22, 24, 21};
        int n = 5;
        double expectedAvg = 22.4;
        System.out.println("Input: temperatures = [20, 25, 22, 24, 21], n = 5");
        System.out.printf("Expected Average = (20+25+22+24+21)/5 = 112/5 = %.1f%n%n", expectedAvg);

        traceAlgorithmA(temps, n);
        traceAlgorithmB(temps, n);

        System.out.printf("→ Algorithm A produces: %.1f ✅ (CORRECT)%n", algorithmA(temps, n));
        System.out.printf("→ Algorithm B produces: %.6f ❌ (WRONG)%n%n", algorithmB(temps, n));

        // ── c) Logical Error in Algorithm B ─────────────────────────
        System.out.println("(c) LOGICAL ERROR IN ALGORITHM B");
        System.out.println("─".repeat(60));
        System.out.println("""
            ERROR IDENTIFIED:
            Loop 2 in Algorithm B divides `sum` by n a total of n times.
            This is mathematically equivalent to dividing by n^n, not n.

            Mathematical proof of the error:
              Correct:   average = (sum) / n = 112 / 5 = 22.4
              Algorithm B: sum / n / n / n / n / n = sum / n^5
                         = 112 / 5^5 = 112 / 3125 ≈ 0.03584

            Mathematical Principle Violated:
              The DIVISION OPERATION is not idempotent — applying it
              multiple times changes the result each time.
              The algorithm should divide ONCE by n (scalar division),
              not n times. This violates the intended formula:
                  average = Σ(temperature[i]) / n

            FIX: Replace the entire second loop with a single statement:
              sum = sum / n;   // divide once, outside any loop
            """);

        // ── d) Comparison and Recommendation ────────────────────────
        System.out.println("(d) COMPARISON AND RECOMMENDATION");
        System.out.println("─".repeat(60));
        System.out.println("""
            ┌─────────────┬──────────────────────────┬──────────────────────┐
            │ Criterion   │ Algorithm A              │ Algorithm B          │
            ├─────────────┼──────────────────────────┼──────────────────────┤
            │ Correctness │ ✅ Always correct         │ ❌ Logically wrong   │
            │ Simplicity  │ ✅ Clean, readable        │ ❌ Unnecessarily      │
            │             │                          │    complex (2 loops) │
            │ Efficiency  │ O(n) time, O(1) space    │ O(n) time, O(1)space │
            │             │ (1 pass through data)    │ (2 passes — wasteful)│
            │ Generality  │ ✅ Works for any n ≥ 1   │ ❌ Produces wrong    │
            │             │                          │    results always    │
            └─────────────┴──────────────────────────┴──────────────────────┘

            RECOMMENDATION: Deploy ALGORITHM A for production.
            Reasons:
              1. Correctness is NON-NEGOTIABLE in production — Algorithm B fails.
              2. Algorithm A is simpler and more readable.
              3. Both have the same time complexity O(n), but Algorithm A
                 completes in one pass vs two unnecessary passes in B.
              4. Simpler code means fewer bugs and easier maintenance.
            """);

        // ── e) Test Strategy ─────────────────────────────────────────
        System.out.println("(e) TEST STRATEGY — Algorithm A");
        System.out.println("─".repeat(60));
        System.out.printf("  %-35s | %-12s | %-12s | %s%n",
                "Test Case", "Expected", "AlgoA Result", "Pass?");
        System.out.println("  " + "-".repeat(80));

        // TC1: Standard input
        runTest("TC1: Normal [20,25,22,24,21], n=5",
                temps, 5, 22.4);

        // TC2: Single element
        runTest("TC2: Single element [15], n=1",
                new double[]{15}, 1, 15.0);

        // TC3: All same values
        runTest("TC3: All same [10,10,10], n=3",
                new double[]{10, 10, 10}, 3, 10.0);

        // TC4: Negative temperatures
        runTest("TC4: Negatives [-5,-3,-10,-2], n=4",
                new double[]{-5, -3, -10, -2}, 4, -5.0);

        // TC5: Mixed positive/negative
        runTest("TC5: Mixed [-10,0,10,20], n=4",
                new double[]{-10, 0, 10, 20}, 4, 5.0);

        // TC6: Large n
        double[] large = new double[1000];
        for (int i = 0; i < 1000; i++) large[i] = i + 1;
        runTest("TC6: n=1000, values 1-1000",
                large, 1000, 500.5);

        // TC7: All zeros
        runTest("TC7: All zeros [0,0,0,0], n=4",
                new double[]{0, 0, 0, 0}, 4, 0.0);

        System.out.println("\n  TC8 (Edge case n=0): Division by zero → must validate n > 0");
        System.out.println("  → Add guard: if (n <= 0) throw IllegalArgumentException(\"n must be > 0\")");

        System.out.println("\nAll standard test cases pass for Algorithm A. ✅");
    }
}
