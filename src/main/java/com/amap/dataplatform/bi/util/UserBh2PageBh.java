package com.amap.dataplatform.bi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserBh2PageBh {

	/**
	 * @param args
	 */
	public UserBh2PageBh()
	{
		
	}
	/*将用户队列转换成页面行为向量
	 * @param usBArr 用户行为队列
	 */
	/*public static Map beList2pgVector(List<Integer> usBArr)
	{
		Map pgMap =  new TreeMap<Integer,Long>();
		for(int usStr : usBArr)
		{
			if(pgMap.containsKey(usStr))
			{
				long  val = (Long) pgMap.get(usStr);
				pgMap.put(usStr, val+1);
			}
			else
			{
				pgMap.put(usStr, 1);
			}
		}
	
		return pgMap;
	}*/
	/*将用户队列转换成页面行为矩阵
	 * @param usBArr 用户行为队列
	 */
	public static SparseMatrix beList2pgMatrix(List<Integer> usBArr ,int ml)
	{
		  SparseMatrix pgMatr = new SparseMatrix(ml);
		  for(int i = 1; i < usBArr.size(); i++)
		  {
			  int row = usBArr.get(i-1);
			  int col =  usBArr.get(i);
			  pgMatr.update(row, col, 1);
		  }
		  //System.out.println("Matrix " +pgMatr.toString());
		return pgMatr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<Integer> us = new ArrayList<Integer>();
	us.add(1);
	us.add(3);
	us.add(4);

	 SparseMatrix A = new SparseMatrix(5);
	   SparseMatrix B = UserBh2PageBh.beList2pgMatrix(us, 5);
      A.put(0, 0, 1);
      A.put(1, 1, 1);
      A.update(2, 2, 1);
      A.update(2, 2, 3);
      A.put(4, 4, 1);
      A.put(2, 4, 3);
	  System.out.println(A.plus(B));	
	}

}
