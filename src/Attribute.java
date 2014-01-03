public class Attribute {
	public String   name;
	public String[] values;
	
	public Attribute(String name, String[] values) {
		this.name = name;
		this.values = values;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer(name + ":\t\t ");

		for (String value : values)
			str.append(value).append(", ");
			
		return str.toString();
	}
}
