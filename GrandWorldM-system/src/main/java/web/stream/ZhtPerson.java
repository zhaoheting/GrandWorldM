package web.stream;

import java.util.Optional;

public class ZhtPerson implements Comparable<ZhtPerson>{
    public String username;
    public int age;
    private Optional<String> address;

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

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    @Override
    public int compareTo(ZhtPerson o) {
        return username.compareTo(o.username);
    }
}
