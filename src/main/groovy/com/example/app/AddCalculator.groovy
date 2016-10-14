package com.example.app

import org.springframework.stereotype.Component

@Component
class AddCalculator implements Calculator {
    @Override
    int calc(int a, int b) {
        return a + b
    }
}
