package Day18;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest {
    @Test
    public void charsetMethod(){
        SortedMap<String,Charset> charsets = Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> entrySet = charsets.entrySet();

        Iterator<Map.Entry<String,Charset>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Charset> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    @Test
    public void charsetCode(){
        // 实例化
        Charset charset = Charset.forName("UTF-8");

        // 得到编码器和解码器
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();

        // 创建charBuffer容器
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("Charset的使用");

        // 重置position位置
        charBuffer.flip();

        // 编码
        try {
            ByteBuffer byteBuffer = encoder.encode(charBuffer);

            // 输出到控制台
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.println(byteBuffer.get());
            }

            // 解码
            byteBuffer.flip();
            CharBuffer decodeCharBuffer = decoder.decode(byteBuffer);
            System.out.println(new String(decodeCharBuffer.array(),0,decodeCharBuffer.limit()));
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
