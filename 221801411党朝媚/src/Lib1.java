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
