package ru.netology;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Data
@AllArgsConstructor
public class DataGenerator {

    public static class Generate {
        private Generate() {
        }

        public static DeliveryData generateUserData(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new DeliveryData(generateCity(), faker.name().lastName() + " " + faker.name().firstName(), generatePhoneNumber());
        }

        public static String generateDeliveryDate(int plusDays) {
            LocalDate date1 = LocalDate.now().plusDays(plusDays);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return date1.format(formatter);
        }

        public static String generateCity() {
            Random random = new Random();
            List<String> cityValid = Arrays.asList("Москва", "Санкт-Петербург", "Казань", "Екатеринбург", "Тамбов", "Архангельск", "Нижний Новгород", "Пенза", "Краснодар", "Анадырь", "Барнаул", "Калининград");
            String city = cityValid.get(random.nextInt(cityValid.size()));
            return city;
        }

        public static String generatePhoneNumber() {
            String phoneNumber = "+79161234567";
            return phoneNumber;
        }
    }
}
