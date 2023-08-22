package model;

import helper.MockHelper;
import org.com.labs.model.Order;
import org.com.labs.utils.FormatUtils;
import org.junit.Assert;
import org.junit.Test;

public class OderTest {

    @Test
    public void shoudlReturnValidJsonOnToJson(){
        Order order = MockHelper.getBasicOder();
        String expectedJson = FormatUtils.minify(MockHelper.getOrderJson());

        Assert.assertEquals(expectedJson, FormatUtils.minify(order.toJson()));
    }

}
