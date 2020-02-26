package com.example.superbotsdk2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.superbotsdk2.DataHolder;
import com.example.superbotsdk2.Post;
import com.example.superbotsdk2.WebViewActivity;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CustomRelativeLayout extends RelativeLayout implements View.OnClickListener {

    private ImageButton mButton;
    private LinearLayout linearLayout, linearLayout1;
    private Context context;
    private float TextHeadersize;
    private TextView textViewheader , textViewSubHeader;
    private Response<Post> responseGlob;

    public CustomRelativeLayout(Context context) {
        super(context);
        this.context = context;

    }

    /**
     *
     * @param account
     * @param secret
     */
    public void init(String account, String secret) {
        Log.e("Response", "inIt: working");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.superbot.works")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataHolder dataHolder = retrofit.create(DataHolder.class);
        Call<Post> call = dataHolder.getPost(
                account,
                secret
        );
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    responseGlob = response;
                    Log.d("*1234*","My response"+ response.body());
                    initViews(response);

                    /*List<Post> posts = response.body();
                    for (Post post:posts)
                    {

                    }*/
                }

                Log.d("REsp", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("REsp1", String.valueOf(call));
            }
        });
    }
    private void initViews(Response<Post> response) {

        if(response.body().getWidgetPosition().equalsIgnoreCase("right"))
        {
            LayoutParams bparams = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            bparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            bparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);


            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            linearParams.setMargins(10, 0, 30, 10);
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParams);
            LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            linearParams1.setMargins(10, 0, 10, 25);

            textViewheader = new TextView(context);
            textViewSubHeader = new TextView(context);
            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {
                textViewSubHeader.setText(response.body().getHeaderTitle());
                textViewSubHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 6f);
                String subHeading = textViewSubHeader.getText().toString();
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + subHeading + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));
                textViewheader.setPadding(30, 30, 30, 30);
               // textViewheader.setBackgroundColor(getResources().getColor(R.color.titlecolor));
                textViewheader.setBackgroundResource(R.drawable.background_textview);
                textViewheader.setLayoutParams(linearParams);
                textViewheader.setLayoutParams(linearParams1);
                textViewheader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                mButton = new ImageButton(context);
                mButton.setId((int) 0X101);
                //  mButton.setBackgroundResource(R.drawable.round_button);


                GradientDrawable shape = new GradientDrawable();
                shape.setShape(GradientDrawable.OVAL);
                shape.setSize(150, 150);
                shape.setColor(Color.parseColor(response.body().getMainColor()));
                shape.setStroke(2, Color.BLACK);
                mButton.setBackground(shape);

                Picasso.get().load(response.body().getBaseUrl() + "/" + response.body().getIcon()).into(mButton);


                //mButton.setBackgroundColor();

                mButton.setLayoutParams(linearParams);
                mButton.setOnClickListener(this);
                linearLayout.setLayoutParams(bparams);
                linearLayout.addView(textViewheader);
                linearLayout.addView(mButton);

                addView(linearLayout);

                getButton();
            }

        }

        if(response.body().getWidgetPosition().equalsIgnoreCase("left"))
        {
            LayoutParams bparams = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            bparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            bparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);


            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            linearParams.setMargins(10, 0, 30, 10);
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParams);
            LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            linearParams1.setMargins(10, 0, 10, 25);

            textViewheader = new TextView(context);
            textViewSubHeader = new TextView(context);
            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {
                textViewSubHeader.setText(response.body().getHeaderTitle());
                textViewSubHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 6f);
                String subHeading = textViewSubHeader.getText().toString();
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + subHeading + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));
                textViewheader.setPadding(30, 30, 30, 30);
               // textViewheader.setBackgroundColor(getResources().getColor(R.color.titlecolor));
                textViewheader.setBackgroundResource(R.drawable.background_textview);
                textViewheader.setLayoutParams(linearParams);
                textViewheader.setLayoutParams(linearParams1);
                textViewheader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                mButton = new ImageButton(context);
                mButton.setId((int) 0X101);
                  mButton.setBackgroundResource(R.drawable.round_button);


                GradientDrawable shape = new GradientDrawable();
                shape.setShape(GradientDrawable.OVAL);
                shape.setSize(150, 150);
                shape.setColor(Color.parseColor(response.body().getMainColor()));
                shape.setStroke(2, Color.BLACK);
                mButton.setBackground(shape);

                Picasso.get().load(response.body().getBaseUrl() + "/" + response.body().getIcon()).into(mButton);


                //mButton.setBackgroundColor();

                mButton.setLayoutParams(linearParams);
                mButton.setOnClickListener(this);
                linearLayout.setLayoutParams(bparams);
                linearLayout.addView(mButton);
                linearLayout.addView(textViewheader);


                addView(linearLayout);

                getButton();
            }

        }

    }


    private ImageButton getButton() {
        return mButton;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case 0X101:
                if (responseGlob!=null)
                context.startActivity(new Intent(context, WebViewActivity.class).putExtra("webview",responseGlob.body().getWidgetUrl()));

                break;
            case 0X102:
                break;
        }
    }
}

