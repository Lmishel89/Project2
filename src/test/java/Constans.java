import org.openqa.selenium.By;

import java.util.regex.Pattern;

public class Constans {
    public static final String FIRST_NAME = "Lenura";
    public static final String EMAIL = "example@gmail.com";
    public static final String PASSWORD = "Lkukareku1";
    public static final String PASSWORD1 = "Lkukareku1";
    public static final String RECEIVER_NAME = "Ronen";
    public static final String SENDER = "LenuraM";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
}