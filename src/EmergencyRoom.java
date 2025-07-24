import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Patient{
    String name;
    int priority;
    Patient(String name,int priority){
        this.name=name;
        this.priority=priority;
    }
    public String getName(){
        return name;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public String toString() {
        return "Patient {Name:"+name+",Priority:"+priority+"}";
    }
}
class PatientComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2){
        return Integer.compare(p1.getPriority(),p2.getPriority());
    }
}
public class EmergencyRoom {
    PriorityQueue<Patient>pq=new PriorityQueue<>(new PatientComparator());
    Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        EmergencyRoom e = new EmergencyRoom();
        Scanner sc = new Scanner(System.in);
        int in = 0;
        while (in != 4) {
            System.out.println("\nChoose an option: \n 1. Add patients \n 2. Get next patient \n 3. Display all patients in priority order  \n 4. Quit");
            if (sc.hasNextInt()) {
                in = sc.nextInt();
                sc.nextLine();
                switch (in) {
                    case 1 -> {
                        System.out.println("enter patient name and priority");
                        String name=sc.nextLine();
                        int priority=sc.nextInt();
                        Patient p=new Patient(name,priority);
                        e.add(p);
                    }
                    case 2 -> {
                        System.out.println("Next patient to treat: ");
                        e.get();
                    }
                    case 3 -> {
                        System.out.println("Display of all patients ");
                        e.display();
                    }
                    case 4 -> System.out.println("Quiting....");
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
    private void display() {
        PriorityQueue<Patient> copy = new PriorityQueue<>(pq);
        if(copy.isEmpty()){
            System.out.println("No patients to display");
            return;
        }
        long s=System.nanoTime();
        while (!copy.isEmpty())
            System.out.println(copy.poll());
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for displaying all the patients:"+(e-s));
    }
    private void get() {
        if(pq.isEmpty()){
            System.out.println("No patients waiting");
        }
        long s=System.nanoTime();
        System.out.println(pq.peek());
        pq.poll();
        long e=System.nanoTime();
        System.out.println("Time complexity: O(log n), Time taken for getting and deleting patients:"+(e-s));
    }

    private void add(Patient p) {
        long s=System.nanoTime();
        pq.offer(p);
        long e=System.nanoTime();
        System.out.println("Time complexity: O(log n), Time taken for adding patients:"+(e-s));
    }
}