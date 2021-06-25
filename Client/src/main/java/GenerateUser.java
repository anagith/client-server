import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateUser {
    private static final Faker instance = Faker.instance();

    public static List<User> generateUsersArray() {
        final List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            users.add(generate());
        }
        return users;
    }

    public static User generate() {
        Integer ageInt = 10 + new Random().nextInt(60);
        String age = ageInt.toString();
        return new User(instance.name().firstName(),
                instance.name().lastName(),
                instance.phoneNumber().phoneNumber(),
                instance.internet().emailAddress(),
                instance.address().fullAddress(),
                age);
    }
}
