package Prac.variable;

class Person {
    String name;
    Address address;

    public String getName() {
        return name.toUpperCase();
    }

    public String getFullAddress() {
        return address.getFullAddress();
    }
}

class Address {
    String city;
    String street;

    public String getFullAddress() {
        return street.toUpperCase() + ", " + city.toUpperCase(); // street 또는 city가 null일 경우 NullPointerException 발생
    }
}

public class NullExc {
    public static void main(String[] args) {
        NullExc nullExc = new NullExc();
        Person person = new Person();

        System.out.println("Name: " + nullExc.getPersonName(person));

        System.out.println("Address: " + nullExc.getPersonAddress(person));
    }

    public String getPersonName(Person person) {
        return person.getName();
    }

    public String getPersonAddress(Person person) {
        return person.getFullAddress();
    }
}
