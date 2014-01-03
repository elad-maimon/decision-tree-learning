import java.util.ArrayList;

public class Attributes {
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();

	public void add(String name, String[] values) {
		attributes.add(new Attribute(name, values));
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Attribute attribute : attributes) {
			str.append(attribute.name).append(": ");
			
			for (String value : attribute.values)
				str.append(value).append(", ");
			
			str.append("\n");
		}
		
		return str.toString();
	}
}
