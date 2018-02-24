package CoreContainer.bean.test;

import CoreContainer.bean.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 思考 以下代码执行了哪些逻辑？
 *
 * 1.数据准备阶段
 *      首先对传入的resource资源做封装
 *      通过sax读取xml的方式来准备inputStream对象
 *      doLoadBeanDefinitions传入真正的核心处理
 *              1.获取xml验证模式
 *                  xml文件的验证模式保证了文件的正确性，比较常用的验证模式有2种
 *                  DTD 和 XSD
 *              2.加载xml文件，得到对应的document
 *              3.根据返回的document注册bean信息（对配资文件的解析 复杂）
 *2.默认标签的解析
 */
@SuppressWarnings("deprecation")
public class beanFactoryTest {
    @Test
    public void  testSimpleLoad(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("spring.xml"));
        MyTestBean mb=(MyTestBean) bf.getBean("myTestBean");
        System.out.println(mb.getTestStr());


    }
}
/**
 * 功能分析：
 * 1.读取 spring.xml配置文件
 * 2.根据配置文件找到对应的类的配置，并进行实例话
 * 3.调用实例
 * 首先要对xml文件进行读取及验证并放到内存中
 * 然后根据配置进行反射实例化bean
 *
 * 具体如何实现的呢？
 * 查看spring－beans包
 * 两个核心类
 * 1.DefaultListableBeanFactory
 *      a.XmlBeanFactory继承自它 XmlBeanFactory实现了XmlBeanDefinitionReader个性化读取
 *      b.是整个bean加载的核心，是spring注册和加载bean的默认实现
 *      c.继承了AbstractAutowireCapableBeanFactory 实现了ConfigurableListableBeanFactory和BeanDefinitionRegistry
 *      d.实现了序列化接口
 *  ConfigurableListableBeanFactory接口
 *      接口可以实现多继承
 *      ConfigurableListableBeanFactory接口继承了多个接口
 * 2.XmlBeanDefinitionReader
 *      负责对配置文件的读取／解析／注册
 *      通过继承的AbstractBeanDefinitionReader的方法把ResourceLoader资源路径
 *      转为Resource文件；
 *      通过documentLoader 将Resource文件转换为 elements文件
 *      实现BeanDefinitionReader接口 对elements／documents 进行解析
 * Resource资源如何封装的？
 *      文件是通过ClassPathResource进行封装读取的
 *      ClassPathResource完成了什么功能？
 *      如何实现不同（file avi）资源文件的加载？
 *      Resource rs＝new ClassPathResource（"..."）；
 *      InputStream is＝rs.getInputStream（）；
 *
 *Resource资源可以对不同资源类型进行统一处理
 *  this.reader = new XmlBeanDefinitionReader(this);
 this.reader.loadBeanDefinitions(resource);//加载配置文件的真正实现
 */
