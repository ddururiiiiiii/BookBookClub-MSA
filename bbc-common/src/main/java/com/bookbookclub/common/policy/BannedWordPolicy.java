package com.bookbookclub.common.policy;

import java.util.List;

public class BannedWordPolicy {

    private static final List<String> BANNED_WORDS = List.of(
            "시발", "fuck", "바보", "멍청이", "admin", "운영자"
    );

    public static boolean containsBannedWord(String input) {
        if (input == null) return false;
        String lowerInput = input.toLowerCase();
        return BANNED_WORDS.stream().anyMatch(lowerInput::contains);
    }

    public static List<String> getBannedWords() {
        return BANNED_WORDS;
    }
}