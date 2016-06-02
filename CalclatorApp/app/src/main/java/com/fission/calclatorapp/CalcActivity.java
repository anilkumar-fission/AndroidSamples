package com.fission.calclatorapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends Activity implements View.OnClickListener{
    Button one,two,three,four,five,six,seven,eight,nine,zero,add,divide,multiplication,substraction,equal,clear;
    EditText Entervalue;
    int op1,op2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        add=(Button)findViewById(R.id.add);
        substraction=(Button)findViewById(R.id.substraction);
        divide=(Button)findViewById(R.id.divide);
        multiplication=(Button)findViewById(R.id.multiplication);
        equal=(Button)findViewById(R.id.equal);
        clear=(Button)findViewById(R.id.clear);
        Entervalue=(EditText)findViewById(R.id.Entervalue);
        try {
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            add.setOnClickListener(this);
            substraction.setOnClickListener(this);
            multiplication.setOnClickListener(this);
            divide.setOnClickListener(this);
            equal.setOnClickListener(this);
            clear.setOnClickListener(this);
            }catch (Exception e){

        }
    }
    public void operation(){
    if(operator.equals("+")){
        op2=Integer.parseInt(Entervalue.getText().toString());
        Entervalue.setText(" ");
        op1=op1+op2;
        Entervalue.setText("Result:"+Integer.toString(op1));
    }
    else if(operator.equals("-")){
            op2=Integer.parseInt(Entervalue.getText().toString());
            Entervalue.setText(" ");
            op1=op1-op2;
            Entervalue.setText("Result:"+Integer.toString(op1));
        }
    else if(operator.equals("*")){
        op2=Integer.parseInt(Entervalue.getText().toString());
        Entervalue.setText(" ");
        op1=op1*op2;
        Entervalue.setText("Result:"+Integer.toString(op1));
    }
    else if(operator.equals("/")){
        op2=Integer.parseInt(Entervalue.getText().toString());
        Entervalue.setText(" ");
        op1=op1/op2;
        Entervalue.setText("Result:"+Integer.toString(op1));
    }
    }
    @Override
    public void onClick(View v) {
        Editable str=Entervalue.getText();
        switch (v.getId()){
            case R.id.one:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(two.getText());
                Entervalue.setText(str);
                break;
            case R.id.two:
                if(op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(two.getText());
                Entervalue.setText(str);
                break;
            case R.id.three:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(three.getText());
                Entervalue.setText(str);
                break;
            case R.id.four:
                if(op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(four.getText());
                Entervalue.setText(str);
                break;
            case R.id.five:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(five.getText());
                Entervalue.setText(str);
                break;
            case R.id.six:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
               str= str.append(six.getText());
                Entervalue.setText(str);
                break;
            case R.id.seven:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
               str= str.append(eight.getText());
                Entervalue.setText(str);
                break;
            case R.id.eight:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(nine.getText());
                Entervalue.setText(str);
                break;
            case R.id.nine:
                if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                str=str.append(zero.getText());
                Entervalue.setText(str);
                break;
            case R.id.clear:
                op1=0;
                op2=0;
                Entervalue.setText(" ");
                Entervalue.setHint(" perform operation:");
                break;
            case R.id.add:
                operator="+";
                if (op1==0){
                    op1=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                }
                else if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                else{
                    op2=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                    op1=op1+op2;
                    Entervalue.setText("Result:"+Integer.toString(op1));
                }
                break;
            case R.id.substraction:
                operator="-";
                if (op1==0){
                    op1=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                }
                else if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                else {
                    op2=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                    op1=op1-op2;
                    Entervalue.setText("Result:"+Integer.toString(op1));
                }
                break;
            case R.id.multiplication:
                operator="*";
                if (op1==0){
                    op1=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                }
                else if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                else {
                    op2=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                    op1=op1*op2;
                    Entervalue.setText("Result:"+Integer.toString(op1));
                }
                break;
            case R.id.divide:
                operator="/";
                if (op1==0){
                    op1=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                }
                else if (op2!=0){
                    op2=0;
                    Entervalue.setText(" ");
                }
                else {
                    op2=Integer.parseInt(Entervalue.getText().toString());
                    Entervalue.setText(" ");
                    op1=op1/op2;
                    Entervalue.setText("Result:"+Integer.toString(op1));
                }
                break;
            case R.id.equal:
                if (!operator.equals(null)){
                    if (op2!=0){
                        if (operator.equals("+")){
                            Entervalue.setText(" ");
                            Entervalue.setText("Result:"+Integer.toString(op1));
                        }
                        else if (operator.equals("-")){
                            Entervalue.setText(" ");
                            Entervalue.setText("Result:"+Integer.toString(op1));
                        }
                        else if (operator.equals("*")){
                            Entervalue.setText(" ");
                            Entervalue.setText("Result:"+Integer.toString(op1));
                        }
                        else if (operator.equals("/")){
                            Entervalue.setText(" ");
                            Entervalue.setText("Result:"+Integer.toString(op1));
                        }
                    }
                    else {
                        operation();
                    }

                }
                break;
        }

    }
}
