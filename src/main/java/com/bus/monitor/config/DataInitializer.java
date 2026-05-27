package com.bus.monitor.config;

import com.bus.monitor.model.User;
import com.bus.monitor.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEnabled(true);
            userRepository.save(user);
            System.out.println("========================================");
            System.out.println("✅ Пользователь создан!");
            System.out.println("   Логин: admin");
            System.out.println("   Пароль: 123");
            System.out.println("========================================");
        }
        
        if (userRepository.findByUsername("testuser").isEmpty()) {
            User user = new User();
            user.setUsername("testuser");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEnabled(true);
            userRepository.save(user);
            System.out.println("✅ Пользователь testuser создан!");
        }
    }
}