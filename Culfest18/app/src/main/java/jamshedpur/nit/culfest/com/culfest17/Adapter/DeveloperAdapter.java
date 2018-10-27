package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import jamshedpur.nit.culfest.com.culfest17.R;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by skshubhamiitkmr on 19-12-2017.
 */

public class DeveloperAdapter extends PagerAdapter {

    List<Integer> images;
    List<String> names,email,phone;
    Context context;
    LayoutInflater layoutInflater;

    public DeveloperAdapter(List<Integer> images, List<String> names, List<String> email, List<String> phone, Context context )
    {
        this.images=images;
        this.context=context;
        this.names=names;
        this.email=email;
        this.phone=phone;
        layoutInflater=LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View)object);

    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
      View view=layoutInflater.inflate(R.layout.card_item,container,false);
      ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
      TextView tv1=(TextView)view.findViewById(R.id.tv1);
      TextView tv2=(TextView)view.findViewById(R.id.tv2);
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Regular.otf");
        final TextView tv3=(TextView)view.findViewById(R.id.tv3);
      tv1.setText(names.get(position));
      tv2.setText(email.get(position));
      tv3.setText(phone.get(position));
      tv3.setPaintFlags(tv3.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        tv1.setTypeface(typeface1);
        tv2.setTypeface(typeface1);

      tv3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(Intent.ACTION_DIAL);
              intent.setData(Uri.parse("tel:"+tv3.getText().toString()));
              v.getContext().startActivity(intent);
          }
      });

        imageView.setImageResource(images.get(position));

      container.addView(view);
      return view;

    }

}
