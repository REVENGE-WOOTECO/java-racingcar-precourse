package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String REGEX = "^[a-zA-z,]+";
    private static final Pattern p = Pattern.compile(REGEX);

    public static List<String> validateNameList(String input) {

        // 1. 알파벳, 쉼표 외 입력여부 검증
        if (isValidRegex(input)) {
            return null;
        }

        // 2. parsing 후 각각 길이 검증
        return isValidLength(input);
    }

    private static List<String> isValidLength(String input) {
        List<String> names;
        try {
            names = parsingNameList(input);
            validateByLength(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return names;
    }

    private static boolean isValidRegex(String input) {
        try {
            validateByRegex(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static void validateByLength(List<String> names) {
        for (String name : names) {
            if (name.length() == 0 || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 1자 이상 5자 이하로 입력하세요.");
            }
        }
    }

    private static void validateByRegex(String input) {
        if (!p.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 알파벳과 쉼표(,)로만 입력하세요. 입력 내에 공백도 없어야 합니다.");
        }
    }

    private static List<String> parsingNameList(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toList());
    }
}
