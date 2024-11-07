package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class GameAssetManager extends AssetManager{
    // Classe no padrão singleton
    private static GameAssetManager self;

    public static final AssetDescriptor<Texture> playerTexture =
            new AssetDescriptor<Texture>("character.png", Texture.class);

    public static final AssetDescriptor<Texture> arrowTexture =
            new AssetDescriptor<Texture>("arrow.png", Texture.class);

    public static final AssetDescriptor<Texture> balloonTexture =
            new AssetDescriptor<Texture>("balloon.png", Texture.class);

    // privado para evitar instanciacao externa
    private GameAssetManager() {
    }

    public static GameAssetManager getInstance() {
        if (self == null) {
            self = new GameAssetManager();
        }
        return self;
    }

    public void load(){
        self.load(playerTexture);
        self.load(arrowTexture);
        self.load(balloonTexture);
    }

    public void dispose(){
        self.dispose();
    }
}
