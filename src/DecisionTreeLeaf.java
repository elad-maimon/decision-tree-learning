public class DecisionTreeLeaf implements iDecisionTreeNode {
	private String value;

	public DecisionTreeLeaf(String value) {
		this.value = value;
	}
	
	@Override
	public String evaluate(Example example) {
		return value;
	}
}