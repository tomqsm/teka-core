package biz.letsweb.item.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Tomasz
 */
public class LineSplitterTest {

  private LineSplitter splitter;

  public LineSplitterTest() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {
    splitter = new LineSplitter();
  }

  @After
  public void tearDown() {}

  /**
   * content markers: first, number, last paliwo verva 98 - 234 56 - kupiłem w drodze do domu
   * article description - group of numbers (last two) - comments last but one and last group of
   * numbers is a divider between article and comment
   */
  @Test
  public void testSomeMethod() {
    String cyfryPowtarzajaceSiePoSobie = "((\\d){1})\\1"; // \\1 takes first one {1} found and
                                                          // matches
                                                          // next against first
    // paliwo 2342334 -> I found the text "33" starting at index 11 and ending at index 13.
    String bunderedDigits = "(\\b\\d+\\b)";
    String atLeastOneTime = "\\d{4,}";

    String myRegex = bunderedDigits;

    String said = "paliwo 2342334 123 43";
    Pattern pattern = Pattern.compile(myRegex, Pattern.CASE_INSENSITIVE); // enter regex here
    Matcher matcher = pattern.matcher(said); // text
    boolean found = false;
    while (matcher.find()) {
      System.out.println(String.format("I found the text"
          + " \"%s\" starting at index %d and ending at index %d.%n", matcher.group(),
          matcher.start(), matcher.end()));
      found = true;
    }
    if (!found) {
      System.out.println("No match found.");
    }
    String[] numberGroups = said.split(myRegex);
    System.out.println(numberGroups.length);
  }
}
