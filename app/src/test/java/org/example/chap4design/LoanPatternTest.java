package org.example.chap4design;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LoanPatternTest {

    private static final String FROM_KEY = "from";
    private static final String TO_KEY = "to";
    private static final String SUBJECT_KEY = "subject";
    private static final String BODY_KEY = "body";
    private static final String FROM_VALUE = "tim";
    private static final String TO_VALUE = "tom";
    private static final String SUBJECT_VALUE = "test subject";
    private static final String BODY_VALUE = "test body";

    @Test
    void testLoanPatternApi() {
        Map<String, String> result = LoanPattern.send(mailer ->
                mailer.from(FROM_VALUE)
                        .body(BODY_VALUE)
                        .subject(SUBJECT_VALUE)
                        .to(TO_VALUE)
        );

        assertThat(result).isEqualTo(Map.of(
                FROM_KEY, FROM_VALUE,
                TO_KEY, TO_VALUE,
                SUBJECT_KEY, SUBJECT_VALUE,
                BODY_KEY, BODY_VALUE
        ));
    }
}
