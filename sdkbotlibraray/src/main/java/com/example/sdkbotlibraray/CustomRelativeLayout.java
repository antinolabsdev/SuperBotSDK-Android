package com.example.sdkbotlibraray;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CustomRelativeLayout extends RelativeLayout implements View.OnClickListener {

    private FloatingActionButton mButton;
    private LinearLayout linearLayout, linearLayout1;
    private Context context;
    private float TextHeadersize;
    private TextView textViewheader , textViewSubHeader;
    private Response<Post> responseGlob;
    private String android_id = Settings.Secure.getString(getContext().getContentResolver(),
            Settings.Secure.ANDROID_ID);


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
        Log.e("Response", android_id);
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

        if(response.body().getWidgetPosition().equalsIgnoreCase("left"))
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
           // linearParams.setMargins(0, 0, 0, 20);
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParams);

           // linearParams1.setMargins(0, 4, 30, 10);

            textViewheader = new TextView(context);
            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + response.body().getHeaderTitle() + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));
                textViewheader.setPadding(30, 30, 80, 30);
                textViewheader.setBackgroundResource(R.drawable.background_textview);
                textViewheader.setLayoutParams(linearParams);

                mButton = new FloatingActionButton(context);
                mButton.setId((int) 0X101);
                mButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(response.body().getMainColor())));
                Picasso.get().load(response.body().getBaseUrl() + "/" + response.body().getIcon()).resize(600,600).into(mButton);

                LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );
                mButton.setLayoutParams(linearParams1);
                mButton.setOnClickListener(this);
                linearLayout.setLayoutParams(bparams);
                linearLayout.addView(textViewheader);
                linearLayout.addView(mButton);


                addView(linearLayout);

                getButton();
            }

        }

        if(response.body().getWidgetPosition().equalsIgnoreCase("right"))
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
            int valueMarginTop = 6;
            int dpValueTopMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginTop, context.getResources().getDisplayMetrics());
            linearParams.setMargins(0, 0, 0, dpValueTopMargin);
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParams);
            LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            int valueMarginLeft = 5;
            int dpvalueMarginLeft = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginLeft, context.getResources().getDisplayMetrics());
            int valueMarginTopButton = 0;
            int dpvalueMarginTopButton = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginTopButton, context.getResources().getDisplayMetrics());
            int valueMarginBottomButton = 1;
            int dpvalueMarginBottomButton = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginBottomButton, context.getResources().getDisplayMetrics());
            linearParams1.setMargins(dpvalueMarginLeft, dpvalueMarginTopButton, 0, dpvalueMarginBottomButton);
            textViewheader = new TextView(context);
            textViewSubHeader = new TextView(context);
            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {

                textViewSubHeader.setText(response.body().getHeaderTitle());
                String subHeading = textViewSubHeader.getText().toString();
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + subHeading + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));

                int value1 = 30;
                int dpValueLeft = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value1, context.getResources().getDisplayMetrics());

                int value2 = 10;
                int dpValueTop = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value2,
                        context.getResources().getDisplayMetrics());
                int value3 = 10;
                int dpValueRight = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value3,
                        context.getResources().getDisplayMetrics());
                int value4 = 10;
                int dpValueBottom = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value4,
                        context.getResources().getDisplayMetrics());
                textViewheader.setPadding(dpValueLeft, dpValueTop, dpValueRight, dpValueBottom);
                textViewheader.setBackgroundResource(R.drawable.background_left_textview);
                textViewheader.setLayoutParams(linearParams);


                mButton = new FloatingActionButton(context);
                mButton.setId((int) 0X101);
                mButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(response.body().getMainColor())));

                Picasso.get().load(response.body().getBaseUrl() + "/" + response.body().getIcon()).into(mButton);



                mButton.setLayoutParams(linearParams1);
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
                    context.startActivity(new Intent(context, WebViewActivity.class).putExtra("webview",responseGlob.body().getWidgetUrl()+"&udid=android."+android_id));

                break;
            case 0X102:
                break;
        }
    }
}

