package pattern.creational_pattern.singleton;

/**
 * 实现单例访问Kerrigan的第一次尝试
 * 懒汉模式
 */    
public class SingletonKerriganA {     
      
    /**   
     * 单例对象实例
     */
    private static SingletonKerriganA instance = null;

    /**
     * 1 构造器私有化，确保系统唯一
     */
    private SingletonKerriganA() {
    }

    /**
     * 不支持多线程并发访问
     * 1 线程一 从lineA 刚判断完为空，进入lineB位置
     * 2 cpu资源让给线程二， 判断lineA仍然为空
     * 3定义公有并静态的方法，返回该对象
     * @return
     */
    public static SingletonKerriganA getInstance() {     
        if (instance == null) {                              //line A     
            instance = new SingletonKerriganA();          //line B     
        }     
        return instance;     
    }     
}     