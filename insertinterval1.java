/*
	judge small :540ms
	judge large::650ms

	This interview question is tougher than it appears. I tend to make a lot of 
	mistakes when coding it.
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
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();        
        Interval pre= new Interval(newInterval.start,newInterval.end);
        
        boolean inserted = false;
        int i=0;
        while(i<intervals.size() || !inserted){
            if(i<intervals.size()){
                Interval current= intervals.get(i);
                if(inserted)
                    res.add(current);
                else if(current.end<pre.start)
                    res.add(current);
                else if(isOverlap(current,pre)){
                    pre.start = Math.min(current.start,pre.start);
                    pre.end = Math.max(current.end,pre.end);
                }
                 else{
                     res.add(pre);
                     res.add(current);
                     inserted=true;
                 }
            }else{
                res.add(pre);
                inserted=true;
            }
                
            i++;
                
        }     
        return res;


    }
    public boolean isOverlap(Interval a, Interval b){
    	return !(b.start>a.end || a.start> b.end);
    }
}	