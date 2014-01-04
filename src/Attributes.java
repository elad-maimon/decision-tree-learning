import java.util.ArrayList;

// This class represents list of attributes. It extends AttayList and add a method to reject an attribute
// from the list.
@SuppressWarnings("serial")
public class Attributes extends ArrayList<Attribute>{
	public boolean empty() {
		return size() == 0;
	}

	// Reject an attribute. This methods returns a cloned attributes without the rejected one.
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
