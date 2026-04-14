/**
 * Q1: Singly Linked List - Student Record Management
 *
 * Operations:
 *  1. Add student at beginning, end, or specific position
 *  2. Delete student by Roll Number
 *  3. Search student by Roll Number
 *  4. Display all students
 *  5. Update student grade by Roll Number
 */
public class Q1_StudentRecordManagement {

    // ── Node ─────────────────────────────────────────────────────────
    static class Student {
        int    rollNo;
        String name;
        int    age;
        String grade;
        Student next;

        Student(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name   = name;
            this.age    = age;
            this.grade  = grade;
        }
    }

    // ── Singly Linked List ────────────────────────────────────────────
    static class StudentList {
        Student head;

        // 1a. Add at beginning
        void addAtBeginning(int rollNo, String name, int age, String grade) {
            Student node = new Student(rollNo, name, age, grade);
            node.next = head;
            head = node;
            System.out.println("Added at beginning: " + name);
        }

        // 1b. Add at end
        void addAtEnd(int rollNo, String name, int age, String grade) {
            Student node = new Student(rollNo, name, age, grade);
            if (head == null) { head = node; return; }
            Student cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
            System.out.println("Added at end: " + name);
        }

        // 1c. Add at specific position (1-based)
        void addAtPosition(int pos, int rollNo, String name, int age, String grade) {
            if (pos <= 1) { addAtBeginning(rollNo, name, age, grade); return; }
            Student node = new Student(rollNo, name, age, grade);
            Student cur = head;
            for (int i = 1; i < pos - 1 && cur != null; i++) cur = cur.next;
            if (cur == null) { System.out.println("Position out of range. Adding at end."); addAtEnd(rollNo, name, age, grade); return; }
            node.next = cur.next;
            cur.next  = node;
            System.out.println("Added at position " + pos + ": " + name);
        }

        // 2. Delete by Roll Number
        void deleteByRollNo(int rollNo) {
            if (head == null) { System.out.println("List is empty."); return; }
            if (head.rollNo == rollNo) { head = head.next; System.out.println("Deleted roll no: " + rollNo); return; }
            Student cur = head;
            while (cur.next != null && cur.next.rollNo != rollNo) cur = cur.next;
            if (cur.next == null) { System.out.println("Roll No " + rollNo + " not found."); return; }
            cur.next = cur.next.next;
            System.out.println("Deleted roll no: " + rollNo);
        }

        // 3. Search by Roll Number
        Student searchByRollNo(int rollNo) {
            Student cur = head;
            while (cur != null) {
                if (cur.rollNo == rollNo) return cur;
                cur = cur.next;
            }
            return null;
        }

        // 4. Display all
        void display() {
            if (head == null) { System.out.println("  (No records found)"); return; }
            Student cur = head;
            System.out.println("  Roll | Name             | Age | Grade");
            System.out.println("  -----|------------------|-----|------");
            while (cur != null) {
                System.out.printf("  %-4d | %-16s | %-3d | %s%n",
                        cur.rollNo, cur.name, cur.age, cur.grade);
                cur = cur.next;
            }
        }

        // 5. Update grade
        void updateGrade(int rollNo, String newGrade) {
            Student s = searchByRollNo(rollNo);
            if (s == null) { System.out.println("Roll No " + rollNo + " not found."); return; }
            s.grade = newGrade;
            System.out.println("Updated grade of " + s.name + " to " + newGrade);
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Student Record Management (Singly Linked List) ===\n");
        StudentList list = new StudentList();

        list.addAtEnd(101, "Alice",   20, "A");
        list.addAtEnd(102, "Bob",     21, "B");
        list.addAtEnd(103, "Charlie", 19, "A");
        list.addAtBeginning(100, "Zara", 22, "C");
        list.addAtPosition(3, 105, "Diana", 20, "B");

        System.out.println("\n--- All Students ---");
        list.display();

        System.out.println("\n--- Search Roll No 102 ---");
        Student s = list.searchByRollNo(102);
        if (s != null) System.out.println("Found: " + s.name + ", Grade: " + s.grade);

        System.out.println("\n--- Update Grade of Roll 103 to A+ ---");
        list.updateGrade(103, "A+");

        System.out.println("\n--- Delete Roll No 100 ---");
        list.deleteByRollNo(100);

        System.out.println("\n--- Final List ---");
        list.display();
    }
}
