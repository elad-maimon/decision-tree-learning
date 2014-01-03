public class Attributes {
	private Attribute[] attributes;

	public Attributes(Attribute[] attributes) {
		this.attributes = attributes;
	}
	
	public Attribute get(int i) {
		return attributes[i];
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Attribute attribute : attributes)
			str.append(attribute);
		
		return str.toString();
	}
}
