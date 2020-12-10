package bai12_java_collection_framework.thuc_hanh.ex_4_sap_xep_comparator_comparable;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() == o2.getAge()) {
            return 0;
        } else
            return -1;
    }
}
