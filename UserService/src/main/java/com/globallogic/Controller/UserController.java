package com.globallogic.Controller;

import com.globallogic.Entity.User;
import com.globallogic.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;
    @PostMapping("")
    public ResponseEntity<User> Saveuser(@RequestBody User user)
    {
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser()
    {
        return new ResponseEntity<>(service.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<User> getUser(@PathVariable String Id)
    {
        return new ResponseEntity<>(service.getUser(Id), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable  String Id)
    {
        return new ResponseEntity<>(service.deleteUser(Id),HttpStatus.OK);
    }
}
