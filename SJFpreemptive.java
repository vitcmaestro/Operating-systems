package sjfpreemptive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJFpreemptive {
    
    private void sort(int[] process, int[] arrival, int n) {
        for(int i=0;i<n;i++)
        {
            for(int j =i+1;j<n;j++)
            {
                if(arrival[i] > arrival[j])
                {
                    arrival[j] = arrival[i]+arrival[j];
                    arrival[i] = arrival[j] - arrival[i];
                    arrival[j] = arrival[j] - arrival[i];
                    process[j] = process[i]+process[j];
                    process[i] = process[j] - process[i];
                    process[j] = process[j] - process[i];
                }
            }
        }
        findtime(process,arrival,n);    
    }

    private void findtime(int[] process, int[] arrival, int n) {
        int total = 0,stime = arrival[0],sbt =0;
        int[] wt = new int[n];
        int tatavg = 0,wtavg = 0;
        for(int i=0;i<n;i++)
        {
            wt[i] = process[i];
        }
        int[] tat = new int[n];
        boolean undone = false;
        
        int minofthisround = process[0];
        while(true)
        {
            undone = false;
            minofthisround = 100;
            sbt = 100;
           for(int i =0;i< n;i++)
           {
               
               if(process[i] >0){
                  undone = true;
               if(arrival[i]<= total && (process[i]<minofthisround))
               {
                   minofthisround = process[i];
                   sbt = i;
               }
               }
           }
           if(undone == false)
               break;
           process[sbt]--;
           total++;
           if(process[sbt] == 0)
            {
                tat[sbt] = total - arrival[sbt];
                wt[sbt] = tat[sbt]-wt[sbt];
                tatavg+=tat[sbt];
                wtavg+=wt[sbt];
                process[sbt] = -1;
            }
           
            
        }
        System.out.println("sno arrivalTime tat   wt");
        for(int i =0;i<n;i++)
        {
            System.out.println((i+1)+"   "+arrival[i]+"          "+wt[i]+"   "+tat[i]);
        }
        System.out.println("Average turn around time "+tatavg/n);
        System.out.println("Average waiting time "+wtavg/n);
        
    }
    
    public static void main(String[] args) {
        SJFpreemptive sp = new SJFpreemptive();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Enter the number of processes");
            int n = Integer.parseInt(br.readLine());
            int[] process = new int[n];
            int[] arrival = new int[n];
            System.out.println("Enter the process Burst time and arrival time");
            for(int i=0;i<n;i++)
            {
                System.out.println("Enter burst time for "+(i+1)+ "th process");
                process[i] = Integer.parseInt(br.readLine());
                System.out.println("Enter it's arrival time");
                arrival[i] = Integer.parseInt(br.readLine());
            }
            sp.sort(process,arrival,n);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    

    
}
