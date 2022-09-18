package com.walker.newcoder;

import org.junit.Test;

public class basicexercise {
    /**
     * 1.
     * 初始化块在构造器执行之前执行，类初始化阶段先执行最顶层父类的静态初始化块，依次向下执行，
     * 最后执行当前类的静态初始化块；创建对象时，先调用顶层父类的构造方法，依次向下执行，
     * 最后调用本类的构造方法。
     */
    @Test
    public void test1(){
        new A();
    }

    /**
     * 2.
     * run()相当于线程的任务处理逻辑的入口方法，它由Java虚拟机在运行相应线程时直接调用，而不是由应用代码进行调用。
     * 而start()的作用是启动相应的线程。启动一个线程实际是请求Java虚拟机运行相应的线程，而这个线程何时能够运行是由线程调度器决定的。
     * start()调用结束并不表示相应线程已经开始运行，这个线程可能稍后运行，也可能永远也不会运行。
     */

    /**
     * 3.
     * 假如某个JAVA进程的JVM参数配置如下：
     * -Xms1G -Xmx2G -Xmn500M -XX:MaxPermSize=64M -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=3,
     * 请问eden区最终分配的大小是多少？
     *
     * ************answer************
     * 先分析一下里面各个参数的含义：
     * -Xms：1G ， 就是说初始堆大小为1G
     * -Xmx：2G ， 就是说最大堆大小为2G
     * -Xmn：500M ，就是说年轻代大小是500M（包括一个Eden和两个Survivor）
     * -XX:MaxPermSize：64M ， 就是说设置持久代最大值为64M
     * -XX:+UseConcMarkSweepGC ， 就是说使用使用CMS内存收集算法
     * -XX:SurvivorRatio=3 ， 就是说Eden区与Survivor区的大小比值为3：1：1
     * 题目中所问的Eden区的大小是指年轻代的大小，直接根据-Xmn：500M和-XX:SurvivorRatio=3可以直接计算得出
     * 500M*(3/(3+1+1))
     * =500M*（3/5）
     * =500M*0.6
     * =300M
     * 所以Eden区域的大小为300M。123
     */


}

/**
 * @author test1
 *
 */
class B extends Object
{
    static
    {
        System.out.println("Load B");
    }
    public B()
    {
        System.out.println("Create B");
    }
}
class A extends B
{
    static
    {
        System.out.println("Load A");
    }
    public A()
    {
        System.out.println("Create A");
    }
}
