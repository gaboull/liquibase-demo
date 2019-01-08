package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Started.");
        Sort sort = Sort.by(new Sort.Order(Direction.ASC, "id"));
        LOG.info("Users:");
        Iterable<User> users = userRepository.findAll(sort);
        for (User user : users) {
            LOG.info("{}", user);
        }
        LOG.info("Roles:");
        Iterable<Role> roles = roleRepository.findAll(sort);
        for (Role role : roles) {
            LOG.info("{}", role);
        }
        LOG.info("Finished.");
    }

}
