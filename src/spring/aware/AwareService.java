package spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String s) {
        this.beanName=s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }

    public String getBeanName() {
        return beanName;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
    public void outputResult(){
        System.out.println("bean的名称为:"+beanName);
        Resource resource=resourceLoader.getResource("classpath:spring/aware/test.txt");
        try {
            System.out.println("文件的内容为:"+ IOUtils.toString(resource.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
