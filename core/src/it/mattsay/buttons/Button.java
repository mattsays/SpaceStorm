package it.mattsay.buttons;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import it.mattsay.game.SpaceStorm;

/**
 * Created by MattSay on 04/02/2017.
 */
public interface Button {
    public void update(float delta);
    public void draw();
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
