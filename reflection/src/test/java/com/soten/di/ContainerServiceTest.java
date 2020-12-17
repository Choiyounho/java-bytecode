package com.soten.di;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ContainerServiceTest {

    @Test
    @DisplayName("Inject 어노테이션을 쓰지 않은 클래스의 경우")
    void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertThat(bookRepository).isNotNull();
    }

    @Test
    @DisplayName("Inject 어노테이션 사용한 클래스")
    void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertThat(bookService).isNotNull();
    }

}
