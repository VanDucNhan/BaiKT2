package com.google.baikt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.baikt2.Model.Ca;

import org.w3c.dom.Text;

import java.io.Serializable;

public class TrangChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chi_tiet);

        ImageView img_mota = (ImageView) findViewById(R.id.img_mota);
        TextView txttenthuonggoimota = (TextView) findViewById(R.id.txt_motatenca);
        TextView txttenkhoahocmoto = (TextView) findViewById(R.id.txt_motatenkhoahoc);
        TextView txtdactinhmoto = (TextView) findViewById(R.id.txt_motadactinh);
        TextView txtmausacmoto = (TextView) findViewById(R.id.txt_motamausac);


        img_mota.setImageResource(getIntent().getIntExtra("url", 0));
        txttenthuonggoimota.setText(getIntent().getStringExtra("tenthuonggoi").toString());
        txttenkhoahocmoto.setText(getIntent().getStringExtra("tenkhoahoc").toString());
        txtdactinhmoto.setText(getIntent().getStringExtra("dactinh").toString());
        txtmausacmoto.setText(getIntent().getStringExtra("mauca").toString());

        ImageView btnthoat = (ImageView) findViewById(R.id.arrow);
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrangChiTietActivity.this,HomeActivity.class));
            }
        });

    }
}