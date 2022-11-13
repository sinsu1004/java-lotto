package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.LottoList;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.UserNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private UserNumbers userNumbers;

    @BeforeEach
    void setup() {
        userNumbers = new UserNumbers("1,2,3,4,5,6", "7");
    }

    @DisplayName("1등 테스트")
    @Test
    void firsttest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                LottoList lottoList = new LottoList(1000);
                Result result = new Result(lottoList,userNumbers);
                assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
                assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(0);
                assertThat(result.getSumPrice()).isEqualTo(2000000000);
            },
            List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("5등 3번 4등 1번 테스트")
    @Test
    void test() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                LottoList lottoList = new LottoList(4000);
                Result result = new Result(lottoList,userNumbers);
                assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(3);
                assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(1);
                assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(0);
                assertThat(result.getSumPrice()).isEqualTo(65000);
            },
            List.of(1, 7, 3, 4, 8, 9),
            List.of(1, 2, 3, 12, 11, 10),
            List.of(1, 2, 3, 16, 20, 12),
            List.of(1, 20, 30, 4, 5, 6)
        );
    }

    @DisplayName("2등 테스트")
    @Test
    void secondtest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                LottoList lottoList = new LottoList(1000);
                Result result = new Result(lottoList,userNumbers);
                assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
                assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(0);
                assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(0);
                assertThat(result.getSumPrice()).isEqualTo(30000000);
            },
            List.of(1, 7, 3, 4, 2, 5)

        );
    }
}