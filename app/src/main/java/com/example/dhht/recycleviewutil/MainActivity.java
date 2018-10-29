package com.example.dhht.recycleviewutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.recyclelibrary.CommonAdapter;
import com.example.recyclelibrary.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stringList.add(String.valueOf(i));
        }

        CommonAdapter adapter = new CommonAdapter<String>(MainActivity.this, stringList, R.layout.item_test) {
            @Override
            public void onBindView(final CommonViewHolder holder, String o) {
                holder.setText(R.id.tv, o);
                holder.setOnClick(R.id.tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, holder.getAdapterPosition() + "", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);




    }
}
