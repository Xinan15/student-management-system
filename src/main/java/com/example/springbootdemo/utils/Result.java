package com.example.springbootdemo.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Result {
    public static String okGeString() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "success");
        // map.put("data", null);
        String s = JSONObject.toJSONString(map);
        return s;

        // 解耦
    }
}
