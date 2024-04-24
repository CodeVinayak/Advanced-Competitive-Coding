public class Main {
    static int swapNibbles(int x) {
        return ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
    }
    public static void main(String arg[]) {
        int x = 100;
        System.out.print(swapNibbles(x));
    }
}

 // (x & 0x0F) isolates the last 4 bits (rightmost nibble) of x
// 0x64 & 0x0F = 0x04 (binary 0000 0100)

// (x & 0xF0) isolates the first 4 bits (leftmost nibble) of x
// 0x64 & 0xF0 = 0x60 (binary 0110 0000)

// ((x & 0x0F) << 4) shifts the rightmost nibble (0x04) 4 bits to the left
// 0x04 << 4 = 0x40 (binary 0100 0000)

// ((x & 0xF0) >> 4) shifts the leftmost nibble (0x60) 4 bits to the right
// 0x60 >> 4 = 0x06 (binary 0000 0110)

// The bitwise OR operation | combines the two shifted nibbles
// 0x40 | 0x06 = 0x46 (binary 0100 0110)

// Decimal value 100 is 0x64 in hexadecimal (0110 0100 in binary)
// Output: 70 (Decimal value 70 is 0x46 in hexadecimal, which is 0100 0110 in binary)
