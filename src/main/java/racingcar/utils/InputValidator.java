package racingcar.utils;

import static racingcar.utils.Constant.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    private static final Pattern patternForName = Pattern.compile(REGEX_FOR_NAME_LIST);
    private static final Pattern patternForCount = Pattern.compile(REGEX_FOR_COUNT);

    public static List<String> validateNameList(String input) {
        if (isValidRegexName(input)) {
            return null;
        }
        List<String> names = parsingNameList(input);
        if (isValidLengthAndNoOverlap(names)) {
            return names;
        }
        return null;
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

    private static boolean isValidLengthAndNoOverlap(List<String> names) {
        try {
            validateByLength(names);
            validateByOverlap(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateByOverlap(List<String> names) {
        long overlapRemoveCount = names.stream()
            .distinct()
            .count();
        if (overlapRemoveCount != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    private static void isValidRegexCount(String input) {
        if (!patternForCount.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자만 입력하세요.");
        }
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
        if (name.length() == ZERO_NUMBER || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 1자 이상 5자 이하로 입력하세요.");
        }
    }

    private static void validateByRegex(String input) {
        if (!patternForName.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 알파벳과 쉼표(,)로만 입력하세요. 입력 내에 공백도 없어야 합니다.");
        }
    }

    private static List<String> parsingNameList(String input) {
        return Arrays.stream(input.split(SPLIT_REGEX))
            .collect(Collectors.toList());
    }
}
