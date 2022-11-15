package study.step4.helper;

import org.junit.jupiter.api.Test;
import study.step4.models.Lottos;
import study.step4.models.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {
    @Test
    void 구입_금액대로_로또를_발급() {
        Money inputMoney = new Money("14000");
        Lottos lottos = LottoMaker.makeLottos(inputMoney.numberAvailable());

        assertThat(lottos.size()).isEqualTo(inputMoney.numberAvailable());
    }
}
