package com.chen.reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射技术  (另一种创建对象*、调用方法*、使用属性、执行过程中获取方法参数、分析注解...)
 */
public class ReflectionTest {

    public static void main(String[] args) {
        String classname;
        if(args.length>0){
            classname=args[0];
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入类名：（例：com.chen.entity.Product）");
            classname = scanner.next();
        }

        try {
            // 利用反射，获得 Class类对象,一个Class对象表示的是一个类型，而这个类型未必是一个类
            // 例：int 不是一个类， 但 int.class 是一个Class类型的对象
            //Class<Product> c = Product.class;
            Class<?> c = Class.forName(classname);
            c.getComponentType()
            // 获取 c 的父类
            Class<?> superclass = c.getSuperclass();

            String s = Modifier.toString(c.getModifiers());

            if(s.length()>0){
                System.out.println("类的修饰符："+s+" ");
            }
            System.out.println("类名class： "+classname);

            if(superclass !=null && superclass != Object.class){
                System.out.println(" extends "+superclass.getName());
            }

            System.out.println("\n{\n");

            System.out.println("c 的构造方法: \n");

            // 打印 c 的构造方法
            printConstructors(c);

            System.out.println();
            System.out.println("c 的方法: \n");

            // 打印 c 的方法
            printMethods(c);

            System.out.println();
            System.out.println("c 的变量: \n");

            // 打印 c 的变量
            printFileds(c);

            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    // 打印 c 的变量
    private static void printFileds(Class<?> c) {
        // 获取 c 中的所有变量：得到本类所有的属性（公有，私有...)
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            // 获取变量的类型
            Class<?> type = field.getType();
            // 获取变量的名字
            String name = field.getName();
            // 获取变量的修饰符
            String s = Modifier.toString(field.getModifiers());
            if(s.length()>0){
                System.out.println(type.getName()+" "+name+" ");
            }
        }
    }

    // 打印 c 的方法
    private static void printMethods(Class<?> c) {
        // 获取这个类或接口的全部方法（包括私有），但不包括由超类继承的方法
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            // 获取该方法的返回值类型
            Class<?> returnType = method.getReturnType();
            // 获取方法的名字
            String name = method.getName();

            System.out.println("  ");

            // 获取方法的修饰符
            String s = Modifier.toString(method.getModifiers());
            if(s.length()>0){
                System.out.println(s+" ");
            }

            System.out.println(returnType.getName()+" "+name+"(");

            // 获得方法的参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i>0){
                    System.out.println(", ");
                }
                // 打印方法的参数名
                System.out.println("方法参数名："+parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    // 打印 c 的构造方法
    private static void printConstructors(Class<?> c) {
        // 返回该类声明的所有构造方法：公共的，私有的，但不包括父类的
        Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            // 获得构造方法的名字
            String name = constructor.getName();
            System.out.println("  ");

            // 获得构造方法的修饰符
            String s = Modifier.toString(constructor.getModifiers());
            if(s.length()>0){
                System.out.println(s+" ");
            }
            System.out.println(name+"(");

            // 获得构造方法的参数类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i>0){
                    System.out.println(", ");
                }
                // 打印构造方法的参数名
                System.out.println(parameterTypes[i].getName());
            }

            System.out.println(");");
        }
    }
}
