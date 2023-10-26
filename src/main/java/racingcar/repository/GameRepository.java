package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Game;

public class GameRepository {
    private Long id = 0L;
    private final Map<Long, Game> games = new HashMap<>();

    public Long Save(Game game) {
        Long returnId = id;
        games.put(id, game);
        id += 1;
        return returnId;
    }


}
