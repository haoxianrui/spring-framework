## 目录
[Spring源码学习01：IntelliJ IDEA2019.3编译Spring5.3.x源码](https://www.cnblogs.com/fly4j/p/12825586.html)

## 前言
工欲善其事必先利其器。学习和深读Spring源码一个重要的前提：编译源码到我们的本地环境。这样方便我们在本地环境添加注释、断点追踪、查看类或接口的继承关系等等，更加高效的学习Spring源码。个人觉得深读Spring源码对我们的编码水平会有很大很大的提升，因为其牵涉的广度、深读、以及优秀编码规范都值得我们去品、细品、慢慢品。废话不多说，本篇就如何在我们的intelliJ IDEA编译Spring源码的步骤以及在编译的过程中遇到的问题做一个详细说明。

## 环境
- 开发工具： IntelliJ IDEA 20193.3
- 编译工具： gradle-6.4-rc-4
- 操作系统： windows 10

## 编译
### 一、下载Spring源码
访问Spring官方源码地址 [https://github.com/spring-projects/spring-framework.git](https://github.com/spring-projects/spring-framework.git)，下载源码zip包到本地

### 二、下载和配置编译工具Gradle
**1. 下载Gradle**

访问Gradle官网 [https://services.gradle.org/distributions/](https://services.gradle.org/distributions/)，选择gradle-6.4-rc-4-bin.zip（截止2020-05-03当前最新），下载到本地并解压

![](https://i.loli.net/2020/05/03/xBaG8Lb29DXqJI4.png)


![](https://i.loli.net/2020/05/03/JgAWh4p8sI2cFEX.png)

**2. 配置Gradle系统环境变量**

![](https://i.loli.net/2020/05/03/4Vr2wUbOMEuiNfJ.png)
![](https://i.loli.net/2020/05/03/gKRG3ZdveEWbp7M.png)

**3. 验证Gradle**
 ![](https://i.loli.net/2020/05/03/AmG6vVjuQ2OsLYH.png)

### 三、IntelliJ IDEA编译Spring源码
**1. 导入Spring源码至IntelliJ IDEA**

将之前下载好的Spring源码解压后导入到IDEA，依次点击File->New->Project from Existing Sources，选择源码包路径下的**build.gradle**文件完成源码导入

![](https://i.loli.net/2020/05/03/5uS7wJXyQPgqpVT.png)
![](https://i.loli.net/2020/05/03/EQoGbcNfJ6vVDZT.png)

**2. IntelliJ IDEA配置Gradle**

依次打开File->Settings

![](https://i.loli.net/2020/05/03/1uRgAOMTSk7zQ23.png)

**3. 开始编译**

在编译开始之前，我们先看看下载的官方源码里给出的导入IDEA的提示
![](https://i.loli.net/2020/05/03/1o5DRtvxBzecfyX.png)

按照上面描述，因为上面导入我是按照第二步去做的。最后仅仅只需做第1条，预编译spring-oxm。进入项目路径，执行以下命令完成spring-oxm的预编译即可

```
gradlew :spring-oxm:compileTestJava
```

![](https://i.loli.net/2020/05/03/WH2UrRDBqQLICie.png)

完成了spring-oxm的预编译之后，就可以编译我们的代码了，一般由IDEA自动帮我们完成源码到projects的转换，也可以由我们手动import。

![](https://i.loli.net/2020/05/03/EG2Rdl84avf6Acn.png)

自此，编译的整个过程已经完成。下面我们要做的事就是添加自己的模块对已编译的项目模块进行验证测试，相信我验证会是一个有趣的过程。

## 测试

打开源码我们可以看到每个模块都对应的有单元测试，再相比较平时自己在开发时干的事情。再想到流行的敏捷开发模式中的TDD（测试驱动开发），没有测试就没有功能代码。不禁觉得其中的优秀是为了让我忘尘而叹。

![](https://i.loli.net/2020/05/03/OFNAm5BvXg4SbRx.jpg)

扯回正题，不能让你们觉得我扯废话凑字数暴露没啥水平的真实情况。上面说到各个模块的单元测试我们可以测试编译项目是否有问题，但是后续学习在于模块之间的整合之上。所以我在此添加一个新的模块，这个模块模拟一个bean的创建和获取这么个过程。

**1. 创建模块spring-fly4j**

如果你们想问这名字有啥深意吗？抱歉哈..没有。想起spring-test起不了，你们懂spring有这个模块了，起名障碍啊，强行理解的话：“为了java飞吧”,忍住别笑

依次右击项目->New->Module
![](https://i.loli.net/2020/05/03/54EZu1tkpCWVoB6.png)
![](https://i.loli.net/2020/05/03/d9QMVWP4oyNazbT.png)

**2. 添加测试模块代码**

先预览下添加的代码结构吧，很简单是不？加上需要添加依赖的build.gradle共5个文件。
![](https://i.loli.net/2020/05/03/viba7oR84y9tZQ2.png)

我这里贴出这5个文件的代码

![](https://i.loli.net/2020/05/03/v5ygoDnsf8rMuzJ.gif)


```
@Configuration
@ComponentScan("com.fly4j.spring.context.**")
public class ContextConfig {
}
```

```
public interface IUserService {
}
```

```
@Service
@Scope("singleton")
public class UserServiceImpl implements IUserService {
	public UserServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " 构造函数执行...");
	}
}
```

```
public class ContextApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ContextConfig.class
		);
	    IUserService bean = context.getBean(IUserService.class);
		System.out.println(bean);
	}
}
```

```
// build.gradle
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile(project(":spring-context"))
    compile(project(":spring-instrument"))
}
```

相信以上代码机智的你一看就明白其意，其中build.gradle就只添加了spring-context和spring-instrument的依赖，spring-context模块里包含了bean工厂，可想而知，我这里生成bean和取出bean的测试案例是多么的依赖这个模块，另一个spring-instrument是spring-context模块编译需要的。

**3. 测试**

运行ContextApplication的main方法，其中会提示找不到CoroutinesUtils符号，这个问题解决我在下面一节的“问题一”进行了说明，我这里先放结果好了。

![](https://i.loli.net/2020/05/03/A3qyDnE4CKIxd17.png)

如上可以看到从上下文注入bean和取出bean的过程，至此spring-context这个重要模块验证成功结束。

## 问题

**1. 问题一**

```
Error:(350, 51) java: 找不到符号
  符号:   变量 CoroutinesUtils
  位置: 类 org.springframework.core.ReactiveAdapterRegistry.CoroutinesRegistrar
```

**解决:** 依次File->Project Structure->Libraries->+->java->spring-core->kotlin-coroutines->build->libs->kotlin-coroutines-5.3.0-SNAPSHOT.jar

![](https://i.loli.net/2020/05/03/e5rFYzJZuRWCT8g.png)

![](https://i.loli.net/2020/05/03/maP31ZC9v52ioVK.png)

![](https://i.loli.net/2020/05/03/WXoQaV6bFJcI4Dl.png)

**2. 问题二**
```
Error:(26, 38) java: 找不到符号
  符号:   类 InstrumentationSavingAgent
  位置: 程序包 org.springframework.instrument
```
**解决:** 因为spring-context对spring-instrument有依赖，在build.gradle添加对spring-instrument的依赖即可。

## 结语
至此，Spring源码如何在IntelliJ IDEA如何编译这篇文章就废话完毕了。写这篇文章目的我希望把它作为Spring系列的开始，没有环境的学习就像你想抬一个没有边角的桌子无处施力。如果大家在编译时有什么问题欢迎指出。也可以联系我(微信号:WxHXR2015)，大家相互学习，在当前环境下自己也是一个担心有今天没明天的菜比技术人。最后贴出我编译好的spring源码的地址，欢迎大家star。
[https://github.com/haoxianrui/spring-framework.git](https://github.com/haoxianrui/spring-framework.git)
