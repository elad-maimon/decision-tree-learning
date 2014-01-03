import java.util.HashMap;

public class Example extends HashMap<String, String> {
	public void setClassification(String classification) {
		this.put("classification", classification);
	}
	
	public String getClassification() {
		return this.get("classification");
	}
	
	public static class Builder {
		private Attributes attributes;
		private String[]   values;
		private String     classification;

		public Builder withAttributes(Attributes attributes) {
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
			
			for (Attribute attr : attributes) {
				example.attributes.pu
			}
			
			return example;
		}
	}

}

//if (classification.equals("yes"))
//	this.classification = true;
//else if (classification.equals("no"))
//	this.classification = false;
//else {
//	System.out.println("Recived error classification: " + classification);
//	System.exit(1);
//}
