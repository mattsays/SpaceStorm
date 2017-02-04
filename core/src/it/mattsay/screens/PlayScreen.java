package it.mattsay.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import it.mattsay.characters.Enemy;
import it.mattsay.characters.Player;
import it.mattsay.game.SpaceStorm;
/**
 * Created by MattSay on 28/01/2017.
 */
public class PlayScreen implements Screen{

    SpaceStorm game;
    Player player;
    Enemy enemy;
    OrthographicCamera camera;

    public PlayScreen(SpaceStorm spaceStorm)
    {
        game = spaceStorm;
        camera = new OrthographicCamera();
        camera.setToOrtho(false , 800 ,480);
        player = new Player(800 / 2 - 64 / 2,20,30,48,game,new Texture(Gdx.files.internal("SPACESHIP.png")),camera);
        enemy = new Enemy(32 , 32 , game ,new Texture(Gdx.files.internal("ENEMY.png")));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        //Draw the Player
        player.draw();
        //Update the Player
        player.update(delta);
        //Update the Enemies
        enemy.update(delta);
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
