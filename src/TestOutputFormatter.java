import java.io.*;

public class TestOutputFormatter {
	private Examples failed_examples = new Examples();
	private int      test_set_size;   

	public TestOutputFormatter(int test_set_size) {
		this.test_set_size = test_set_size;
	}
	
	public void addFailure(Example failed_example) {
		failed_examples.add(failed_example);
	}
	
	public void writeToFile(String filename) {
		BufferedWriter bw = null;

		try {
			if (filename.equals("STDOUT"))
				bw = new BufferedWriter(new OutputStreamWriter(System.out));
			else
				bw = new BufferedWriter(new FileWriter(filename));
			
			bw.write(calculatePercent(failed_examples.size(), test_set_size) + "%\n");

			for (Example failure : failed_examples)
				bw.write(failure.original_line + "\n");
		} catch (IOException e) {
			System.out.println("Error occured while writing output file");
			e.printStackTrace();
		} finally {
			if (bw != null)
				try { bw.close(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	// Calculate percent and format rounded to 3 decimal digits
	private double calculatePercent(int failed, int total) {
		double percent = (double)(total - failed) / total * 100;
		return ((double)Math.round(percent * 1000) / 1000);
	}
}
