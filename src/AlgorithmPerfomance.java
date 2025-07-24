import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class AlgorithmPerfomance {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        AlgorithmPerfomance a=new AlgorithmPerfomance();
        System.out.println("Enter n value:");
        int n=sc.nextInt();
        a.constantTime(n);
        a.logarithmicTime(n);
        a.linearTime(n);
        a.linearithmicTime(n);
        a.quadraticTime(n);
    }
    private void quadraticTime(int n) {
        long s=System.nanoTime();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.println("i value:"+i+", j value:"+j);
            }
        }
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n^2), Time taken for looping using two loops:"+(e-s));
    }
    private void linearithmicTime(int n) {
        ArrayList<Integer> l=new ArrayList<>();
        System.out.println("Enter"+n+" numbers :");
        for(int i=0;i<n;i++){
            l.add(sc.nextInt());
        }
        long s=System.nanoTime();
        Collections.sort(l);
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n log(n), Time taken for sorting:"+(e-s));
    }
    private void linearTime(int n) {
        long s=System.nanoTime();
        for(int i=1;i<=n;i++){
            System.out.println(i);
        }
        long e=System.nanoTime();
        System.out.println("Time complexity: O(n), Time taken for looping from 1 to"+n+":"+(e-s));
    }
    private void logarithmicTime(int n) {
        ArrayList<Integer> l=new ArrayList<>();
        System.out.println("Enter "+n+" numbers :");
        for(int i=0;i<n;i++){
            l.add(sc.nextInt());
        }
        Collections.sort(l);
        System.out.println("Enter element to search:");
        int ele= sc.nextInt();
        long s=System.nanoTime();
        int index = Collections.binarySearch(l,ele);
        long e=System.nanoTime();
        System.out.println("Index of the element being searched:"+index);
        System.out.println("Time complexity: O(n log(n)), Time taken for searching for an element:"+(e-s));
    }
    private void constantTime(int n) {
        long s=System.nanoTime();
        System.out.println("n:"+n);
        long e=System.nanoTime();
        System.out.println("Time complexity: O(1), Time taken for displaying message:"+(e-s));
    }
}