package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListeView1 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_view1);

        String[] tVilles = {"Paris", "Marseille", "Lyon", "Nice"};

        liste = (ListView)findViewById(R.id.liste);

        liste.setOnItemClickListener(this);

        ArrayAdapter<String> aaListe = new ArrayAdapter<String>(this, R.layout.ligne_avec_image, R.id.etiquette, tVilles);
        liste.setAdapter(aaListe);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String lsChoix = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, lsChoix, Toast.LENGTH_SHORT).show();
    }
}
