class Meal<T extends MealPlan>{
 private T plan;
 public Meal(T p){ plan=p; }
}
class Q15_MealPlanGenerator{
 public static <T extends MealPlan> void generate(T p){
  System.out.println(p.getClass().getSimpleName());
 }
 public static void main(String[] args){
  generate(new VeganMeal());
 }
}
