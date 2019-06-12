import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        LRU obj = new LRU();
        Scanner scan = new Scanner(System.in);
        System.out.println("This is least recently used algorithm implementation");
        System.out.println("Enter the capacity of the page");
        int capacity = scan.nextInt();
        int count = 0,val,mini = 0,lru = 0,i = 0;
        HashMap<Integer,Integer> page = new HashMap<>(capacity);
        int[] pageArr = new int[capacity];
         Iterator pageIter;
        int choice = 0,check;
        while(choice !=1)
        {
            System.out.print("Enter the page value to retrieve");
            val = scan.nextInt();
         if(page.containsKey(val))
         {
             page.put(val, count);
             System.out.print("Hit");
         }
         else
         {
             if(page.size() < capacity)
             {
                 page.put(val,count);
                 pageArr[i] = val;
                 i++;
             }
             else
             {
                 pageIter = page.entrySet().iterator();
                 mini = count;
                 while(pageIter.hasNext())
                 {
                     Map.Entry mapElement = (Map.Entry)pageIter.next();
                     check = (int)mapElement.getValue();
                     if(check <mini)
                     {
                         lru = (Integer) mapElement.getKey();
                         mini = check;
                     }
                 }
                 for(int j = 0;j<pageArr.length;j++)
                 {
                     if(pageArr[j] == lru)
                         pageArr[j] = val;
                 }
                 page.remove(lru);
                 page.put(val, count);
                 
             }
         }
         count++;
         /*Iterator pageIte = page.entrySet().iterator();
         while(pageIte.hasNext())
                 {
                     Map.Entry mapElement = (Map.Entry)pageIte.next();
                     check = (int)mapElement.getKey();
                     System.out.println(check+" "+(int)mapElement.getValue());
                 }*/
         for(int j = 0;j<i;j++)
             System.out.print(pageArr[j]+" ");
        System.out.print("Enter 1 to quit 0  to continue  ");
         choice = scan.nextInt();
        }
        
    }
    
}
