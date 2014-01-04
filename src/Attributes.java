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

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Attribute attribute : this)
			str.append(attribute + "\n");
		
		return str.toString();
	}
}
