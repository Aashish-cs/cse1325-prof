 public class PriorityToDo extends Todo {
     private int priority;
     public PriorityToDo(String action, int priority) {
         super(action);
         this.priority = priority;
     }
     @Override
     public String toString() {
         return super.toString() + " priority " + priority;
     }
 }

