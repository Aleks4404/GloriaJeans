package web.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    public DataHelper() {
    }

    // TODO Ввести Валидный номер телефона!!!
    public static String generateNamberPhone() {
        return "1234567890";
    }

    public static String generateUsersNameInRussian(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName();
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return "test1234";
    }

    public static String getEmail() {
        return "gloria1234@mail.ru";
    }

    public static String getUserName() {
        return "Алексей";
    }

    public static String getInvalidePhone1() {
        return "1234567";
    }

    public static String generateInvalidePassword() {
        return "пар";
    }

    public static String getInvalideEmail() {
        return "gloria1234@mai";
    }

    public static String getInvalideUserName() {
        return "Aleksey 123";
    }

    public static String getInvalidePhone() {
        return "0000000000";
    }
}
