package cn.atd3.tthhr.snakegame.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class FPSActor extends Actor {
    BitmapFont fps;
    String fpss="0";
    public FPSActor()
    {
        fps=FontActor.getFontActor().getFont();
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        fps.draw(batch,fpss,getX(),getY());
    }

    @Override
    public void act(float delta) {
        fpss= ""+Gdx.graphics.getFramesPerSecond();
        super.act(delta);
    }
    public void dispose()
    {
        fps.dispose();
    }
}
