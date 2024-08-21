package com.BookstoreAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    List<String> list = new ArrayList<>();

    @GetMapping("bookApi")
    public List<String> getMethodName() {
        System.out.println("get method running");
        return list;
    }

    @PostMapping("bookApi")
    public String postMethodName() {
        list.add("hello");
        list.add("gelo");
        list.add("okay");
        System.out.println("post method running");
        return "saved";
    }
}