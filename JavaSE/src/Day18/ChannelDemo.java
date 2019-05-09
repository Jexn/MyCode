package Day18;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelDemo {

    // 非直接缓冲区读写
    @Test
    public void channelTest() {
        try (
                FileInputStream fileInputStream = new FileInputStream("E:\\视频\\300MIUM-120.mp4");
                FileOutputStream fileOutputStream = new FileOutputStream("F:\\test.mp4");
                FileChannel inChannel = fileInputStream.getChannel();
                FileChannel outChannel = fileOutputStream.getChannel();
        ) {
            long start = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inChannel.read(byteBuffer) != -1) {
                // 因为此时position、limit、capacity全都都是1024
                // 在outChannel读的时候需要使用flip()将position重置为0，切换到读模式
                byteBuffer.flip();

                outChannel.write(byteBuffer);

                // 数据读完之后，position又到达末尾，所以需要使用clear()才能写入成功
                byteBuffer.clear();
            }
            long end = System.currentTimeMillis();
            System.out.println("消耗时间：" + (end - start));  // 消耗时间：48494
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 直接缓冲区读写，不能子接读写超过Integer.Max_Value大小的文件
    @Test
    public void directBuffer() {

        try (
                FileChannel inChannel = FileChannel.open(Paths.get("E:\\图片\\road.jpg"), StandardOpenOption.READ);
                FileChannel outChanel = FileChannel.open(Paths.get("File/directBuffer.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        ) {
            // 得到子接缓冲区
            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChanel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 数据的读写操作
            byte[] buffer = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(buffer);
            outMappedByteBuffer.put(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void transfer() {

        try (FileChannel inChannel = FileChannel.open(Paths.get("E:\\图片\\road.jpg"), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("File/transfer_transferFrom.jpg"),
                     StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // 将一个数据转换到一个可写的channel中
            // inChannel.transferTo(0,inChannel.size(),outChannel);

            // 将一个数据转换到一个可写的channel中
            outChannel.transferFrom(inChannel,0,inChannel.size());

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    // 分散读取和聚集写入
    @Test
    public void diffuseReadAndCollectWrite(){
        try(
                RandomAccessFile readFile = new RandomAccessFile("File/Comparable和Comparator.txt","r");
                RandomAccessFile writeFile = new RandomAccessFile("File/分散读取和聚集写入.txt","rw");
                FileChannel inChannel = readFile.getChannel();
                FileChannel outChannel = writeFile.getChannel();
                ){

            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(4096);

            ByteBuffer[] byteBuffers = {buffer1,buffer2};

            // 分散读取
            inChannel.read(byteBuffers);

            // 切换读模式
            buffer1.flip();
            buffer2.flip();

            System.out.println(new String(buffer1.array(),0,buffer1.limit()));
            System.out.println();
            System.out.println(new String(buffer2.array(),0,buffer2.limit()));

            // 聚集写入
            outChannel.write(byteBuffers);

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
