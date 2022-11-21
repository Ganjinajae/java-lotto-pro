package study.step4.models;

import study.step4.exception.BonusBallNumberInWinningLottoException;

import java.util.Map;

public class WinningLotto {
    private final Lotto winningLottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLottoNumbers, LottoNumber bonusBall) {
        this.winningLottoNumbers = winningLottoNumbers;
        validateNotInWinningLotto(bonusBall);
        this.bonusBall = bonusBall;
    }

    public void validateNotInWinningLotto(LottoNumber bonusBall) {
        if (winningLottoNumbers.contains(bonusBall)) {
            throw new BonusBallNumberInWinningLottoException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

    public Map<Rank, Integer> findWinningLottos(Lottos lottos) {
        return lottos.evaluateRankResult(winningLottoNumbers, bonusBall);
    }
}
