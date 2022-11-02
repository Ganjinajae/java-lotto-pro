package study.step4.models;

import study.step4.Rank;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void printAll() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    public Winners findWinners(Lotto winLotto) {
        Winners winners = new Winners();
        for (Lotto lotto : lottos) {
            int numberOfMatching = lotto.countNumberOfMatching(winLotto);
            winners.add(new Winner(lotto, Rank.valueOf(numberOfMatching)));
        }
        return winners;
    }
}
