package service;

import model.Greeting;
import repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // UC 2: Simple Hello World
    public String getSimpleGreeting() {
        return "Hello World";
    }

    // UC 3: Custom Greeting based on name
    public String getCustomGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null)
            return "Hello " + firstName + " " + lastName;
        else if (firstName != null)
            return "Hello " + firstName;
        else if (lastName != null)
            return "Hello " + lastName;
        else
            return "Hello World";
    }

    // UC 4: Save a greeting message
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    // UC 5: Find by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC 6: List all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC 7: Edit/Update greeting
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        });
    }

    // UC 8: Delete a greeting
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}
