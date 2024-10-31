package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	MyInputProcessor inputProcessor = new MyInputProcessor();
	Arrow arrow = new Arrow();
//	private final ArrayList<Arrow> activeArrows = new ArrayList<Arrow>();

//	private final Pool<Arrow> arrowPool = new Pool<Arrow>() {
//		@Override
//		protected Arrow newObject() {
//			return new Arrow();
//		}
//	};

//	public void update(float delta) {
//		// Nova Bala
//		Arrow item = arrowPool.obtain();
//		item.init(2, 2);
//		activeArrows.add(item);
//
//		// Retorna balas usadas ao pool
//		Arrow arrowItem;
//		final int listSize = activeArrows.size();
//		for (int i = listSize; --i >= 0;) {
//			arrowItem = activeArrows.get(i);
//			if (!arrowItem.isAlive) {
//				activeArrows.remove(i);
//				arrowPool.free(arrowItem);
//			}
//		}
//	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(inputProcessor);
		arrow.init(10,10);
	}

	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 0, 1, 1);
		batch.begin();
		arrow.update(deltaTime, batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
