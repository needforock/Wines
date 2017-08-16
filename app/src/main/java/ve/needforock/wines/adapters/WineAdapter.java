package ve.needforock.wines.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ve.needforock.wines.R;
import ve.needforock.wines.models.Wine;
import ve.needforock.wines.queries.Query;

/**
 * Created by Soporte on 14-Aug-17.
 */

public class WineAdapter  extends RecyclerView.Adapter<WineAdapter.ViewHolder>{

    private List<Wine> wines = new Query().wines();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Wine wine = wines.get(position);
        holder.nameTv.setText(wine.getName());
        holder.typeTv.setText(wine.getType());
        holder.yearsTv.setText(wine.getAge());

    }

    @Override
    public int getItemCount() {

        return wines.size();
    }

    public void update(Wine wine){
        wines.add(wine);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{


        private TextView nameTv, yearsTv, typeTv;

        public ViewHolder(View itemView) {
            super(itemView);


            nameTv = (TextView) itemView.findViewById(R.id.nameTv);
            yearsTv = (TextView) itemView.findViewById(R.id.yearsTv);
            typeTv = (TextView) itemView.findViewById(R.id.typeTv);
        }
    }

}
