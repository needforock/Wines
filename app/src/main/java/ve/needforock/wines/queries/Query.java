package ve.needforock.wines.queries;

import java.util.ArrayList;
import java.util.List;

import ve.needforock.wines.models.Wine;

/**
 * Created by Soporte on 14-Aug-17.
 */

public class Query {
    public List<Wine> wines(){
        List<Wine> wines = new ArrayList<>();
        List<Wine> wineList = Wine.listAll(Wine.class);

        if(wineList != null && wineList.size()>0){
            wines.addAll(wineList);
        }
        return wines;
    }
}
