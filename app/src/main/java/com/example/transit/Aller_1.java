package com.example.transit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Aller_1 extends AppCompatActivity {
    ListView listView;
    String mStation[]={"Bab Diwen","5 Aout","Sabra","Beaux-Arts","Ariana","Chaaben","Ecole Français","Seka","El Jad","Mosquée El Bousten",
            "Lycée Mohamed Ali","Markaz Bou Assida","El Blaket","Diwen El Zit","Kaanich","El Zalouza","Bab El Aaidi","Becha","Bou Ain","El Khairia",
            "Bab Diwen","5 Aout","Sabra","Beaux-Arts","Ariana","Chaaben","Ecole Français","Seka","El Jad","Mosquée El Bousten","Lycée Mohamed Ali",
            "Markaz Bou Assida","El Blaket","Diwen El Zit","Kaanich","El Zalouza","Bab El Aaidi","Becha","Bou Ain","El Khairia"};

    String mTime[]={"07 :00","07 :03","07 :04"," 07 :05"," 07 :07","07 :08","07 :09","07 :10","07 :11","07 :12" ," 07 :14","07 :15","07 :16",
            " 07 :17"," 07 :19"," 07 :21","07 :22"," 07 :23","07 :24","07 :25","08 :10","08 :13","08 :14"," 08 :15"," 08 :17","08 :18",
            "08 :19","08 :20","08 :21","08 :22" ," 08 :24","08 :25","08 :26"," 08 :27"," 08 :29"," 08 :31","08 :32"," 08 :33","08 :34","08 :35"};

    int images[]={R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,
            R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,
            R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,R.drawable.c_bleu,
            R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,
            R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,
            R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune,R.drawable.c_jaune};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aller_1);

        listView = findViewById(R.id.listview_aller);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mStation, mTime, images);
        listView.setAdapter(adapter);



    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rStation[];
        String rTime[];
        int rImgs[];

        MyAdapter (Aller_1 c, String[] station, String[] time, int[] imgs) {
            super(c, R.layout.row, R.id.textView1, station);
            this.context = c;
            this.rStation = station;
            this.rTime = time;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myStation = row.findViewById(R.id.textView1);
            TextView myTime = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myStation.setText(rStation[position]);
            myTime.setText(rTime[position]);

            return row;
        }
    }
}
