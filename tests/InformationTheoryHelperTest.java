import static org.junit.Assert.*;

import org.junit.Test;


public class InformationTheoryHelperTest {
	@Test
    public void testEntropyWithZero() {
    	BinaryCounter counter = new BinaryCounter(0, 2);
        assertEquals(0, InformationTheoryHelper.entropy(counter), 0.001);
    }

	@Test
    public void testEntropyWithNoZeros() {
    	BinaryCounter counter = new BinaryCounter(4, 2);
        assertEquals(0.918, InformationTheoryHelper.entropy(counter), 0.001);
    }

	@Test
    public void testInformationGain() {
		BinaryCounter full_counter = new BinaryCounter(6, 6);
		BinaryCounter[] subset_counter = new BinaryCounter[3];
    	subset_counter[0] = new BinaryCounter(0, 2);
    	subset_counter[1] = new BinaryCounter(4, 0);
    	subset_counter[2] = new BinaryCounter(2, 4);

    	double information_gain = InformationTheoryHelper.informationGain(full_counter, subset_counter);
    	assertEquals(0.541, information_gain, 0.001);
    }
}
