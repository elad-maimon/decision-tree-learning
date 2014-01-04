public class java_ex3 {
	public static final String INPUT_FILENAME = "input.txt";
	public static final String OUTPUT_FILENAME = "output.txt";

	public static void main(String[] args) {
		DTL dtl = new DTL();

		FileParser fileParser = new FileParser(INPUT_FILENAME);
		dtl.train(fileParser.getTrainingSet(), fileParser.getAttributes());
//		dtl.printTree();

		TestOutputFormatter testFormatter = new TestOutputFormatter(fileParser.getTestSet().size());

		for (Example test_example : fileParser.getTestSet()) {
			String evaluation = dtl.evaluate(test_example);
			
			if (!evaluation.equals(test_example.classification))
				testFormatter.addFailure(test_example);
		}

		testFormatter.writeToFile(OUTPUT_FILENAME);

//		Examples e1 = fileParser.getTestSet();
//		int[] count = e1.countByClassification();
//		System.out.println(count[0] + " " + count[1]);
//		Examples e2 = e1.selectByAttribute("chance_to_bypassing", "maybe");
//		Examples e3 = e2.selectByAttribute("time", "day");
//		Examples e4 = e1.selectByAttribute("weather", "clear");
//		Examples e5 = e1.selectByAttribute("weather", "clear2");
//		System.out.println(e1);
//		System.out.println("--------");
//		System.out.println(e2);
//		System.out.println("--------");
//		System.out.println(e3);
//		System.out.println("--------");
//		System.out.println(e4);
//		System.out.println("--------");
//		System.out.println(e5);
//		
//		Attributes a = fileParser.getAttributes();
//		Attributes b = a.reject(a.get(2));
//		Attributes c = b.reject(a.get(3));
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(fileParser.getTestSet().getCommonClassification());
	}
}
