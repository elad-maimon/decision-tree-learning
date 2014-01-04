import java.util.ArrayList;

//This class represents list of examples by extending ArrayList
@SuppressWarnings("serial")
public class Examples extends ArrayList<Example> {
	public boolean empty() {
		return size() == 0;
	}
	
	// Returns a clone of the examples in the list that their attribute "key" has valu "value"
	public Examples selectByAttribute(String key, String value) {
		Examples selected_examples = new Examples();
		
		for (Example example : this)
			if (example.get(key).equals(value))
				selected_examples.add(example);
		
		return selected_examples;
	}

	// Returns a binary (2D) counter divided by the classification
	public BinaryCounter countByClassification() {
		BinaryCounter counter = new BinaryCounter();
		
		for (Example example : this)
			if (example.classification.equals("yes"))
				counter.pos++;
			else
				counter.neg++;
		
		return counter;
	}

	// If all examples in the list has the same calssification the return it, otherwise return null 
	public String getCommonClassification() {
		if (empty())
			return null;
		
		String base_classification = get(0).classification;
		
		for (Example example : this)
			if (!example.classification.equals(base_classification))
				return null;
		
		return base_classification;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Example example: this)
			str.append(example + "\n");
		
		return str.toString();
	}
}
