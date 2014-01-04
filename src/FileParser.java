import java.io.*;

// This class concerns the reading from the formatted input file and create the data structure necessary
// for the DTL class. It has main method for parsing the file (parseInputFile) and getters for the 
// data structures that stored during the parsing
public class FileParser {
	public static final String DELIMITER = ",";
	public static final String ATTR_TERMINATOR = "<END_ATTR>";
	public static final String TRAIN_TERMINATOR = "<END_TRAIN>";
	
	private Attributes attributes = new Attributes();
	private Examples   training_set = new Examples();
	private Examples   test_set = new Examples();

	public FileParser(String filename) {
		parseInputFile(filename);
	}

	public Attributes getAttributes()  { return attributes; }
	public Examples   getTrainingSet() { return training_set; }
	public Examples   getTestSet()     { return test_set; }
	
	private void parseInputFile(String filename) {
		BufferedReader br = null;
		String line;
		String[] parts;

		try {
			br = new BufferedReader(new FileReader(filename));

			// Reading attributes section
			while (!(line = br.readLine()).equals(ATTR_TERMINATOR)) {
				parts = line.split("\\s+");
				if (parts.length == 2)
					attributes.add(new Attribute(parts[0], parts[1].split(DELIMITER)));
			}

			// Reading training set section
			while (!(line = br.readLine()).equals(TRAIN_TERMINATOR)) {
				parts = line.split(", ");
				training_set.add(new Example.BuilderForAttributes(attributes)
											.values(parts[0].split(DELIMITER))
											.classification(parts[1])
											.build());
			}

			// Reading test set section
			while ((line = br.readLine()) != null) {
				parts = line.split(", ");
				test_set.add(new Example.BuilderForAttributes(attributes)
										.originalLine(line)
										.values(parts[0].split(DELIMITER))
										.classification(parts[1])
										.build());
			}
		} catch (IOException e) {
			System.out.println("Error occured while reading input file");
			e.printStackTrace();
		} finally {
			if (br != null)
				try { br.close(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
}
