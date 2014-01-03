import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	public static final String DELIMITER = ",";
	public static final String ATTR_TERMINATOR = "<END_ATTR>";
	public static final String TRAIN_TERMINATOR = "<END_TRAIN>";
	
	private Attribute[] attributes;
	private int         training_set;
	private int         test_set;

	public FileParser(String filename) {
		parseInputFile(filename);
	}

	public Attribute[] getAttributes()  { return attributes; }
	public int         getTrainingSet() { return training_set; }
	public int         getTestSet()     { return test_set; }
	
	private void parseInputFile(String filename) {
		BufferedReader br = null;
		String line;
		String[] parts;

		try {
			br = new BufferedReader(new FileReader(filename));

			// Reading attributes section
			ArrayList<Attribute> attributes_list = new ArrayList<Attribute>();
			while (!(line = br.readLine()).equals(ATTR_TERMINATOR)) {
				parts = line.split("\\s+");
				if (parts.length == 2)
					attributes_list.add(new Attribute(parts[0], parts[1].split(",")));
			}
			
			attributes = (Attribute[])attributes_list.toArray();

 		} catch (IOException e) {
			System.out.println("Error occured while reading input file");
			e.printStackTrace();
		} finally {
			if (br != null)
				try { br.close(); } catch (IOException e) { e.printStackTrace(); }
		}
		
	}
}
