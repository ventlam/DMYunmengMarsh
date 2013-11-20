package com.amap.dataplatform.bi.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CrePBIdArr {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static ArrayList<String> readTxt(String path) throws IOException
	{
		ArrayList<String> pageArr = new ArrayList<String>();
		// Open the file
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
				pageArr.add(strLine);
			  //System.out.println (strLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Close the input stream
		br.close();
		return pageArr;
	}
	public static ArrayList<String> GeneratePgBtIdArr(ArrayList pgidArr,ArrayList btidArr)
	{
		if(pgidArr.size()!=btidArr.size()) throw new RuntimeException("array list size dont match!");
		ArrayList<String> pgbtArr = new ArrayList<String>();
		//String s = "\"";
		for(int i = 0; i < pgidArr.size(); i ++)
		{
			String pgid = String.format("%04d", Long.parseLong(pgidArr.get(i).toString()));
			String btid = String.format("%02d", Long.parseLong(btidArr.get(i).toString()));
			pgbtArr.add(pgid+btid);		
		}
		
		//System.out.println(pgidArr.toArray().toString());
		return pgbtArr;
		
	}
	public static String toString(ArrayList<String> pgbtArr)
	{
		StringBuffer ptStr = new StringBuffer();
		ptStr.append("{");
		for(String ss : pgbtArr)
		{
			ptStr.append("\"");
			ptStr.append(ss);
			ptStr.append("\",");
		}
		ptStr.append("}");
		return ptStr.toString();
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//andriod 050201
		String pg1 = "D:\\pageversion\\pgid-and050201.txt";
		String bt1 = "D:\\pageversion\\btid-and050201.txt";
		
		//ios 050201
		String pg2 = "D:\\pageversion\\pgid-ios050201.txt";
		String bt2= "D:\\pageversion\\btid-ios050201.txt";
		
		//andriod 050301
		String pg3 = "D:\\pageversion\\pgid-and050301.txt";
		String bt3 = "D:\\pageversion\\btid-and050301.txt";
		
		//ios 050300
		String pg4 = "D:\\pageversion\\pgid-ios050300.txt";
		String bt4 = "D:\\pageversion\\btid-ios050300.txt";
		
		//andriod 060000		
		String pg5 = "D:\\pageversion\\pgid-and060000.txt";
		String bt5 = "D:\\pageversion\\btid-and060000.txt";

		//ios 060000		
		String pg6 = "D:\\pageversion\\pgid-ios060000.txt";
		String bt6 = "D:\\pageversion\\btid-ios060000.txt";
		
		//andriod 060001		
		String pg7 = "D:\\pageversion\\pgid-and060001.txt";
		String bt7 = "D:\\pageversion\\btid-and060001.txt";
		
		ArrayList<String> pl = CrePBIdArr.readTxt(pg7);
		ArrayList<String> p2 = CrePBIdArr.readTxt(bt7);
		ArrayList<String> al = CrePBIdArr.GeneratePgBtIdArr(pl, p2);
		System.out.println(CrePBIdArr.toString(al));
	}

}
