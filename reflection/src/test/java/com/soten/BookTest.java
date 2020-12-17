package com.soten;

import com.soten.book.Book;
import com.soten.book.MyAnnotation;
import com.soten.book.MyBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

class BookTest {

    Class<Book> bookClass;
    Book book;

    @BeforeEach
    void setUp() {
        bookClass = Book.class;
        book = new Book();
    }

    @Test
    @DisplayName("public 필드 출력")
    void printField() throws ClassNotFoundException {
        Arrays.stream(bookClass.getFields()).forEach(System.out::println); // public 필드 출력
    }

    @Test
    @DisplayName("모든 필드 출력")
    void printFields() {
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println); // 모든 필드 출력
    }

    @Test
    @DisplayName("모든 필드와 내용 출력")
    void printFieldsAndDescription() {
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> { // 모든 필드와 필드의 값 출력력
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @DisplayName("메소드 출력")
    void printMethod() {
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
    }

    @Test
    @DisplayName("생성자 출력")
    void printConstructors() {
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
    }

    @Test
    @DisplayName("상위 클래스의 생성자 출력")
    void printSuperConstructors() {
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    @DisplayName("인터페이스 출력")
    void printInterface() {
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
    }

    @Test
    @DisplayName("static, 접근제어자 확인, 필드 메서드 파라미터 어노테이션 등 여러가지 정보 참조 가능")
    void checkStaticAndAccessController() {
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
    }

    @Test
    @DisplayName("@Inherited 을 이용한 어노테이션 조회")
    void printAnnotation() {
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
    }

    @Test
    @DisplayName("필드에 있는 어노테이션 출력")
    void printMyAnnotation() {
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(System.out::println);
        });
    }

    @Test
    @DisplayName("원하는 어노테이션일 경우 출력하기")
    void printInstanceAnnotation() {
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.name());
                    System.out.println(myAnnotation.number());
                }
            });
        });
    }

}
