import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	private Attributes attributes;
	private int training_set;
	private int test_set;

	public FileParser(String filename) {
		parseInputFile(filename);
	}

	public Attributes getAttributes() { return attributes; }
	public int getTrainingSet()       { return training_set; }
	public int getTestSet()           { return test_set; }
	
	private void parseInputFile(String filename) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filename));

// 			this.algorithm = br.readLine().charAt(0);
 			
 		} catch (IOException e) {
			System.out.println("Error occured while reading input file");
			e.printStackTrace();
		} finally {
			if (br != null)
				try { br.close(); } catch (IOException e) { e.printStackTrace(); }
		}
		
	}
}
