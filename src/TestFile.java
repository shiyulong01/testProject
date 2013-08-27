import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class TestFile {
	
	public void readDataTofile(String srcPath, String tarPath){
		int n = 1000;//读取n行进行一次写入
		BufferedReader br = null;
		FileReader fr = null;
		InputStreamReader isr = null;
		BufferedWriter bw =null;
		FileWriter fw = null;
		try {
			fr = new FileReader(new File(srcPath));
			isr = new InputStreamReader(new FileInputStream(srcPath), "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(isr);
		String str = "";
		String content = "";
		int line = 0;
		try {
			while((str= br.readLine())!= null&&line<n){
				content+= str + "/n";
				if(line%10000==0){
					System.out.println("readline: " + line);
				}
				line++;
			}
			fw = new FileWriter(new File(tarPath));
			fw.write(content);
			fw.close();
			fr.close();
			br.close();
			System.out.println("total: " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
//		String path = "/home/yulong/store/33.txt";
//		String content = "adasdasdjasfjoishfoihaofhodshfoisdhfoiasdhfoiashfoiah\n"+"dfsiofhosidhfoidshfoisdfh";
//	    try {
//	    	File file = new File(path);
//			FileInputStream fs = new FileInputStream(file);
//			long size = fs.available();
//			fs.close();
//			System.out.println(size);
//			FileWriter fw = new FileWriter(file);
//			fw.write(content);
//			fw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		TestFile tf = new TestFile();
		tf.readDataTofile("/home/yulong/data/sogouQ.log", "/home/yulong/data/sogouQ.txt");
	}

}
