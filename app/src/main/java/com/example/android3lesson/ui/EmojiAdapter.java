package com.example.android3lesson.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    public EmogiGame game;
    private  final ClickListener listener;

    public EmojiAdapter(ClickListener listener, EmogiGame game) {
        this.listener = listener;
        this.game = game;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent,false);
        return new EmojiHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
       holder.bind(game.getCards().get(position));

    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {

        private ClickListener listener;
        private ImageView imageList;

        public EmojiHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);
            this.listener = listener;
            imageList = itemView.findViewById(R.id.tv_CardList);
        }

        public void bind(Card<Integer> card) {
            itemView.setOnClickListener(v -> listener.listener(card));
            if (card.isFaceUp()) {
                imageList.setBackgroundColor(Color.BLUE);
                imageList.setImageResource(card.getContent());
                YoYo.with(Techniques.FlipInY)
                        .duration(2000)
                        .playOn(imageList);
            } else {
                imageList.setImageResource(R.drawable.volk);
            }
        }
    }

    interface ClickListener{
        void listener(Card<Integer> card);
    }
}

