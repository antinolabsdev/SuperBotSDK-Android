package com.example.sdkbotlibraray;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

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
    private int value1,value2,value3,value4;
    private int marginbottom,marginup,marginleft,marginRight;
    private String android_id = Settings.Secure.getString(getContext().getContentResolver(),
            Settings.Secure.ANDROID_ID);


    public CustomRelativeLayout(Context context) {
        super(context);
        this.context = context;

    }


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
                    initViews(responseGlob);

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
            bparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

            LinearLayout.LayoutParams linearParamTextviewLinearLayout = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            //This parameter is used for button when chatbox is not visible
            LinearLayout.LayoutParams buttonMarginWithoutBubbleParams= new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            marginleft=25;
            marginbottom=25;
            int dpMarginButtonWithoutBubbleLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,marginleft,context.getResources().getDisplayMetrics());
            int dpMarginButtonWithoutBubbleBottom = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,marginbottom,context.getResources().getDisplayMetrics());
            buttonMarginWithoutBubbleParams.setMargins(dpMarginButtonWithoutBubbleLeft,0,0,dpMarginButtonWithoutBubbleBottom);


            int dpValueBottomMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    marginbottom, context.getResources().getDisplayMetrics());
            linearParamTextviewLinearLayout.setMargins(0, 0, 0, dpValueBottomMargin);

            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParamTextviewLinearLayout);
            LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            marginleft = 20;
            int dpvalueMarginLeft = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    marginleft, context.getResources().getDisplayMetrics());
            linearParams1.setMargins(dpvalueMarginLeft, 0, 0, 0);
            mButton = new FloatingActionButton(context);
            mButton.setId((int) 0X101);
            mButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(response.body().getMainColor())));
            String currentImage =response.body().getBaseUrl() + "/" + response.body().getIcon() ;
            if(currentImage!=null)
            {
                new DownloadImageTask(mButton).execute(currentImage);
            }
            mButton.setOnClickListener(this);
            mButton.setLayoutParams(buttonMarginWithoutBubbleParams);
            linearLayout.setLayoutParams(bparams);
            linearLayout.addView(mButton);


            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {
                textViewheader = new TextView(context);
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + response.body().getHeaderTitle() + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));
                value1 = 30;
                int dpValueLeft = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value1, context.getResources().getDisplayMetrics());

                value2 = 12;
                int dpValueTop = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value2,
                        context.getResources().getDisplayMetrics());
                value3 = 10;
                int dpValueRight = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value3,
                        context.getResources().getDisplayMetrics());
                value4 = 12;
                int dpValueBottom = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value4,
                        context.getResources().getDisplayMetrics());
                textViewheader.setPadding(dpValueLeft, dpValueTop, dpValueRight, dpValueBottom);
                textViewheader.setBackgroundResource(R.drawable.background_left_textview);
                textViewheader.setLayoutParams(linearParamTextviewLinearLayout);
                linearLayout.addView(textViewheader);


            }

            addView(linearLayout);

            getButton();

        }

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

            int valueMarginBottom = 15;
            int dpValueMarginBottom = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginBottom, context.getResources().getDisplayMetrics());
            linearParams.setMargins(0, 0, 0, dpValueMarginBottom);
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearParams);
            LinearLayout.LayoutParams linearParams1 = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            int valueMarginRight1 = 15;
            int dpvalueMarginRight = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    valueMarginRight1, context.getResources().getDisplayMetrics());
            linearParams1.setMargins(0, 0, dpvalueMarginRight, dpValueMarginBottom);
            textViewheader = new TextView(context);
            textViewSubHeader = new TextView(context);
            if (response.body().getChatBoxBubble().equalsIgnoreCase("1")) {

                textViewSubHeader.setText(response.body().getHeaderTitle());
                String subHeading = textViewSubHeader.getText().toString();
                textViewheader.setText(Html.fromHtml("<b>" + response.body().getHeaderSubtitle() + "</b><br>" + "<font color=" + "darkgrey" + ">" + subHeading + "</font>"));
                textViewheader.setTextColor(Color.parseColor(response.body().getTextColor()));

                 value1 = 10;
                int dpValueLeftPadding = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value1, context.getResources().getDisplayMetrics());

                 value2 = 12;
                int dpValueTopPadding = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value2,
                        context.getResources().getDisplayMetrics());
                value3 = 30;
                int dpValueRightPadding = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value3,
                        context.getResources().getDisplayMetrics());
                value4 = 12;
                int dpValueBottomPadding = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value4,
                        context.getResources().getDisplayMetrics());
                textViewheader.setPadding(dpValueLeftPadding, dpValueTopPadding, dpValueRightPadding, dpValueBottomPadding);
                textViewheader.setBackgroundResource(R.drawable.background_textview);
                textViewheader.setLayoutParams(linearParams);
                linearLayout.addView(textViewheader);
            }
            mButton = new FloatingActionButton(context);
            mButton.setId((int) 0X101);
            String currentImage =response.body().getBaseUrl() + "/" + response.body().getIcon() ;
            if(currentImage!=null)
            {
                new DownloadImageTask(mButton).execute(currentImage);
            }
            mButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(response.body().getMainColor())));
           // Picasso.get().load().into(mButton);
            mButton.setScaleType(ImageView.ScaleType.CENTER);
            mButton.setLayoutParams(linearParams1);
            mButton.setOnClickListener(this);
            linearLayout.setLayoutParams(bparams);

            linearLayout.addView(mButton);


            addView(linearLayout);

            getButton();

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

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        FloatingActionButton actionButton;
        public DownloadImageTask(FloatingActionButton mButton) {
            this.actionButton=mButton;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urldisplay = strings[0];

            Bitmap bmp = null;

            try {

                InputStream in = new java.net.URL(urldisplay).openStream();

                bmp = BitmapFactory.decodeStream(in);

            } catch (Exception e) {

                Log.e("Error", e.getMessage());

                e.printStackTrace();

            }

            return bmp;
        }
        protected void onPostExecute(Bitmap result) {

            actionButton.setImageBitmap(result);

        }
    }
}
