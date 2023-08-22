package model;

import helper.MockHelper;
import org.com.labs.model.Product;
import org.com.labs.utils.FormatUtils;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void shoudlReturnValidJsonOnToJson(){
        Product product = MockHelper.getBasicProduct();
        String expectedJson = FormatUtils.minify(MockHelper.getProductJson());

        Assert.assertEquals(expectedJson, FormatUtils.minify(product.toJson()));
    }

}
