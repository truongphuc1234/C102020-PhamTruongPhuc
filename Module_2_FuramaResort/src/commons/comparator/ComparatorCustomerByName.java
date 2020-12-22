package commons.comparator;

import models.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ComparatorCustomerByName implements Comparator<Customer> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName().compareTo(o2.getName()) > 0)
            return 1;
        else if (o1.getName().compareTo(o2.getName()) < 0)
            return -1;
        else if(LocalDate.parse(o1.getBirthday(),formatter).compareTo(LocalDate.parse(o2.getBirthday(),formatter)) >0)
            return 1;
        else if(LocalDate.parse(o1.getBirthday(),formatter).compareTo(LocalDate.parse(o2.getBirthday(),formatter)) <0)
            return -1;
        else
            return 0;
    }
}
