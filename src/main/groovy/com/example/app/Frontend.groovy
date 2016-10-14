package com.example.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Frontend {
    @Autowired
    ArgumentResolver argumentResolver

    @Autowired
    Calculator calculator

    void run() {
        print("Enter 2 numbers like a b : ")
        Argument argument = argumentResolver.resolve(System.in)
        int result = calculator.calc(argument.a, argument.b)

        println("result = ${result}")
    }
}
