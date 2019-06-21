package fcfs;

import java.util.HashMap;
import java.util.Scanner;

public class calculation {
    void findtime(HashMap process,int n) {
        double wat = 0,tat = 0,totat = 0,towat = 0;
        int bursttime;
        for(int i=1;i<=n;i++)
        {
            bursttime = (int) process.get(i);
            tat = wat + bursttime;
            System.out.println("i   bursttime   wat   tat");
            System.out.println(i+"    "+bursttime+"    "+wat+"    "+tat);
            totat+=tat;
            towat+=wat;
            wat = tat;
            
        }
        System.out.println("Average waiting time "+(towat/n)+"\nAverage turn around time "+(totat/n));
    }
}


public class FCFS {

    public static void main(String[] args) {
        calculation wt = new calculation();
        System.out.println("This first come first serve impementation0");
        HashMap<Integer,Integer> process = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = scan.nextInt();
        int order,bursttime;
        System.out.println("Enter the process' order number and it's burst time");
        for(int i =0;i< n;i++)
        {
            order = scan.nextInt();
            bursttime = scan.nextInt();
            process.put(order,bursttime);
        }
        wt.findtime(process,n);
        
       
    }
    
}
