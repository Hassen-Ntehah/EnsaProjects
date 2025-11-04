package com.example.calculator;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnEquals;
    StringBuilder expressionBuilder = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.result);
        btnEquals=findViewById(R.id.btnEquals);
        Button btnadd=findViewById(R.id.btnAdd);

        btnadd.setOnClickListener(operatorButtonListener);
        Button btnSubstract=findViewById(R.id.btnSubtract);
        btnSubstract.setOnClickListener(operatorButtonListener);
        Button btnMultiply=findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(operatorButtonListener);
        Button btnClear=findViewById(R.id.btnClear);
        btnClear.setOnClickListener(ClearInput);


    }

        public void numberButtonListener(View v) {
            Button button = (Button) v;
            String buttonText = button.getText().toString();

            String currentText = textView.getText().toString();


            if (currentText.equals("0") || currentText.equals("Error")) {
                expressionBuilder.setLength(0);
            }


            expressionBuilder.append(buttonText);
            textView.setText(expressionBuilder.toString());
        };

    private View.OnClickListener operatorButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String operator = button.getText().toString();


            if (operator.equals("x")) {
                expressionBuilder.append(" * ");
            } else {

                expressionBuilder.append(" " + operator + " ");
            }

            textView.setText(expressionBuilder.toString());
        }
    };

private View.OnClickListener ClearInput=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        expressionBuilder.setLength(0);
        expressionBuilder.append("0");
        textView.setText(expressionBuilder.toString());

    }
};
public void usePreviousOPeration(View v){
    TextView previousOPeration=(TextView) v;
    expressionBuilder.setLength(0);
    expressionBuilder.append(previousOPeration.getText());
    textView.setText(expressionBuilder.toString());
    previousOPeration.setVisibility(INVISIBLE);
}


    public void calculateTotal(View view){

    String planeinput=expressionBuilder.toString();
//    float result=0;
//    String sub1="";
//    String sub2="";
//    char op='0';
//    Boolean operandfound=false;
//
//        for (int i=0;i<expressionBuilder.toString().length();i++){
//        if(planeinput.charAt(i)=='+'||planeinput.charAt(i)=='-'||planeinput.charAt(i)=='*'||planeinput.charAt(i)=='/'){
//            op=planeinput.charAt(i);
//            operandfound=true;
//            if(!sub2.equals("")){
//                switch (op){
//                    case '+':
//                        result=Integer.parseInt(sub1)+Integer.parseInt(sub2);
//                    case '-':
//                        result=Integer.parseInt(sub1)+Integer.parseInt(sub2);
//
//                    default:break;
//
//                }
//            }
//        }else if(!operandfound){
//            sub1.concat(planeinput.charAt(i)+"");
//        }else{
//            sub2.concat(planeinput.charAt(i)+"");
//
//        }
//    }
        String planeInputValue=expressionBuilder.toString();
        Expression expression= new Expression(planeInputValue);
        TextView previousOPeration=findViewById(R.id.previousOperation);
        previousOPeration.setText(expressionBuilder.toString());
        previousOPeration.setVisibility(VISIBLE);
        textView.setText(expression.calculate() + "");
//                textView.setText(result +"");

        expressionBuilder.setLength(0);
        expressionBuilder.append(textView.getText());


    }

}