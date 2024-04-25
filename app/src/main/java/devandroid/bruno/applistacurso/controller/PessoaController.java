package devandroid.bruno.applistacurso.controller;

import android.content.SharedPreferences;

import devandroid.bruno.applistacurso.model.Pessoa;
import devandroid.bruno.applistacurso.view.MainActivity;

public class PessoaController {

    public static final String NOME_PREFERENCES = "pref_listacurso";
    SharedPreferences preferences;
    private SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public Pessoa salvar(Pessoa dto) {
        listaVip.putString("primeiroNome", dto.getPrimeiroNome());
        listaVip.putString("segundoNome", dto.getSegundoNome());
        listaVip.putString("cursoDesejado", dto.getCursoDesejado());
        listaVip.putString("telefoneContato", dto.getTelefoneContato());
        listaVip.apply();
        return dto;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

    public Pessoa recuperar() {
        Pessoa pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSegundoNome(preferences.getString("segundoNome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }
}
