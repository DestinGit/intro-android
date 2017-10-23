package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class liste_deroulante extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerFonctions;
    private Spinner spinnerServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_deroulante);

        initInterface();
    }

    private void initInterface(){
        // --- Pour une liste deroulante a initialiser en code
        String[] tServices = { "Finances", "Commercial", "Marketing", "Informatique", "Administratif" };
        ArrayAdapter<String> aaServices;

		/*
		 * INITIALISATION DES COMPOSANTS
		 */
        spinnerFonctions = (Spinner) findViewById(R.id.spinnerFonctions);
        spinnerServices = (Spinner) findViewById(R.id.spinnerServices);

		/*
		 * REMPLISSAGE DE LA LISTE DES SERVICES
		 */
        // --- Le spinner avec les services
        aaServices = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tServices);
        aaServices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerServices.setAdapter(aaServices);

		/*
		 * GESTION EVENEMENTIELLE
		 */
        spinnerFonctions.setOnItemSelectedListener(this);
        spinnerServices.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		/*
		 * Le spinner spinnerFonctions est initialise a partir d'un tableau
		 * dans arrays.xml nomme fonctions
		 */
        if (parent == spinnerFonctions) {
            String lsFonction = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, lsFonction, Toast.LENGTH_SHORT).show();
        }

        if (parent == spinnerServices) {
            String lsService = parent.getSelectedItem().toString();
            Toast.makeText(this, lsService, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
