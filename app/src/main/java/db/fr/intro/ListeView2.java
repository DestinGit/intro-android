package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListeView2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView textViewSelection;
    private ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_view2);

        String[] tNoms = {"Dupont","Dupond","Tintin","Milou","Casta"};
        String[] tTelephones = {"11-11-11-11-11","22-22-22-22-22","33-33-33-33-33","44-44-44-44-44","55-55-55-55-55"};

        liste = (ListView)findViewById(R.id.liste);
        textViewSelection = (TextView) findViewById(R.id.textViewSelection);

        // --- Creation de l'ArrayList pour remplir la ListView
        List<Map<String, String>> listeItems = new ArrayList();

        // --- HashMap pour les informations pour un item
        Map<String, String> hm;

        // --- Remplissage dynamique
        for(int i = 0; i < tNoms.length; i++) {
            hm = new HashMap();
            hm.put("nom", tNoms[i]);
            hm.put("telephone", tTelephones[i]);
            listeItems.add(hm);
        }

        SimpleAdapter sa = new SimpleAdapter(
                this.getBaseContext(),
                listeItems,
                R.layout.ligne_complexe,
                new String[] {"nom", "telephone"},
                new int[] {R.id.nom, R.id.telephone}
        );

        // Affectation directe du Simple Adapter a la ListView
        liste.setAdapter(sa);

        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String,String> map = (Map<String, String>) parent.getAdapter().getItem(position);

        textViewSelection.setText(map.get("nom") + " : " + map.get("telephone"));
    }
}
