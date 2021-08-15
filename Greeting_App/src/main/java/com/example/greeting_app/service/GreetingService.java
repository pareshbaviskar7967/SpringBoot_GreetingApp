package com.example.greeting_app.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.example.greeting_app.model.Greeting;
import com.example.greeting_app.model.User;
import com.example.greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService
{
    private static final String template = "Hello, %s!";
//private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(message));
    }

    @Override
    public Optional<Greeting> findById(long id) {

        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    @Override
    public Optional<Greeting> editGreetingById(long id, String name) {
        Optional<Greeting> particularGreeting = greetingRepository.findById(id);
        particularGreeting.get().setMessage(name);
        return particularGreeting;
    }

    @Override
    public void delete(long id) {
        greetingRepository.deleteById(id);
    }

}
