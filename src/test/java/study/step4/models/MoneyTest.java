package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoInputMoneyInvalidUnitException;
import study.step4.exception.LottoInputMoneyTypeException;
import study.step4.exception.NotEnoughToBuyLottoException;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    void 돈_객체_생성() {
        assertThatNoException().isThrownBy(() -> new Money("3000"));
    }

    @Test
    void 돈_객체_생성_예외() {
        assertThatThrownBy(() -> new Money("123$#!"))
                .isInstanceOf(LottoInputMoneyTypeException.class);
    }

    @Test
    void 구매_단위에_맞지_않은_경우_예외() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
        assertThatThrownBy(() -> new Money("300"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
        assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
    }

    @Test
    void 입력_값을_나누기() {
        Money money = new Money("3000");

        assertThat(money.divide(15000)).isEqualTo(5);
    }

    @Test
    void 수동_로또_갯수_주어졌을_때_금액을_넘어갈_때_예외() {
        Money money = new Money("3000");

        assertThatThrownBy(() -> money.validateEnoughToBuyLotto(4))
                .isInstanceOf(NotEnoughToBuyLottoException.class);
    }
}
