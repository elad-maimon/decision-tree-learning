// This class represents an attribute. It has key and list of optional values
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
