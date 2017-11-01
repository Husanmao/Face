package com.huawei.colin.Problems;


import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Morse Code Arrays
 * A	B	C	D	E	F	G
 * .-  -…  -.-. -.. .  ..-.	–.
 * H	I	J	K	L	M
 * ….	..	.—	-.-	.-..	—
 * N	O	P	Q	R	S	T
 * -.	—	.–.	–.-	.-.	…	–
 * U	V	W	X	Y	Z
 * ..-  …- .– -..- -.– __..
 */
public class Problem07 {

    private static final String[] MORSE_CODE = {".-","-...","-.-.","-..",".","..-.","--.", "....",
            "..", ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--..", "/"};

    /**
     * Translates plain text into morse code.
     * @param plainText The text to convert
     * @return Morse code
     */
    @NotNull
    public static String converToMorse(@NotNull String plainText) {

        StringBuilder result = new StringBuilder();
        String text = plainText.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            int code = text.charAt(i) - 'a';
            if (code >= 0 && code <= 25) {
                result.append(MORSE_CODE[code]);
            } else {
                result.append("/");
            }
        }
        return result.toString();
    }

    /**
     * Convert morse code to plain text
     * @param morse Morse code
     * @return Plain text
     */
    @NotNull
    public static String convertToPlain(@NotNull String morse) {

        StringBuilder result = new StringBuilder();
        String[] s = morse.split("\\s+");

        for (int i = 0; i < s.length; i++) {
            if (s[i].trim().equals("/")) {
                result.append(" ");
            } else {
                boolean find = false;
                for (int j = 0; j < MORSE_CODE.length; j++) {
                    if (s[i].equals(MORSE_CODE[j])) {
                        result.append((char)('A' + j));
                        find = true;
                    }
                }
                if (!find) result.append(s[i]);
            }
        }
        return result.toString();
    }

    public static void mapMorse(String morse) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("A", ".-");

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//
//        }
    }
}
