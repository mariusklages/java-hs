package space.harbour.java.class4;

class Main{
    public static void main(String[] args) {
        ExampleValue value = new ExampleValue();
        System.out.println(value.toJsonObject());

        ExampleValue value1 = new ExampleValue();
        value1.fromJson("{\"i\":10,\"s\":\"ABC\",\"f\":0.8999999761581421,\"hiddenClass\":{\"i\":1050,\"s\":\"XYZ\"}}");
        System.out.println(value1.i);
    }
}