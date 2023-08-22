package mapper;

import helper.MockHelper;
import org.com.labs.mapper.HashMapper;
import org.com.labs.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HashMapperTest {

    @Test
    public void toJsonTest() {

        HashMap<Integer, User> map = MockHelper.getUserHashMapWith2Users();

        String expectedJson = MockHelper.getJsonString().replaceAll("\\s+", "");;
        String jsonOutput = HashMapper.toJson(map).replaceAll("\\s+", "");;

        Assert.assertEquals(expectedJson, jsonOutput);
    }

}
