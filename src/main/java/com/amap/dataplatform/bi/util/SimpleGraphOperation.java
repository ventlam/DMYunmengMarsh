package com.amap.dataplatform.bi.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class SimpleGraphOperation {

	/**
	 * @param args
	 */
	public static long calDegree(SparseMatrix spm,int vertex)
	{
	
		
		return 0L;
	}
	public static long travelGraph(SparseMatrix spm,String sVet,String eVet)
	{
		
		int a = PBID2MatrixIndex.verChange("IOSH050300", sVet);
		int b = PBID2MatrixIndex.verChange("IOSH050300",eVet);
		long traRes = spm.get(a, b);
		System.out.println(sVet+" --> "+eVet+": "+traRes);
		return traRes;	
	}
	public static SparseMatrix genMatrfromFile(String path) throws IOException
	{
		SparseMatrix sm = new SparseMatrix(ConstantsParseInput.MatrixLength);
		
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				//pageArr.add(strLine);
				//System.out.println(strLine);
			String[] textrows = strLine.split(ConstantsParseInput.timeButtonSeparator);
			//System.out.println(textrows[0]);
			for(int i = 0; i < textrows.length ; i++)
			{
				
				String[] textcols= textrows[i].split(ConstantsParseInput.MatrixSeparator);
				//System.out.println(textcols[0]);
				for(int j = 0; j < textcols.length ; j++)
				{
					long ele = Long.parseLong(textcols[j]);
					if(ele != 0)sm.update(i, j, ele);				
				}
			}
			 System.out.println (sm.toPrettyString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Close the input stream
		br.close();
		return sm;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path1 = "D:\\20131026usergraph.txt";
		String path2 = "D:\\20131029IOSH050300.txt";
		SparseMatrix sm = SimpleGraphOperation.genMatrfromFile(path2);
		String[] endver ={"1410","1411","1412","1413","1415","1424","1600"};
		String[] staver ={"0703","1410","1411","1412","1413","1415","1424","1600"};
	/*	for(int i = 0; i < staver.length; i++)
		{
			for(int j = 0; j < staver.length;j++ )
			{
				SimpleGraphOperation.travelGraph(sm, staver[i],staver[j]) ;
			}
		}*/
	    
	    }

}
