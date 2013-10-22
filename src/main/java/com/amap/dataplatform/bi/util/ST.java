package com.amap.dataplatform.bi.util;

import java.util.Iterator;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>,Value> implements Iterable<Key> {

	/**
	 * @param args
	 */
	private TreeMap<Key,Value> st;
	//初始空符号表
	public ST()
	{
		st = new TreeMap<Key,Value>();
		
	}
	/*
	 * return value associated with the given key
	 * @param key the key
	 */
	public Value get(Key key)
	{
		if(key == null)
		{
			throw new NullPointerException("called get() with null key!");
		}
		return st.get(key);
	}
	/*
	 * insert key-value pair into symbol table,overwrite the old value
	 * @param key the key
	 * @param val the value
	 */
	public void put(Key key,Value val)
	{
		if(key == null) 
		{
			throw new NullPointerException("called put() with null key");
		}
		if(val == null)
		{
			st.remove(key); 
		}
		else st.put(key, val);
	}
	/*
	 * delete the key-value pair 
	 * @param key the key
	 */
	public void del (Key key)
	{
		if(key == null ) 
		{
			throw new NullPointerException("call del() with null key");
		}
		st.remove(key);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
