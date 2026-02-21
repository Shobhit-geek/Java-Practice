package PracticeExtra;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {

    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (o == null || getClass() != o.getClass())
            return false;

        Employee emp = (Employee) o;
        return id == emp.id &&
                Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class hashcodeEquals {
public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee(1, "Amit"));
        set.add(new Employee(1, "Amit"));
        System.out.println(set.size());
    }
}
