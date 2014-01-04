// Simple implementation of the composite design pattern
public class DecisionTreeLeaf implements iDecisionTreeNode {
	private String value;

	public DecisionTreeLeaf(String value) {
		this.value = value;
	}
	
	@Override
	public String evaluate(Example example) {
		return value;
	}

	@Override
	public void print(int depth) {
		System.out.println("<" + value + ">");
	}
}
