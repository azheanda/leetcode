import java.util.*;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> need = new HashMap<String, Integer>();
        HashMap<String, Integer> meet = new HashMap<String, Integer>();

        for(String s: L)
            if(!need.containsKey(s))
        		need.put(s,1);
        	else
        		need.put(s,need.get(s)+1);
        	
        int wordLen = L[0].length();
        int numOfWords = L.length;
        int i=0;
        int count=0;
        int checkpoint=0;

         while(i<S.length()-wordLen+1) {
            String cWord = S.substring(i,i+wordLen);
        	if(need.containsKey(cWord) && (!meet.containsKey(cWord) || need.get(cWord)>meet.get(cWord))) {
        		count++;
        		if(meet.containsKey(cWord))
        			meet.put(cWord,meet.get(cWord)+1);
        		else
        			meet.put(cWord,1);

        		if(numOfWords == count){
        			res.add(checkpoint);
        			count=0;
        			meet.clear();
        			i = checkpoint+1;
        			checkpoint = i;
        			continue;
        		}
        		i += wordLen;	
        	}else{
        		if(count!=0){      			
        			count=0;
        			meet.clear();
        			i = checkpoint;
        		}
        		checkpoint = ++i;
        	}
        	
        }
		return res;
    }
}

