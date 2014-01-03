import java.util.ArrayList;

@SuppressWarnings("serial")
public class Examples extends ArrayList<Example> {
	public boolean empty() {
		return size() == 0;
	}
	
	public Examples selectByAttribute(String name, String value) {
		Examples selected_examples = new Examples();
		
		for (Example example : toArray())
			if (example.get(name).equals(value))
				selected_examples.add(example);
		
		return selected_examples;
	}

	@Override
	public Example[] toArray() {
		return super.toArray(new Example[size()]);
	}
	
	public String getCommonClassification() {
		if (empty())
			return null;
		
		String base_classification = get(0).getClassification();
		
		for (Example example : toArray())
			if (!example.getClassification().equals(base_classification))
				return null;
		
		return base_classification;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (Example example: toArray())
			str.append(example + "\n");
		
		return str.toString();
	}
}
