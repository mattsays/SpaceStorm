package it.mattsay.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by MattSay on 29/01/2017.
 */
public interface Character {
    public void draw();
    public void update(float delta);
    public int getWidth();
    public int getHeight();
    public int getX();
    public int getY();
    public Rectangle getRectangle();
    public Texture getSprite();
    public void setX(int x);
    public void setY(int y);
    public void setRectangle(Rectangle rect);
    public void setSprite(Texture sprite);
}
