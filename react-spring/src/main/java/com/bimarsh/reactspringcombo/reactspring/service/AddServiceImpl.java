package com.bimarsh.reactspringcombo.reactspring.service;

import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService{

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
