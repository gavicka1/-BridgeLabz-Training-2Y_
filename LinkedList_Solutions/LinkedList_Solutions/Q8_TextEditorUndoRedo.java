/**
 * Q8: Doubly Linked List - Undo/Redo Functionality for Text Editor
 *
 * Operations:
 *  1. Add new text state (type / perform action)
 *  2. Undo — revert to previous state
 *  3. Redo — revert to next state after undo
 *  4. Display current state
 *  5. Limit history to last N states (default 10)
 */
public class Q8_TextEditorUndoRedo {

    // ── Node: each node is one state of the document ─────────────────
    static class State {
        String content;
        State  next, prev;
        State(String content) { this.content = content; }
    }

    // ── Text Editor with Doubly Linked List ───────────────────────────
    static class TextEditor {
        State current;    // pointer to the current state
        int   historySize;
        int   maxHistory;

        TextEditor(int maxHistory) {
            this.maxHistory = maxHistory;
            // Initial empty state
            current      = new State("");
            historySize  = 1;
        }

        // 1. Type / perform an action — add new state
        void type(String newContent) {
            // Discard any redo states (future states after current)
            current.next = null;

            State newState  = new State(newContent);
            newState.prev   = current;
            current.next    = newState;
            current         = newState;
            historySize++;

            // Enforce max history limit: drop oldest state
            if (historySize > maxHistory) {
                State oldest = getOldest();
                oldest.next.prev = null;
                historySize--;
            }
            System.out.println("Typed  → \"" + newContent + "\"");
        }

        // 2. Undo
        boolean undo() {
            if (current.prev == null) {
                System.out.println("Nothing to undo.");
                return false;
            }
            current = current.prev;
            System.out.println("Undo   → \"" + current.content + "\"");
            return true;
        }

        // 3. Redo
        boolean redo() {
            if (current.next == null) {
                System.out.println("Nothing to redo.");
                return false;
            }
            current = current.next;
            System.out.println("Redo   → \"" + current.content + "\"");
            return true;
        }

        // 4. Display current state
        void displayCurrent() {
            System.out.println("Current state: \"" + current.content + "\"");
        }

        // Helper: walk back to oldest state
        State getOldest() {
            State cur = current;
            while (cur.prev != null) cur = cur.prev;
            return cur;
        }

        // Display entire history (for debugging)
        void displayHistory() {
            State oldest = getOldest();
            System.out.print("  History: ");
            State cur = oldest;
            while (cur != null) {
                System.out.print("[" + (cur == current ? "*" : "") + "\"" + cur.content + "\"] ");
                if (cur.next != null) System.out.print("→ ");
                cur = cur.next;
            }
            System.out.println("  (* = current)");
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Text Editor Undo/Redo (Doubly Linked List) ===\n");
        TextEditor editor = new TextEditor(10); // max 10 states

        System.out.println("--- Typing ---");
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!");
        editor.type("Hello World! How");
        editor.type("Hello World! How are");
        editor.type("Hello World! How are you?");

        System.out.println("\n--- Current State ---");
        editor.displayCurrent();

        System.out.println("\n--- Full History ---");
        editor.displayHistory();

        System.out.println("\n--- Undo x3 ---");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.displayCurrent();

        System.out.println("\n--- Redo x2 ---");
        editor.redo();
        editor.redo();
        editor.displayCurrent();

        System.out.println("\n--- Type new content after undo (discards redo history) ---");
        editor.type("Hello World! New branch.");
        editor.displayCurrent();

        System.out.println("\n--- Redo should be empty now ---");
        editor.redo();

        System.out.println("\n--- Test max history (add 6 more states) ---");
        for (int i = 1; i <= 6; i++) editor.type("State " + i);
        System.out.println("History after 6 more entries (capped at 10):");
        editor.displayHistory();
    }
}
