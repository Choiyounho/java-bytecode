package com.soten.case2;

import com.soten.Book2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Book2Test {

    @Test
    @DisplayName("디폴트 생성자 호출 확인")
    void getDefaultConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<?> book2Class = Class.forName("com.soten.Book2"); // 클래스 호출
        Constructor<?> constructor = book2Class.getConstructor(null); // 클래스의 디폴트 생성자 호출
        Book2 book2 = (Book2) constructor.newInstance(); // 생성자가
        System.out.println(book2);
    }

    @Test
    @DisplayName("파라미터가 있는 생성자 호출 확인")
    void getConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<?> book2Class = Class.forName("com.soten.Book2");
        Constructor<?> constructor = book2Class.getConstructor(String.class);
        Book2 book2 = (Book2) constructor.newInstance("myBook");
        System.out.println(book2);
    }

    @Test
    @DisplayName("필드에 있는 값을 가져오기, 값을 수정하기")
    void getFieldValue() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException
            , InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> book2Class = Class.forName("com.soten.Book2");
        Constructor<?> constructor = book2Class.getConstructor(String.class);
        Book2 book2 = (Book2) constructor.newInstance("myBook");
        System.out.println(book2);

        Field a = Book2.class.getDeclaredField("A"); // static 필드 가져오기
        System.out.println(a.get(null));
        a.set(null, "AAAAAAA");

        Field b = Book2.class.getDeclaredField("B");
        b.setAccessible(true); // 접근제어자 무시
        System.out.println(b.get(book2)); // null 로는 가져오기 불가능. 특정한 인스턴스를 거쳐야함.
        b.set(book2, "BBBBBBB");
        System.out.println(b.get(book2));
    }

    @Test
    @DisplayName("메서드 가져오기")
    void getMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> book2Class = Class.forName("com.soten.Book2");
        Constructor<?> constructor = book2Class.getConstructor(String.class);

        Book2 book2 = (Book2) constructor.newInstance("myBook");
        System.out.println(book2);

        Method c = Book2.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book2);

        Method d = Book2.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book2, 1, 2);
        System.out.println(invoke);
    }

}
