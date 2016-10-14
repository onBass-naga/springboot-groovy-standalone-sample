package com.example.app

import org.springframework.stereotype.Component

@Component
class ScannerArgumentResolver implements ArgumentResolver {

    @Override
    Argument resolve(InputStream stream) {
        Scanner scanner = new Scanner(stream)
        int a = scanner.nextInt()
        int b = scanner.nextInt()
        return new Argument(a, b)
    }
}
