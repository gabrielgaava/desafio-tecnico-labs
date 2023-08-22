package mapper;

import helper.MockHelper;
import org.com.labs.mapper.FileMapper;
import org.com.labs.model.Order;
import org.com.labs.model.Product;
import org.com.labs.model.User;
import org.com.labs.utils.FormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class FileMapperTest {

    @Test
    public void shouldAddLineToMap(){

        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";
        Integer userId = 70;
        String userName = "Palmer Prosacco";
        Integer orderId = 753;
        Integer productId = 3;
        BigDecimal productValue = new BigDecimal("1836.74");
        String orderDate = "20210308";

        HashMap<Integer, User> map = new HashMap<>();
        map = FileMapper.mapLine(line, map);

        User storedUser = map.get(userId);
        Assert.assertNotNull(storedUser);
        Assert.assertEquals(userName, storedUser.getName());

        Order storedOrder = storedUser.getOrders().get(orderId);
        Assert.assertNotNull(storedOrder);
        Assert.assertEquals(orderId, storedOrder.getOrderId());
        Assert.assertEquals(FormatUtils.formatRawDate(orderDate), storedOrder.getDate());
        Assert.assertEquals(productValue, storedOrder.getTotal());
        Assert.assertEquals(1, storedOrder.getProducts().size());

        Product storedProduct = storedOrder.getProducts().get(0);
        Assert.assertNotNull(storedProduct);
        Assert.assertEquals(productId, storedProduct.getProductId());
        Assert.assertEquals(productValue, storedProduct.getValue());

    }

    @Test
    public void shouldAddProductToSameUserInMap() {

        String line = "0000000070                              Palmer Prosacco00000007530000000003     1009.5420210308";
        HashMap<Integer, User> beforeMap = MockHelper.getUserHashMap();
        HashMap<Integer, User> afterMap = FileMapper.mapLine(line, beforeMap);

        User storedUser = afterMap.get(70);
        Order storedOrder = storedUser.getOrders().get(753);
        List<Product> products = storedOrder.getProducts();

        Assert.assertNotNull(storedUser);
        Assert.assertNotNull(storedOrder);
        Assert.assertNotNull(products);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(new BigDecimal("2846.28"), storedOrder.getTotal());
    }

    @Test
    public void shouldAddOrderToSameUserInMap() {

        String line = "0000000070                              Palmer Prosacco00000007510000000005      942.5420210407";
        HashMap<Integer, User> beforeMap = MockHelper.getUserHashMap();
        HashMap<Integer, User> afterMap = FileMapper.mapLine(line, beforeMap);

        User storedUser = afterMap.get(70);
        Order storedOrder = storedUser.getOrders().get(751);
        List<Product> products = storedOrder.getProducts();

        Assert.assertNotNull(storedUser);
        Assert.assertNotNull(storedOrder);
        Assert.assertNotNull(products);
        Assert.assertNotNull(storedUser.getOrders().get(753));
        Assert.assertEquals(1, products.size());
        Assert.assertEquals(new BigDecimal("942.54"), storedOrder.getTotal());
    }

}
