import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    private final Password password = new Password("Secret");
    private final Alphabet alphabetOne = new Alphabet(true,false,false,false);
    private final Alphabet alphabetTwo = new Alphabet(false,true,true,true);
    private final Generator generator = new Generator(true,false,false,false);

    @Test
    void test1() {
        assertEquals("Secret", password.toString());
    }

    @Test
    void test2() {
        assertEquals(alphabetOne.getAlphabet(), Alphabet.upperCaseLetters);
    }

    @Test
    void test3() {
        assertEquals(alphabetTwo.getAlphabet(), Alphabet.lowerCaseLetters + Alphabet.numbers + Alphabet.symbols);
    }

    @Test
    void test4() {
        assertEquals(generator.alphabet.getAlphabet(), Alphabet.upperCaseLetters);
    }

    @Test
    void test5() {
        assertEquals(generator.alphabet.getAlphabet().length(), 26);
    }
}
