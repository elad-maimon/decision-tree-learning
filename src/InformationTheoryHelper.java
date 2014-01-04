
public class InformationTheoryHelper {
	public static double calculateForAttribute(Attribute attribute, Examples examples) {
		BinaryCounter full_set_counter = examples.countByClassification();
		BinaryCounter[] subset_counters = new BinaryCounter[attribute.values.length];

		for (int i = 0; i < attribute.values.length; i++)
			subset_counters[i] = examples.selectByAttribute(attribute.key, attribute.values[i]).countByClassification();
			
		return informationGain(full_set_counter, subset_counters);
	}
	
	public static double entropy(BinaryCounter bin) {
		double pos_prob = (double)bin.pos / bin.total();
		double neg_prob = (double)bin.neg / bin.total();
		double result = - pos_prob * logBase2(pos_prob) - neg_prob * logBase2(neg_prob);
		
		if (Double.isNaN(result))
			return 0;
		else
			return result;
	}
	
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
