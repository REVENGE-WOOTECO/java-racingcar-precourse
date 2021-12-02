package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String REGEX_FOR_NAME_LIST = "^[a-zA-z,]+";
    private static final String REGEX_FOR_COUNT = "^[0-9]+";
    private static final Pattern patternForName = Pattern.compile(REGEX_FOR_NAME_LIST);
    private static final Pattern patternForCount = Pattern.compile(REGEX_FOR_COUNT);

    public static List<String> validateNameList(String input) {

        // 1. 알파벳, 쉼표 외 입력여부 검증
        if (isValidRegexName(input)) {
            return null;
        }

        // 2. parsing 후 각각 길이 검증
        return isValidLength(input);
    }


    public static boolean validateCount(String input) {

        try {
            isValidRegexCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void isValidRegexCount(String input) {
        if (!patternForCount.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자만 입력하세요.");
        }
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

    private static boolean isValidRegexName(String input) {
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
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 1자 이상 5자 이하로 입력하세요.");
        }
    }

    private static void validateByRegex(String input) {
        if (!patternForName.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 알파벳과 쉼표(,)로만 입력하세요. 입력 내에 공백도 없어야 합니다.");
        }
    }

    private static List<String> parsingNameList(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toList());
    }
}
