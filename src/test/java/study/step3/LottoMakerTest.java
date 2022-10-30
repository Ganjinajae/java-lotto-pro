package study.step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.constants.CommonConstants.PRICE_PER_LOTTO;

public class LottoMakerTest {
    @Test
    void 구입_금액대로_로또를_발급() {
        Money inputMoney = new Money("14000");
        Lottos lottos = LottoMaker.makeLottos(inputMoney);

        assertThat(lottos.hasEqualSize(inputMoney.dividedBy(PRICE_PER_LOTTO))).isTrue();
    }
}
