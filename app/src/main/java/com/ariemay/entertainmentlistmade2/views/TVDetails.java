package com.ariemay.entertainmentlistmade2.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariemay.entertainmentlistmade2.R;
import com.ariemay.entertainmentlistmade2.models.TV;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TVDetails extends AppCompatActivity {

    public static String EXTRA_DATA = "extras";

    TextView name, startDate, endDate, genre, description;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdetails);

        TV tv = getIntent().getParcelableExtra(EXTRA_DATA);

        name = findViewById(R.id.detail_tv_name);
        startDate = findViewById(R.id.start);
        endDate = findViewById(R.id.end);
        genre = findViewById(R.id.tv_genre);
        description = findViewById(R.id.description);
        poster = findViewById(R.id.detail_tv_poster);

        Glide.with(getApplicationContext())
                .load(tv.getTv_photo())
                .apply(new RequestOptions()
                        .override(150,150))
                .into(poster);

        name.setText(tv.getTv_name());
        startDate.setText(String.valueOf(tv.getTv_startYear()));
        endDate.setText(String.valueOf(tv.getTv_endYear()));
        genre.setText(tv.getTv_genre());
        description.setText(tv.getTv_description());
    }

}
