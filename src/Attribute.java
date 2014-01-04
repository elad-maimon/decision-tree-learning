public class Attribute {
	public String   key;
	public String[] values;
	
	public Attribute(String key, String[] values) {
		this.key = key;
		this.values = values;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer(key + ":\t\t ");

		for (String value : values)
			str.append(value).append(", ");
			
		return str.toString();
	}
}
