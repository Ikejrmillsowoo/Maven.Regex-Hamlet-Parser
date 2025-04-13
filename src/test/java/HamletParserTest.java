import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;



public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() throws IOException {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon_expectTrue() {
        //given
        String string = "Hamlet";
        //When
        String actualName = hamletParser.findAndChangeNames(string);
        String expectedName = "Leon";
        //Then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHamletToLeon_expectFalse() {
        //given
        String string = "Camlet";
        //When
        String actualName = hamletParser.findAndChangeNames(string);
        String expectedName = "Leon";
        //Then
        Assert.assertNotEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHamletToLeonInString_expectTrue() {
        //given
        String string = "The Tragedy of Hamlet, Prince of Denmark";
        //When
        String actualString = hamletParser.findAndChangeNames(string);
        String expectedString = "The Tragedy of Leon, Prince of Denmark";
        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testChangeHoratioToTariq_expectTrue() {
        //given
        String string = "Horatio";
        //When
        String actualName = hamletParser.findAndChangeNames(string);
        String expectedName = "Tariq";
        //Then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHoratioToTariq_expectFalse() {
        //given
        String string = "Horatia";
        //When
        String actualName = hamletParser.findAndChangeNames(string);
        String expectedName = "Tariq";
        //Then
        Assert.assertNotEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHoratioToTariqInString_expectTrue() {
        //given
        String string = "If you do meet Horatio and Marcellus,";
        //When
        String actualString = hamletParser.findAndChangeNames(string);
        String expectedString = "If you do meet Tariq and Marcellus,";
        //Then
        Assert.assertEquals(expectedString, actualString);
       // I think I hear them. Stand, ho! Who's there?
    }

    @Test
    public void testFindHoratio_expectTrue() {
        //given
        String string = "Horatio";

        //When
        Assert.assertTrue(hamletParser.findGivenName(string));
    }

    @Test
    public void testFindLeon_expectFalse() {
        //given
        String string = "Leon";

        //When
        Assert.assertFalse(hamletParser.findGivenName(string));
    }

    @Test
    public void testFindHamlet_expectTrue() {
        //given
        String string = "Hamlet";


        Assert.assertTrue(hamletParser.findGivenName(string));
    }

    @Test
    public void testFindTariq_expectFalse() {
        //given
        String string = "Tariq";

        Assert.assertFalse(hamletParser.findGivenName(string));
    }
}