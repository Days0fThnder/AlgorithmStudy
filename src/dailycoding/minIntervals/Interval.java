package dailycoding.minIntervals;

public class Interval implements Comparable<Interval>{
    private Integer start;
    private Integer end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return this.getStart().compareTo(o.getStart());
    }
}
