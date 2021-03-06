// This is the main API to the decision tree learning technique.
// The API supports this two operations:
//   1. Train - build the decision tree according to given set of examples
//   2. Evaluate - evaluate an example based on the existing decision tree.
public class DTL {
	private iDecisionTreeNode decision_tree;

	public void train(Examples examples, Attributes attributes) {
		decision_tree = train(examples, attributes, null);
	}
	
	public String evaluate(Example example) {
		return decision_tree.evaluate(example);
	}

	// The main algorithm for building the decision tree.
	// Based on this algorithm: http://u.cs.biu.ac.il/~haimga/Teaching/AI/saritLectures/Lecture8a.pdf
	private iDecisionTreeNode train(Examples examples, Attributes attributes, String default_classification) {
		if (examples.empty())
			return new DecisionTreeLeaf(default_classification);
		
		String common_classification = examples.getCommonClassification();
		if (common_classification != null)
			return new DecisionTreeLeaf(common_classification);
		
		if (attributes.empty())
			return new DecisionTreeLeaf(mode(examples));

		Attribute best = chooseAttribute(attributes, examples);
		
		DecisionTreeComposite node = new DecisionTreeComposite(best.key);
		
		// For each value in the best attribute, recursively build the child node by calling this method
		for (String value : best.values) {
			Examples filtered_examples = examples.selectByAttribute(best.key, value);
			Attributes filtered_attributes = attributes.reject(best);
			
			iDecisionTreeNode child_node = train(filtered_examples, filtered_attributes, mode(examples));
			node.addChild(value, child_node);
		}
		
		return node;
	}

	// Return the majority classification
	private String mode(Examples examples) {
		BinaryCounter counter = examples.countByClassification();
		
		if (counter.pos >= counter.neg)
			return "yes";
		else
			return "no";
	}

	private Attribute chooseAttribute(Attributes attributes, Examples examples) {
		// Calculate information gain for first attribute and save as best
		double best_gain = InformationTheoryHelper.calculateForAttribute(attributes.get(0), examples);
		Attribute best = attributes.get(0);
		
		// Calculate information gain for rest of the attributes check if better then best
		for (int i = 1; i < attributes.size(); i++) {
			double current_gain = InformationTheoryHelper.calculateForAttribute(attributes.get(i), examples);
			
			if (current_gain > best_gain) {
				best = attributes.get(i);
				best_gain = current_gain;
			}
		}
		
		return best;
	}
	
	public void printTree() {
		decision_tree.print(0);
	}
}
