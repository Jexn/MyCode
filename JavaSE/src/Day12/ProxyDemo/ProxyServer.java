package Day12.ProxyDemo;

/**
 * @cLassName: ProxyServer
 * @author: cube
 * @description: TODO
 * @date: 2019/3/26 11:47
 */
public class ProxyServer implements NetWork{
    private NetWork netWork;

    public ProxyServer(NetWork netWork) {
        this.netWork = netWork;
    }

    public void check(){
        System.out.println("检查网络连接");
    }

    @Override
    public void browse() {
        check();
        System.out.println("代理服务器操作：");
        netWork.browse();
    }
}
