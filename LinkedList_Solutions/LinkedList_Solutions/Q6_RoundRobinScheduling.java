/**
 * Q6: Circular Linked List - Round Robin CPU Scheduling
 *
 * Operations:
 *  1. Add process at end of circular list
 *  2. Remove process by Process ID after execution
 *  3. Simulate round-robin scheduling with fixed time quantum
 *  4. Display processes after each round
 *  5. Calculate and display average waiting time and turnaround time
 */
public class Q6_RoundRobinScheduling {

    // ── Node ─────────────────────────────────────────────────────────
    static class Process {
        int    pid, burstTime, remainingTime, priority;
        int    waitingTime, turnaroundTime, completionTime;
        String name;
        Process next;

        Process(int pid, String name, int burstTime, int priority) {
            this.pid           = pid;
            this.name          = name;
            this.burstTime     = burstTime;
            this.remainingTime = burstTime;
            this.priority      = priority;
        }
    }

    // ── Circular Linked List ─────────────────────────────────────────
    static class Scheduler {
        Process head, tail;
        int size;

        boolean isEmpty() { return head == null; }

        // 1. Add process at end
        void addProcess(int pid, String name, int burst, int priority) {
            Process node = new Process(pid, name, burst, priority);
            if (head == null) {
                head = tail = node;
                node.next = head;
            } else {
                tail.next = node;
                node.next = head;
                tail      = node;
            }
            size++;
            System.out.printf("Added Process P%d (%s) | Burst: %d | Priority: %d%n",
                    pid, name, burst, priority);
        }

        // 2. Remove by PID
        void removeProcess(int pid) {
            if (head == null) return;
            if (head == tail && head.pid == pid) { head = tail = null; size--; return; }
            if (head.pid == pid) {
                head      = head.next;
                tail.next = head;
                size--; return;
            }
            Process prev = head, cur = head.next;
            while (cur != head && cur.pid != pid) { prev = cur; cur = cur.next; }
            if (cur == head) return;
            if (cur == tail) tail = prev;
            prev.next = cur.next;
            size--;
        }

        // Display current queue
        void displayQueue() {
            if (head == null) { System.out.println("  (Queue empty)"); return; }
            System.out.print("  Queue → ");
            Process cur = head;
            do {
                System.out.printf("P%d(rem:%d) ", cur.pid, cur.remainingTime);
                cur = cur.next;
            } while (cur != head);
            System.out.println();
        }

        // 3 & 4 & 5. Simulate Round Robin
        void simulate(int quantum) {
            System.out.println("\n--- Simulation Start | Time Quantum = " + quantum + " ---\n");

            // Store all processes for metrics calculation
            int n = size;
            int[] originalBurst = new int[n];
            Process[] procs     = new int[0] instanceof int[] ? new Process[0] : new Process[n];
            Process cur = head;
            for (int i = 0; i < n; i++) { procs[i] = cur; originalBurst[i] = cur.burstTime; cur = cur.next; }

            int time  = 0;
            int round = 1;

            while (!isEmpty()) {
                System.out.println("Round " + round + " (Time = " + time + "):");
                displayQueue();

                int processed = size;
                Process current = head;

                for (int i = 0; i < processed; i++) {
                    Process next = current.next;

                    int execTime = Math.min(quantum, current.remainingTime);
                    System.out.printf("  Executing P%d (%s) for %d units [%d → %d]%n",
                            current.pid, current.name, execTime, time, time + execTime);

                    current.remainingTime -= execTime;
                    time += execTime;

                    if (current.remainingTime == 0) {
                        current.completionTime  = time;
                        current.turnaroundTime  = time - 0; // arrival = 0
                        System.out.printf("  → P%d completed at time %d%n", current.pid, time);
                        removeProcess(current.pid);
                    }
                    current = isEmpty() ? null : (current == tail ? head : next);
                    if (current == null) break;
                }
                System.out.println();
                round++;
            }

            // 5. Compute waiting times and metrics
            for (Process p : procs) {
                p.waitingTime = p.completionTime - p.burstTime;
            }

            System.out.println("--- Scheduling Metrics ---");
            System.out.printf("  %-5s | %-12s | %-5s | %-10s | %-12s | %-12s%n",
                    "PID", "Name", "Burst", "Completion", "Turnaround", "Waiting");
            System.out.println("  -----|--------------|-------|------------|--------------|----------");
            double totalWT = 0, totalTAT = 0;
            for (Process p : procs) {
                System.out.printf("  P%-4d | %-12s | %-5d | %-10d | %-12d | %-10d%n",
                        p.pid, p.name, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
                totalWT  += p.waitingTime;
                totalTAT += p.turnaroundTime;
            }
            System.out.printf("%n  Average Waiting Time    : %.2f%n", totalWT  / n);
            System.out.printf("  Average Turnaround Time : %.2f%n",   totalTAT / n);
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Round Robin CPU Scheduling (Circular Linked List) ===\n");
        Scheduler scheduler = new Scheduler();

        scheduler.addProcess(1, "Process-A", 10, 2);
        scheduler.addProcess(2, "Process-B",  5, 1);
        scheduler.addProcess(3, "Process-C",  8, 3);
        scheduler.addProcess(4, "Process-D",  3, 2);

        int TIME_QUANTUM = 3;
        scheduler.simulate(TIME_QUANTUM);
    }
}
