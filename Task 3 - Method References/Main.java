import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Static method
    static boolean isOlderThan(Person person, int ageLimit) {
        return person.age > ageLimit;
    }

    // Instance method
    String toUpperCase() {
        return name.toUpperCase();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();

            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        // Sort names alphabetically using method reference
        List<String> sortedNames = persons.stream()
                .map(p -> p.name)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // Filter using static method reference
        BiPredicate<Person, Integer> olderCheck = Person::isOlderThan;

        List<String> olderNames = persons.stream()
                .filter(p -> olderCheck.test(p, ageLimit))
                .map(p -> p.name)
                .collect(Collectors.toList());

        // Convert names to uppercase using instance method reference
        List<String> upperNames = persons.stream()
                .map(Person::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", sortedNames));
        System.out.println(String.join(" ", olderNames));
        System.out.println(String.join(" ", upperNames));

        sc.close();
    }
}