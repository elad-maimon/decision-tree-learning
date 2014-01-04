import static org.junit.Assert.*;

import org.junit.*;

public class ExampleTest {
	public static final String DELIMITER = ",";

	private Example    example;
	private String     example_line = "yes,no,no,yes,some,$$$,no,yes,french,0-10, yes";
	private Attributes attributes = new Attributes();
	private String[]   attributes_lines = new String[] {
			"alternate     yes,no",
			"bar           yes,no",
			"friday        yes,no",
			"hungry        yes,no",
			"patron        some,full,none",
			"price         $,$$,$$$",
			"raining       yes,no",
			"reservation   yes,no",
			"type          french,thai,burger,italian",
			"estimate      0-10,10-30,30-60,>60"
		};

    @Before
    public void setUp() {
		for (String line : attributes_lines) {
			String[] parts = line.split("\\s+");
			if (parts.length == 2)
				attributes.add(new Attribute(parts[0], parts[1].split(DELIMITER)));
		}

		String[] parts = example_line.split(", ");

		example = new Example.BuilderForAttributes(attributes)
								.originalLine(example_line)
								.values(parts[0].split(DELIMITER))
								.classification(parts[1])
								.build();
    }

    @Test
    public void testOriginalLine() {
        assertEquals(example_line, example.original_line);
    }

    @Test
    public void attributeAlternate() {
        assertEquals("yes", example.get("alternate"));
    }

}
