package bai7_abstract_interface.thuc_hanh.ex_3_comparator_lop_hinh_hoc;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if(o1.getArea()> o2.getArea()) return 1;
        else if (o1.getArea() < o2.getArea()) return -1;
        else return 0;
    }
}
