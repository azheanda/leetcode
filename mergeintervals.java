/*
    This problem is trivial if based on the algorithm of inserting interval.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        for(Interval interval: intervals){
            res = insert(res,interval);
        }
        
        return res;
        
    }
    
  
    //-------------insertinterval2.java----------------
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();        
        Interval t= new Interval(newInterval.start,newInterval.end);
        Iterator<Interval> itr = intervals.iterator();
        
        while(itr.hasNext()){
            Interval i = itr.next();
            if(i.start>t.end){
                res.add(t);
                res.add(i);
                while(itr.hasNext()){res.add(itr.next());}
                return res;
            }
            
            if(t.start>i.end) 
                res.add(i);
            else{
                 t.start = Math.min(i.start,t.start);
                 t.end = Math.max(i.end,t.end);   
            }
        }
        res.add(t);
        return res;

    }
    
}