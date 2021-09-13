package com.example.function.handler;

import com.example.util.TimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalTime;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest()
class TimeHandlerTest {
    @Autowired
    TimeHandler timeHandler;

    @MockBean
    TimeFormatter timeFormatter;

    @Test
    void testTimeHandler() {
        String timeString = "10:10 AM";
        when(timeFormatter.format(any(LocalTime.class))).thenReturn(timeString);
        String result = timeHandler.apply("");
        assertThat(result).isEqualTo(format("Time: %s", timeString));
    }
}
