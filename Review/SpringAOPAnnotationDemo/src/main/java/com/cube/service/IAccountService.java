package com.cube.service;

/**
 * @author Cube
 * @className IAccountService
 * @description 账户业务层接口
 * @date 2019-06-13 10:24
 */

/**
 * JoinPoint(连接点): 所谓连接点是指那些被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点。 比如此业务层接口中的所有方法就是连接点。
 * Pointcut(切入点): 所谓切入点是指我们要对哪些JoinPoint进行拦截的定义。
 *                  对连接点中具体哪些类方法要进行代理，哪些不需要代理进行过滤，需要代理的就是切入点。所有的切入点都是连接点，而连接点不一定切入点
 * Advice(通知/增强): 所谓通知是指拦截到JoinPoint之后所要做的事情就是通知。
 *                   通知的类型：前置通知,后置通知,异常通知,最终通知,环绕通知。
 *                   通过代理类理解就是method.invoke()方法执行前后操作，根据执行的位置的不同对通知进行分类。
 * Introduction(引介): 引介是一种特殊的通知在不修改类代码的前提下, Introduction可以在运行期为类动态地添加一些方法或Field。
 * Target(目标对象): 代理的目标对象。被代理对象。
 * Weaving(织入): 是指把增强应用到目标对象来创建新的代理对象的过程。 spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入。对一个对象进行代理操作的过程
 * Proxy（代理）: 一个类被AOP织入增强后，就产生一个结果代理类。被代理之后产生的对象。
 * Aspect(切面): 是切入点和通知（引介）的结合。
 */
public interface IAccountService {

    // 保存用户
    void saveAccount();

    // 更新用户
    void updateAccount(int id);

    // 根据ID删除用户
    int deleteAccount();

}
