package com.microservice.service_01.controller;

import com.microservice.service_01.dto.userDTO;
import com.microservice.service_01.service.Service01;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service01")
public class ExampleController {
    private final Service01 service;

    @GetMapping("/{UserId}")
    public ResponseEntity<userDTO> getUser(@PathVariable("UserId") int userId){
        userDTO user = service.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
