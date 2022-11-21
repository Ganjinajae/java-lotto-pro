package study.step4.models;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    public Map<Rank, Integer> evaluateRankResult(Lotto winningLotto, LottoNumber bonusBall) {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int numberOfMatching = winningLotto.countNumberOfMatching(lotto);
            Rank rank = Rank.valueOf(numberOfMatching, lotto.hasNumber(bonusBall));
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return winningResult;
    }
}
