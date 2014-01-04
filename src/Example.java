import java.util.HashMap;
import java.util.Map;

// This class represents an example. Example can be both train example or test example.
// It extends HashMap so each example has a list of attributes and the specific value for it.
// It also include the classification of the example and the raw original creating line for output purpose. 
@SuppressWarnings("serial")
public class Example extends HashMap<String, String> {
	public String classification;
	public String original_line;
	
	// Using builder pattern to build the example with the correct keys and values according the the attributes
	public static class BuilderForAttributes {
		private final Attributes attributes; // Required
		private String[]         values;
		private String           classification;
		private String           original_line;
		
		public BuilderForAttributes(Attributes attributes) {
			this.attributes = attributes;
		}

		public BuilderForAttributes originalLine(String line) {
			this.original_line = line;
			return this;
		}

		public BuilderForAttributes values(String[] values) {
			this.values = values;
			return this;
		}
		
		public BuilderForAttributes classification(String classification) {
			this.classification = classification;
			return this;
		}
		
		public Example build() {
			Example example = new Example();
			
			for (int i = 0; i < attributes.size(); i++)
				example.put(attributes.get(i).key, values[i]);

			example.original_line = original_line;
			example.classification = classification;
			
			return example;
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for (Map.Entry<String, String> entry : entrySet())
			str.append(entry.getKey() + ": " + entry.getValue() + ",\t ");

		return str.toString();
	}
}
