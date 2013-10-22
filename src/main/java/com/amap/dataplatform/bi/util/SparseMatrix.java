package com.amap.dataplatform.bi.util;

public class SparseMatrix {

	/**
	 * @param args
	 */
	private final int R;
	private SparseVector[] rows;
	
	//初始化 R*R的矩阵
	public SparseMatrix(int R)
	{
		this.R = R;
		rows = new SparseVector[R];
		for(int i = 0; i < R; i++)
		{
			//rows[i] = new SparseVector[R];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
