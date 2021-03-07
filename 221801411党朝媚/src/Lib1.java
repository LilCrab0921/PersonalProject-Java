package Wc;
import java.io.*;
import java.util.*;
public class Lib1 
{
	//计算文件字符数
	public String getCNum(String _filepath) throws IOException 
	{
        int Ccount = 0;
        int bytes = 0;
        String result = "";
        byte [] item = new byte[10*1024];
        int len = item.length;
        FileInputStream in = null;
                 in = new FileInputStream(_filepath);
                while ((bytes = in.read(item,0,len))!=-1) {//得到文件中的所有字符
                		Ccount+=bytes;//统计字符数
                }
                result += "characters: "+Ccount+"\n";
                Ccount = 0;
                in.close();
        return result;
    }
	//计算文件单词数
	public String getWNum(String _filepath) throws IOException 
	{
		int Wcount=0;
		String result="";
		StringBuffer saveStr=new StringBuffer();
		String temp="";
		FileInputStream in=null;
		InputStreamReader isr=null;
		BufferedReader bis=null;
		try {
				in=new FileInputStream(_filepath);
				isr=new InputStreamReader(in);
				bis=new BufferedReader(isr);
				while((temp=bis.readLine())!=null)
				{
					saveStr.append(temp);
					saveStr.append(" ");
				}
			in.close();
			isr.close();
			temp = saveStr.toString();
			temp=temp.replaceAll("[^A-Za-z0-9]", " ");//替换所有非字母数字的符号为空格
			temp=temp.toLowerCase();
			String [] allW = temp.split(" +");//单词以空格分割（所有非字母数字符号已经变成空格）
				Wcount=allW.length;
			    for(int i=0;i<allW.length;i++)
			    {
			    	String s=allW[i].toString();
			    	if(s.length()<4)//至少以4个英文字母开头
			    	{
			    		Wcount--;
			    	}
			    	else
			    	{
			    		for(int j=0;j<4;j++)
			    		{
			    			char c=s.charAt(j);
			    			if(!(c>='a'&&c<='z'))
			    			{
			    				Wcount--;
			    				break;
			    			}
			    		}
			    	}
			    }
				result += "words: "+Wcount+"\n";
				Wcount=0;
				bis.close();				
		return result;
    }
	//计算文件总行数
	public String getLNum(String _filepath) throws IOException //throws IOException

	{
		int Lcount=0;
		String result="";
		FileInputStream in=null;
		InputStreamReader isr=null;
		BufferedReader bis=null;
		in=new FileInputStream(_filepath);
		isr=new InputStreamReader(in);
		bis=new BufferedReader(isr);
		while(bis.readLine()!=null)//一次读取一行
		{
			Lcount++;
		}
		in.close();
		isr.close();
		result += "lines: "+Lcount+"\n";
		Lcount=0;
		bis.close();
		return result;
	}

	
		
}
