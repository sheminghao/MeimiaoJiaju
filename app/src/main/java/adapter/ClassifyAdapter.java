package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.meimiaojiaju.R;

import java.util.ArrayList;
import java.util.List;

import model.GoodsContextModel;
import utils.UniversalUtil;
import utils.VolleyUtils;


/**
 * Created by win 8 on 2015/11/21.
 */
public class ClassifyAdapter extends BaseAdapter {
    List<GoodsContextModel> list = new ArrayList<>();
    Context context;
    ViewHolder holder ;

    public ClassifyAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<GoodsContextModel> datas){
        list.clear();
        list.addAll(datas);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.goods_content_layout,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        UniversalUtil.downLoadImage(list.get(position).getCategoryIcon(), holder.imageView);
        VolleyUtils.requestString(list.get(position).getCategoryName(), new VolleyUtils.OnRequest() {
            @Override
            public void response(String url, String response) {
                holder.textView.setText(response);
            }

            @Override
            public void errorResponse(String url, VolleyError volleyError) {

            }
        });
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
