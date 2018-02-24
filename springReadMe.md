1.spring概述(基础)
    是一种轻量级企业开发解决方案；
    每一种被spring管理的java对象都称为bean；
    spring提供了ioc容器来初始化对象，解决对象间的依赖管理和对象的使用；
    spring是模块化的
        1) Core Container (核心容器)
            Spring－Core：核心工具类
            Spring－Beans：Spring定义Bean的支持
            Spring－Context：运行时Spring容器
            Spring－Expression：使用表达式语言在运行时查询和操作对象
        2) AOP 
            Spring－Aop 基于代理的Aop支持
            Spring－Aspects 基于Aspects的代理支持
        3) Message 消息
            Spring－Message 对消息架构和协议的支持
        4）Web
            Spring－Web 提供web集成的功能 ，提供Spring web容器
            Spring－webmvc 提供基于Servlet的Spring Mvc
            Spring－WebSocket 提供webSocket功能
        5）Data Access／integration 数据访问／集成
            Spring－jdbc 提供jdbc访问数据库的支持
            Spring－orm 提供对象／关系模型映射支持
            Spring－oxm 提供对象／xml模型映射支持
            Spring－jms 提供jms支持
2.Spring生态
3.Spring搭建
    Spring的基本配置
        1）使用pojo进行侵入式最小和轻量级开发
        2）通过依赖注入和基于接口编程实现松耦合    
        3）通过Aop和默认习惯进行声明式编程
        4）使用Aop和模版减少模式化代码
    依赖注入
        ioc（控制反转）和Di（依赖注入）
        控制反转是通过依赖注入实现的
        依赖注入是指*容器*进行创建和维护对象间的依赖关系，而不是通过对象本身负责创建和解决自己的依赖
        依赖注入的目的是：*解耦*  ,体现了 *组合*的思想  
    Spring ioc容器
        负责创建bean
        spring提供通过使用xml/注解／java配置／groovy配置实现Bean的创建和注入
        
4.1）声明bean注解    
    @Component组件 没有明确的角色
    @Service 在业务逻辑层使用
    @Repository 在数据访问层使用
    @Controller 在表现层（mvc－Spring MVC）使用
4.2）注入bean的注解
    @Autowired：spring提供的注解
    @Inject
    @Resource
    可注解在set方法上或者属性上  
    
    
Aop
    面向切面编程，相对于oop面向对象编程
    Aop存在的目的是解耦合。Aop可以让一组类共享相同的行为。在oop中
    只能通过继承  耦合性高 且只能单继承  解决了oop这一缺陷
    ＊
    Spring  支持 @AspectJ的注解式切面编程
        1）使用@Aspect 声明是一个切面
        2）使用@After @Before @Around可直接将拦截规则（切点）作为参数
        3）其中@After @Before @Around参数的拦截规则为切点，为使切点复用 使用@pointCut专门定义拦截规则，然后在前三个注解中调用
        其中每一个符合连接处为连接点
        
        
注解
    注解本身没有功能，和xml一样，都是一种原数据 ，也叫配置
    注解的功能来自使用注解的地方            
    
2.Spring常用配置
    2.1 bean的Scope
        1）singleton  单例（默认）
        2）prototype  
        3）request
        4）Session
        5）globalSession  
    2.2spring el 和资源的调用
        Spring－el 表达式语言 支持在xml和注解中使用表达式，类似于jsp中的el表达式
        Spring 主要在@value的参数中使用表达式
                    @Value("i love you!")//注入普通字符串
                    @Value("#{systemProperties['os.name']}")//注入操作系统属性
                    @Value("#{T(java.lang.Math).random()*100.0}")//注入表达式结果
                    @Value("#{demoService.another}")//注入其它bean属性
                    @Value("classpath:spring/el/test.txt")//注入文件资源
                    @Value("https://www.zhihu.com/")//注入网站资源
                    @Value("${book.name}")
                    *#{} 和 ${} 的区别*
    2.3bean的初始化和销毁 
           bean的生命周期
           1）java配置  使用@bean的initMethod 和   destroyMethod  
                 @Bean(initMethod = "init",destroyMethod = "destroy")   
           2）注解方式@postConstruct @PreDestroy
    2.4 profile
          profile 为不同环境下的配置提供了支持
                    如：开发环境和生产环境 对数据库的不同配置  
          1）通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境，在开发中使用@profile注解类或者方法，达到在不同情况下选择实例化不同的bean
          2）通过设定jvm的spring.profiles.active参数来设置配置环境
          3）web项目设置在Servlet的context parameter中
            打开容器
            设置环境
            加载bean
            刷新容器
    2.5 Spring事件 Application event
        Spring的事件为Bean与bean之间的消息通信提供了支持。当一个bean处理完成一个任务后
        希望另外一个bean也做出相应的处理，所以需要另外一个bean监听当前bean发送的事件
           spring事件遵循规则
            1.自定义事件，集成ApplicationEvent
            2.定义事件监听器，实现ApplicationListener
            3.使用容器发布事件
                注入ApplicationContext用来发布事件
                使用ApplicationContext的publish方法来发布
                
                
*spring高级话题*
    1.Spring Aware
            spring 依赖注入的最大亮点是 解耦 也就是你所有的bean对spring容器的存在是没有意识的
        你可以将容器换成其它容器 如google Guice bean间的耦合性低
            但在实际项目中 要使用到spring容器本身的资源功能，bean必须意识到spring容器的存在
        才能调用容器的功能，这时 bean将和spring 容器耦合
             spring提供的 Aware接口
                BeanNameAware
                ...
             spring Aware的目的是让bean使用Spring容器的服务。因为ApplicationContext接口
        集成了MessageSource，applicationPublisher 和 ResourceLoader接口，所以Bean继承
        ApplicationContextAware 可以获得Spring容器的所有服务，原则上是需要什么服务就实现
        对应的接口 
    2.多线程
        Spring通过任务执行器(taskExecutor)实现多线程和并发编程
        使用ThreadPoolTaskExecutor可以实现一个基于线程池的taskExecutor
        *通过注解@EnableAsync*在配置类中开启对异步任务的支持 
            实现AsyncConfigurer接口   
        *在实际执行的bean方法中使用@Async*声明这是一个异步任务
    3.计划任务
        配置类使用@EnableScheduling开启对计划任务的支持
        然后在执行计划类的方法上使用@Scheduled 声明计划任务
        @Scheduled 支持多种计划任务
        cron  fixDelay  fixRate  
    4.条件注解 @Condition
        基于条件的bean创建
            1)判断条件的定义
            2)不同系统下的bean类
            3)配置类
            4)运行 
    5.组合注解和元注解
        注解可以用来替代xml配置
        Spring中的注解主要用来配置bean 以及切面的相关配置
        我们要避免模板代码的出现(消除)
            元注解就是可以注解在注解上的注解
            组合注解就是被注解的注解，组合注解具有元注解的功能
    6.@Enable*注解的工作原理
        开启一项功能支持
        好处是减少了很多代码量
             每一个Enable注解都有一个@import注解  
             @import是用来导入配置类的
             意味着这些自动开启的实现其实是导入了一些自动配置的bean
           1  
        导入配置的方式有3种：
            1）直接导入配置类
            2）根据条件选择配置类
            3）动态注册bean    
    7.测试
        集成测试和单元测试
        
        
                 
              
                
                              
                
                                
        
              