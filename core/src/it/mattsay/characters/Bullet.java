package it.mattsay.characters;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by MattSay on 29/01/2017.
 */
public class Bullet
{
    public Vector2 position;
    public float velocity;

    public Bullet()
    {
        position = new Vector2();
        velocity = 5f; //or whatever
    }

    public void update()
    {
        position.y += velocity;
    }
}
