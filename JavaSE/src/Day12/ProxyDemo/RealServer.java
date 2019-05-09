package Day12.ProxyDemo;

/**
 * @cLassName: RealServer
 * @author: cube
 * @description: TODO
 * @date: 2019/3/26 11:46
 */
public class RealServer implements NetWork{
    @Override
    public void browse() {
        System.out.println("真正的浏览网页");
    }
}
