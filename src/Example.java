import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Example extends HashMap<String, String> {
	public void setClassification(String classification) {
		put("classification", classification);
	}
	
	public String getClassification() {
		return get("classification");
	}
	
	// Using builder pattern to build the example with the correct keys and values according the the attributes
	public static class BuilderForAttributes {
		private final Attribute[] attributes; // Required
		private String[]          values;
		private String            classification;
		
		public BuilderForAttributes(Attribute[] attributes) {
			this.attributes = attributes;
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
			
			for (int i = 0; i < attributes.length; i++)
				example.put(attributes[i].name, values[i]);
				
			example.setClassification(classification);
			
			return example;
		}
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for (Map.Entry<String, String> entry : entrySet())
			str.append(entry.getKey() + ":\t " + entry.getValue() + "\n");

		return str.toString();
	}
}
