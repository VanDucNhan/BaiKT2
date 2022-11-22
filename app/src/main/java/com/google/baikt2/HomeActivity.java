package com.google.baikt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.baikt2.Controller.CaAdapter;
import com.google.baikt2.Model.Ca;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvca;
    CaAdapter cayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvca= (RecyclerView) findViewById(R.id.rv);
        rvca.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Ca> options =
                new FirebaseRecyclerOptions.Builder<Ca>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ca"), Ca.class)
                        .build();

        cayAdapter = new CaAdapter(options);
        rvca.setAdapter(cayAdapter);


        FloatingActionButton btnsangadd = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        btnsangadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,AddActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        cayAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cayAdapter.stopListening();
    }
}