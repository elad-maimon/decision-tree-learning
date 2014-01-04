public class java_ex3 {
	public static final String INPUT_FILENAME = "input.txt";
	public static final String OUTPUT_FILENAME = "output.txt";

	public static void main(String[] args) {
		DTL dtl = new DTL();

		FileParser fileParser = new FileParser(INPUT_FILENAME);
		dtl.train(fileParser.getTrainingSet(), fileParser.getAttributes());

		TestOutputFormatter testFormatter = new TestOutputFormatter(fileParser.getTestSet().size());

		for (Example test_example : fileParser.getTestSet()) {
			String evaluation = dtl.evaluate(test_example);
			
			if (!evaluation.equals(test_example.classification))
				testFormatter.addFailure(test_example);
		}

		testFormatter.writeToFile(OUTPUT_FILENAME);
	}
}
