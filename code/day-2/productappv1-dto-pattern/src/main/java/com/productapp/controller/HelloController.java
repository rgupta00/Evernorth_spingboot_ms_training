package com.productapp.controller;

import com.productapp.dto.InfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${profile.data}")
    private String info;

    @Autowired
    private InfoDto infoDto;

    @GetMapping(path = "info")
    public InfoDto sayInfo() {
        return infoDto;
    }


    @GetMapping(path = "hello")
    public String sayHello() {
        return "Hello "+ info;
    }


//    @GetMapping(path = "hello/{name}/{city}")
//    public String sayHello(@PathVariable String name, @PathVariable String city) {
//        return "Hello "+name+ " "+ city;
//    }
//
//    @GetMapping(path = "hello2")
//    public String sayHello2(@RequestParam String start, @RequestParam String end) {
//        String name = start + " " + end;
//        return name;

}
