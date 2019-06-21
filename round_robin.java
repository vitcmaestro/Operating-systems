
package roundrobin;

import java.util.HashMap;
import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        Operations op = new Operations();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = scan.nextInt();
        System.out.println("Enter the process number and bursttime\n");
        int bt,order;
        HashMap<Integer,Integer> btime = new HashMap<>();
        for(int i=0 ;i<n;i++)
        {
            order = scan.nextInt();
            bt = scan.nextInt();
            btime.put(order,bt);
        }
        System.out.println("Enter the quantum value\n");
        int quantum = scan.nextInt();
        op.findTime(btime,quantum);
    }
    
}


class Operations {

    void findTime(HashMap<Integer, Integer> btime,int quantum) {
        int[] rem_time = new int[btime.size()];
        int totaltime =0;
        int[] wt = new int[btime.size()];
        int[] tat = new int[wt.length];
        for(int i =0;i< btime.size();i++)
        {
            rem_time[i] = btime.get(i+1);
            //System.out.println("bt"+rem_time[i]);
        }
        boolean undone = false;
        while(true)
        {
            undone = false;
        for(int i =0;i<rem_time.length;i++)
        {
            if(rem_time[i]> quantum)
            {
                undone = true;
                rem_time[i]-=quantum;
                totaltime += quantum;
            }
            else if(rem_time[i] >0)
            {
                totaltime+=rem_time[i];
                rem_time[i] = 0;
                wt[i] = totaltime - btime.get(i+1);
                tat[i] = btime.get(i+1)+wt[i];
            }
        }
        if(undone == false)
            break;
        
        }
        System.out.println("i   bt   wt   tat");
        for(int i=0;i<wt.length;i++)
        {
            System.out.println((i+1)+" "+btime.get(i+1)+" "+wt[i]+" "+tat[i]);
        }
        
    }
    
}
