import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        // Sort events chronologically
        events.sort(Comparator.comparing(event -> event.date));

        // All events sorted by date
        String sortedNames = events.stream()
                .map(event -> event.name)
                .collect(Collectors.joining(" "));

        // Earliest event
        String earliest = events.get(0).name;

        // Latest event
        String latest = events.get(events.size() - 1).name;

        // Events occurring in the given month
        String monthEvents = events.stream()
                .filter(event -> event.date.getMonthValue() == month)
                .map(event -> event.name)
                .collect(Collectors.joining(" "));

        System.out.println(sortedNames);
        System.out.println(earliest);
        System.out.println(latest);
        System.out.println(monthEvents);

        sc.close();
    }
}