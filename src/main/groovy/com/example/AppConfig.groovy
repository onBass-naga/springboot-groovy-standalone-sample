package com.example

import com.example.app.AddCalculator
import com.example.app.Calculator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    Calculator calculator() {
        return new AddCalculator()
    }
}
