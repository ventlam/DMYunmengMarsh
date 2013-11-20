package com.amap.dataplatform.bi.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class UserBehavior {

	/**
	 * @param args
	 */
	public static List<List> RouteSplit(List<Long> timeList ,List<Integer> pbidList,long interval)
	{	
		if(timeList.size()!= pbidList.size() ) throw new RuntimeException("input lists size don't match");
		List<List> subLists =  new ArrayList<List>();
		if(timeList.size() != pbidList.size()) throw new RuntimeException();	
		int size = timeList.size();
		int from = 0;
		for(int i = 1 ; i < size ; i++)
		{
			if(timeList.get(i) - timeList.get(i-1) > interval)
			{						
				subLists.add(pbidList.subList(from, i));
				from = i ;
			}
			
		}
		subLists.add(pbidList.subList(from, size));
		//
		//System.out.println("SubLists "+subLists);
		return subLists;
	}
/*	public static ArrayList<NavigableMap<Integer,Double>> TreeMapSplit(TreeMap<Integer,Double> tm,long interval)
	{
		ArrayList<NavigableMap<Integer,Double>> subMaps = new ArrayList<NavigableMap<Integer,Double>>();
		
		//int from = tm.firstKey();
		//int to   = tm.lastKey();
		
		Integer[] keyArr = tm.keySet().toArray(new Integer[0]);
		int j = 0;
		int size = keyArr.length;
		for(int i = 1; i < keyArr.length ; i++)
		{
			
			if(keyArr[i]-keyArr[j] > interval)
			{	
				//TreeMap aa = (TreeMap) tm.subMap(keyArr[j],keyArr[i] );
				//System.out.println("aa" + aa);
				subMaps.add( tm.subMap(keyArr[j],true,keyArr[i],false ));
				j = i;		
				System.out.println("Sub map values: "+tm.subMap(from, to));   
				 
			}
		
			System.out.println("i : " +i);
			
		}
		subMaps.add( tm.subMap(keyArr[j],true,keyArr[size-1],true ));
		System.out.println("Submaps: "+subMaps);  
//		/System.out.println("tm: "+tm); 
		return subMaps ;
	
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	TreeMap<Integer,Double> tm = new TreeMap<Integer,Double>();
		tm.put(10,21.0);
		tm.put(9, 11.0);
		tm.put(29, 11.5);
		tm.put(30, 11.5);
		tm.put(33,111.1);
		tm.put(111, 1111.1);
		ArrayList<NavigableMap<Integer,Double>> ak =ActionMapSplit.TreeMapSplit(tm, 15);
	//	System.out.println(ak.get(0));
		SparseVector a = new SparseVector(200,ak.get(0));
		SparseVector b = new SparseVector(200,ak.get(1));
		System.out.println("a + b   = " + a.plus(b));*/
		long interval = 30L;
		List<Long> tl =  new ArrayList<Long>();
		tl.add(125L);
		tl.add(123L);
		tl.add(199L);
		tl.add(200L);
		tl.add(214L);
		tl.add(322L);
		/*Collections.sort(tl);
		*/
		List<Integer>  pl = new ArrayList<Integer>();
		pl.add(123);
		pl.add(125);
		pl.add(199);
		pl.add(200);
		pl.add(214);
		pl.add(322);
		List<List> ak  = UserBehavior.RouteSplit(tl, pl, interval);
		
	}

}
