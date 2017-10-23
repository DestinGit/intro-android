package db.fr.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class acteur1 extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextPrenom;
    private Button buttonValider;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acteur1);

        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        buttonValider = (Button) findViewById(R.id.buttonValider);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);

        buttonValider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        textViewMessage.setText(editTextPrenom.getText().toString());
    }
}
