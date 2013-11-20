package com.amap.dataplatform.bi.util;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class SparseMatrix {

	/**
	 * @param args
	 */
	public final int R; //R*R 矩阵 
	public SparseVector[] rows; //R 行稀疏向量数组来表达稀疏矩阵
	
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
	//使用已有稀疏向量初始化矩阵
	public SparseMatrix(SparseVector[] spaVec)
	{
		this.R = spaVec.length;
		rows = new SparseVector[R];
		for(int i = 0; i < R; i++)
		{
			rows[i] = spaVec[i];
		}
	}
	public SparseMatrix(long[][] arr)
	{
		this.R = arr.length ;
	}
	//插入A[i][j]
	public void put(int i,int j,long val)
	{
		if (i < 0 || i > R) throw new RuntimeException("Illegal index");
		if (j < 0 || j > R) throw new RuntimeException("Illegal index");
		rows[i].put(j, val);
	}
	//更新A[i][j]
	public void update(int i,int j,long val)
	{
		if (i < 0 || i > R) throw new RuntimeException("Illegal index");
		if (j < 0 || j > R) throw new RuntimeException("Illegal index");
		long upval = rows[i].get(j) ;
	
			upval  += val;
			rows[i].put(j,upval);
					
	}
	//获取A[i][j]
	public long get(int i ,int j)
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
	//计算有向图顶点入度
	public long indegree(int vertex)
	{
		if(vertex > R) throw new RuntimeException("index out range!");
		long in = 0L;
		for(int i = 0; i < R; i++)
		{
			in += rows[i].get(vertex);
		}
		return in;
	}
	//计算有向图顶点出度
	public long outdegree(int vertex)
	{
		if(vertex > R) throw new RuntimeException("index out range!");
		long out = 0L;
		for(int i = 0; i < R ; i++)
		{
			out += rows[vertex].get(i);
		}
		return out;
	}
	//rewrite to string method
	public String toString ()
	{
		 StringBuilder s = new StringBuilder() ;
	        for (int i = 0; i < R; i++) 
	        {	        	
	        	for(int j = 0 ; j < R; j++)
	        	{	        		
	        		long ak = rows[i].get(j);
	        		s.append(ak);
	        		if(j < R-1) s.append(ConstantsParseInput.MatrixSeparator);
	        	}
	        	if(i < R -1 ) s.append(ConstantsParseInput.timeButtonSeparator);
	  	        }
	        return s.toString();
	}

    // return a string representation
    public String toPrettyString() {
        String s = "N = " + R + ", nonzeros = " + nnz() + "\n";
        for (int i = 0; i < R; i++) {
            s += i + ": " + rows[i] + "\n";
        }
        return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   SparseVector a = new SparseVector(5);
		   a.put(1, 10);
		   a.put(2, 20);
		   SparseVector b = new SparseVector(5);
		   b.put(1, 5);
		   b.put(3, 30);
		   SparseVector c = new SparseVector(5);
		   SparseVector d = new SparseVector(5);
		   SparseVector e = new SparseVector(5);
		   
		   SparseVector[] aA = {a,b,c,d,e};
		   SparseVector[] aB = {b,a,c,b,a};
		   SparseMatrix A = new SparseMatrix(5);
		   SparseMatrix B = new SparseMatrix(5);
	        A.put(0, 0, 1);
	        A.put(1, 1, 1);
	        A.put(0, 1, 100);
	        A.update(2, 2, 1);
	        A.update(2, 2, 3);
	        A.put(4, 4, 1);
	        A.put(2, 4, 0);
	        B.put(0, 0, 1);
	        B.put(1, 1, 1);
	        B.put(2, 3, 1);
	        B.put(3, 3, 1); 
	        
	        System.out.println("B     : " + B);
	        System.out.println("A     : " + A);
	        System.out.println("A.get    : " + A.get(3,1));
	     	System.out.println("A + B : " + A.plus(B));
	     	A=  A.plus(B);
	     	System.out.println("A     : " + A);
	     	System.out.println("A 1 in degree " + A.outdegree(1));
	     	System.out.println("A 1 out degree " + A.indegree(1));
	}

}
