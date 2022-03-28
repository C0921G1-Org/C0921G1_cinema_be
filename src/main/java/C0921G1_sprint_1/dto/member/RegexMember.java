package C0921G1_sprint_1.dto.member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMember {

    private static Pattern pattern;
    private static Matcher matcher;

    public static final String REGEX_MEMBER_NAME = "^[a-zA-Z ]+$";
    public static final String REGEX_PHONE_NUMBER = "^(\\(84\\)\\+|0)(90|91)(\\d){7}$";
    public static final String REGEX_TIME = "^(\\d){4}-(\\d){2}-(\\d){2}$";
    public static final String REGEX_IDENTITY_NUMBER = "^((\\d){9}|(\\d){12})$";


    //check age member >= 16 - KhanhLDQ
    public static boolean checkAgeMember(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        pattern = Pattern.compile(REGEX_TIME);
        matcher = pattern.matcher(dateOfBirth);

        boolean isRetry = false;

        if (!matcher.matches())
            isRetry = true;
        else {
            LocalDate birthDay = LocalDate.parse(dateOfBirth,formatter);
            LocalDate after16Years = birthDay.plusYears(16);
            LocalDate after100Years = birthDay.plusYears(100);

            if (after16Years.isAfter(now) || after100Years.isBefore(now))
                isRetry = true;
        }

        return isRetry;
    }

}
