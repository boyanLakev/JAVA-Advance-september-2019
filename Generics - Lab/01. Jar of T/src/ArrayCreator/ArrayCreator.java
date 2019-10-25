package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static  <T> T[] create(Class<T> Clazz, int length, T item) {

        T[] array=(T[]) Array.newInstance(Clazz,length);
        for (int i = 0; i <length ; i++) {
            array[i]=item;
        }
        return array;
    }


    public static  <T> T[]create(int length, T item) {
        T[] array;
        array = (T[]) new Object[length];
        for (int i = 0; i <length ; i++) {
            array[i]=item;
        }
        return array;
    }

}
