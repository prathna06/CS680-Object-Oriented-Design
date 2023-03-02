package edu.umb.CS680.HW01;


import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @org.junit.jupiter.api.Test
    void generatePrimesValid() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
    }
    @org.junit.jupiter.api.Test
    void generatePrimes10to100() {
        PrimeGenerator gen = new PrimeGenerator(10, 100);
        gen.generatePrimes();
        Long[] expectedPrimes = { 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertArrayEquals( expectedPrimes,gen.getPrimes().toArray() );
    }

    @org.junit.jupiter.api.Test
    void generatePrimes100to10() {

        try{
            PrimeGenerator gen = new PrimeGenerator(100, 10);
            gen.generatePrimes();
            Long[] expectedPrimes = {};
            assertArrayEquals( expectedPrimes,gen.getPrimes().toArray() );
        }
        catch(Exception ex){
            assertNotEquals("Invalid input range from " + 100 + " to " + 10, ex.getMessage() );
        }

    }
    @org.junit.jupiter.api.Test
    void generatePrimes100to100() {

        try{
            PrimeGenerator gen = new PrimeGenerator(100, 100);
            gen.generatePrimes();
            Long[] expectedPrimes = {};
            assertArrayEquals( expectedPrimes,gen.getPrimes().toArray() );
        }
        catch(Exception ex){
            assertNotEquals("Invalid input range from " + 100 + " to " + 100, ex.getMessage() );
        }

    }
    @org.junit.jupiter.api.Test
    void generatePrimesNegative10toNegative100() {

        try{
            PrimeGenerator gen = new PrimeGenerator(-10, -100);
            gen.generatePrimes();
            Long[] expectedPrimes = {};
            assertArrayEquals( expectedPrimes,gen.getPrimes().toArray() );
        }
        catch(Exception ex){
            assertNotEquals("Invalid input range from " + -10 + " to " + -100, ex.getMessage() );
        }

    }


    @org.junit.jupiter.api.Test
    void main() {
    }
}