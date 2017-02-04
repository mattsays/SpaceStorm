package it.mattsay.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import it.mattsay.game.SpaceStorm;
import it.mattsay.screens.PlayScreen;
import it.mattsay.states.GameStateManager;

/**
 * Created by MattSay on 04/02/2017.
 */
public class PlayButton implements Button {

    SpaceStorm game;
    Texture sprite;
    OrthographicCamera camera;
    Rectangle r;

    public PlayButton(int width , int height, Texture sp , SpaceStorm game , OrthographicCamera cam){
        r = new Rectangle(800 / 2 - width/4 + 55, 460 / 2 - height/4 , width/4 , height/4);
        sprite = sp;
        camera = cam;
        this.game = game;
    }

    @Override
    public void update(float delta) {

        if(Gdx.input.justTouched())
        {
            Vector3 touch = new Vector3(Gdx.input.getX() , Gdx.input.getY() , 0);
            camera.unproject(touch);
            if(r.contains(touch.x,touch.y))
            {
                GameStateManager.setState(GameStateManager.GameStates.IN_GAME);
                game.setScreen(new PlayScreen(game));
            }
        }
    }

    @Override
    public void draw() {
     game.batch.begin();
     game.batch.draw(sprite , r.x , r.y , r.width , r.height);
     game.batch.end();
    }

    @Override
    public int getWidth() {
        return (int)r.width;
    }

    @Override
    public int getHeight() {
        return (int)r.height;
    }

    @Override
    public int getX() {
        return (int)r.x;
    }

    @Override
    public int getY() {
        return (int)r.y;
    }

    @Override
    public Rectangle getRectangle() {
        return r;
    }

    @Override
    public Texture getSprite() {
        return sprite;
    }

    @Override
    public void setX(int x) {
    r.x = x;
    }

    @Override
    public void setY(int y) {
    r.y = y;
    }

    @Override
    public void setRectangle(Rectangle rect) {
    r = rect;
    }

    @Override
    public void setSprite(Texture sprite) {
    this.sprite = sprite;
    }
}
