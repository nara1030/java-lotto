package lotto.domain;

import lotto.exception.InvalidBonusNumberException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningConditionTest {
    @Test
    void 로또_당첨번호_및_보너스번호_중복_테스트() {
        Lotto lotto = new Lotto(new Integer[]{5,27,29,35,39,44});

        assertAll(
                () -> {
                    Lotto previousLotto = new Lotto(new Integer[]{5,28,29,35,39,44});
                    LottoNumber bonusNumber = LottoNumber.valueOf(28);
                    assertThatThrownBy(() -> {
                        new LottoWinningCondition(previousLotto, bonusNumber);
                    }).isInstanceOf(InvalidBonusNumberException.class);
                },
                () -> {
                    Lotto previousLotto = new Lotto(new Integer[]{5,28,29,35,39,44});
                    LottoNumber bonusNumber = LottoNumber.valueOf(27);
                    assertThat(new LottoWinningCondition(previousLotto, bonusNumber).winLotto(lotto)).isEqualTo(LottoWinnerType.valueOf(5, true));
                }
        );
    }
}