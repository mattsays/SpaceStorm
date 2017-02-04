package it.mattsay.characters;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.sun.org.apache.regexp.internal.RE;
import it.mattsay.game.SpaceStorm;
import it.mattsay.projectile.Bullet;
import it.mattsay.screens.MenuScreen;
import it.mattsay.states.GameStateManager;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MattSay on 29/01/2017.
 */
public class Enemy implements Character{
    int width = 0;
    int height = 0;
    SpaceStorm game = null;
    Texture sprite = null;
    Rectangle rectangle = null;
    static ArrayList<Rectangle> enemies;
    float lastEnemyDrop;

    public Enemy(int width, int height, SpaceStorm game, Texture sp){
        this.width = width;
        this.height = height;
        this.game = game;
        this.sprite = sp;
        this.rectangle = new Rectangle();
        rectangle.width = width;
        rectangle.height = height;
        enemies = new ArrayList<Rectangle>();
    }

    private void spawnEnemies() {
        Rectangle rectangle = new Rectangle();
        rectangle.x = MathUtils.random(0, 800 - 64);
        rectangle.y = 480;
        rectangle.width = 64;
        rectangle.height = 64;
        enemies.add(rectangle);
        lastEnemyDrop = TimeUtils.nanoTime();
        draw();
    }

    public void draw() {
         for(Rectangle rectangle : enemies) {
             game.batch.begin();
             game.batch.draw(sprite, rectangle.x, rectangle.y);
             game.batch.end();
         }
     }

    @Override
    public void update(float delta) {
            if(TimeUtils.nanoTime() - lastEnemyDrop > 1000000000){
                spawnEnemies();
            }
      draw();
             for(Iterator<Rectangle> itr = enemies.iterator(); itr.hasNext();){
             Rectangle r = itr.next();
                r.y -= 100 * delta;
                if(r.y <= 0){
                    itr.remove();
                }
                if(r.overlaps(Player.getRectangles())){
                    itr.remove();
                    --Player.lives;
                    if(Player.lives == 0){
                        Player.getRectangles().set(0, 0, 0 , 0);
                        game.setScreen(new MenuScreen(game));
                        GameStateManager.setState(GameStateManager.GameStates.IN_MENU);
                    }
                }
                 for(Iterator<Bullet> iter = Player.bullets.iterator(); iter.hasNext();){
                    Bullet bullet = iter.next();
                    Rectangle rectangle = new Rectangle(bullet.position.x , bullet.position.y , 3 ,7);
                    if(r.overlaps(rectangle)){
                    iter.remove();
                    itr.remove();
                    }
                 }
            }
     }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    @Override
    public Texture getSprite() {
        return sprite;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void setRectangle(Rectangle rect) {

    }

    @Override
    public void setSprite(Texture sprite) {
    this.sprite = sprite;
    }
}
