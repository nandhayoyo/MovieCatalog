package com.example.moviecatalog;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName = {"Aquaman","Bird Box","Bohomean Rapsody","BumbleBee","Creed II","DeadPool","Glass","Hunter Kill","Spiderman","Venom"};
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DETAIL, "Film ini mengungkap asal-usul Arthur Curry, manusia perkasa yang bisa mengendalikan air dan hewan laut. Dari mana ia mendapatkan kekuatannya? Siapa orang tuanya, dan pantaskah dia menjadi seorang raja di 7samudera?");
                intent.putExtra(DetailActivity.EXTRA_TTL, "22 Februari 1988");
                intent.putExtra(DetailActivity.EXTRA_TINGGI, ",74 M");
                intent.putExtra(DetailActivity.EXTRA_PASANGAN, "uan Carlos V");
                Toast.makeText(MainActivity.this, films.get(i).getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

        });
    }

        private void prepare() {
            dataName = getResources().getStringArray(R.array.data_name);
            dataDescription = getResources().getStringArray(R.array.data_description);
            dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }


}
