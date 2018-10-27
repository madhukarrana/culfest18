package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import jamshedpur.nit.culfest.com.culfest17.Widget.SingleItemModel;
import jamshedpur.nit.culfest.com.culfest17.R;
/**
 * Created by skshubhamiitkmr on 31-12-2017.
 */

public class CoreTeamSectionListDataAdapter extends RecyclerView.Adapter<CoreTeamSectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public CoreTeamSectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getName());
        holder.itemImage.setImageResource(singleItem.getImages());
        holder.email.setText(singleItem.getEmail());
        holder.phone.setText(singleItem.getPhone());
        holder.post.setText(singleItem.getPost());

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle,email,phone,post;
        protected CircleImageView itemImage;


      //  protected ImageView itemImage;


        public SingleItemRowHolder(final View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.email = (TextView) view.findViewById(R.id.email);
            this.phone = (TextView) view.findViewById(R.id.phone);

            this.post = (TextView) view.findViewById(R.id.post);

            this.itemImage = (CircleImageView) view.findViewById(R.id.itemImage);



            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                   // Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder mBuilder=new AlertDialog.Builder(v.getContext());
                    View mView=View.inflate(v.getContext(),R.layout.dialog, null);

                    ImageView iv1=(ImageView) mView.findViewById(R.id.iv1);
                    TextView tv1=(TextView) mView.findViewById(R.id.tv1);
                    final TextView tv2=(TextView) mView.findViewById(R.id.tv2);
                    final TextView tv3=(TextView) mView.findViewById(R.id.tv3);

                    final TextView tv4=(TextView) mView.findViewById(R.id.tv4);

                    tv1.setText(tvTitle.getText());
                    tv2.setText(email.getText());
                    tv3.setText(phone.getText());
                    tv4.setText(post.getText());
                    iv1.setImageDrawable(itemImage.getDrawable());
                    tv3.setPaintFlags(tv3.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                    tv2.setPaintFlags(tv2.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);



                    tv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:"+tv3.getText().toString()));
                            v.getContext().startActivity(intent);
                        }
                    });

                    tv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(Intent.ACTION_SEND);
                            intent.putExtra(Intent.EXTRA_EMAIL,new String[] {tv2.getText().toString()});
                            intent.setType("message/rfc822");
                            v.getContext().startActivity(Intent.createChooser(intent,"Choose An Email Client"));
                        }
                    });


                    mBuilder.setView(mView);
                    AlertDialog dialog=mBuilder.create();
                    dialog.show();






                }
            });


        }

    }

}
