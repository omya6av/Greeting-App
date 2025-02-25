package com.greetingapp.repository;

import com.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

//UC4
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
