关于设计模式的一点思考

## 2018-03-22

1. 模板

[beetl][1] 我挺喜欢的一款java模板引擎，你知道里面有多少种设计模式？


- 要去解释那些元素，是不是得用解释器的设计模式？
- GroupTemplate是核心功能，他是不是通过组合模式？
- 是不是还有工厂模式Configuration..?
- 正如其模板的魅力，肯定有模板模式，挖上一个窟窿，到时候填上去。



[mybatis-plus][2] 也是我挺喜欢的一款面向web端的数据库的增删查着开发工具，

- 支持分页、
- 代码生成的（帮你生成一些重复性的代码）

这是不是也是一种模板方法template pattern.

    Scan Entity----------->
            Reflection extrantion
                    ----------->
                            Analysis Table Name Column---------->
                                                             SQL Insert update delete select 
                                                                    ----->Injection Mybatis Container

这些开源软件，包含着各种各样的设计模式，值得我们去

- 学习，
- 挖掘，
- 提高（提高永远无止境,追求更好是一种态度）

这就好像策略模式有很多针对具体问题的解决方式一样，我们也许只需要一种即可，但为了适合不同场景，我们又
需要很多其他策略。

我们的原则是`拓展开放，修改关闭`, 指向性(子类赋值给父类)约束(方法调用，采用子类方法),指向性调用,
尽量在不改变原先code基础上，对代码系统进行修改

多态原则：子类可指向父类，在方法调用时候使用子类的覆盖方法.**很重要啦！**
父类类型的对象可以指向子类类型的对象，调用父类类型的方法是子类的实现。【特别重要】


2. 接口和抽象函数

接口是什么？……

- Collection接口，
- 文件流

Hessian接口，

1. 搭建Hessian接口
2. Hessian服务器
3. Hessian客户端(代理模式的运用, https文本代理，rpc二进制代理)

![hessian][6]
牛顿说："世界要接口，于是接口无处不在"



3. 动态分派和静态分派

在[访问者模式][4]中, 我才明白参数和接收者的意思，明白java是接收者动态分配【按子类调用 对应 被操作对象.accept
(行为访问类)】，动态分配置换掉某个方法，发生在运行期，而
针对于参数则是使用静态方式【发生在编译期】，也就是使用父类方式，对应visitor的vistor.visit(this)

一定要考虑好两个窟窿， 接收者.\(参数者\)

也就是

a. 重载的分派是根据静态类型(父类)进行的
b. 重写的分派是根据动态类型(子类)进行的



类似于数学公式

```
     Y = AX + b
```

X部分相当于是参数方法
Y相当于对象。


有时候也可能这样，别人给你一个开源代码，相当于给你一个Y,一个展示，以及各个模块X，但是你不知道他做的怎么样？ 也就是你不知道A，不知道有多少坑！
(有些专家一辈子(GMRES--YouSef Saad[1])就搞Y=AX+B的求解，这只是一个简化型公式，用于描述流体流动的Navier-Stokes方程,
A可以包含复杂的线性和非线性张量, 并搞得很出彩

1. Saad Y , Sosonkina M . Distributed Schur Complement Techniques for General Sparse Linear Systems[J]. SIAM Journal on Scientific Computing, 1997, 21(4):1337-1356.



而如果你是一名开发者，也就是你你在从事整个设计的过程，相当于你知道所有的A和X，也就是上述的终极方程
进一步变为

```
     Y =  Ai * Xi +bi , i = 0,1,...,n
```

X代表各个子模块，子包，A代表坑的多少(存在非线性的迭代过程），做到的程度， Y就是你设计的后台系统。

设计模式体现着不同的组织形式，不同形式有不同的优缺点【这句话得深入体会】

```
        看都看得明白，自己写还是if-else

        特别是状态模式和策略模式
```

4. 枚举类

静态枚举类，enum类，通过instance调用，是最经常使用的一种单例模式。

**优先使用组合（has -a)，不要使用集成(is a)**


5. 责任链模式

必须能够生成chain，也就是setNextHandler(下一个处理人是谁)，过滤器就是典型的责任链，只要有我就过滤掉，
然后就不管了，继续处理下一个bean。


6. 大小概念

在设计模式中，得体会这几个概念的相似

- 资源类
- 产品类【模板方法, 也可以拓展一下把一个开源软件当做一种产品去欣赏】
- 元素类【访问者模式  状态模式等】

针对动作、行为的行为类[访问者模式的visitorImpl， 策略模式的方法] 

小结： 有些设计模式针对元素进行重构，有些设计模式针对行为、方法进行重构

7. 对象繁殖

当前的对象的最基本能力就是生产下一代，培育下一代，没有其他。

每个对象都由构建、销毁的能力。

基于这种thinking也可能帮助account for the design patterns.

8. 访问者模式

在访问者模式有写到

- ASTParser
- html解析
- xml解析等， 

他们都是包含节点的概念，也就是节点是一个抽象概念，比如在html有

- body
- div
- ul
- li节点等，

在ASTParser有

- function
- method
- class
- 变量类型节点， 

这些节点构成了系统的骨骼元素;

而解析的时候，我们可能需要看到对应的相应状态，也就是添加一个visitor，其实这跟
观察真模式有点像，比如在观察者模式Observer pattern中对D://aaa文件夹的

- 创建文件 
- 删除文件 
- 创建文件夹 
- 删除文件夹 
- 修改文件等行为进行观察，如果发生相应动作该怎么办;

而现在visitor pattern不同的是，他没有行为，只是我们要观察的行为，我们想看到、侦查到某一个元素、结构等，并进行

- `上报`
- `显示`
- `回馈` 等行为，不同的vistor类;

最终report的内容就不一样【让我想起了Perl语言， Practical extraction and report language】
这就有点像解释器模式，因为其实程序本身就是一个解释器！【最好的理解方式是通过[scheme写一个解释器][5]出来】

访问者模式只不过是解释器的一种简化对象模式，对象可能比较少，解释器要求是一个模态空间的全部、完备对象。
很多解释器都是用visitor模式进行编写

- 而策略模式、
- 观察者模式、
- 责任链模式等都是针对你的行为进行`轮询` or `Iterator`的过程,

代理模式则是针对行为进行`替换`的操作。

9. 插上一个private洞变量

很多设计模式都喜欢插上private窟窿变量， 比如

- 组合模式
- adpater模式等。

10. AOPInject

- 了解动态代理的生成原理(invoke)
- 了解注解的执行过程(@Fluid)
![fluid][7]


[1]:http://ibeetl.com/guide/#beetl 
[2]:http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B 
[3]:http://hessian.caucho.com/ 
[4]:https://blog.csdn.net/anxpp/article/details/51224293 
[5]:http://jueqingsizhe66.github.io/blog/2015/05/18/the-little-scheme-and-part-of-tss/ 
[6]:https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/Hessian.png
[7]:https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/AOPInject.png
