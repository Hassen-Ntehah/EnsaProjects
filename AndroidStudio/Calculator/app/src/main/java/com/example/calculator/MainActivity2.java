package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
Toast toast ;
EditText edlogin,edpass;
Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(submitclicked);
        edlogin=findViewById(R.id.edlogin);
        edpass=findViewById(R.id.edpass);



    }
private View.OnClickListener submitclicked=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(edlogin.getText().toString().equals("ing.hassen")){
//            Toast.makeText('');
            toast.makeText(MainActivity2.this, "hello 3ami", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();

        }

    }
};
}