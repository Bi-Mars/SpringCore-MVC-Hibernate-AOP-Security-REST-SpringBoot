package com.bimarsh.reactspringcombo.reactspring.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddService {

    AddService addService;

    @Test
    public void testAddService(){
        addService = new AddServiceImpl();
        assertEquals(1,addService.add(1,0));
    }

}
