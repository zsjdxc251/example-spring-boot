package com.lesson;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     *
     * @see StringUtils#replacePattern(java.lang.String, java.lang.String, java.lang.String)
     *  Map转POJO
     */
    @Test
    public void shouldAnswerWithTrue()
    {

 
        User user = new User();
        Map<String,String> map = new HashMap<>();
        map.put("name","1");
        map.put("age","2");
        try {
            BeanUtils.populate(user,map);
            System.out.println(JSON.toJSONString(user));
            System.out.println(JSON.toJSONString(map));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


    @Data
    public class User{
        private String name;
        private String age;
    }
}
