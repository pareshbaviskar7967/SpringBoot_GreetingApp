package com.example.greeting_app.controller;

import com.example.greeting_app.model.Greeting;
import com.example.greeting_app.model.User;
import com.example.greeting_app.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class GreetingController
{
    private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService iGreetingService;

    @GetMapping(value = {"/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        User user = new User();
        user.setFirstName(name);
        return iGreetingService.addGreeting(user);
    }

    @PostMapping("/fullName")
    public Greeting sayWow(@RequestBody User user) {
        return iGreetingService.addGreeting(user);
    }

    @GetMapping("/find/{id}")
    public Optional<Greeting> greeting(@PathVariable(value = "id") long id)
    {
        return iGreetingService.findById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAll(){
        return iGreetingService.getAll();
    }

    @PutMapping("/editGreeting/{id}")
    public Optional<Greeting> editGreetingById(@PathVariable("id") long id, @RequestParam(value = "name") String name) {
        return iGreetingService.editGreetingById(id, name);
    }

    @DeleteMapping("/delete")
    public void deleteByID(@RequestParam(name = "id") long id) {
        iGreetingService.delete(id);
    }
}

