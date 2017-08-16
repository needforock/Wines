package ve.needforock.wines;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import ve.needforock.wines.models.Wine;

public class MainActivity extends AppCompatActivity {

    private WineFragment wineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wineFragment = (WineFragment) getSupportFragmentManager().findFragmentById(R.id.winefragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.new_wine_dialog);

                ImageButton saveBtn  = (ImageButton) dialog.findViewById(R.id.saveWineBtn);
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText nameEt = (EditText) dialog.findViewById(R.id.nameEt);
                        String wineName = nameEt.getText().toString();
                        EditText typeEt = (EditText) dialog.findViewById(R.id.typeEt);
                        String wineType = typeEt.getText().toString();
                        EditText ageEt = (EditText) dialog.findViewById(R.id.ageEt);
                        String wineAge = ageEt.getText().toString();

                        if(wineName.trim().length()>0 && wineType.trim().length()>0 && wineAge.trim().length()>0){
                            Wine wine = new Wine();
                            wine.setName(wineName);
                            wine.setType(wineType);
                            wine.setAge(wineAge);

                            wine.save();

                            wineFragment.updateList(wine);
                        }

                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
