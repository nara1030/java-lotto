package lotto.domain;

import lotto.util.Utility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottosTest {
    @Test
    void 당첨자_확인() {
        List<Lotto> testCases = new ArrayList<>();
        testCases.add(new Lotto(new Integer[]{1, 5, 10, 15, 20, 30}));
        testCases.add(new Lotto(new Integer[]{2, 5, 15, 30, 36, 45}));

        assertAll(
                () -> {
                    String previousLottoString = "1, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    Lottos lottos = Lottos.supplyLottos(testCases);
                    LottoWinner winner = lottos.calculateWinner(previousLotto, 10);

                    Map<LottoWinnerType, Integer> winners = new HashMap<>();
                    winners.put(LottoWinnerType.SECOND_PLACE, 1);
                    winners.put(LottoWinnerType.FIFTH_PLACE, 1);

                    assertTrue(winner.getWinners().equals(winners));
                },
                () -> {
                    String previousLottoString = "2, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    Lottos lottos = Lottos.supplyLottos(testCases);
                    LottoWinner winner = lottos.calculateWinner(previousLotto, 5);

                    Map<LottoWinnerType, Integer> winners = new HashMap<>();
                    winners.put(LottoWinnerType.FOURTH_PLACE, 2);

                    assertTrue(winner.getWinners().equals(winners));
                }

        );
    }

    @Test
    void 수익률_계산() {
        List<Lotto> testCases = new ArrayList<>();
        testCases.add(new Lotto(new Integer[]{1, 5, 10, 15, 20, 30}));
        testCases.add(new Lotto(new Integer[]{2, 5, 15, 30, 36, 45}));

        assertAll(
                () -> {
                    String previousLottoString = "1, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    Lottos lottos = Lottos.supplyLottos(testCases);
                    LottoWinner winner = lottos.calculateWinner(previousLotto, 10);
                    assertThat(lottos.calculateYield(winner, 10000)).isEqualTo(3000.5f);
                },
                () -> {
                    String previousLottoString = "2, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    Lottos lottos = Lottos.supplyLottos(testCases);
                    LottoWinner winner = lottos.calculateWinner(previousLotto, 5);
                    assertThat(lottos.calculateYield(winner, 10000)).isEqualTo(10.0f);
                }

        );
    }
}