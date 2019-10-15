package com.xhzhao.summerboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xhzhao
 */
public final class ReflectionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception ex) {
            logger.error("new instance failure", ex);
            throw new RuntimeException(ex);
        }
        return instance;
    }

    public static Object invokeMethod(Object obj, Method method, Object...args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception ex) {
            logger.error("invoke method failure", ex);
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception ex) {
            logger.error("set field failure", ex);
            throw new RuntimeException(ex);
        }
    }
}
