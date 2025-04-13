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
    public void testChangeHamletToLeon() {
        //given
        hamletText = "Hamlet";
        hamletParser.setDataFile(hamletText);

        //when
       // HamletParser ham = new HamletParser();
       // System.out.println(hamletParser.getHamletData());

        Assert.assertEquals("Leon", hamletParser.getHamletData());
    }

    @Test
    public void testChangeHoratioToTariq() {
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}