package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int xPos = 0, yPos = 0;
	int xTarget, yTarget = 0;
	int step = 3;
	MyInputProcessor inputProcessor = new MyInputProcessor();
	MyTextInputListener textInputListener = new MyTextInputListener();

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Gdx.input.setInputProcessor(inputProcessor);
		Gdx.input.getTextInput(textInputListener, "Título", "Valor inicial do textfield", "Dica de preenchimento" );
	}

	@Override
	public void render() {
		// Altera a posição, quando houver interação
		if (Gdx.input.isTouched()) {
			xTarget = Gdx.input.getX() - img.getWidth() / 2;
			yTarget = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight() / 2;
		}

		// distância horizontal e vertical entre a textura e a posição do clique
		int xDif = xTarget - xPos;
		int yDif = yTarget - yPos;

		// move horizontalmente
		if (Math.abs(xDif) > step) {
			xPos += (xDif > 0) ? step : -step;
		} else {
			xPos = xTarget;
		}

		// move verticalmente
		if (Math.abs(yDif) > step) {
			yPos += (yDif > 0) ? step : -step;
		} else {
			yPos = yTarget;
		}

		ScreenUtils.clear(0, 0, 1, 1);
		batch.begin();
		batch.draw(img, xPos, yPos);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
