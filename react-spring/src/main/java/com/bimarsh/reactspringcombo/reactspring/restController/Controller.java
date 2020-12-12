package com.bimarsh.reactspringcombo.reactspring.restController;

import com.bimarsh.reactspringcombo.reactspring.entity.Add;
import com.bimarsh.reactspringcombo.reactspring.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    AddService addService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public int add(@RequestBody Add addUserInput){

        return addService.add(addUserInput.getA(), addUserInput.getB());
    }
}
