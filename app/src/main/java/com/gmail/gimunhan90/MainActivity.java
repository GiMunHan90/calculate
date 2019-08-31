package com.gmail.gimunhan90;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnMinority;
    private Button multiple, divide, minus, plus, btnCe, btnResult, btnNext;
    private TextView resultView;

    private String resultStatus = "init";
    private boolean isCalculStatus = false;
    private StringBuffer resultNum = new StringBuffer();
    private String resultTemp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test1", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test2", "pause");

    }

    public void init() {
        resultView = findViewById(R.id.result);
        resultNum.append("0");
        resultView.setText(resultNum);

        btnZero = findViewById(R.id.btnZero);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnZero.getText().toString());
            }
        });

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnOne.getText().toString());
            }
        });

        btnTwo = findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnTwo.getText().toString());
            }
        });

        btnThree = findViewById(R.id.btnThree);
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnThree.getText().toString());
            }
        });

        btnFour = findViewById(R.id.btnFour);
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnFour.getText().toString());
            }
        });

        btnFive = findViewById(R.id.btnFive);
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnFive.getText().toString());
            }
        });

        btnSix = findViewById(R.id.btnSix);
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnSix.getText().toString());
            }
        });

        btnSeven = findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnSeven.getText().toString());
            }
        });

        btnEight = findViewById(R.id.btnEight);
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnEight.getText().toString());
            }
        });

        btnNine = findViewById(R.id.btnNine);
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnNine.getText().toString());
            }
        });

        btnMinority = findViewById(R.id.btnMinority);
        btnMinority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNum(btnMinority.getText().toString());
            }
        });

        //사칙연산
        multiple = findViewById(R.id.multiple);
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(multiple.getText().toString());
            }
        });

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(divide.getText().toString());
            }
        });

        minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(minus.getText().toString());
            }
        });

        plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(plus.getText().toString());
            }
        });

        //취소
        btnCe = findViewById(R.id.btnCencel);
        btnCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetCalculate();
            }
        });

        //결과
        btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentActivity.class);
                intent.putExtra("name", "kimun");
                startActivity(intent);
                finish();
            }
        });

        //btnResult.setOnClickListener(listener);

    }

//    View.OnClickListener listener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//            int id = view.getId();
//
//            switch (id){
//                case R.id.btnCencel:
//                    break;
//            }
//
//        }
//    };

    public void inputNum(String val){

        if(resultNum.toString().equals("0") && val.equals("0")){
            return;
        }

        if(resultNum.toString().equals("0") && !val.equals(".")){
            resultNum.setLength(0);
        }

        resultNum.append(val);
        resultView.setText(resultNum);
    }

    public void calculate(String val) {
        Log.d("calculate","========================================= calculate =========================================");
        Log.d("calculate",val);
        if(!changeStatus(val)){
            return;
        }

        Log.d("calculate",resultTemp);
        Log.d("calculate",resultNum.toString());
        String temp = "";
        switch(resultStatus){
            case "X" :
                temp = (Double.parseDouble(resultTemp) * Double.parseDouble(resultNum.toString())) + "";
                Log.d(" X ",temp);
                break;
            case "/" :
                temp = (Double.parseDouble(resultTemp) / Double.parseDouble(resultNum.toString())) + "";
                Log.d(" + ",temp);
                break;
            case "-" :
                temp = (Double.parseDouble(resultTemp) - Double.parseDouble(resultNum.toString())) + "";
                Log.d(" - ",temp);
                break;
            case "+" :
                temp = (Double.parseDouble(resultTemp) + Double.parseDouble(resultNum.toString())) + "";
                Log.d(" + ",temp);
                break;
        }

        resultStatus = val;
        resultTemp = temp;
        Log.d("calculate",resultTemp);
        Log.d("calculate",resultNum.toString());
        resultNum.setLength(0);
        resultView.setText(temp);
    }

    public void getResult(){
        resultStatus = "init";
        resultTemp = "";
        resultNum.setLength(0);
        resultNum.append(0);

        resultView.setText(resultNum);
    }

    public boolean changeStatus(String val){
        boolean res = true;
        if(resultStatus.equals("init")){
            resultTemp = resultNum.toString();
            resultNum.setLength(0);
            resultStatus = val;

            res = false;
        }

        return res;
    }

    public void resetCalculate(){
        resultStatus = "init";
        resultTemp = "";
        resultNum.setLength(0);
        resultNum.append(0);

        resultView.setText(resultNum);
    }

}
