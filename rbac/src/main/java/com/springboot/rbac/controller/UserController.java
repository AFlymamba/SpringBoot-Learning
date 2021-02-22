package com.springboot.rbac.controller;

import com.springboot.rbac.common.annotation.AdminAnnotation;
import com.springboot.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User 对外 Api
 *
 * @author huangyin
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(
            @Autowired UserService userService
    ) {
        this.userService = userService;
    }

    @AdminAnnotation
    @GetMapping("/needAdmin")
    public ResponseEntity<?> needAdmin() {
        log.info("need admin......");
        return ResponseEntity.ok("need admin");
    }

    @GetMapping("notNeedAdmin")
    public ResponseEntity<?> notNeedAdmin() {
        log.info("not need admin......");
        return ResponseEntity.ok("not need admin");
    }
}
