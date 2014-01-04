// Using composite pattern to build the decision tree
public interface iDecisionTreeNode {
    public String evaluate(Example example);
	public void print(int depth);
}
 