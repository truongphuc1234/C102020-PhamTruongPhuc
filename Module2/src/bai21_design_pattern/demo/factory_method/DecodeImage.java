package bai21_design_pattern.demo.factory_method;

public class DecodeImage {
    private String image;

    @Override
    public String toString() {
        return image + ": is decoded";
    }

    public DecodeImage(String image) {
        this.image = image;
    }
}
