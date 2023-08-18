package org.com.labs.mapper;

import org.com.labs.model.User;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

/**
 * Classe responsavel por mappear e transformar os dados do HashMap de Usuarios
 * para uma String no formato JSON.
 * **/
public abstract class HashMapper {

    /**
     * @param map: O HashMap dos dados previamentes tratados
     * @return JSON String contendo o dados formatados
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

        formatter.format("]%n");
        formatter.flush();
        return builder.toString();

    }

}
