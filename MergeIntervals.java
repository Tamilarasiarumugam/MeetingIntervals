package assignments;

import java.util.Arrays;
import java.util.Stack;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {
	
	public static void merge(Interval arr[])
    {
        
        if (arr.length <= 0)
            return;
 
        
        Stack<Interval> stack = new Stack<>();
 
        
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
 
       
        stack.push(arr[0]);
 
        
        for (int i = 1; i < arr.length; i++) {
            
            Interval top = stack.peek();
 
           
            if (top.end < arr[i].start)
                stack.push(arr[i]);
 
            
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
 
        
        System.out.println("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.println("[" + t.start + "," + t.end
                             + "] ");
        }
    }
	
	public static void main(String[] args)
	{
		
		Interval arr[] = new Interval[4];
        arr[0] = new Interval(1,3);
        arr[1] = new Interval(2,6);
        arr[2] = new Interval(8,10);
        arr[3] = new Interval(15,18);
        merge(arr);
		
	}

}

