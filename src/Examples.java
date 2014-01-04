import java.util.ArrayList;

@SuppressWarnings("serial")
public class Examples extends ArrayList<Example> {
	public boolean empty() {
		return size() == 0;
	}
	
	public Examples selectByAttribute(String name, String value) {
		Examples selected_examples = new Examples();
		
		for (Example example : this)
			if (example.get(name).equals(value))
				selected_examples.add(example);
		
		return selected_examples;
	}
	
	public BinaryCounter countByClassification() {
		BinaryCounter counter = new BinaryCounter();
		
		for (Example example : this)
			if (example.classification.equals("yes"))
				counter.pos++;
			else
				counter.neg++;
		
		return counter;
	}

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
