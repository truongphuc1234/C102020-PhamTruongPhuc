package commons.convert_csv;

public interface FormatCSV<E> {
    String COMMA_DELIMITER = ",";

    String getHeader();

    String convertToStringCSV(E e);

    E getObjectByStringCSV(String string);

}
