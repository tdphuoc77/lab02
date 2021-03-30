package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abhinav.passwordgenerator.PasswordGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        2a
//        setContentView(R.layout.layout1);

//        2b
//        setContentView(R.layout.layout2);

//        2c
        sumPrice();


//        2d
//        createPassword();



    }

    public  void sumPrice(){
        Button btnMinus;
        Button btnAdd;
        TextView txtAmount;
        TextView txtProvisional;
        TextView txtSum;
        TextView txtPrice;

        setContentView(R.layout.layout3);
         btnMinus =findViewById(R.id.btnminus);
         btnAdd=findViewById(R.id.btnadd);
         txtAmount=findViewById(R.id.amount);
         txtProvisional=findViewById(R.id.provisional);
         txtSum=findViewById(R.id.sum);
         txtPrice=findViewById(R.id.price);




        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int amount=Integer.parseInt(txtAmount.toString());
                    long price=Long.parseLong(txtPrice.toString());
                    if(amount>0){
                        amount= amount-1;
                        long priceSum= price*amount;
                        txtAmount.setText(amount);
                        txtProvisional.setText(priceSum+"");
                        txtSum.setText(priceSum+"");
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int amount=Integer.parseInt(txtAmount.toString());
                    long price=Long.parseLong(txtPrice.toString());
                    amount= amount+1;
                    txtAmount.setText(amount);
                    long priceSum=price*amount;
                    txtProvisional.setText(priceSum+"");
                    txtSum.setText(priceSum+"");
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void createPassword(){
        EditText txtPassLength;
        CheckBox cbkLowerCase;
        CheckBox cbkUpperCase;
        CheckBox cbkNumber;
        CheckBox cbkSpecialSymbol;
        TextView txtPassword;
        Button btnGenerate;
        setContentView(R.layout.layout4);

        txtPassLength=findViewById(R.id.passlength);
        cbkLowerCase= findViewById(R.id.lowcase);
        cbkUpperCase= findViewById(R.id.upcase);
        cbkNumber = findViewById(R.id.number);
        cbkSpecialSymbol=  findViewById(R.id.specialSymbol);
        txtPassword= findViewById(R.id.password);
        btnGenerate= findViewById(R.id.btnGenerate);



        btnGenerate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int length;
                try {
                    length= Integer.parseInt(txtPassLength.getText().toString());
                    boolean isUpperCase= cbkUpperCase.isChecked();
                    boolean isLowerCase= cbkLowerCase.isChecked();
                    boolean isSymbol= cbkSpecialSymbol.isChecked();
                    boolean isNumber= cbkNumber.isChecked();

                    PasswordGenerator generator = new PasswordGenerator(length, isUpperCase, isLowerCase, isSymbol, isNumber);
                    txtPassword.setText(generator.generatePassword());

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}