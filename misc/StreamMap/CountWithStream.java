import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountWithStream {

    public static void main(String[] args) {
        System.out.println("Initialize the stream:");
        System.out.println("Brian	100");
        System.out.println("Emily	60");
        System.out.println("null	10");
        System.out.println("Brian	null");
        System.out.println("Brian	90");
        System.out.println("Peter	50");
        System.out.println("Brian	20");
        System.out.println("Mark	500");
        System.out.println("Nancy	39");
        System.out.println("Bill	319");
        System.out.println("Alice	97");
        List<VisitCount> visitCounts = Arrays.asList(new VisitCount("Brian", 100L), new VisitCount("Emily", 60L),
                new VisitCount("", 10L), new VisitCount("Brian", null), new VisitCount("Brian", 90L),
                new VisitCount("Peter", 50L), new VisitCount("Brian", 20L), new VisitCount("Mark", 500L),
                new VisitCount("Nancy", 39L), new VisitCount("Bill", 319L), new VisitCount("Alice", 97L));
        System.out.println();

        System.out.println("Summary by Name:");
        LongSummaryStatistics nameSummary = visitCounts.stream().collect(Collectors.summarizingLong(v -> v.getCount()));
        System.out.println("Visitors summary: " + nameSummary);
        // LongSummaryStatistics{count=8, sum=956, min=20, average=119.500000, max=500}
        System.out.println();

        System.out.println("Name starts from B + to lowercase:");
        visitCounts.stream().filter(s -> s.getName().startsWith("B")).map(s -> s.getName().toLowerCase()).sorted()
                .forEach(System.out::println); // bill brian ...
                System.out.println();
                System.out.println();

        System.out.println("Only keep the counts > 100:");
        visitCounts.stream().filter(s -> s.getCount() > 100L).map(s -> s.getCount()).sorted()
                .forEach(System.out::println); // 319 500
System.out.println();

        System.out.println("Mame Set:");
        Set<String> visitorNames = visitCounts.stream().filter(s -> s.getName().length() > 0).map(VisitCount::getName)
                .collect(Collectors.toSet());
        System.out.println("Valid visitors: " + visitorNames); // [Brian, Emily, Alice, Bill, Mark, Nancy, Peter]
        System.out.println();

        System.out.println("Total count:");
        Long sumCount = visitCounts.stream().filter(s -> s.getCount() > 0L).map(VisitCount::getCount).reduce(0L,
                Long::sum);
        System.out.println("Total count: " + String.valueOf(sumCount)); // 1285
        System.out.println();

        System.out.println("Merge by Name:");
        Map<String, List<VisitCount>> groupByName = visitCounts.stream().filter(s -> s.getName().length() > 0)
                .filter(s -> s.getCount() > 0L).collect(Collectors.groupingBy(e -> e.getName()));
        System.out.println(groupByName);
        System.out.println(groupByName.values());
        for (String key : groupByName.keySet()) {
            System.out.println(key + ": " + groupByName.get(key));
        }
        System.out.println();

        System.out.println("Merge Count by Name:");
        List<VisitCount> groupByNameThenMerge = visitCounts.stream().filter(s -> s.getName().length() > 0)
                .filter(s -> s.getCount() > 0L)
                .collect(Collectors.groupingBy(VisitCount::getName, Collectors.summingLong(VisitCount::getCount)))
                .entrySet().stream().map(e -> new VisitCount(e.getKey(), e.getValue())).collect(Collectors.toList());
        System.out.println(groupByNameThenMerge);
        System.out.println();
    }

}