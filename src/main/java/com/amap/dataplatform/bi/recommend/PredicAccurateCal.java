package com.amap.dataplatform.bi.recommend;

public class PredicAccurateCal {

	/**
	 * sample of calculate recommend system  evaluation values
	 * @param args
	 */
	static int[][] records =  {{0,0,5,1},{0,1,4,1},{0,2,4,2},{1,0,1,5},{1,1,2,5},{1,2,2,3}
	 ,{2,0,4,2},{2,1,4,4}};
	static int[][] crecords =  {{5,1},{4,1},{4,2},{1,5},{2,5},{2,3},{4,2},{4,4}};
	public static void RMSECal()
	{
		
		int leng = records.length;
		float mse = 0;
		for(int[] row : records)
		{
			
			 mse += (row[0]-row[1])*(row[0]-row[1]);
			 //System.out.println("mse "+mse);
		}
		double rmse = Math.sqrt(mse/leng);
		System.out.println("rmse: "+rmse);
		
	}
	public static void MAECal()
	{
		int len  = crecords.length;
		float ma = 0;
		for(int[] r : crecords)
		{
			ma += Math.abs(r[0]-r[1]);
		}
		double mae = ma/len;
		System.out.println(mae);
	}
	public static void preciRec()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PredicAccurateCal.RMSECal();
		PredicAccurateCal.MAECal();
	}

}
