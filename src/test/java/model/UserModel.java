package model;

import helper.MockHelper;
import org.com.labs.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.com.labs.utils.FormatUtils.minify;

public class UserModel {

    @Test
    public void shoudlReturnValidJsonOnToJson() {
        User user = MockHelper.getBasicUser();
        String expectedJson = minify(MockHelper.getUserJson());

        Assert.assertEquals(expectedJson, minify(user.toJson()));
    }

}
