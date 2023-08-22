package utils;

import org.com.labs.utils.FormatUtils;
import org.junit.Assert;
import org.junit.Test;

public class FormatUtilsTest {

    @Test
    public void formatRawDateTest() {
        String input = "20210308";
        String expectedOutput = "2021-03-08";
        Assert.assertEquals(expectedOutput, FormatUtils.formatRawDate(input));
    }

    @Test
    public void tabsTest() {
        String expectedOutput = "\t\t\t\t";
        Assert.assertEquals(expectedOutput, FormatUtils.tabs(4));
    }

    @Test
    public void minifyTest() {
        String input = "\t1\n2\r3   \r  \n  4 ";
        Assert.assertEquals("1234", FormatUtils.minify(input));
    }

}
