import java.util.HashMap;

@SuppressWarnings("serial")
public class Example extends HashMap<String, String> {
	public void setClassification(String classification) {
		this.put("classification", classification);
	}
	
	public String getClassification() {
		return this.get("classification");
	}
	
	public static class Builder {
		private Attribute[] attributes;
		private String[]    values;
		private String      classification;

		public Builder withAttributes(Attribute[] attributes) {
			this.attributes = attributes;
			return this;
		}

		public Builder withValues(String[] values) {
			this.values = values;
			return this;
		}
		
		public Builder classification(String classification) {
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
}
