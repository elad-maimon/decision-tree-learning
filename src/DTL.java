public class DTL {
	private iDecisionTreeNode decision_tree;

	public void train(Examples examples, Attributes attributes) {
		decision_tree = train(examples, attributes, null);
	}
	
	public String evaluate(Example example) {
		return "No";
	}

	private iDecisionTreeNode train(Examples examples, Attributes attributes, String default_classification) {
		if (examples.empty())
			return new DecisionTreeLeaf(default_classification);
		
		String common_classification = examples.getCommonClassification();
		if (common_classification != null)
			return new DecisionTreeLeaf(common_classification);
		
		if (attributes.empty())
			return new DecisionTreeLeaf(mode(examples));

		Attribute best = chooseAttribute(attributes, examples);
		DecisionTreeComposite node = new DecisionTreeComposite(best.name);
		
		for (String value : best.values) {
			Examples filtered_examples = examples.selectByAttribute(best.name, value);
			Attributes filtered_attributes = attributes.reject(best);
			
			iDecisionTreeNode child_node = train(filtered_examples, filtered_attributes, mode(examples));
			node.addChild(value, child_node);
		}
		
		return node;
	}

	private String mode(Examples examples) {
		return null;
	}

	private Attribute chooseAttribute(Attributes attributes, Examples examples) {
		return attributes.get(0);
	}
}
