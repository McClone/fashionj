package org.fashionwork.example.demo.utils;

import org.fashionwork.example.demo.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengsd
 */
public class EntityUtils {

    private static Map<Class, String> entityColumnMap = new HashMap<>();

    public final static String sqlFormatter = "%s as %s";

    public static Map<String, String> getEntityColumn(Class<?> tClass) {
        Map<String, String> result = new HashMap<>();
        Annotation[] annotations = tClass.getDeclaredAnnotations();
        Field[] fields = tClass.getDeclaredFields();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Entity.class) {
                Method[] methods = tClass.getMethods();
                for (Method method : methods) {
                    Column column = method.getDeclaredAnnotation(Column.class);
                    if (column != null) {
                        String methodName = method.getName();
                        for (Field field : fields) {
                            if (methodName.toLowerCase().contains(field.getName().toLowerCase())) {
                                result.put(column.name(), field.getName());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static String getEntityColumnSql(Class<?> tClass) {
        if (entityColumnMap.containsKey(tClass)) {
            return entityColumnMap.get(tClass);
        }
        Map<String, String> result = EntityUtils.getEntityColumn(User.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (String column : result.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(sqlFormatter, column, result.get(column)));
        }
        String entityColumnSql = stringBuilder.toString();
        entityColumnMap.put(tClass, entityColumnSql);
        return entityColumnSql;
    }

    public static void main(String[] args) {
        System.out.println(EntityUtils.getEntityColumnSql(User.class));
    }
}
