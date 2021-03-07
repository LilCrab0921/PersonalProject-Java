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
//输出频率最高的10个词汇
	public String getTopTenCommonWords(String _filepath) throws IOException //throws IOException
	{
		String result="";
		StringBuffer saveStr=new StringBuffer();
		String temp="";
		FileInputStream in=null;
		InputStreamReader isr=null;
		BufferedReader bis=null;
		in=new FileInputStream(_filepath);
		isr=new InputStreamReader(in);
		bis=new BufferedReader(isr);
		while((temp=bis.readLine())!=null)
		{
			saveStr.append(temp);
			saveStr.append(" ");
		}
		Map<String,Integer>map = new HashMap<String, Integer>();//运用哈希排序的方法进行排序
		temp = saveStr.toString();
		temp=temp.replaceAll("[^A-Za-z0-9]", " ");
		temp=temp.toLowerCase();
	        StringTokenizer st = new StringTokenizer(temp," ");//分割字符串
		//用来测试是否有此标记生成器的字符串可以有更多的标记。并把分割好的单词保存在letter字符串中。
	          while (st.hasMoreTokens()) 
	          {
	                String letter = st.nextToken();
	                int count;
	                if (map.get(letter) == null) {
	                    count = 1;
	                } else {
	                    count = map.get(letter).intValue() + 1;
	                }
	                map.put(letter,count);
	            }
	            Set<WordEntity> set = new TreeSet<WordEntity>();
	            for (String key : map.keySet()) {
	                 set.add(new WordEntity(key,map.get(key)));
	             }
			in.close();
			isr.close();
	            int count=1;
	            for (Iterator<WordEntity> it = set.iterator(); it.hasNext();) {
	                 WordEntity w = it.next();
	                 boolean isWords=true;
	                 if(w.getKey().length()>4)
	                 {
	                	 String s=w.getKey();
	                	 for(int i=0;i<4;i++)
	                	 {
	                		 char c=s.charAt(i);
  			    			 if(!(c>='a'&&c<='z'))
  			    			 {
  			    				isWords=false;
  			    				break;
  			    			 }
	                	 }
	                	 if(isWords==true)
	                	 {
	                	     result+=w.getKey()+": "+w.getCount()+"\n";
	                	     if(count==10)// 当输出10个后跳出循环
	                	     {
	                		    break;
	                	     }   
	                         count++;
				bis.close();
		return result;
	}
				 
//将输出结果写入指定文件夹
public boolean WriteFile(String File_path,String Context) throws IOException {
		File OutputFile = new File(File_path); 
		FileOutputStream os = null; 
		byte [] a = null; 
			if(!OutputFile.exists()) {        
				OutputFile.createNewFile(); 
			}
			FileWriter fileWriter =new FileWriter(File_path);
			fileWriter.write("");
		    fileWriter.flush();
		    fileWriter.close();
			os = new FileOutputStream(OutputFile); 
			a = Context.getBytes(); 
			os.write(a); 
			os.close(); 			
		return true;
	}


	
		
}
