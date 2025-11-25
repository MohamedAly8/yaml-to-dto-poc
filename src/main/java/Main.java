import com.example.model.User;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .withId(101L)
                .withUsername("jdoe")
                .withActive(true)
                .build();

        System.out.println("Created user: " + user.getUsername());
    }
}