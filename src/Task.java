import java.util.ArrayList;
import java.util.Scanner;
public class Task {
    ArrayList<String>l=new ArrayList<>();
    ArrayList<Boolean>m=new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        Task t = new Task();
        Scanner sc = new Scanner(System.in);
        int in = 0;        while (in != 5) {
            System.out.println("\nChoose an option: \n 1. Add task \n 2. Mark task as completed \n 3. Remove task \n 4. Display tasks \n 5. Quit");
            if (sc.hasNextInt()) {
                in = sc.nextInt();
                sc.nextLine();
                switch (in) {
                    case 1 -> {
                        System.out.println("enter task");
                        String i=sc.nextLine();
                        t.add(i);
                    }
                    case 2 -> {
                        System.out.print("Enter task name to mark as complete: ");
                        String task = sc.nextLine();
                        t.mark(task);
                    }
                    case 3 -> {
                        System.out.print("Enter the task name to remove: ");
                        String task = sc.nextLine();
                        t.remove(task);
                    }
                    case 4 -> t.displayTasks();
                    case 5 -> System.out.println("Quiting...");
                    default -> System.out.println("Invalid choice");
                }
            }
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
        sc.close();
    }
    public void add(String in){
        long s=System.nanoTime();
        l.add(in);
        m.add(false);
        long e=System.nanoTime();
        System.out.println("Time complexity: O(1), Time taken for adding tasks:"+(e-s));
    }
    public void mark(String task) {
        long s = 0,e=0;
        int flag=0;
        s=System.nanoTime();
        for(int i=0;i<l.size();i++){
            if(l.get(i).equalsIgnoreCase(task)){
                m.set(i,true);
                flag++;
            }
        }
        if(flag==0)
            System.out.println("No such task");
        e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for marking:"+(e-s));
    }
    public void remove(String task) {
        long s=System.nanoTime();
        if(l.contains(task)){
            l.remove(task);
            System.out.println("Task removed:"+task);
        }
        else {
            System.out.println("No such task");
            return;
        }
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for removing:"+(e-s));
    }
    public void displayTasks() {
        if(l.isEmpty()){
            System.out.println("No tasks");
            return;
        }
        System.out.println("The tasks  and their status:");
        long s=System.nanoTime();
        for(int i=0;i<l.size();i++){
            if(m.get(i)==true)
                System.out.println(l.get(i)+":"+"DONE"+"\n");
            else
                System.out.println(l.get(i)+":"+"NOT DONE"+"\n");
        }
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for displaying:"+(e-s));
    }
}