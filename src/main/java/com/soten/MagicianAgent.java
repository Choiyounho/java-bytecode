package com.soten;

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder;
import org.assertj.core.internal.bytebuddy.implementation.FixedValue;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.named;

public class MagicianAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform((builder, typeDescription, classLoader, javaModule)
                        -> builder.method(named("pullOut"))
                        .intercept(FixedValue.value("Rabbit!!"))).installOn(instrumentation);
    }

}
