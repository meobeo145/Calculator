package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNumber;
    private TextView tvMath;
    public int ketqua = 0;

    private int[] idButton = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnDot, R.id.btnResult,
            R.id.btnPlus, R.id.btnSub, R.id.btnMul, R.id.btnDiv,
            R.id.btnCE, R.id.btnC, R.id.btnBS, R.id.btnOpenSP
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tvFont = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGIT.TTF");
        tvNumber = findViewById(R.id.tvNumber);
        tvNumber.setTypeface(tvFont);
        tvMath = findViewById(R.id.tvMath);
        tvMath.setTypeface(tvFont);

        connectView();
    }

    private void connectView() {
        tvMath = findViewById(R.id.tvMath);
        tvNumber = findViewById(R.id.tvNumber);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())  {
            case R.id.btn0:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("0");
                break;
            case R.id.btn1:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("1");
                break;
            case R.id.btn2:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("2");
                break;
            case R.id.btn3:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("3");
                break;
            case R.id.btn4:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("4");
                break;
            case R.id.btn5:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("5");
                break;
            case R.id.btn6:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("6");
                break;
            case R.id.btn7:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("7");
                break;
            case R.id.btn8:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("8");
                break;
            case R.id.btn9:
                if(Integer.parseInt(tvMath.getText().toString()) == 0)
                    tvMath.setText("");
                tvMath.append("9");
                break;
            case R.id.btnCE:
                tvMath.setText("0");
                break;
            case R.id.btnC:
                tvNumber.setText("");
                tvMath.setText("0");
                break;
            case R.id.btnBS:
                String numberAfterBS = deleteANumber(tvMath.getText().toString());
                if (numberAfterBS.length() == 0) tvMath.setText("0");
                else tvMath.setText(numberAfterBS);
                break;
            case R.id.btnDiv:
                if (tvNumber.getText() != ""){
                    String numberAfter = deleteANumber(tvNumber.getText().toString());
                    tvNumber.setText(numberAfter);
                } else  {
                    tvNumber.append(tvMath.getText());
                }
                tvNumber.append("/");
                tvMath.setText("0");
                break;
            case R.id.btnMul:
                if (tvNumber.getText() != ""){
                    String numberAfter = deleteANumber(tvNumber.getText().toString());
                    tvNumber.setText(numberAfter);
                } else  {
                    tvNumber.append(tvMath.getText());
                }
                tvNumber.append("x");
                tvMath.setText("0");
                break;
            case R.id.btnSub:
                if (tvNumber.getText() != ""){
                    String numberAfter = deleteANumber(tvNumber.getText().toString());
                    tvNumber.setText(numberAfter);
                } else  {
                    tvNumber.append(tvMath.getText());
                }
                tvNumber.append("-");
                tvMath.setText("0");
                break;
            case R.id.btnPlus:
                if (tvNumber.getText() != ""){
                    String numberAfter = deleteANumber(tvNumber.getText().toString());
                    tvNumber.setText(numberAfter);
                } else  {
                    tvNumber.append(tvMath.getText());
                }
                tvNumber.append("+");
                tvMath.setText("0");
                break;
            case R.id.btnOpenSP:
                tvNumber.append(tvMath.getText());
                tvNumber.append("");
                tvMath.setText("0");
                break;
            case R.id.btnDot:
                //tvNumber.append(".");
                break;
            case R.id.btnResult:
                int result = 0;
                tvNumber.append(tvMath.getText());
                int x = output(tvNumber.getText().toString(), tvNumber.getText().toString());
                tvNumber.append("=");
                tvMath.setText(x + "");
                break;
        }
    }
    public  String deleteANumber(String number)  {
        int length = number.length();
        String tmp = number.substring(0, length - 1);
        return tmp;
    }
    //mảng lưu phép toán
    public ArrayList<String> arrOperation;
    //mảng lưu số
    public  ArrayList<Double> arrNumber;

    public void addOperration(String input)  {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++)  {
            switch (cArray[i])  {
                case '+' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/' :
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
    }
    //public  void output()
    public void addNumber(String stringInput)  {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find())  {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

    public int output(String a, String b)  {
        addNumber(a);
        addOperration(b);
        int result = 0;
        for (int i = 0; i < arrNumber.size() - 1; i++)  {
            switch (arrOperation.get(i))  {
                case "+" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) + arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result + arrNumber.get(i + 1));
                    }
                    break;
                case "-" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) - arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result - arrNumber.get(i + 1));
                    }
                    break;
                case "x" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) * arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result * arrNumber.get(i + 1));
                    }
                    break;
                case "/" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) / arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result / arrNumber.get(i + 1));
                    }
                    break;
            }
        }
        return result;
    }
}
