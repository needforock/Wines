package ve.needforock.wines;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ve.needforock.wines.adapters.WineAdapter;
import ve.needforock.wines.models.Wine;

/**
 * A placeholder fragment containing a simple view.
 */
public class WineFragment extends Fragment {

    WineAdapter wineAdapter;

    public WineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.wineRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        wineAdapter = new WineAdapter();
        recyclerView.setAdapter(wineAdapter);

    }

    public void updateList(Wine wine){
        wineAdapter.update(wine);
    }
}
