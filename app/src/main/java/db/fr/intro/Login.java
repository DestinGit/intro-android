package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextLogin;
    private EditText editTextPwd;
    private Button buttonValider;
    private Button buttonAnnuler;
    private CheckBox checkBoxVivant;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Associer les variables aux ID représentant les éléments du DOM (view)
        textViewMessage = (TextView)findViewById(R.id.textViewMessage);

        editTextLogin = (EditText)findViewById(R.id.editTextLogin);
        editTextPwd = (EditText)findViewById(R.id.editTextPwd);

        buttonValider = (Button)findViewById(R.id.buttonValider);
        buttonAnnuler = (Button)findViewById(R.id.buttonAnnuler);

        checkBoxVivant = (CheckBox)findViewById(R.id.checkBoxVivant);

        // Binder les boutons aux évènements onClick
        buttonValider.setOnClickListener(this);
        buttonAnnuler.setOnClickListener(this);
        checkBoxVivant.setOnClickListener(this);

        checkOfCheckBox();
    }

    @Override
    public void onClick(View v) {
        Log.e("onClick","onClick");
        String login = "Destin", pwd = "123";
        if (v == buttonValider) {
            if(editTextLogin.getText().toString().equals(login) && editTextPwd.getText().toString().equals(pwd)) {
                textViewMessage.setText("Vous êtes connecté");
            } else {
                textViewMessage.setText("La connexion a échoué. Vérifier vos identifiants");
            }
        }
        if (v == checkBoxVivant) {
            checkOfCheckBox();
        }
    }

    private void checkOfCheckBox() {
        if (checkBoxVivant.isChecked()) {
            editTextPwd.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            editTextPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}
