package com.erpconnect.controller;

import org.jpos.iso.packager.GenericPackager;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin()
@RequestMapping("/authentication/v1")
public class RestControllerClass {
    private byte[] result = new byte[0];
    private InputStream is;
    private GenericPackager packager;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();


    @GetMapping ("/hello")
    private String Hello(){
        return "Hello!";
    }

}
