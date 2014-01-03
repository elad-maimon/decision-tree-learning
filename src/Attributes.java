import java.util.ArrayList;

@SuppressWarnings("serial")
public class Attributes extends ArrayList<Attribute>{
	public boolean empty() {
		return size() == 0;
	}

	public Attributes reject(Attribute attribute_to_reject) {
		Attributes selected_attributes = (Attributes)clone();
		selected_attributes.remove(attribute_to_reject);
		return selected_attributes;
	}
	
	// TODO: not necessary
	public Attribute getByName(String name) {
		for (Attribute attribute : toArray())
			if (attribute.name.equals(name))
				return attribute;
		
		return null;
	}

	@Override
	public Attribute[] toArray() {
		return super.toArray(new Attribute[size()]);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Attribute attribute : toArray())
			str.append(attribute + "\n");
		
		return str.toString();
	}
}
