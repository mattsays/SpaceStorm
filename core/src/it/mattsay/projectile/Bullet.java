package it.mattsay.projectile;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by MattSay on 29/01/2017.
 */
public class Bullet
{
    public Vector2 position;
    public float velocity;
    Rectangle r;

    public Bullet(Vector2 vector2)
    {
        position =vector2;
        velocity = 5f; //or whatever
        r = new Rectangle();
        r.set(position.x , position.y , 3 ,7);
    }
    public Rectangle getBullet(){
        return r;
    }
    public void update()
    {
        position.y += velocity;
    }
}
