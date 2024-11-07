package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	private GameManager gameManager;
	GameInputProcessor gameInputProcessor;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameManager = new GameManager();
		gameInputProcessor = new GameInputProcessor(gameManager);
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(gameInputProcessor);
		Gdx.input.setInputProcessor(inputMultiplexer);
	}

	@Override
	public void render() {
		gameManager.update(Gdx.graphics.getDeltaTime());
		gameManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameManager.dispose();
	}
}
