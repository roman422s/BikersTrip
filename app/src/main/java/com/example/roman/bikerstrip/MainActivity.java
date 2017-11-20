package com.example.roman.bikerstrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.Pot;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    public static final String PARAMETER_ACTIVITY_1="ActivityFirst_PARAMETER_ACTIVITY_1";
    private Button btn;
    private  Button btnOpen;
    private  Button btnOpenList;
    private ApplicationMy app; //Skupno stanje
    //private DataAll all; //move to ApplicationMy
    private EditText etOd, etDo, etModel, etZnamka, etLetnik, etDatum;
    private TextView etMaxH, etCasV;
    private Pot izbran;
    Integer message;

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dodadno

        btn = (Button) findViewById(R.id.btnStart);
        btnOpen = (Button) findViewById(R.id.btnOpenDrugo);
        btnOpenList = (Button) findViewById(R.id.btnOpenList);
        etOd = (EditText) findViewById(R.id.etOd);
        etDo = (EditText) findViewById(R.id.etDo);
        etMaxH = (TextView) findViewById(R.id.etMaxH);
        etCasV = (TextView) findViewById(R.id.etCasV);
        app = (ApplicationMy) getApplication();
        etZnamka = (EditText) findViewById(R.id.etZnamka);
        etModel = (EditText) findViewById(R.id.etModel);
        etLetnik = (EditText) findViewById(R.id.etLetnik);
        etDatum = (EditText) findViewById(R.id.etDatum);

        //all = DataAll.getScenarij1Data(); //testni pripravljeni podatki

        izbran = app.getAll().getPot(0); //default for test        setForma(izbran);
        //popravi(izbran);
        if (izbran!=null) {
            setForma(izbran);
        }

        //dodano
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }*/
        if (fab != null)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Nekaj naredim", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void  btnOpenListClick(View v) {
        Intent openlist = new Intent(this, MainList.class);
        startActivity(openlist);
    }

    public void btnMaps(View v) {
        Intent mp = new Intent(this, MapsActivity.class);
        String strt = etOd.getText().toString();
        String stop = etDo.getText().toString();
        mp.putExtra("zac", strt);
        mp.putExtra("konc", stop);
        mp.putExtra("message", message);

        //mp.putExtra(PARAMETER_ACTIVITY_1, etOd.getText().toString());
        startActivity(mp);
    }

    public void btnDrugiOnClick(View v) {
        Intent dva = new Intent(this, MainSecond.class);
        dva.putExtra(PARAMETER_ACTIVITY_1, etOd.getText().toString());
        startActivity(dva);
    }
    //onClick parameter method MUST have form: public void XXXX(View yy)
    public void onClickShrani(View v) {
        //it is set in content_activity_first.xml on "@+id/btnStart"
        popravi(izbran);

    }
    private void popravi(Pot p) {
        p.setKrajOd(etOd.getText().toString());
        p.setKrajDo(etDo.getText().toString());

        //p.getM().setZnamka(etZnamka.toString());
        //p.getM().setModel(etModel.toString());
        //p.getM().setLetnik(etLetnik.get);
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), p.toString(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        app.save();
    }

    //my helper method for data
    private void setForma(Pot p) {
        etOd.setText(p.getKrajOd());
        etDo.setText(p.getKrajDo());
        etMaxH.setText(Double.toString(p.getMaxHitrost()));
        etCasV.setText(Double.toString(p.getCasVoznje()));
        etZnamka.setText(p.getM().getZnamka());
        etModel.setText(p.getM().getModel());
        etLetnik.setText(Integer.toString(p.getM().getLetnik()));
        etDatum.setText(p.getDatum());

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
            Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Nekaj naredim", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            btn.setText("Nastavitve");
            return true;
        }

        if (id == R.id.action_save) {
            popravi(izbran);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent!=null) {
             message = intent.getIntExtra(AdapterPot.PARAMETER_POSITION_1,0);
            izbran = app.getAll().getPot(message); //default for test
            // add.pot
            if (izbran!=null) {
                setForma(izbran);
            }
            Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Shranim podatke:" + message,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
    }


}
