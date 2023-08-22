package org.com.labs.mapper;

import org.com.labs.model.User;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

/**
 * Class responsable for map and transform the data from the HashMap of
 * users to a String formated on JSON.
 * **/
public abstract class HashMapper {

    /**
     * @param map: The HashMap that stores the previous treated data
     * @return A JSON string containing the formatted data
     * **/
    public static String toJson(HashMap<Integer, User> map) {

        StringBuilder builder = new StringBuilder();
        Formatter formatter = new Formatter(builder);

        List<User> userList = new ArrayList<>(map.values());
        formatter.format("[%n");

        /* For each user in the HashMap a new block of String will be added to the JSON
        *  Which, in the end, will result on the final JSON String */
        for(int i = 0; i < userList.size(); i++) {
            formatter.format(userList.get(i).toJson());

            // Last element of the list
            if(i + 1 == userList.size())
                formatter.format("%n");

            else formatter.format(",%n");
        }

        formatter.format("]");
        formatter.flush();
        return builder.toString();

    }

}
