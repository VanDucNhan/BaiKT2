package com.google.baikt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddActivity extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://baikt2-70e37-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button btnthoat = (Button) findViewById(R.id.btncanceladd);

        EditText tenthuonggoiadd = (EditText) findViewById(R.id.tenthuonggoiadd);
        EditText tenkhoahocadd = (EditText) findViewById(R.id.txttenkhoahocadd);
        EditText dactinhadd = (EditText) findViewById(R.id.txtdactinhadd);
        EditText mausacdd = (EditText) findViewById(R.id.txtmausacadd);
        EditText urladd = (EditText) findViewById(R.id.txturladd);
        Button btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txttenthuonggoiadd=tenthuonggoiadd.getText().toString();
                String txttenkhoahocadd = tenkhoahocadd.getText().toString();
                String txtdactinhadd=dactinhadd.getText().toString();
                String txtmausacadd = mausacdd.getText().toString();
                String txturladd =urladd.getText().toString();


                databaseReference.child("Ca").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.hasChild(txttenthuonggoiadd)){
                            Toast.makeText(AddActivity.this,"cá đã được nhập",Toast.LENGTH_SHORT).show();
                        }else{
                            databaseReference.child("Ca").child(txttenthuonggoiadd).child("tenthuonggoi").setValue(txttenthuonggoiadd);
                            databaseReference.child("Ca").child(txttenthuonggoiadd).child("tenkhoahoc").setValue(txttenkhoahocadd);
                            databaseReference.child("Ca").child(txttenthuonggoiadd).child("dactinh").setValue(txtdactinhadd);
                            databaseReference.child("Ca").child(txttenthuonggoiadd).child("mauca").setValue(txtmausacadd);
                            databaseReference.child("Ca").child(txttenthuonggoiadd).child("url").setValue(txturladd);

                            Toast.makeText(AddActivity.this,"Nhập Cá thành công",Toast.LENGTH_SHORT).show();
                            tenthuonggoiadd.setText("");
                            tenkhoahocadd.setText("");
                            dactinhadd.setText("");
                            mausacdd.setText("");
                            urladd.setText("");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this,HomeActivity.class));
            }
        });
    }
}