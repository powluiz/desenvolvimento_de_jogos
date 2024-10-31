package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;


public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	MyInputProcessor inputProcessor;
	private final Array<Arrow> activeArrows = new Array<Arrow>();
	private final ArrowPool arrowPool = new ArrowPool();

	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(new MyInputProcessor(arrowPool, activeArrows));
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 1, 1);
		float deltaTime = Gdx.graphics.getDeltaTime();
		batch.begin();

		for (Arrow arrow : activeArrows) {
			arrow.update(deltaTime, batch);
		}
		batch.end();


		// Libera as balas que não mais ativas
		for (Arrow arrow : activeArrows) {

			if (!arrow.isAlive) {

				arrowPool.free(arrow);
				activeArrows.removeValue(arrow, true);
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
