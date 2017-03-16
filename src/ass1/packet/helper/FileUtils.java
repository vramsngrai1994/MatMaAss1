package ass1.packet.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileUtils {

	public static String ASSEST_DIR = "./src/assest";
	
	public static boolean isFileExist(String fileName){
		File file = new File(fileName);
		return file.exists();
	}
	
	public static Object readFileObject(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
	    Object obj = null;
		ObjectInputStream inputStream = null;
	    try{
		    inputStream = new ObjectInputStream(new FileInputStream(fileName));
		     obj =  inputStream.readObject();
	    }finally {
		    inputStream.close();
		}
		return obj;
	}

	public static String readPlainFile(String fileName) throws IOException {
		StringBuilder result = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String curLine = null;
			while ((curLine = reader.readLine()) != null) {
				result.append(curLine);
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result.toString();

	}

	public static void writeToFile(String fileName, String content) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(content);
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

}
