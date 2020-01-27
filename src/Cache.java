import java.lang.reflect.Array;
import java.util.*;

public class Cache {

	public static void main(String[] args) {
		//populate each array
		ArrayList<ArrayList<Integer>> theCache = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a= new ArrayList<Integer>(); 
		a.add(1);
		a.add(2);
		ArrayList<Integer> b= new ArrayList<Integer>(); 
		b.add(3);
		b.add(1);
		ArrayList<Integer> c= new ArrayList<Integer>(); 
		c.add(4);
		c.add(2);
		ArrayList<Integer> d= new ArrayList<Integer>(); 
		d.add(2);
		ArrayList<Integer> e= new ArrayList<Integer>(); 
		e.add(5);
		e.add(2);
		ArrayList<Integer> f= new ArrayList<Integer>(); 
		f.add(6);
		f.add(1);
		ArrayList<Integer> g= new ArrayList<Integer>(); 
		g.add(2);
		g.add(1);
		ArrayList<Integer> h= new ArrayList<Integer>(); 
		h.add(2);
		h.add(1);
		//add each array to outer Array.class 
		theCache.add(a);
		theCache.add(b);
		theCache.add(c);
		theCache.add(d);
		theCache.add(e);
		theCache.add(f);
	//	theCache.add(g);
		theCache.add(h);
		
		
		theCache.sort((x,y) -> Integer.compare(x.get(0), y.get(0)));
		for(ArrayList<Integer> lists:theCache)
	            System.out.println(lists);
	   
	
	HashMap<Integer,Integer> caching = new HashMap<Integer,Integer>();
	ArrayList<Integer> answer = new ArrayList<Integer>();
	
	
	for(int i=0; i < theCache.size(); i++) {
	if(theCache.get(i).size() >1 ) {
     if(caching.containsKey(theCache.get(i).get(1)))
     {
    	 caching.computeIfPresent(theCache.get(i).get(1), (k, v) -> v + 3);
    	
     }
     else {
    	 caching.put((theCache.get(i).get(1)), 0);
    	 caching.computeIfPresent(theCache.get(i).get(1), (k, v) -> v + 3);	 
     }
	}
	   //TODO fix decrementation
		for(Map.Entry<Integer,Integer> map : caching.entrySet()){
		if(map.getValue() > 0)
			caching.put(map.getKey(), map.getValue()-1);
		}
	   
	}
	for (Integer name: caching.keySet()){
        Integer key = name;
        Integer value = caching.get(name);  
        System.out.println(key + " " + value);  
}
	for(Map.Entry<Integer,Integer> map : caching.entrySet()){

		if(map.getValue() > 3)
	     answer.add(map.getKey());
	}
	
	for (int i= 0; i < answer.size() ; i++) {
	System.out.println(answer.get(i));		
	}
}
}
