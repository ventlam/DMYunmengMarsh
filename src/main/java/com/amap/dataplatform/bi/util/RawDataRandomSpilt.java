package com.amap.dataplatform.bi.util;

import java.util.Random;

import com.amap.dataplatform.bi.recommend.PredicAccurateCal;

public class RawDataRandomSpilt {
	
	/*
	 * 生成伪随机种子，用于均匀切分数据集
	 */
	public static int genrateRanWeed()
	{
		long seed = 10248964;
		int range = 10 ;
		Random rweed = new Random(seed);
		int rand = rweed.nextInt(range);
		return rand;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RawDataRandomSpilt.genrateRanWeed();
		
	}

}
