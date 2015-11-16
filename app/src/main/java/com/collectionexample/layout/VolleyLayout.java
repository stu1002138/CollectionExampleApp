package com.collectionexample.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.collectionexample.model.GenerateViewId;
import com.collectionexample.model.WH;

/**
 * Created by Lucas on 2015/10/24.
 */
public class VolleyLayout extends LinearLayout{
    private TextView stringText,jsonText;
    private GenerateViewId generateViewId;
    private WH ruler;
    public ImageView imageView;
    public VolleyLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        init();

    }
    private void init(){
        ruler= new WH(getContext());
        {
            stringText = new TextView(getContext());
            stringText.setId(generateViewId());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,ruler.getH(25));
            stringText.setLayoutParams(params);
            stringText.setTextSize(ruler.getTextSize(10));
            this.addView(stringText);
        }
        {
            imageView = new ImageView(getContext());
            imageView.setId(generateViewId());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ruler.getW(20),ruler.getH(20));
            imageView.setLayoutParams(params);
            this.addView(imageView);
        }
        {
            jsonText = new TextView(getContext());
            jsonText.setId(generateViewId());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ruler.getH(25));
            jsonText.setLayoutParams(params);
            jsonText.setTextSize(ruler.getTextSize(10));
            this.addView(jsonText);
        }
    }
    public TextView getStringText(){
        return stringText;
    }
    public TextView getJsonText(){  return jsonText;}
    public ImageView getImage(){
        return imageView;
    }

}
