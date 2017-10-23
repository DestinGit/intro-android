package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Acteur2 extends AppCompatActivity implements View.OnClickListener{

    // Déclaration des varibles de classes
    // qu'on associera avec les éléments du DOM (view)
    private EditText editTextNom;
    private EditText editTextPrenom;
    private Button buttonValider;
    private Button buttonAnnuler;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acteur2);

        // Associer les variqbles aux ID représentant les éléments du DOM (view)
        textViewMessage = (TextView)findViewById(R.id.textViewMessage);
        editTextNom = (EditText) findViewById(R.id.editTextNom);
        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);

        buttonValider = (Button) findViewById(R.id.buttonValider);
        buttonAnnuler = (Button)findViewById(R.id.buttonAnnuler);

        // Binder les boutons aux évènements onClick
        buttonValider.setOnClickListener(this);
        buttonAnnuler.setOnClickListener(this);
    }

    /**
     * Gestion de l'évènement onClick
     * @param v
     */
    @Override
    public void onClick(View v) {
        // Si le click est le bouton Annuler
        if (v == buttonAnnuler) {
            // Effacer les champs de type EditText (text en html)
            editTextNom.setText(null);
            editTextPrenom.setText(null);
            textViewMessage.setText("Annuler");
        }
        // si le click est sur le bouton Valider
        if (v == buttonValider) {
            // TextView message (label en html)
            textViewMessage.setText("Valider");
        }
    }
}
