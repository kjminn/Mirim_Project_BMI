package kr.hs.emirim.kjminn.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textComment;
    ImageView imgv;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textComment = findViewById(R.id.text_result_comment);
        imgv = findViewById(R.id.imgv);
        ImageView imgHome = findViewById(R.id.img_home);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double weight = Double.parseDouble(intent.getStringExtra("weight"));
        double height = Double.parseDouble(intent.getStringExtra("height"));
        bmi = weight / Math.pow(height/100, 2);
        String bmiResult = "";
        if(bmi < 18.5){
            bmiResult = "저";
            imgv.setImageResource(R.drawable.bmi_01);
        }else if(bmi < 24.9){
            bmiResult = "정상";
            imgv.setImageResource(R.drawable.bmi_02);
        }else if(bmi < 29.9){
            bmiResult = "과";
            imgv.setImageResource(R.drawable.bmi_03);
        }else if(bmi < 34.9){
            bmiResult = "비만";
            imgv.setImageResource(R.drawable.bmi_04);
        }else{
            bmiResult = "고도비만";
            imgv.setImageResource(R.drawable.bmi_05);
        }
        textComment.setText(name + "님의 BMI지수는 "
                + String.format("%.2f", bmi) +"(㎏/㎡)입니다. 따라서 "
                + bmiResult +"체중입니다.");
    }
}