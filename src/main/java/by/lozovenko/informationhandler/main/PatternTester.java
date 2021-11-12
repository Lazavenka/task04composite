package by.lozovenko.informationhandler.main;

import java.util.Arrays;

public class PatternTester {
    public static final String TEST_PARAGRAPH = "JAVA (Рига) ob.run() Science! JAVA (Рига) ob.run() Science! JAVA (Рига) ob.run() Science!";

    public static void main(String[] args) {
        String[] sentences = TEST_PARAGRAPH.split("\\s");
        System.out.println("Lenght - "+ sentences.length+" "+Arrays.toString(sentences));
    }
}
