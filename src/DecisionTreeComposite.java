import java.util.HashMap;
import java.util.Map;

// Simple implementation of the composite design pattern
public class DecisionTreeComposite implements iDecisionTreeNode {
	private String attribute_name;
	private HashMap<String, iDecisionTreeNode> children = new HashMap<String, iDecisionTreeNode>();
	
	public DecisionTreeComposite(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	
	public void addChild(String label, iDecisionTreeNode child) {
		children.put(label, child);
	}
	
	// This evalute an example through the tree.
	// Using the composite pattern it just evaluates the correct child until getting to a leaf 
	@Override
	public String evaluate(Example example) {
		String label = example.get(attribute_name);
		return children.get(label).evaluate(example);
	}
	
	// Print nice output of the tree
	@Override
	public void print(int depth) {
		System.out.println(attribute_name + "?");
		
		for (Map.Entry<String, iDecisionTreeNode> entry : children.entrySet()) {
			for (int i = 0; i < depth; i++)
				System.out.print("    ");
			
			System.out.print("-- " + entry.getKey() + ": ");
			entry.getValue().print(depth + 1);
		}
	}
}
 
