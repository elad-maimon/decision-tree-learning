import java.util.HashMap;
import java.util.Map;

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
 
