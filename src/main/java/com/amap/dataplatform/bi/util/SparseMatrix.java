package com.amap.dataplatform.bi.util;

public class SparseMatrix {

	/**
	 * @param args
	 */
	private final int R; //R*R 矩阵 
	private SparseVector[] rows; //R 行稀疏向量数组来表达稀疏矩阵
	
	//初始化 R*R的矩阵
	public SparseMatrix(int R)
	{
		this.R = R;
		rows = new SparseVector[R];
		for(int i = 0; i < R; i++)
		{
			rows[i] = new SparseVector(R);
		}
	}
	//插入A[i][j]
	public void put(int i,int j,double val)
	{
		if (i < 0 || i > R) throw new RuntimeException("Illegal index");
		if (j < 0 || j > R) throw new RuntimeException("Illegal index");
		rows[i].put(j, val);
	}
	//获取A[i][j]
	public double get(int i ,int j)
	{
		if (i < 0 || i > R) throw new RuntimeException("Illegal index");
		if (j < 0 || j > R) throw new RuntimeException("Illegal index");
		return rows[i].get(j);
	}
	//获取非零值
	public int nnz()
	{
		int sum = 0;
		for (int i = 0; i < R; i++)
		{
			sum += rows[i].nnz();
		}
		return sum;
	}
	//矩阵相加 C = A+B
	public SparseMatrix plus(SparseMatrix B)
	{
		SparseMatrix A = this;
		if(A.R != B.R) throw new RuntimeException("Dimensions Dismatch");
		SparseMatrix C = new SparseMatrix(R);
		for(int i = 0; i < R; i++)
		{
			C.rows[i] = A.rows[i].plus(B.rows[i]);
		}
		return C;
	}
	//rewrite to string method
	public String toString ()
	{
		 String s = "N = " + R + ", nonzeros = " + nnz() + "\n";
	        for (int i = 0; i < R; i++) {
	            s += i + ": " + rows[i] + "\n";
	        }
	        return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   SparseMatrix A = new SparseMatrix(5);
		   SparseMatrix B = new SparseMatrix(5);
	        A.put(0, 0, 1.0);
	        A.put(1, 1, 1.0);
	        A.put(2, 2, 1.0);
	        A.put(3, 3, 1.0);
	        A.put(4, 4, 1.0);
	        A.put(2, 4, 0.3);
	        B.put(0, 0, 1.0);
	        B.put(1, 1, 1.0);
	        B.put(2, 3, 1.0);
	        B.put(3, 3, 1.0);
	        System.out.println("B     : " + B);
	        System.out.println("A     : " + A);
	     	System.out.println("A + B : " + A.plus(B));
	}

}
