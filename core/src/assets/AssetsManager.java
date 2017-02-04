package assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

/**
 * Created by MattSay on 04/02/2017.
 */
public class AssetsManager {

    public static ArrayList<Texture> assets;

    public enum Assets {
        PLAYER(0, "PLAYER.png"),
        ENEMY(1 , "ENEMY.png"),
        BULLET(2 , "LASER.png"),
        PLAY_BTN(3 , "PLAY_BTN.png"),
        EXIT_BTN(4 , "EXIT_BTN.png"),
        BACKGROUND(5 , "BACKGROUND.png");
        private int number;
        private String name;
        Assets(int number, String name){
        this.number = number;
        this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
    }
    public static void addAssets(Assets a){

        assets.add(a.getNumber() ,new Texture(Gdx.files.internal(a.getName())));
    }
    public static void registerAssets(){
      assets = new ArrayList<Texture>();
      addAssets(Assets.PLAYER);
      addAssets(Assets.ENEMY);
      addAssets(Assets.BULLET);
      addAssets(Assets.PLAY_BTN);
    }
    public static Texture getTexture(Assets a){
        return assets.get(a.getNumber());
    }
}
