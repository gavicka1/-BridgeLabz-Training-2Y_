import java.util.*;
public class TournamentTracker{
 static class Player{ String id; int score; Player(String i,int s){id=i;score=s;} }
 public static void main(String[] args){
  Set<String> players = new HashSet<>(Arrays.asList("p1","p2"));
  Queue<String> matches = new LinkedList<>(Arrays.asList("m1","m2"));
  List<String> results = new ArrayList<>();
  TreeSet<Integer> leaderboard = new TreeSet<>(Collections.reverseOrder());
  leaderboard.add(100); leaderboard.add(80);
  System.out.println("Leaderboard "+leaderboard);
 }
}
