package game.introduction.project.android.startanimation;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by appu2 on 2018/02/24.
 */

public class StartActivity extends AppCompatActivity {
//    女の子が歩くアニメ
    private ImageView default_walk_image;
    private AnimationDrawable animationWalkGirl;
//    太陽が回るアニメ
    private RotateAnimation routeSunAnimation;
    private ImageView sumImageView;
//    くも
    private ImageView kumoView1;
    private ImageView kumoView2;
    private ImageView kumoView3;
    private ImageView kumoView4;
    private ImageView kumoView5;
    private TranslateAnimation kumoTransAnimation;
    private ImageView[] ImageList;
//    音楽
    private MediaPlayer flowerPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
//        女の子が歩くアニメーション呼び出し
        default_girl_walk();
//        太陽アニメーション呼び出し
         sunrotate();
//         雲動くアニメーション
         kumo_move_animation();
    }
//    音楽
    private void flowerPlayer_sound(){
        flowerPlayer = MediaPlayer.create(this,R.drawable.flower);
        flowerPlayer.setLooping(true);
        flowerPlayer.start();
    }

//    アニメーション
//    女の子が歩くアニメーション
    private void default_girl_walk(){
        default_walk_image = findViewById(R.id.girl_walk_image);
        default_walk_image.setBackgroundResource(R.drawable.girl_walk_animation);
        animationWalkGirl = (AnimationDrawable)default_walk_image.getBackground();
        animationWalkGirl.start();
    }
//    太陽傾くアニメーション
    private void sunrotate(){
        sumImageView = findViewById(R.id.sun_Image);
        routeSunAnimation = new RotateAnimation(-40,40,sumImageView.getWidth()/2,sumImageView.getHeight()/2);
        routeSunAnimation.setDuration(1000);
        routeSunAnimation.setRepeatMode(Animation.REVERSE);
        routeSunAnimation.setRepeatCount(Animation.INFINITE);
        sumImageView.startAnimation(routeSunAnimation);

    }
//    雲が動くアニメーション
    private void kumo_move_animation(){
        kumoTransAnimation = new TranslateAnimation(0,100,0,100);
        kumoTransAnimation.setRepeatMode(Animation.REVERSE);
        kumoTransAnimation.setRepeatCount(Animation.INFINITE);
        kumoTransAnimation.setDuration(3000);


        kumoView1 = findViewById(R.id.kumoview1);
        kumoView2 = findViewById(R.id.kumoview2);
        kumoView3 = findViewById(R.id.kumoview3);
        kumoView4 = findViewById(R.id.kumoview4);
        kumoView5 = findViewById(R.id.kumoview5);
        ImageList = new ImageView[]{kumoView1,kumoView2,kumoView3,kumoView4,kumoView5};
        for(ImageView animeImage: ImageList){
            animeImage.startAnimation(kumoTransAnimation);
        }

    }
}
