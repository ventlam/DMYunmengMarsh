package com.amap.dataplatform.bi.util;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/*
 * 稀疏向量，使用符号表实现(符号表可以用Tree Map来代替)
 */
public class SparseVector {

	/**
	 * @param args
	 */
	private final int N ; //length
	private NavigableMap<Integer,Long> st;
	//初始化稀疏向量
	public SparseVector(int N)
	{
		this.N = N;
		this.st = new TreeMap<Integer,Long>();
	}
	public SparseVector(NavigableMap<Integer,Long> tm)
	{
		this.N = tm.size();
		this.st = tm ;
	}
	public SparseVector(int N,NavigableMap<Integer,Long> tm)
	{
		this.N = N;
		this.st = tm ;
	}

	//稀疏向量插入key-value
	public void put(int i ,long value)
	{
		if(i < 0 || i >= N)
		{
			throw new RuntimeException("Illegal Index");
		}
		else
			st.put(i, value);
	}
	//稀疏向量取值
	public long get(int i)
	{
		if(i < 0 || i >= N)
		{
			throw new RuntimeException("Illegal Index");
		}
		if(st.containsKey(i)) return st.get(i);
		else return 0;		
	}
	//返回不为0的实体数量
	public int nnz()
	{
		return st.size();
	}
	//返回稀疏向量大小
	public int size()
	{
		return N;
	}
	//返回与b向量的点乘结果
	public long dotPro(SparseVector b)
	{
		SparseVector a = this;
		if(a.N!=b.N) throw new RuntimeException("Vector lengths disagree");
		long sum = 0;
		//遍历元素不为零较少的稀疏向量
		if(a.nnz() <= b.nnz())
		{
			for(Map.Entry<Integer,Long> entry :a.st.entrySet())
			{
				if(b.st.containsKey(entry.getKey()))
				{		
					sum += b.st.get(entry.getKey()) * entry.getValue();
				}
			}
		}
		else
		{
			for(Map.Entry<Integer, Long>entry : b.st.entrySet())
			{
				if(a.st.containsKey(entry.getKey()))
				{
					sum += entry.getValue() * a.st.get(entry.getKey());
				}
			}
		
		}
		return sum;
	}
	//返回向量和
	public SparseVector plus(SparseVector b)
	{
		SparseVector a = this ;
		if(a.N != b.N)
		{
			throw new RuntimeException("Vector Length Dismatch");
		}
		SparseVector c =  new SparseVector(N);
		//c = a, should have clone method
		for(Map.Entry<Integer, Long>entry : a.st.entrySet())
		{
			c.put(entry.getKey(), entry.getValue());
		}
		for(Map.Entry<Integer, Long>entry : b.st.entrySet())
		{
			c.put(entry.getKey(),c.get(entry.getKey())+entry.getValue());
		}
		return c;
	}
	   // return a string representation
  public String toString() {
        String s = "";
        for (Map.Entry<Integer, Long>entry : st.entrySet()) {
            s += "(" + entry.getKey() + ", " + st.get(entry.getKey()) + ") ";
        }
        return s;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,Long> tm = new TreeMap<Integer,Long>();
		tm.put(3, 60L);
		tm.put(4,90L);
	    SparseVector a = new SparseVector(10);
	    SparseVector b = new SparseVector(10);
	    SparseVector c = new SparseVector(10,tm);
	    SparseVector d = new SparseVector(tm);
	        a.put(3, 50);
	        a.put(9, 75);
	        a.put(6, 11);
	        a.put(6, 00);
	        b.put(3, 60);
	        b.put(4, 90);
	        System.out.println("a = " + a);
	        System.out.println("b = " + b);
	        System.out.println("c = " + c);
	        System.out.println("d = " + d);
	    //    System.out.println("a dot b = " + a.dotPro(b));
	        System.out.println("a + b   = " + a.plus(b));
	        System.out.println("a + c   = " + a.plus(c));
	}

}
