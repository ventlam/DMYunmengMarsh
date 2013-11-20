package com.amap.dataplatform.bi.util;
/*
 * 构建R*C矩阵，以及相关矩阵运算
 */
public class DensMatrix {

	/**
	 * @param args
	 */
	private final int R ; //行数
	private final int C ; //列数
	private final double[][] data; //R*C矩阵
	
	//create r*c matrix of 0
	public DensMatrix(int R,int C)
	{
		this.R = R ;
		this.C = C ;
		data = new double[R][C];
	}
	//create matrix based on array
	public DensMatrix(double[][]data)
	{
		R = data.length;
		C = data[0].length;
		this.data = new double[R][C];
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				this.data[i][j]= data[i][j];
			}
		}
	}
	  // print matrix to standard output
    public void show() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) 
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }
    // return V = A + B
    public DensMatrix plus(DensMatrix B) {
    	DensMatrix A = this;
        if (B.R != A.R || B.C != A.C) throw new RuntimeException("Illegal matrix dimensions.");
        DensMatrix V = new DensMatrix( R , C);
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C ; j++)
                V.data[i][j] = A.data[i][j] + B.data[i][j];
        return V;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] a = {{1,0,1},{2,2,3}};
		DensMatrix gm = new DensMatrix(a);
		gm.show();
		
	}
	

}
