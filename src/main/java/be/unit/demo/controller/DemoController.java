package be.unit.demo.controller;

import be.unit.demo.entity.User;
import be.unit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World !!!";
    }

    @GetMapping(path = "/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
