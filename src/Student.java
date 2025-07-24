import java.util.*;
public class Student {
    Map<String, List<Integer>> m=new HashMap<>();
    public static void main(String[] args) {
        Student ob = new Student();
        Scanner sc = new Scanner(System.in);
        int in = 0;
        int no=0;
        while (in != 5) {
            System.out.println("\nChoose an option: \n 1. Add student \n 2. Add grade \n 3. Calculate average \n 4. Display students \n 5. Quit");
            if (sc.hasNextInt()) {
                in = sc.nextInt();
                sc.nextLine();
                switch (in) {
                    case 1 -> { System.out.println("enter name of student");
                        String i=sc.nextLine();
                        System.out.println("Enter number of subjects");
                        no=sc.nextInt(); ob.addName(i);
                    }
                    case 2 -> {
                        List<Integer>l=new ArrayList<>();
                        System.out.println("Enter name of student");
                        String student=sc.nextLine();
                        long s=System.nanoTime();
                        for (int i = 1; i<=no; i++) {
                            System.out.println("Enter grade of student in subject:" + i);
                            l.add(sc.nextInt());
                        }
                        ob.addGrade(student,l);
                        long e=System.nanoTime();
                        System.out.println("Time complexity: O(n), Time taken for adding grade of student:"+(e-s));
                    }
                    case 3 -> {
                        System.out.println("enter name of student");
                        String n=sc.nextLine();
                        System.out.print("Average of grades of all subjects of"+n+"is: ");
                        ob.average(n);
                    }
                    case 4 -> ob.displayStudents();
                    case 5 -> System.out.println("Quiting.........");
                    default -> System.out.println("Invalid choice");
                }
            }
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); } } sc.close();
            }
            private void displayStudents() {
                if(m.isEmpty()) {
                    System.out.println("No students to display");
                    return;
                }
                long s=System.nanoTime();
                for(Map.Entry<String,List<Integer>>e:m.entrySet()){
                    System.out.println(e.getKey());
                }
                long e=System.nanoTime();
                System.out.println("Time complexity: O(n), Time taken for displaying all students:"+(e-s));
            }
            private void average(String name) {
                double sum=0; double avg=0.0;
                long s=System.nanoTime();
                if(m.containsKey(name)){
                    List<Integer>l=m.get(name);
                    for(Integer i:l){
                        sum+=i;
                    }
                    avg=sum/(l.size());
                    System.out.println(avg);
                }
                else
                    System.out.println("No such student");
                long e=System.nanoTime();
                System.out.println("Time complexity: O(n), Time taken for calculating average:"+(e-s));
    }
    private void addGrade(String student,List<Integer>l) {
        if(m.containsKey(student)){
            m.put(student,l);
        }
        else{
            System.out.println("No such student");
        }
    }
    private void addName(String i) {
        long s=System.nanoTime();
        m.putIfAbsent(i,new ArrayList<>());
        long e=System.nanoTime();
        System.out.println("Time complexity: O(1), Time taken for adding student name:"+(e-s));
    }
}