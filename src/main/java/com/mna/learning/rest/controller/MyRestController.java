package com.mna.learning.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping("/ping")
    public String ping(){
        return "Poooooooong !!!";
    }
	
	@RequestMapping("/bounani")
    public String ping(){
        return "Bounani toi eussiiii !!!";
    }
}
