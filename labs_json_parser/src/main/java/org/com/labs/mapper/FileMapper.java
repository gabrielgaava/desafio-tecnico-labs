package org.com.labs.mapper;

import org.com.labs.model.Order;
import org.com.labs.model.Product;
import org.com.labs.model.User;
import org.com.labs.utils.FormatUtils;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class FileMapper {

    /* Each field in the data file have a fixed size,
    the variables below reflect each position on files`s line */
    private static final int USER_ID_SIZE = 10;
    private static final int USER_NAME_SIZE = USER_ID_SIZE + 45;
    private static final int ORDER_ID_SIZE = USER_NAME_SIZE + 10;
    private static final int PRODUCT_ID_SIZE = ORDER_ID_SIZE + 10;
    private static final int PRODUCT_VALUE_SIZE = PRODUCT_ID_SIZE + 12;
    private static final int DATE_SIZE = PRODUCT_VALUE_SIZE + 8;

    /**
     * @param line: A string line from the file (respecting the fixed sizes above)
     * @param hashMap: The previous state of the data structure where the data will be updated
     * @return A new hash map with the data updated
     * **/
    public static HashMap<Integer, User> mapLine(String line, HashMap<Integer, User> hashMap) {

        /* Reading the variables from the file */
        Integer userId = Integer.valueOf(line.substring(0, USER_ID_SIZE));
        String useName = line.substring(USER_ID_SIZE, USER_NAME_SIZE).trim();
        Integer orderId = Integer.valueOf(line.substring(USER_NAME_SIZE, ORDER_ID_SIZE));
        Integer productId = Integer.valueOf(line.substring(ORDER_ID_SIZE, PRODUCT_ID_SIZE));
        BigDecimal productValue = new BigDecimal(line.substring(PRODUCT_ID_SIZE, PRODUCT_VALUE_SIZE).trim());
        String date = FormatUtils.formatRawDate(line.substring(PRODUCT_VALUE_SIZE, DATE_SIZE).trim());

        /* Creating objects */
        Product product = new Product(productId, productValue);
        Order order = new Order(orderId, date);
        User user = new User(userId, useName);

        /* No previous data from this user is stored */
        if(hashMap.get(userId) != null) {

            User savedUser = hashMap.get(userId);
            savedUser.addOrUpdateOder(order, product);
            hashMap.put(savedUser.getUserId(), savedUser);
            return hashMap;

        }

        user.addOrUpdateOder(order, product);
        hashMap.put(userId, user);
        return hashMap;

    }


}
