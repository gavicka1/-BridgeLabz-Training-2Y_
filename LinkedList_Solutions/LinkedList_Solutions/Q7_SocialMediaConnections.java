/**
 * Q7: Singly Linked List - Social Media Friend Connections
 *
 * Operations:
 *  1. Add a friend connection between two users
 *  2. Remove a friend connection
 *  3. Find mutual friends between two users
 *  4. Display all friends of a specific user
 *  5. Search for a user by Name or User ID
 *  6. Count number of friends per user
 */
import java.util.*;

public class Q7_SocialMediaConnections {

    // ── Friend ID node (nested singly linked list) ────────────────────
    static class FriendNode {
        int        friendId;
        FriendNode next;
        FriendNode(int id) { this.friendId = id; }
    }

    // ── User node ─────────────────────────────────────────────────────
    static class User {
        int        userId, age;
        String     name;
        FriendNode friendsHead; // linked list of friend IDs
        User       next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name   = name;
            this.age    = age;
        }

        void addFriend(int friendId) {
            FriendNode node = new FriendNode(friendId);
            node.next   = friendsHead;
            friendsHead = node;
        }

        boolean removeFriend(int friendId) {
            if (friendsHead == null) return false;
            if (friendsHead.friendId == friendId) { friendsHead = friendsHead.next; return true; }
            FriendNode cur = friendsHead;
            while (cur.next != null && cur.next.friendId != friendId) cur = cur.next;
            if (cur.next == null) return false;
            cur.next = cur.next.next;
            return true;
        }

        boolean hasFriend(int friendId) {
            FriendNode cur = friendsHead;
            while (cur != null) { if (cur.friendId == friendId) return true; cur = cur.next; }
            return false;
        }

        List<Integer> getFriendIds() {
            List<Integer> ids = new ArrayList<>();
            FriendNode cur = friendsHead;
            while (cur != null) { ids.add(cur.friendId); cur = cur.next; }
            return ids;
        }

        int friendCount() {
            int cnt = 0;
            FriendNode cur = friendsHead;
            while (cur != null) { cnt++; cur = cur.next; }
            return cnt;
        }
    }

    // ── Social Network (singly linked list of users) ─────────────────
    static class SocialNetwork {
        User head;

        // Add user to network
        void addUser(int userId, String name, int age) {
            User node = new User(userId, name, age);
            node.next = head;
            head = node;
            System.out.println("Added user: " + name + " (ID: " + userId + ")");
        }

        // Find user by ID
        User findById(int userId) {
            User cur = head;
            while (cur != null) { if (cur.userId == userId) return cur; cur = cur.next; }
            return null;
        }

        // 5. Search by Name
        User findByName(String name) {
            User cur = head;
            while (cur != null) { if (cur.name.equalsIgnoreCase(name)) return cur; cur = cur.next; }
            return null;
        }

        // 1. Add friend connection (bidirectional)
        void addFriendConnection(int userId1, int userId2) {
            User u1 = findById(userId1);
            User u2 = findById(userId2);
            if (u1 == null || u2 == null) { System.out.println("One or both users not found."); return; }
            if (!u1.hasFriend(userId2)) u1.addFriend(userId2);
            if (!u2.hasFriend(userId1)) u2.addFriend(userId1);
            System.out.println("Connected: " + u1.name + " <→ " + u2.name);
        }

        // 2. Remove friend connection (bidirectional)
        void removeFriendConnection(int userId1, int userId2) {
            User u1 = findById(userId1);
            User u2 = findById(userId2);
            if (u1 == null || u2 == null) { System.out.println("User not found."); return; }
            u1.removeFriend(userId2);
            u2.removeFriend(userId1);
            System.out.println("Disconnected: " + u1.name + " and " + u2.name);
        }

        // 3. Mutual friends
        List<String> mutualFriends(int userId1, int userId2) {
            User u1 = findById(userId1);
            User u2 = findById(userId2);
            List<String> mutual = new ArrayList<>();
            if (u1 == null || u2 == null) return mutual;
            for (int fid : u1.getFriendIds()) {
                if (u2.hasFriend(fid)) {
                    User f = findById(fid);
                    if (f != null) mutual.add(f.name);
                }
            }
            return mutual;
        }

        // 4. Display all friends of a user
        void displayFriends(int userId) {
            User u = findById(userId);
            if (u == null) { System.out.println("User not found."); return; }
            System.out.println("  Friends of " + u.name + ":");
            List<Integer> ids = u.getFriendIds();
            if (ids.isEmpty()) { System.out.println("    (No friends yet)"); return; }
            for (int fid : ids) {
                User f = findById(fid);
                System.out.println("    → " + (f != null ? f.name : "Unknown") + " (ID: " + fid + ")");
            }
        }

        // 6. Display friend count for all users
        void displayFriendCounts() {
            System.out.println("  User Friend Counts:");
            User cur = head;
            while (cur != null) {
                System.out.printf("    %-15s → %d friends%n", cur.name, cur.friendCount());
                cur = cur.next;
            }
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Social Media Friend Connections (Singly Linked List) ===\n");
        SocialNetwork net = new SocialNetwork();

        net.addUser(1, "Alice",   22);
        net.addUser(2, "Bob",     25);
        net.addUser(3, "Charlie", 23);
        net.addUser(4, "Diana",   21);
        net.addUser(5, "Eve",     27);

        System.out.println("\n--- Adding Connections ---");
        net.addFriendConnection(1, 2);
        net.addFriendConnection(1, 3);
        net.addFriendConnection(2, 3);
        net.addFriendConnection(3, 4);
        net.addFriendConnection(4, 5);
        net.addFriendConnection(1, 5);

        System.out.println("\n--- Friends of Alice (ID 1) ---");
        net.displayFriends(1);

        System.out.println("\n--- Friends of Bob (ID 2) ---");
        net.displayFriends(2);

        System.out.println("\n--- Mutual Friends of Alice and Bob ---");
        List<String> mutual = net.mutualFriends(1, 2);
        System.out.println("  Mutual: " + (mutual.isEmpty() ? "None" : mutual));

        System.out.println("\n--- Search by Name 'Diana' ---");
        User d = net.findByName("Diana");
        if (d != null) System.out.println("  Found: " + d.name + ", Age: " + d.age);

        System.out.println("\n--- Friend Counts ---");
        net.displayFriendCounts();

        System.out.println("\n--- Remove Connection Alice - Eve ---");
        net.removeFriendConnection(1, 5);
        net.displayFriends(1);
    }
}
