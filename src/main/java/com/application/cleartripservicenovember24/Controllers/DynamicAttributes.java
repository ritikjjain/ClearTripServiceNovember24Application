package com.application.cleartripservicenovember24.Controllers;

import java.util.HashMap;
import java.util.Map;

public class DynamicAttributes {
    private Map<String, Object> attributes = new HashMap<>();

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

//    public static void main(String[] args) {
//        DynamicAttributes obj = new DynamicAttributes();
//        obj.setAttribute("name", "Alice");
//        obj.setAttribute("age", 30);
//
//        String name = (String) obj.getAttribute("name");
//        int age = (int) obj.getAttribute("age");
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//    }
}
