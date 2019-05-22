package io.github.pactstart.commonutils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class ReflectionUtils {

    public static Field[] getAllDeclaredFields(Class<?> beanClass) {
        HashMap<String, Field> fieldMap = new HashMap<String, Field>();
        addFields(beanClass, fieldMap);
        Field[] array = new Field[fieldMap.size()];
        fieldMap.values().toArray(array);
        return array;
    }

    private static void addFields(Class<?> beanClass, HashMap<String, Field> fieldMap) {
        for (Field field : beanClass.getDeclaredFields()) {
            if (!fieldMap.containsKey(field.getName())) {
                fieldMap.put(field.getName(), field);
            }
        }
        Class<?> superclass = beanClass.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            addFields(superclass, fieldMap);
        }
    }

    public static PropertyDescriptor[] getProperties(Class<?> beanClass) {
        HashMap<String, PropertyDescriptor> propertyMap = new HashMap<String, PropertyDescriptor>();
        addProperties(beanClass, propertyMap);
        PropertyDescriptor[] array = new PropertyDescriptor[propertyMap.size()];
        propertyMap.values().toArray(array);
        return array;
    }

    public static PropertyDescriptor findProperty(Class<?> beanClass, String name) {
        HashMap<String, PropertyDescriptor> propertyMap = new HashMap<String, PropertyDescriptor>();
        addProperties(beanClass, propertyMap);
        return propertyMap.get(name);
    }

    private static void addProperties(Class<?> beanClass, HashMap<String, PropertyDescriptor> propertyMap) {
        for (Method method : beanClass.getMethods()) {
            String methodName = method.getName();
            if (!methodName.startsWith("get") && !methodName.startsWith("set") && !methodName.startsWith("is")) {
                continue;
            }
            String upperCaseName = null;
            if (methodName.startsWith("is")) {
                upperCaseName = methodName.substring(2);
            } else {
                upperCaseName = methodName.substring(3);
            }
            if (upperCaseName.equals("Class")) {
                continue;
            }
            char[] chars = upperCaseName.toCharArray();
            chars[0] = Character.toLowerCase(chars[0]);
            String propertyName = new String(chars);
            try {
                PropertyDescriptor property = propertyMap.get(propertyName);
                if (property == null) {
                    property = new PropertyDescriptor(propertyName, beanClass, null, null);
                    propertyMap.put(propertyName, property);
                }
                if (methodName.startsWith("get") || methodName.startsWith("is")) {
                    if (property.getReadMethod() == null) {
                        property.setReadMethod(method);
                    }
                } else {
                    if (property.getWriteMethod() == null) {
                        property.setWriteMethod(method);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Class<?> superclass = beanClass.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            addProperties(superclass, propertyMap);
        }
    }

    public static Field findDeclaredField(Class<?> beanClass, String name) {
        HashMap<String, Field> fieldMap = new HashMap<String, Field>();
        addFields(beanClass, fieldMap);
        return fieldMap.get(name);
    }


    public static Class<?> getUnboxedType(Class<?> type) {
        if (type == Character.class) {
            return char.class;
        }
        if (type == Boolean.class) {
            return boolean.class;
        }
        if (type == Double.class) {
            return double.class;
        }
        if (type == Float.class) {
            return float.class;
        }
        if (type == Long.class) {
            return long.class;
        }
        if (type == Integer.class) {
            return int.class;
        }
        if (type == Short.class) {
            return short.class;
        }
        if (type == Byte.class) {
            return byte.class;
        }
        return type;
    }

    public static boolean isComplexType(Class<?> type) {
        if (type.isPrimitive()) {
            return false;
        }
        if (getUnboxedType(type).isPrimitive()) {
            return false;
        }
        if (type == String.class) {
            return false;
        }
        if (type == Date.class) {
            return false;
        }
        if (type == BigDecimal.class) {
            return false;
        }
        if (type.isArray()) {
            type = type.getComponentType();
            if (type != null) {
                return isComplexType((Class<?>) type);
            }
            return false;
        }
        return true;
    }
}
