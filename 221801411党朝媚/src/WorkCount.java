package Wc;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class WordCount {
	public static void main(String[] args) throws IOException {
		String inputPaths="";
	    Scanner in=new Scanner(System.in);
		inputPaths=in.nextLine();
		String [] iofilepaths = inputPaths.split("[\\s+]");
		String inputFile,outputFile;
		inputFile=iofilepaths[0].toString();
		outputFile=iofilepaths[1].toString();//输入input.txt，将结果输出至output.txt
		File input=new File(inputFile);
		if(input.exists()) //输入非空且文件存在
		{
			String characters,words,lines,TopTenWords;
			//分别用来存放返回的字符数、单词数、行数、频率top10词汇
			characters=new Lib1().getCNum(inputFile);
			words=new Lib1().getWNum(inputFile);
			lines=new Lib1().getLNum(inputFile);
			TopTenWords=new Lib1().getTopTenCommonWords(inputFile);
			String results=characters+words+lines+TopTenWords;
		    if(new Lib1().WriteFile(outputFile, results))//判断是否成功将结果写入指定文件
		    {
			    System.out.println("操作成功，结果已输出至"+outputFile);
		    }
		    else
		    {
				System.out.println("出错");
		    }
		    }
	    in.close();//关闭输入流
	}
}
