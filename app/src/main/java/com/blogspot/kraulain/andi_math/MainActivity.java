package com.blogspot.kraulain.andi_math;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mNum1, mNum2;
    Button mSubmit;
    EditText mAnswer;
    Random random;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        mNum1 = (TextView) findViewById(R.id.num1);
        mNum2 = (TextView) findViewById(R.id.num2);
        mSubmit = (Button) findViewById(R.id.submit);
        mAnswer = (EditText) findViewById(R.id.answer);
        initialise();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int answer = Integer.parseInt(mAnswer.getText().toString());
                    boolean isCorrect = compare(answer);
                    if(isCorrect){
                        initialise();
                    }
                }catch (Exception ex){
                    makeToast("Invalid Input");
                }
            }
        });
    }

    private void initialise(){
        num1 = random.nextInt()%20;
        num2 = random.nextInt()%20;
        mNum1.setText(num1+"");
        mNum2.setText(num2+"");
        mAnswer.setText("");
    }

    private int doAddition(){
        return num1+num2;
    }

    private boolean compare(int answer){
        int sum = doAddition();
        if(answer==sum){
            makeToast("Very Good");
            return true;
        }else{
            makeToast("Try Again");
            return false;
        }
    }

    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
