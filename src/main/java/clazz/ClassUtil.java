package clazz;

import java.util.Set;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-11 09:28
 */
public final class ClassUtil {
    /**
     *
     * 获取类加载器
     * @return java.lang.ClassLoader
     * @author hanqingsong
     * @date 2019-12-12
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls = null;
        try {
            cls=Class.forName(className,isInitialized,getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cls;

    }
    public static Set<Class<?>> getClassSet(String packageName) {
        return null;
    }
}
