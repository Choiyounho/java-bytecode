package com.soten;

import com.sun.org.glassfish.gmbal.Description;
import org.assertj.core.internal.bytebuddy.ByteBuddy;
import org.assertj.core.internal.bytebuddy.implementation.FixedValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.named;

class MagicianTest {

    @Test
    @DisplayName("모자에서 토끼를 꺼내는 마술 준비 (바이트코드 조작)")
    @Description("바이트 코드를 조작했기 때문에 이 후에 pullOut 메서드를 실행해도 Rabbit 이 나온다.")
    void prepareMagic() {
        try {
            new ByteBuddy().redefine(Hat.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
                    .make()
                    .saveIn(new File("C:\\Users\\younh\\Desktop\\java-bytecode\\target\\classes"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("모자에서 토끼를 꺼내는 마술")
    void magic() {
        assertThat(new Hat().pullOut()).isEqualTo("Rabbit");
    }

}
