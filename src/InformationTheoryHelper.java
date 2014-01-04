// Helper class with required methods for calculating the information gain of an attribute.
public class InformationTheoryHelper {
	// This method gets a set of examples and attribute to calculate its information gain.
	// It prepares the counters of every values and uses the basic informationGain method.
	public static double calculateForAttribute(Attribute attribute, Examples examples) {
		BinaryCounter full_set_counter = examples.countByClassification();
		BinaryCounter[] subset_counters = new BinaryCounter[attribute.values.length];

		for (int i = 0; i < attribute.values.length; i++)
			subset_counters[i] = examples.selectByAttribute(attribute.key, attribute.values[i]).countByClassification();
			
		return informationGain(full_set_counter, subset_counters);
	}
	
	// Calculate the entropy of binary probability variable
	public static double entropy(BinaryCounter bin) {
		double pos_prob = (double)bin.pos / bin.total();
		double neg_prob = (double)bin.neg / bin.total();
		double result = - pos_prob * logBase2(pos_prob) - neg_prob * logBase2(neg_prob);
		
		if (Double.isNaN(result))
			return 0;
		else
			return result;
	}

	// Calculates: IG(A) = entropy(P(pos), P(neg)) - remainder(A)
	public static double informationGain(BinaryCounter full_set_counter, BinaryCounter[] subset_counters) {
		double remaidner = 0;
		
		for (BinaryCounter subset_counter : subset_counters)
			remaidner += ((double)subset_counter.total() / full_set_counter.total()) * entropy(subset_counter);
		
		return entropy(full_set_counter) - remaidner;
	}
	
	private static double logBase2(double x) {
		return Math.log(x) / Math.log(2);
	}
}
