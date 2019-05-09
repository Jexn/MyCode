package Day22;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnection {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 获取地址
            URL url = new URL("http://www.gov.cn/premier/2019-04/13/5382268/images/51a38a2d73294aacbdeb00c93552311f.jpg");

            // 获取文件名
            String fileName = url.getFile();
            int lastIndex = fileName.lastIndexOf('/') + 1;
            fileName = fileName.substring(lastIndex);

            // 连接
            connection = (HttpURLConnection) url.openConnection();

            // 获取资源
            inputStream = connection.getInputStream();

            // 写入本地
            fileOutputStream = new FileOutputStream("File/"+fileName);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
