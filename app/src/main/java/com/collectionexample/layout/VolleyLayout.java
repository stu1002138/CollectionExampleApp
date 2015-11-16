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
    private WH ruler;
    public ImageView imageView;
    public VolleyLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        ruler= new WH(getContext());
        stringText=setstringText();
        imageView= setimageView();
        jsonText=setjsonText();
        addView(stringText);
        addView(imageView);
        addView(jsonText);
    }
    public TextView setstringText(){
        TextView v = new TextView(getContext());
        v.setId(GenerateViewId.get());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,ruler.getH(25));
        v.setLayoutParams(params);
        v.setTextSize(ruler.getTextSize(10));
        return v;
    }
    public ImageView setimageView(){
        ImageView v = new ImageView(getContext());
        v.setId(GenerateViewId.get());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ruler.getW(20),ruler.getH(20));
        v.setLayoutParams(params);
        return v;
    }
    public TextView setjsonText(){
        {
            TextView v = new TextView(getContext());
            v.setId(GenerateViewId.get());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ruler.getH(25));
            v.setLayoutParams(params);
            v.setTextSize(ruler.getTextSize(10));
            return v;
        }
    }

}
