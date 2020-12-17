package com.soten.book;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Runtime 까지 이 어노테이션을 유지할 때.
@Target({ElementType.TYPE, ElementType.FIELD}) // 타입과 필드에만 이 어노테이션 사용 가능.
@Inherited // 상위 클래스의 어노테이션 조회할 수 있게 해줌.
public @interface MyAnnotation {

//    String value() default "basic";  >> value 는 값을 하나만 받을 때만 사용

    String name() default "yoynho";

    int number() default 100;

}
