import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int randomInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static double randomDouble() {
        return random.nextDouble();
    }

    public static LocalDate randomDate(LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        return start.plusDays(random.nextLong(days + 1));
    }

    public static String randomFromArray(String[] arr) {
        return arr[random.nextInt(arr.length)];
    }
}
