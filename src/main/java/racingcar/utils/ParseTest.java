package racingcar.utils;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ParseTest {
    private Parser parser = new Parser();
    private static final String ERROR = "[ERROR]";

    @Test
    void 자동차이름_파싱_정상입력() {
        String input = "aaa,bbb,ccc,dddd";
        List<String> result = parser.parseCarName(input);
        assertThat(result).contains("aaa", "bbb", "ccc", "dddd");
    }

    @Test
    void 자동차이름_다섯글자이상_예외() {
        String input = "aaa,bbb,ccc,ddddddddd";
        assertThatThrownBy(() -> parser.parseCarName(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 자동차이름_한글자미만_예외() {
        String input = "aaa,,ccc,ddd";
        assertThatThrownBy(() -> parser.parseCarName(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 자동차이름_빈배열_예외() {
        String input = "";
        assertThatThrownBy(() -> parser.parseCarName(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
