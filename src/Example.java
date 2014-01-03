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
		private final Attributes attributes; // Required
		private String[]         values;
		private String           classification;
		
		public BuilderForAttributes(Attributes attributes) {
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
			
			for (int i = 0; i < attributes.size(); i++)
				example.put(attributes.get(i).name, values[i]);
				
			example.setClassification(classification);
			
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
