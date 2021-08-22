package com.example.calculatordemoapp;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

    }

    private void updateText(String strToAdd){
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftStr = oldString.substring(0,cursorPosition);
        String rightStr = oldString.substring(cursorPosition);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPosition + 1);

    }
    public void zeroBtn(View view) {
        updateText("0");
    }

    public void oneBtn(View view) {
        updateText("1");
    }

    public void twoBtn(View view) {
        updateText("2");
    }

    public void threeBtn(View view) {
        updateText("3");
    }

    public void fourBtn(View view) {
        updateText("4");
    }

    public void fiveBtn(View view) {
        updateText("5");
    }

    public void sixBtn(View view) {
        updateText("6");
    }

    public void sevenBtn(View view) {
        updateText("7");
    }

    public void eightBtn(View view) {
        updateText("8");
    }

    public void nineBtn(View view) {
        updateText("9");
    }

    public void clearBtn(View view) {
        display.setText(" ");
    }

    public void scopesBtn(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLength = display.getText().length();
        for (int i = 0; i < cursorPos; i++) {
            if(display.getText().toString().charAt(i) == '('){
                openPar+=1;
            }
            if(display.getText().toString().charAt(i) == ')'){
                closedPar+=1;
            }
        }
        if(openPar == closedPar || display.getText().toString().charAt(textLength - 1) == '('){
            updateText("(");
            display.setSelection(cursorPos + 1);
        }
        else if(openPar > closedPar && display.getText().toString().charAt(textLength - 1) != '('){
            updateText(")");
            display.setSelection(cursorPos + 1);
        }

    }

    public void plusMinusBtn(View view) {
        updateText("-");
    }

    public void equalsBtn(View view) {
        String userExpr = display.getText().toString();
        Expression exp = new Expression(userExpr);
        String result  = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBtn(View view) {
        int cursorPosition = display.getSelectionStart();
        int textLength = display.getText().length();
        if(cursorPosition != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPosition - 1, cursorPosition, " ");
            display.setText(selection);
            display.setSelection(cursorPosition - 1);
        }
    }

    public void plusBtn(View view) {
        updateText("+");
    }

    public void pointBtn(View view) {
        updateText(".");
    }
    public void pwrBtn(View view){
        updateText("^");
    }
    public void divideBtn(View view){
        updateText("/");
    }
    public void multiplyBtn(View view){
        updateText("*");
    }
    public void minusBtn(View view){
        updateText("-");
    }
}