public class java_ex3 {
	public static final String INPUT_FILENAME = "input.txt";
	public static final String OUTPUT_FILENAME = "output.txt";

	public static void main(String[] args) {
		FileParser fileParser = new FileParser(INPUT_FILENAME);

		DTL dtl = new DTL();
		dtl.train(fileParser.getTrainingSet(), fileParser.getAttributes(), null);

		for (Example test_example : fileParser.getTestSet()) {
			dtl.evaluate(test_example);
		}
	}
}
