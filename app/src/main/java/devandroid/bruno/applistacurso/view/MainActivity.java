package devandroid.bruno.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import devandroid.bruno.applistacurso.R;
import devandroid.bruno.applistacurso.controller.CursoController;
import devandroid.bruno.applistacurso.controller.PessoaController;
import devandroid.bruno.applistacurso.model.Curso;
import devandroid.bruno.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    PessoaController pessoaController;
    CursoController cursoController;
    ArrayList<String> listaDeCursos;
    EditText editNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinnerCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoaController = new PessoaController(MainActivity.this);
        cursoController = new CursoController();

        listaDeCursos = cursoController.getListNomeCursos();

        editNome = findViewById(R.id.editNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        spinnerCursos = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDeCursos);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinnerCursos.setAdapter(adapter);

        Pessoa pessoaReturn = pessoaController.recuperar();

        editNome.setText(pessoaReturn.getPrimeiroNome().toString());
        editSobreNome.setText(pessoaReturn.getSegundoNome().toString());
        editNomeCurso.setText(pessoaReturn.getCursoDesejado().toString());
        editTelefone.setText(pessoaReturn.getTelefoneContato().toString());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNome.setText("");
                editSobreNome.setText("");
                editNomeCurso.setText("");
                editTelefone.setText("");

               pessoaController.limpar();
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editNome.getText().toString());
                pessoa.setSegundoNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Pessoa pessoaResponse = pessoaController.salvar(pessoa);

                Toast.makeText(MainActivity.this, "Salvo "+pessoaResponse.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}