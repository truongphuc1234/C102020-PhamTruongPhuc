package bai15_xu_ly_ngoai_le_debug.bai_tap.ex_1_illegal_triangle_exception;

public class IllegalTriangleException extends RuntimeException {
    public IllegalTriangleException(){
        super("3 canh tam giac khong hop le");
    }
}
