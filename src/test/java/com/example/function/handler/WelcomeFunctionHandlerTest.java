package com.example.function.handler;

import com.example.util.UpperCaseConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest()
class WelcomeFunctionHandlerTest {

    @Autowired
    WelcomeHandler welcomeHandler;

    @MockBean
    UpperCaseConverter upperCaseConverter;

    @Test
    void testWelcomeHandler() {
        String name = "test";
        when(upperCaseConverter.convert(anyString())).thenReturn(name.toUpperCase());
        String result = welcomeHandler.apply(name);
        assertThat(result).isEqualTo(format("Hello, Welcome  %s", name.toUpperCase()));
    }
}
