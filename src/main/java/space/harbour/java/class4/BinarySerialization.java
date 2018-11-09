package space.harbour.java.class4;

import java.io.*;

public class BinarySerialization {
    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }


    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    public static void main(String[] args) {
        Integer i = 10;

        try {
            byte[] data = serialize(i);
            System.out.println(data);

            Integer j = (Integer) deserialize(data);
            System.out.println(j);
        } catch (Exception e) {
            System.out.println(e);
        }


        String s = "Marius is programming";

        try {
            byte[] data = serialize(s);
            for (byte b: data)
                System.out.print(b);

            System.out.println();
            String t = (String) deserialize(data);
            System.out.println(t);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
