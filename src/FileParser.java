import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	public static final String DELIMITER = ",";
	public static final String ATTR_TERMINATOR = "<END_ATTR>";
	public static final String TRAIN_TERMINATOR = "<END_TRAIN>";
	
	private Attribute[] attributes;
	private Example[]   training_set;
	private Example[]   test_set;

	public FileParser(String filename) {
		parseInputFile(filename);
	}

	public Attribute[] getAttributes()  { return attributes; }
	public Example[]   getTrainingSet() { return training_set; }
	public Example[]   getTestSet()     { return test_set; }
	
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
					attributes_list.add(new Attribute(parts[0], parts[1].split(DELIMITER)));
			}
			attributes = attributes_list.toArray(new Attribute[attributes_list.size()]);

			// Reading training set section
			ArrayList<Example> training_set_list = new ArrayList<Example>();
			while (!(line = br.readLine()).equals(TRAIN_TERMINATOR)) {
				parts = line.split(", ");
				training_set_list.add(new Example.BuilderForAttributes(attributes)
										  .values(parts[0].split(DELIMITER))
										  .classification(parts[1])
										  .build());
			}
			training_set = training_set_list.toArray(new Example[training_set_list.size()]);

			// Reading test set section
			ArrayList<Example> test_set_list = new ArrayList<Example>();
			while ((line = br.readLine()) != null) {
				parts = line.split(", ");
				test_set_list.add(new Example.BuilderForAttributes(attributes)
										  .values(parts[0].split(DELIMITER))
										  .classification(parts[1])
										  .build());
			}
			test_set = test_set_list.toArray(new Example[test_set_list.size()]);
		} catch (IOException e) {
			System.out.println("Error occured while reading input file");
			e.printStackTrace();
		} finally {
			if (br != null)
				try { br.close(); } catch (IOException e) { e.printStackTrace(); }
		}
		
	}
}
