package web.stream;

import java.util.Optional;

public class ZhtPerson {
    public String username;
    public int age;
    private Optional<Address> address;

    public ZhtPerson(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    public String compareTo(ZhtPerson o) {
        return username + o.username;
    }
}
