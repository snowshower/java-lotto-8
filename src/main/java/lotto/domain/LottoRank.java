package lotto.domain;

public enum LottoRank {

    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    MISS(0, 0, "꽝");

    private final int matchCount;
    private final int prizeAmount;
    private final String description;

    LottoRank(int matchCount, int prizeAmount, String description) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount(){
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}
