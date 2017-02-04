package it.mattsay.characters;

import assets.AssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import it.mattsay.game.SpaceStorm;
import it.mattsay.projectile.Bullet;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MattSay on 29/01/2017.
 */
public class Player implements Character{

    int width = 0;
    static int lives = 3;
    int height = 0;
    long lastShootTime;
    SpaceStorm game;
    Texture sprite;
    static Rectangle rectangle;
    Rectangle laser = new Rectangle();
    OrthographicCamera camera;
    Sound ShootSound;
    static ArrayList<Bullet> bullets;

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
        bullets = new ArrayList<Bullet>();
        ShootSound = Gdx.audio.newSound(Gdx.files.internal("SHOOT.wav"));
    }


    @Override
    public void draw() {
        game.batch.begin();
        game.batch.draw(sprite, rectangle.x , rectangle.y , rectangle.width , rectangle.height);
        game.batch.end();
    }

    @Override
    public void update(float delta) {

        boolean gyroscopeAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);
      //Handle Input
          Vector3 touch = new Vector3();
          touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
          camera.unproject(touch);
          rectangle.x = touch.x - 30 / 2;
          if(gyroscopeAvail){
              Vector3 gyro = new Vector3();
              gyro.set(Gdx.input.getGyroscopeX() , 0 , 0);
              camera.unproject(gyro);
              rectangle.x = gyro.x - 30 / 2;
          }
      //Bullets Shooting


          if(TimeUtils.nanoTime() - lastShootTime > 1000000000){
              Vector2 vector2 = new Vector2(rectangle.x + 14 , rectangle.y + 47);
              Bullet bullet = new Bullet(vector2);
              bullets.add(bullet);
              ShootSound.play(0.05f);
              lastShootTime = TimeUtils.nanoTime();
          }
              for(Iterator<Bullet> itr = bullets.iterator(); itr.hasNext();)
              {
                  Bullet b = itr.next();
                  game.batch.begin();
                  game.batch.draw(AssetsManager.getTexture(AssetsManager.Assets.BULLET), b.position.x, b.position.y);
                  game.batch.end();
                  b.update();

                  if(b.position.y > Gdx.graphics.getHeight())
                  {
                      itr.remove();
                  }
              }


        //Make the Borders
        if (rectangle.x < 0)
            rectangle.x = 0;
        if (rectangle.x > 800 - 30)
            rectangle.x = 800 - 30;

    }

    public void CreateLaser(float delta){
        laser = new Rectangle();
        laser.y = rectangle.y;
        laser.x = rectangle.x;
        laser.width = 3;
        laser.height = 7;
        Texture lasers = new Texture(Gdx.files.internal("LASER.png"));
        game.batch.begin();
        game.batch.draw(lasers , laser.x , laser.y , laser.width , laser.height);
        game.batch.end();

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

    public static Rectangle getRectangles() {
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
