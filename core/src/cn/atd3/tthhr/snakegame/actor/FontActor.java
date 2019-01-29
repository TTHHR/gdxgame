package cn.atd3.tthhr.snakegame.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontActor {
    private static FontActor ins=null;
    private FreeTypeFontGenerator generator;
    private BitmapFont font;
    public static FontActor getFontActor()
    {
        if(ins==null)
            ins=new FontActor();
        return ins;
    }
    private FontActor(){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/chinattf.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.characters=FreeTypeFontGenerator.DEFAULT_CHARS;
        parameter.color=Color.BLACK;
        font = generator.generateFont(parameter); // font size 12 pixels
    }
    public BitmapFont getFont()
    {
        return font;
    }
    public void dispose()
    {
        font.dispose();
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }
}
