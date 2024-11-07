package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.arrow.Arrow;
import com.mygdx.game.arrow.ArrowPool;
import com.mygdx.game.balloon.Balloon;
import com.mygdx.game.balloon.BalloonPool;

public class GameManager {
	private final Array<Arrow> activeArrows;
	private final Array<Balloon> activeBalloons;
	private final ArrowPool arrowPool;
	private final BalloonPool balloonPool;
//     private final Player player;

    public GameManager() {
        activeArrows = new Array<Arrow>();
        activeBalloons = new Array<Balloon>();
        arrowPool = new ArrowPool();
        balloonPool = new BalloonPool();
        // player = new Player();

        this.createArrow(); // flecha inicial
    }

    // atualiza a logica do jogo
    public void update(float deltaTime) {
        for (Arrow arrow : activeArrows) {
//            arrow.update(deltaTime, player.position);
            arrow.update(deltaTime, new Vector2(10, 10));
			if (!arrow.isAlive) {
				arrowPool.free(arrow);
				activeArrows.removeValue(arrow, true);
			}
        }

        for (Balloon balloon : activeBalloons) {
            balloon.update(deltaTime);
            if (!balloon.isAlive) {
                balloonPool.free(balloon);
                activeBalloons.removeValue(balloon, true);
            }
        }
        spawnBalloonRandomly(deltaTime);
    }

    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0, 0, 1, 1);
		batch.begin();

        for (Arrow arrow : activeArrows) {
            arrow.render(batch);
        }

        for (Balloon balloon : activeBalloons) {
            balloon.render(batch);
        }
		batch.end();
    }

    public void createArrow() {
        Arrow arrow = arrowPool.obtain();
//        arrow.init(deltaTime, player.position);
        arrow.init(new Vector2(10, 10));
        activeArrows.add(arrow);
    }

    public void shootArrow() {
        this.createArrow();
        boolean isFirstArrow = true;
        for (Arrow arrow : activeArrows) {
            if (!isFirstArrow) {
                arrow.fire();
            }
            isFirstArrow = false;
        }
    }

    private void spawnBalloonRandomly(float deltaTime) {
        if (MathUtils.randomBoolean(0.01f)) {
            Balloon balloon = balloonPool.obtain();
            Vector2 initialPosition = new Vector2(MathUtils.random(Gdx.graphics.getWidth()/2, Gdx.graphics.getWidth()), 0);
            balloon.init(initialPosition);
            activeBalloons.add(balloon);
        }
    }

    public void dispose() {
        // Limpeza de recursos
    }
}
