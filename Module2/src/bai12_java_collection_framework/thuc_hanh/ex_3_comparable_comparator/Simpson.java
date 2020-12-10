package bai12_java_collection_framework.thuc_hanh.ex_3_comparable_comparator;

public class Simpson implements Comparable<Simpson> {
    String name;

    Simpson(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Simpson o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "{" + name + '}';
    }
}
