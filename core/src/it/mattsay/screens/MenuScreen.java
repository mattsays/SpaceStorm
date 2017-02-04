package it.mattsay.screens;

import assets.AssetsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import it.mattsay.buttons.PlayButton;
import it.mattsay.game.SpaceStorm;

/**
 * Created by MattSay on 04/02/2017.
 */
public class MenuScreen implements Screen{

    SpaceStorm game;

    PlayButton play_btn;
    Texture exit_btn;
    OrthographicCamera cam;

    public MenuScreen(SpaceStorm spaceStorm){
        game = spaceStorm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false , 800 ,480);
        play_btn = new PlayButton(512 ,512 , AssetsManager.getTexture(AssetsManager.Assets.PLAY_BTN), game , cam);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        game.batch.setProjectionMatrix(cam.combined);
      //Draw Play_btn
      play_btn.draw();
      //Update Play_btn
      play_btn.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
