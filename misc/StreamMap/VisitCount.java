//import java.util.concurrent.ConcurrentHashMap;

public class VisitCount {
    // private ConcurrentHashMap<String, Long> visitCount = new ConcurrentHashMap<>();

    // public ConcurrentHashMap<String, Long> getVisitCount() {
    //     return visitCount;
    // }

    // public void setVisitCount(ConcurrentHashMap<String, Long> visitCount) {
    //     this.visitCount = visitCount;
    // }

    private String name;
    private Long count;

    VisitCount(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCount() {
        if (count == null) {
            return 0L;
        }

        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{Name: " + name + "; Count: " + String.valueOf(count) + "}";
    }
}
