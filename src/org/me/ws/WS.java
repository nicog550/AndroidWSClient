package org.me.ws;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class WS extends Activity {

    private String dataIni, dataFi, places;
    private TextView txt;
    /** Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ScrollView scr = new ScrollView(this);
        txt = new TextView(this);
        WSA wsa = new WSA();
        dataIni = "2014-01-02";
        dataFi = "2014-01-03";
        places = "2";
        txt.setText("Disponibilitat entre les dates " + dataIni + " i " + dataFi + " per " + places + " places:\n");
        txt.append(wsa.cercarDisponibilitat(dataIni, dataFi, places));
        scr.addView(txt);
        setContentView(scr);
    }
    
}
