public class Attribute {
	public String   name;
	public String[] values;
	
	public Attribute(String name, String[] values) {
		this.name = name;
		this.values = values;
	}

	public String toString() {
		StringBuffer str = new StringBuffer(name + ": ");

		for (String value : values)
			str.append(value).append(", ");
			
		return str.toString();
	}
}
