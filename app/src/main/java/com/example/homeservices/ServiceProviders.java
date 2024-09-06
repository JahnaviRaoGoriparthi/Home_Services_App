package com.example.homeservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviders extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    TextView type;
    private List<Item> itemList;
    String[] types = {"Plumber", "Electrician", "Cable Operator", "WIFI", "DOCTORS", "Transport"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_providers);
        type = findViewById(R.id.type);

        Bundle bundle = getIntent().getExtras();

        String chosen = bundle.getString("CHOSEN");
        type.setText(types[Integer.parseInt(chosen)]);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (Integer.parseInt(chosen) == 0) {
            itemList = new ArrayList<>();
            itemList.add(new Item("G.Naresh", "80747503032", "Guntur"));
            itemList.add(new Item("T.Mahesh", "9848233421", "Prakasam"));
            itemList.add(new Item("V.Varun", "7013245678", "Bhimavaram"));
            itemList.add(new Item("S.Suresh", "9876543221", "Machalipatnam"));
            itemList.add(new Item("A.Bhavani", "876543211", "Rajhamundry"));
            itemList.add(new Item("P.Rajesh", "7890789012", "Vijaywada"));
            itemList.add(new Item("G.Srinu", "9087654323", "Ananthapuram"));

        } else if (Integer.parseInt(chosen) == 1) {
            itemList = new ArrayList<>();
            itemList.add(new Item("G.Gowtham", "9848233421", "Gannavaram"));
            itemList.add(new Item("D.Rana", "9848233421", "Rajhamundry"));
            itemList.add(new Item("G.Mahesh", "9984823342", "ongole"));
            itemList.add(new Item("P.Ram", "9848245678", "Wrarangal"));
            itemList.add(new Item("T.Srinivas", "8765430987", "Srikakulam"));
            itemList.add(new Item("H.Kalyan", "9873451234", "Vijaynaganram"));
            itemList.add(new Item("B.Bharath", "6784543234", "Kadapa"));

        } else if (Integer.parseInt(chosen) == 2) {
            itemList = new ArrayList<>();
            itemList.add(new Item("A.Aanand", "9876543123", "Prakasam"));
            itemList.add(new Item("A.Tejas", "9872341470", "Kurnool"));
            itemList.add(new Item("C.Sohit", "9567834232", "Vijaywada"));
            itemList.add(new Item("K.Preman", "6231212343", "Srikakaulam"));
            itemList.add(new Item("R.Rajesh", "9876543212", "Eluru"));
            itemList.add(new Item("N.Goutham", "7895432341", "Kadapa"));
            itemList.add(new Item("B.Bhishma", "7895643219", "Bhimavaram"));

        } else if (Integer.parseInt(chosen) == 3) {
            itemList = new ArrayList<>();
            itemList.add(new Item("A.Aravind", "7431234567", "Bhimavaram"));
            itemList.add(new Item("C.Kamal", "9123456781", "Kurnool"));
            itemList.add(new Item("R.Sai", "8976543211", "Kakinada"));
            itemList.add(new Item("K.Ramesh", "9876543210", "Guntur"));
            itemList.add(new Item("T.Sidhu", "6785432190", "Vijaywada"));
            itemList.add(new Item("P.Lauence", "9765432132", "Kadapa"));
            itemList.add(new Item("A.Hemanth", "9876543210", "Tirupathi"));

        } else if (Integer.parseInt(chosen) == 4) {
            itemList = new ArrayList<>();
            itemList.add(new Item("Dr.Deepthi", "8459412365", "Teacher's colony"));
            itemList.add(new Item("Dr.Munna", "7890234521", "Vijayawada"));
            itemList.add(new Item("Dr.Deepika", "7890678943", "Chalapalli"));
            itemList.add(new Item("Dr.Saketh", "8904567321", "123 Main St"));
            itemList.add(new Item("Dr,hanisha", "8908976543", "Near Sunflower School"));
            itemList.add(new Item("Dr.Srinivas", "8908776123", "Mtm"));
            itemList.add(new Item("Dr.anil", "7890098765", "Gudivada"));

        } else if (Integer.parseInt(chosen) == 5) {
            itemList = new ArrayList<>();
            itemList.add(new Item("R.Karthik", "7865432109", "Ramanagar"));
            itemList.add(new Item("T.Karan", "7896543210", "Peraspeta"));
            itemList.add(new Item("L.kiran", "8765439876", "Kosuru"));
            itemList.add(new Item("P.Kairav", "8765432154", "Movva"));
            itemList.add(new Item("T.Ramesh", "9872345612", "Gudlavalleru"));
            itemList.add(new Item("G.srinu", "9875432134", "Vijayawada"));
            itemList.add(new Item("S.Sushanth", "9870654321", "Bhimavaram"));

        }
        // Initialize the adapter and set it to the RecyclerView
        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Set an OnItemClickListener to toggle the selection of an item
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Item item = itemList.get(position);
                item.setSelected(!item.isSelected());
                adapter.notifyItemChanged(position);
            }
        });
    }
}