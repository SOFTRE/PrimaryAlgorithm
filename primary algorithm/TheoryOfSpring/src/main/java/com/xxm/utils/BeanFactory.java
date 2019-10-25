package com.xxm.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: IntelliJ IDEA test
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-11 12:36:32 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class BeanFactory {
    private static Map<String,Object> map;
    static {
        try {
            map=new HashMap<String,Object>();
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            List<Element> elements= document.selectNodes("//bean");
            for (Element element : elements) {
                String node = element.attributeValue("id");
                String node1 = element.attributeValue("class");
                Object object = Class.forName(node1).newInstance();
                map.put(node,object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object getBeans(String obj) {
        Object object=map.get(obj);
        return object;
    }
}
