package com.mygdx.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Array;

public class MyInputProcessor extends InputAdapter {
    Array<Arrow> activeArrows;
    ArrowPool arrowPool;

    public void createArrow() {
        Arrow arrow = arrowPool.obtain();
        activeArrows.add(arrow);
        arrow.init(10,10); // deve inicializar com a posição do jogador
    }

    public void fireArrow () {
        if (activeArrows.size > 0) {
            for (Arrow arrow : activeArrows) {
                // pega a próxima flecha engatilhada
                if (!arrow.isMoving) {
                    arrow.fire();
                }
            }
        }
        this.createArrow();
    }

    public MyInputProcessor(ArrowPool arrowPool, Array<Arrow> activeArrows) {
        this.activeArrows = activeArrows;
        this.arrowPool = arrowPool;
        this.createArrow(); // flecha inicial
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        this.fireArrow();
        return false;
    }

    @Override
    public boolean keyDown(int i) {
        // movimentacao vertical do personagem
        return false;
    }
}
