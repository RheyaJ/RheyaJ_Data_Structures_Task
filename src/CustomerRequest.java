import java.util.*;
class Customer{
    String name;
    String request;
    public Customer(String name, String request){
        this.name=name; this.request=request;
    }
    public String getName() {
        return name;
    }
    public String getRequest() {
        return request;
    }
    @Override public String toString() {
        return "Customer Name:"+name+", Request:"+request;
    }
}
public class CustomerRequest {
    Queue<Customer>q=new LinkedList<>();
    public static void main(String[] args) {
        CustomerRequest c = new CustomerRequest();
        Scanner sc = new Scanner(System.in);
        int in = 0;
        while (in != 4) {
            System.out.println("\nChoose an option:\n1. Add request\n2. Serve request\n3. Display request\n4. Quit");
            if (sc.hasNextInt()) {
                in = sc.nextInt();
                sc.nextLine();
                switch (in) {
                    case 1 -> {
                        System.out.println("Enter name of customer:");
                        String name=sc.nextLine();
                        System.out.println("enter customer request:");
                        String req=sc.nextLine();
                        Customer cus=new Customer(name,req);
                        c.addRequest(cus);
                    }
                    case 2 -> {
                        c.serveRequest();
                    }
                    case 3 -> {
                        c.displayRequests();
                    }
                    case 4 -> System.out.println("Quiting...");
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
    private void displayRequests() {
        Queue<Customer> copy = new LinkedList<>(q);
        if(copy.isEmpty()){
            System.out.println("No more requests to display");
            return;
        }
        System.out.println("Display of all requests");
        long s=System.nanoTime();
        while (!copy.isEmpty())
            System.out.println(copy.poll());
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for displaying all the requests:"+(e-s));
    }
    private void serveRequest() {
        Customer customer=null;
        long s=System.nanoTime();
        if(!q.isEmpty()){
            System.out.println("Next customer request to serve:");
            customer=q.peek();
            System.out.println(customer);
            q.poll(); long e=System.nanoTime();
            System.out.println("Time complexity: O(1), Time taken for serving request of customer: "+customer.getName()+"is :"+(e-s));
        }
        else{
            System.out.println("No more pending requests");
        }
    }
    private void addRequest(Customer customer) {
        long s=System.nanoTime();
        q.offer(customer);
        long e=System.nanoTime();
        System.out.println("Time complexity: O(1), Time taken for adding request for customer:"+customer.getName()+"is :"+(e-s));
    }
}