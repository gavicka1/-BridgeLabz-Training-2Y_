/**
 * Q5: Circular Tour Problem (Petrol Pump / Gas Station)
 *
 * Problem: There are N petrol pumps arranged in a circle. Each pump[i] gives
 *          petrol[i] litres and is `distance[i]` km from the next pump.
 *          A truck starts with an empty tank. Find the index of the starting
 *          pump that allows the truck to complete the full circle, or -1
 *          if no such pump exists.
 *
 * Approach (Single-pass O(n)):
 *   - Compute net[i] = petrol[i] - distance[i] (surplus/deficit at each pump).
 *   - Track `totalSurplus` (overall balance) and `currentSurplus`.
 *   - If `currentSurplus` drops below 0, the current start cannot work.
 *     Reset start to i+1 and reset currentSurplus to 0.
 *   - If `totalSurplus >= 0` at the end, return `start`; else return -1.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */

public class Q5_Circular_Tour_Problem {

    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int p, int d) { petrol = p; distance = d; }
    }

    static int findStartingPump(PetrolPump[] pumps) {
        int n            = pumps.length;
        int totalSurplus = 0;
        int currSurplus  = 0;
        int start        = 0;

        for (int i = 0; i < n; i++) {
            int net = pumps[i].petrol - pumps[i].distance;
            totalSurplus += net;
            currSurplus  += net;

            // Can't reach the next pump from current start — reset
            if (currSurplus < 0) {
                start       = i + 1;
                currSurplus = 0;
            }
        }

        // If total balance is negative, a complete circle is impossible
        return (totalSurplus >= 0) ? start : -1;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Circular Tour Problem ===\n");

        // Test 1: feasible tour
        PetrolPump[] pumps1 = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        int result1 = findStartingPump(pumps1);
        System.out.println("Test 1 — Starting pump index: " + result1);
        System.out.println("  (Expected: 1, i.e. pump with 6 petrol / 5 km)\n");

        // Test 2: another feasible example
        PetrolPump[] pumps2 = {
            new PetrolPump(2, 3),
            new PetrolPump(3, 4),
            new PetrolPump(5, 2),
            new PetrolPump(1, 3),
            new PetrolPump(6, 2)
        };
        int result2 = findStartingPump(pumps2);
        System.out.println("Test 2 — Starting pump index: " + result2);
        System.out.println("  (Expected: 2)\n");

        // Test 3: no solution
        PetrolPump[] pumps3 = {
            new PetrolPump(1, 5),
            new PetrolPump(2, 3),
            new PetrolPump(1, 4)
        };
        int result3 = findStartingPump(pumps3);
        System.out.println("Test 3 — Starting pump index: " + result3);
        System.out.println("  (Expected: -1, tour not possible)\n");

        /*
         * Walkthrough for Test 1 (net values: -2, +1, +4, -1):
         *   i=0: curr=-2 < 0 → reset start=1, curr=0
         *   i=1: curr=1, start=1
         *   i=2: curr=5, start=1
         *   i=3: curr=4, start=1
         *   totalSurplus = -2+1+4-1 = 2 >= 0 → answer = 1
         */
    }
}
