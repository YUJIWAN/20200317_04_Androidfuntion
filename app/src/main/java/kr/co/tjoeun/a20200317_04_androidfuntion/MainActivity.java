package kr.co.tjoeun.a20200317_04_androidfuntion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import kr.co.tjoeun.a20200317_04_androidfuntion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                다른 화면으로 이동 : Intent
//                => 우리가 만든게 아니라, 안드로이드가 제공하는 화면으로 이동.
//                => 전화 걸기 화면

//                어느 화면으로 갈지 => 안드로이드가 요구하는 양식으로 작성 : Uri

//                응용문제 : EditText에 입력한 폰번으로 전화 걸도록.
//                1) 전화번호가 뭐라고 입력되어있는지 받아오자
//                2)받아온 전화번호로 호출
//                =>Uri.parse()에 들어갈 값을 가공
//                =>tel:전화번호

                String phoneEdt = binding.phoneEdt.getText().toString();
                String phoneUristr = String.format("tel: %s",phoneEdt);
                Uri uri = Uri.parse(phoneUristr);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                현재까지 배운것만으론 실행 불가 : 권한 획득 X.

                Uri uri = Uri.parse("tel : 01026763307");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);

            }
        });



    }
}
