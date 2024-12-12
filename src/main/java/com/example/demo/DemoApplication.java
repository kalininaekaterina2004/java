package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate; 

    public void createUser(int id, String name, String email) {
        String sql = "INSERT INTO Users (id, name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, name, email);
    }

    public void readUser(Integer id) {
        String sql; 
        if (id != null) {
            sql = "SELECT * FROM Users WHERE id = ?";
        } else {
            sql = "SELECT * FROM Users";
        }
    
    }

    public void updateUser(int id, String name, String email) {
        String sql = "UPDATE Users SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, email, id);
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override 
    public void run(String... args) {
        String sql = """
        INSERT INTO "Users" (id, name, email) VALUES (5, 'Vovan', 'vovan@gmail.com');""";
        jdbcTemplate.execute(sql);
    }
}
