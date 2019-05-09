package Day18;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferDemo {
    @Test
    public void buffer(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        // CharBuffer charBuffer = CharBuffer.allocate(10);

        System.out.println("byteBuffer.capacity() = " + byteBuffer.capacity());
        System.out.println("byteBuffer.limit() = " + byteBuffer.limit());
        System.out.println("byteBuffer.position() = " + byteBuffer.position());

        byteBuffer.put("hello".getBytes());

        System.out.println("byteBuffer.capacity() = " + byteBuffer.capacity());
        System.out.println("byteBuffer.limit() = " + byteBuffer.limit());
        System.out.println("byteBuffer.position() = " + byteBuffer.position());

    //  flip()
        byteBuffer.flip();
        System.out.println("byteBuffer.capacity() = " + byteBuffer.capacity());
        System.out.println("byteBuffer.limit() = " + byteBuffer.limit());
        System.out.println("byteBuffer.position() = " + byteBuffer.position());

        System.out.println("byteBuffer.get() = " + (char)byteBuffer.get());
        System.out.println("byteBuffer.get() = " + (char)byteBuffer.get());
        System.out.println("byteBuffer.capacity() = " + byteBuffer.capacity());
        System.out.println("byteBuffer.limit() = " + byteBuffer.limit());
        System.out.println("byteBuffer.position() = " + byteBuffer.position());
    }
}
