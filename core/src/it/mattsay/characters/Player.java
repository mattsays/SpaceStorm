package it.mattsay.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import it.mattsay.game.SpaceStorm;

import java.util.ArrayList;

/**
 * Created by MattSay on 29/01/2017.
 */
public class Player implements Character{

    int width = 0;
    int height = 0;
    long lastShootTime;
    SpaceStorm game;
    Texture sprite;
    Rectangle rectangle;
    Rectangle laser;
    OrthographicCamera camera;


    public Player(int x , int y , int width, int height, SpaceStorm game, Texture sp , OrthographicCamera camera){
        this.width = width;
       this.height = height;
       this.game = game;
       this.sprite = sp;
       this.rectangle = new Rectangle();
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;
        this.camera = camera;
    }


    @Override
    public void draw() {
        game.batch.draw(sprite, rectangle.x , rectangle.y , rectangle.width , rectangle.height);
    }

    @Override
    public void update(float delta) {

      //Handle Input
      if(Gdx.input.isTouched()){
          Vector3 touch = new Vector3();
          touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
          camera.unproject(touch);
          rectangle.x = touch.x - 30 / 2;
      }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            rectangle.x -= 300 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            rectangle.x += 300 * delta;

        //Make the Borders
        if (rectangle.x < 0)
            rectangle.x = 0;
        if (rectangle.x > 800 - 30)
            rectangle.x = 800 - 30;

    }




    @Override
    public int getWidth() {
        return (int)rectangle.width;
    }

    @Override
    public int getHeight() {
     return (int)rectangle.height;
    }
    @Override
    public int getX() {
        return (int)rectangle.x;
    }
    @Override
    public int getY() {
        return (int)rectangle.y;
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public Texture getSprite() {
     return sprite;
    }

    @Override
    public void setX(int x) {
     rectangle.setX((int)x);
    }

    @Override
    public void setY(int y) {
     rectangle.setY((int)y);
    }

    @Override
    public void setRectangle(Rectangle rect) {
    this.rectangle = rect;
    }


    @Override
    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }
}
