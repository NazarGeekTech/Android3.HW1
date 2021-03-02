package com.example.android3lesson.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.ClickListener {

    private static final String tag = "mainActivity";
    EmojiAdapter adapter;
    EmogiGame game;
    RecyclerView recyclerView;


    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void initviews() {
        recyclerView = findViewById(R.id.rv_cards);
        game = new EmogiGame();
        adapter = new EmojiAdapter(this, game);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void listener(Card<Integer> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();
        if (game.getCards().size() == 0)
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_LONG).show();

    }
}