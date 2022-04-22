package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.Utility;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();

        List<Lotto> lottos = Store.pay(price);

        ResultView.printCountOfLottos(Store.countOfLottos(price));
        ResultView.printResultOfPurchase(lottos);

        Integer[] previousLottoNumber = Utility.convertStringArrayToIntegerArray(Utility.split(InputView.inputLottoOfPreviousWeek()));
        Lotto previousLotto = new Lotto(previousLottoNumber);

        int[] stats = Store.calculateStats(lottos, previousLotto);
        ResultView.printWinningStatistics(stats);
        ResultView.printYield(stats, price);
    }
}
