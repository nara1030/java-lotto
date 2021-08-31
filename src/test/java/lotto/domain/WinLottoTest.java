package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    @DisplayName("당첨 로또는 번호 6개와 보너스 번호를 가질 수 있다.")
    void winLottoGenerateTest() {

        // given
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList());
        Number bonusNumber = new Number(7);

        // when
        WinLotto winLotto = new WinLotto(new Lotto(numbers), bonusNumber);

        // then
        assertThat(winLotto.lotto()).isEqualTo(new Lotto(numbers));
        assertThat(winLotto.bonus()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 로또의 기본 로또 번호도 오름차순으로 저장되어있어야 한다.")
    void winLottoAscTest() {

        // given
        List<Number> numbers = Arrays.asList(6, 5, 4, 3, 2, 1)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList());
        Number bonusNumber = new Number(7);

        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        // when
        WinLotto winLotto = new WinLotto(new Lotto(numbers), bonusNumber);

        // then
        assertThat(winLotto.lotto()).isEqualTo(expected);
    }

}