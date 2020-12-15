import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemoveDuplicatesFromFile {
	public static void main(String[] args) {
		FileInputStream in =null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("inputFile.txt");
			out = new FileOutputStream("outputFile.txt");
			
			int c = 0;
			while((c = in.read()) != -1) {
				out.write(c);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
