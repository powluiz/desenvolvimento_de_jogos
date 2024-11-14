package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
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

    public static final AssetDescriptor<Sound> balloonPopSfx =
            new AssetDescriptor<Sound>("balloon_pop.mp3", Sound.class);

    public static final AssetDescriptor<Sound> arrowFireSfx =
            new AssetDescriptor<Sound>("arrow_fire.mp3", Sound.class);



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
        self.load(balloonPopSfx);
        self.load(arrowFireSfx);
    }

    public void dispose(){
        self.dispose();
    }
}
