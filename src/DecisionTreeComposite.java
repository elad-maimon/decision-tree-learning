import java.util.HashMap;

public class DecisionTreeComposite implements iDecisionTreeNode {
	private String attribute_name;
	private HashMap<String, iDecisionTreeNode> children = new HashMap<String, iDecisionTreeNode>();
	
	public DecisionTreeComposite(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	
	public void addChild(String label, iDecisionTreeNode child) {
		children.put(label, child);
	}
	
	@Override
	public String evaluate(Example example) {
		String label = example.get(attribute_name);
		return children.get(label).evaluate(example);
	}
}
 
