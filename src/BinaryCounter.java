
public class BinaryCounter {
	public int pos = 0;
	public int neg = 0;

	public BinaryCounter() {}

	public BinaryCounter(int pos, int neg) {
		this.pos = pos;
		this.neg = neg;
	}
	
	public int total() { return pos + neg; }
}
