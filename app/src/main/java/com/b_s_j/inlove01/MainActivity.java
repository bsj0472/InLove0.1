package com.b_s_j.inlove01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {


    TextView tvNickname;
    TextView tvEmail;
    CircleImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //키해시값 얻어와서 Logcat 창에 출력하기 카카오 개발자 사이트에서 기해시값 등록해야 해서
        String keyHash = Utility.INSTANCE.getKeyHash(this);
        Log.i("KeyHash",keyHash);
        iv = findViewById(R.id.iv);


        TextView signup=findViewById(R.id.login_sign);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

    }



    public void clickLogin(View view) {
        Intent intent =new Intent(this,BNV.class);
        startActivity(intent);
        finish();
    }

    public void clickLogingoogle(View view) {
        Intent intent =new Intent(this,BNV.class);
        startActivity(intent);
    }

   public void clickloginkakao(View view){
        //카카오 계정으로 로그인 하기
       LoginClient.getInstance().loginWithKakaoAccount(this, new Function2<OAuthToken, Throwable, Unit>() {
           @Override
           public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
               if (oAuthToken != null) { //로그인 정보객체있으면
                   Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();

                   //로그인한 계저 ㅇ정보 얻어오기
                   UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                       @Override
                       public Unit invoke(User user, Throwable throwable) {
                           if (user != null) {
                               long id = user.getId(); //카카오 회원번호

                               //필수동의 항목의 회원프로필 정보  [닉네임/프로필이미지 Url]
                             String nickname = user.getKakaoAccount().getProfile().getNickname();
                               String profileImageUrl = user.getKakaoAccount().getProfile().getThumbnailImageUrl();

                               //선택동의 항목으로 지정한 Email
                               String email = user.getKakaoAccount().getEmail();
                              tvNickname.setText(nickname);
                               tvEmail.setText(email);
                               Glide.with(MainActivity.this).load(profileImageUrl).into(iv);

                               //다음에 접속할때 로그인 다시 하지 않을려면 SharedPreference 에 로그인 정보를 저장해두고 불러오도록 코드를 추가...

                           } else {
                               Toast.makeText(MainActivity.this, "Error. : " + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                           }
                           return null;
                       }
                   });
               }else {
                   Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();

               }
               return null;

           }
       });

   }
}