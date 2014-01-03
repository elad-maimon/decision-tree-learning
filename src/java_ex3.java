import java.util.ArrayList;

public class java_ex3 {
	public static final String INPUT_FILENAME = "input.txt";
	public static final String OUTPUT_FILENAME = "output.txt";

	public static void main(String[] args) {
		FileParser fileParser = new FileParser(INPUT_FILENAME);
		System.out.println(fileParser.getAttributes().length);
		System.out.println(fileParser.getTrainingSet().length);
		System.out.println(fileParser.getTestSet().length);
		
//		DTL decision_tree = new DTL();
	}
}
