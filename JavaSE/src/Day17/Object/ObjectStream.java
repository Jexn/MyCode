package Day17.Object;

import org.junit.Test;

import java.io.*;

public class ObjectStream {
    @Test
    public void objectOutputStreamTest() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(new File("File/object.dat"));
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {

            String str = "I Love You!";
            outputStream.writeObject(str);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void objectReaderStreamTest() {
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("File/object.dat"));
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        ) {
            String str = (String) inputStream.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void personOutputObject() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(new File("File/person.dat"));
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            Person person = new Person("老王", 001);
            outputStream.writeObject(person);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void personInputObject() {
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("File/person.dat"));
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
            Person person = (Person) inputStream.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
