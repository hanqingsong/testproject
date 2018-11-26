package classload;

/**
 * https://mp.weixin.qq.com/s/tfBvdon8bz0MIE0NHUkcjA
 * <strong> 类的初始化阶段需要做的是执行类构造器,类构造器是编译器收集所有静态语句块和类变量的赋值语句按语句在源码中的顺序合并生成类构造器 </strong>
 * 因此先执行第一条静态变量的赋值语句即st = new StaticTest ()，此时会进行对象的初始化，
 * <strong> 对象的初始化是先初始化成员变量再执行构造方法 </strong>，
 * 因此打印2->设置a为110->执行构造方法(打印3,此时a已经赋值为110，
 * 但是b只是设置了默认值0，并未完成赋值动作)，等对象的初始化完成后继续执行之前的类构造器的语句，接下来就不详细说了，按照语句在源码中的顺序执行即可。
 */
public class StaticTest
{
   public static void main(String[] args)
   {
       staticFunction();
   }

   static StaticTest st = new StaticTest();

   static
   {
       System.out.println("1");
   }

   {
       System.out.println("2");
   }

   StaticTest()
   {
       System.out.println("3");
       System.out.println("a="+a+",b="+b);
   }

   public static void staticFunction(){
       System.out.println("4");
   }

   int a=110;
   static int b =112;
}