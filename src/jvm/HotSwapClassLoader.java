package jvm;

/**
 * Author ： Martin
 * Date : 17/10/24
 * Description :
 * Version : 2.0
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

//    public class loadByte(byte[] classByte) {
////        return defineClass(null, classByte, 0, classByte.length);
//    }
}
