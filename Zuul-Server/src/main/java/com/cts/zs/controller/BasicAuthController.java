package com.cts.zs.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.zs.ZuulServerApplication;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/order")
public class BasicAuthController {
	  @GetMapping(path = "/basicauth")
	    public ZuulServerApplication basicauth() {
	        return new ZuulServerApplication();
	    }

}