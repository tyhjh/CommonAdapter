package com.example.dhht.recycleviewutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.recyclelibrary.CommonAdapter;
import com.example.recyclelibrary.CommonViewHolder;
import com.example.recyclelibrary.MultiItemCommonAdpter;
import com.example.recyclelibrary.MultiItemTypeSupport;

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


        MultiItemTypeSupport<String> multiItemTypeSupport = new MultiItemTypeSupport<String>() {
            @Override
            public int getLayoutId(int itemType) {
                switch (itemType) {
                    case 0:
                        return R.layout.item_test;
                    case 1:
                        return R.layout.item_test2;
                    default:
                        break;
                }
                return 0;
            }

            @Override
            public int getItemViewType(int position, String s) {
                if (position % 2 == 0) {
                    return 0;
                }
                return 1;
            }
        };

        MultiItemCommonAdpter<String> adpter = new MultiItemCommonAdpter<String>(MainActivity.this, stringList, multiItemTypeSupport) {
            @Override
            public void onBindView(final CommonViewHolder holder, String s) {

                if (holder.getItemViewType() == 0) {
                    holder.setText(R.id.tv, s);
                    holder.setOnClick(R.id.tv, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, holder.getAdapterPosition() + "Type=0", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    holder.setText(R.id.tv_txt, s);
                }


            }
        };
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adpter);
    }


}
