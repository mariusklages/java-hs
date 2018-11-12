package space.harbour.java.class6;

public class Concurrency {

    class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    // you could extend class Person by another Class

    public final Person me = new Person("Julia", 25);
    // if final is added this cannot be changed anymore elsewhere


    public static void main(String[] args) {
        Concurrency concurrency = new Concurrency();
        concurrency.me.name = "Bob";
        System.out.println(concurrency.me.name);

    }
}
