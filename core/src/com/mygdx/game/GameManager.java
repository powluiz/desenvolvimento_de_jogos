package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.arrow.Arrow;
import com.mygdx.game.arrow.ArrowPool;
import com.mygdx.game.balloon.Balloon;
import com.mygdx.game.balloon.BalloonPool;
import com.mygdx.game.player.Player;
import org.w3c.dom.css.Rect;

import java.util.Iterator;

public class GameManager {
    public final Player player;
	private final Array<Arrow> activeArrows;
	private final Array<Balloon> activeBalloons;
	private final ArrowPool arrowPool;
	private final BalloonPool balloonPool;

    public GameManager() {
        player = new Player();
        activeArrows = new Array<Arrow>();
        activeBalloons = new Array<Balloon>();
        arrowPool = new ArrowPool();
        balloonPool = new BalloonPool();
        this.createArrow(); // flecha inicial
    }

    // atualiza a logica do jogo
    public void update(float deltaTime) {
        player.update(deltaTime);
        for (Arrow arrow : activeArrows) {
            arrow.update(deltaTime, player.position);
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
        checkCollisions();
    }

    // renderiza frames do jogo
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0, 0, 1, 1);
		batch.begin();
        player.render(batch);

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
        arrow.init(player.position);
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
        if (MathUtils.randomBoolean(0.05f)) {
            Balloon balloon = balloonPool.obtain();
            float startLimit = (float)Gdx.graphics.getWidth()/3;
            float endLimit = (float)(Gdx.graphics.getWidth() - 25);
            float balloonXPosition = MathUtils.random(startLimit, endLimit);
            Vector2 initialPosition = new Vector2(balloonXPosition, 0);
            balloon.init(initialPosition);
            activeBalloons.add(balloon);
        }
    }

    public boolean isCollision(Rectangle firstInstance, Rectangle secondInstance) {
        return firstInstance.overlaps(secondInstance);
    }

    public void checkCollisions() {
        for (Arrow arrow : activeArrows) {
            for (Balloon balloon : activeBalloons) {
                if (isCollision(arrow.collisionBox, balloon.collisionBox)) {
                    balloonPool.free(balloon);
                    activeBalloons.removeValue(balloon, true);
                    arrowPool.free(arrow);
                    activeArrows.removeValue(arrow, true);
                }
            }
        }
    }

//    public void checkCollisions() {
//        Iterator<Arrow> arrowIterator = activeArrows.iterator();
//        while (arrowIterator.hasNext()) {
//            Arrow arrow = arrowIterator.next();
//
//            Iterator<Balloon> balloonIterator = activeBalloons.iterator();
//            while (balloonIterator.hasNext()) {
//                Balloon balloon = balloonIterator.next();
//                if (isCollision(arrow.collisionBox, balloon.collisionBox)) {
//                    arrowIterator.remove();
//                    balloonIterator.remove();
//                    break;
//                }
//            }
//        }
//    }

    public void dispose() {
        // Limpeza de recursos
    }
}
