import lombok.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Character implements Comparable<Character>, Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private OffsetDateTime time;

    public Character(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.time = OffsetDateTime.now();
    }

    @Override
    public int compareTo(Character o) {
        return (this.age - o.age);
    }

    @Override
    public String toString() {
            return String.format("%-15s  %-15s  %-15s   %-15s%n", getFirstName(), getLastName(), getAge(), getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Character)) return false;
        Character cc = (Character) o;
        return (cc.getFirstName().equals(firstName)) && (cc.getLastName().equals(lastName)) &&
                (cc.getAge() == (age) && (cc.getTime() == (time)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }
}
