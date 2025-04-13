import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon_expectTrue() {
        //given
        String string = "Hamlet";
        //When
        String actualName = hamletParser.changeHamletToLeon(string);
        String expectedName = "Leon";
        //Then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHamletToLeon_expectFalse() {
        //given
        String string = "Camlet";
        //When
        String actualName = hamletParser.changeHamletToLeon(string);
        String expectedName = "Leon";
        //Then
        Assert.assertNotEquals(expectedName, actualName);
    }

    @Test
    public void testChangeHoratioToTariq_expectTru() {
        //given
        String string = "Horatio";
        //When
        String actualName = hamletParser.changeHoratioToTariq(string);
        String expectedName = "Leon";
        //Then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}