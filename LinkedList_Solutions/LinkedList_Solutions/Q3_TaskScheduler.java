/**
 * Q3: Circular Linked List - Task Scheduler
 *
 * Operations:
 *  1. Add task at beginning, end, or specific position
 *  2. Remove task by Task ID
 *  3. View current task and move to next
 *  4. Display all tasks from head
 *  5. Search task by Priority
 */
import java.util.ArrayList;
import java.util.List;

public class Q3_TaskScheduler {

    // ── Node ─────────────────────────────────────────────────────────
    static class Task {
        int    taskId, priority;
        String taskName, dueDate;
        Task   next;

        Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId   = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate  = dueDate;
        }
    }

    // ── Circular Linked List ─────────────────────────────────────────
    static class TaskScheduler {
        Task head;    // first node
        Task tail;    // last node — tail.next always points to head
        Task current; // pointer for "current task" traversal
        int  size;

        // 1a. Add at end
        void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
            Task node = new Task(taskId, taskName, priority, dueDate);
            if (head == null) {
                head = tail = node;
                node.next = head;            // circular
                current   = head;
            } else {
                tail.next = node;
                node.next = head;            // maintain circular link
                tail      = node;
            }
            size++;
            System.out.println("Added task: " + taskName);
        }

        // 1b. Add at beginning
        void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
            Task node = new Task(taskId, taskName, priority, dueDate);
            if (head == null) {
                head = tail = node;
                node.next = head;
                current   = head;
            } else {
                node.next = head;
                tail.next = node;            // tail must still point to new head
                head      = node;
            }
            size++;
            System.out.println("Added task at beginning: " + taskName);
        }

        // 1c. Add at specific position (1-based)
        void addAtPosition(int pos, int taskId, String taskName, int priority, String dueDate) {
            if (pos <= 1) { addAtBeginning(taskId, taskName, priority, dueDate); return; }
            if (pos > size) { addAtEnd(taskId, taskName, priority, dueDate); return; }
            Task node = new Task(taskId, taskName, priority, dueDate);
            Task cur  = head;
            for (int i = 1; i < pos - 1; i++) cur = cur.next;
            node.next = cur.next;
            cur.next  = node;
            size++;
            System.out.println("Added task at position " + pos + ": " + taskName);
        }

        // 2. Remove by Task ID
        void removeByTaskId(int taskId) {
            if (head == null) { System.out.println("Scheduler is empty."); return; }

            // Only one node
            if (head == tail && head.taskId == taskId) {
                System.out.println("Removed task: " + head.taskName);
                head = tail = current = null; size--; return;
            }

            // Head is target
            if (head.taskId == taskId) {
                System.out.println("Removed task: " + head.taskName);
                head      = head.next;
                tail.next = head;
                if (current == head) current = head;
                size--; return;
            }

            Task prev = head;
            Task cur  = head.next;
            while (cur != head && cur.taskId != taskId) { prev = cur; cur = cur.next; }
            if (cur == head) { System.out.println("Task ID " + taskId + " not found."); return; }
            if (cur == tail) tail = prev;
            if (cur == current) current = cur.next;
            prev.next = cur.next;
            size--;
            System.out.println("Removed task: " + cur.taskName);
        }

        // 3. View current and move to next
        void viewCurrentAndAdvance() {
            if (current == null) { System.out.println("No tasks available."); return; }
            System.out.println("Current task: [" + current.taskId + "] " +
                    current.taskName + " | Priority: " + current.priority +
                    " | Due: " + current.dueDate);
            current = current.next;
        }

        // 4. Display all tasks
        void displayAll() {
            if (head == null) { System.out.println("  (No tasks)"); return; }
            System.out.println("  ID  | Task Name            | Priority | Due Date");
            System.out.println("  ----|----------------------|----------|----------");
            Task cur = head;
            do {
                System.out.printf("  %-3d | %-20s | %-8d | %s%n",
                        cur.taskId, cur.taskName, cur.priority, cur.dueDate);
                cur = cur.next;
            } while (cur != head);
        }

        // 5. Search by priority
        List<Task> searchByPriority(int priority) {
            List<Task> result = new ArrayList<>();
            if (head == null) return result;
            Task cur = head;
            do {
                if (cur.priority == priority) result.add(cur);
                cur = cur.next;
            } while (cur != head);
            return result;
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Task Scheduler (Circular Linked List) ===\n");
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Fix Login Bug",        2, "2024-12-01");
        scheduler.addAtEnd(2, "Write Unit Tests",     3, "2024-12-03");
        scheduler.addAtEnd(3, "Deploy to Production", 1, "2024-12-05");
        scheduler.addAtBeginning(4, "Urgent Hotfix",  1, "2024-11-30");
        scheduler.addAtPosition(3, 5, "Code Review",  2, "2024-12-02");

        System.out.println("\n--- All Tasks ---");
        scheduler.displayAll();

        System.out.println("\n--- Cycling through tasks ---");
        for (int i = 0; i < 4; i++) scheduler.viewCurrentAndAdvance();

        System.out.println("\n--- Search Priority = 1 ---");
        scheduler.searchByPriority(1)
            .forEach(t -> System.out.println("  [" + t.taskId + "] " + t.taskName));

        System.out.println("\n--- Remove Task ID 3 ---");
        scheduler.removeByTaskId(3);

        System.out.println("\n--- Final Tasks ---");
        scheduler.displayAll();
    }
}
