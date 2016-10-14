package com.example.app

class ScannerArgumentResolver implements ArgumentResolver {

    @Override
    Argument resolve(InputStream stream) {
        Scanner scanner = new Scanner(stream)
        int a = scanner.nextInt()
        int b = scanner.nextInt()
        return new Argument(a, b)
    }
}
