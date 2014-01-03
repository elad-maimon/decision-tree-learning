import java.util.ArrayList;

public class Attribute {
	public String name;
	public ArrayList<String> values = new ArrayList<String>();
	
	public Attribute(String name, ArrayList<String> values) {
		this.name = name;
		this.values = values;
	}
}
