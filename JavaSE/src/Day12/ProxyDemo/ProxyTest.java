package Day12.ProxyDemo;

/**
 * @cLassName: ProxyTest
 * @author: cube
 * @description: TODO
 * @date: 2019/3/26 11:49
 */
public class ProxyTest {
    public static void main(String[] args) {
        NetWork netWork = new RealServer();
        ProxyServer proxyServer = new ProxyServer(netWork);
        proxyServer.browse();
    }
}
