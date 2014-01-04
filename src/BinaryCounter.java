// This class represents a 2 dimensional counter.
// It makes the handle with the binary classification of the example very easy, for instance in order to
// calculate an entropy (information theory) we need to count the positive examples and the negatives.  
public class BinaryCounter {
	public int pos = 0;
	public int neg = 0;

	public BinaryCounter() {}

	// This doesn't really necessary but it make JUnit tests easier 
	public BinaryCounter(int pos, int neg) {
		this.pos = pos;
		this.neg = neg;
	}
	
	public int total() { return pos + neg; }
}
