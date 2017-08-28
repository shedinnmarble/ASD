package bank.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Dewei Xiang on 8/13/2017.
 */
public class TimingLogProxy implements InvocationHandler {
    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), new TimingLogProxy(obj));
    }

    private TimingLogProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        try {
            long start = System.nanoTime();
            result = m.invoke(obj, args);
            long end = System.nanoTime();
            System.out.println(String.format("%s took %d ns", m.getName(), (end-start)));
            System.out.println(String.format("%s called", m.getName()));
        } catch (InvocationTargetException e) {
            throw e.getTargetException();

        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {

        }
        return result;
    }
}
