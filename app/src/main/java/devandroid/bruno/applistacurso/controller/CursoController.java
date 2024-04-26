package devandroid.bruno.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.bruno.applistacurso.model.Curso;

public class CursoController {
    private ArrayList<Curso> listCursos;

    public ArrayList<Curso> getListCursos() {
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Kotlin"));
        listCursos.add(new Curso("Swift"));
        listCursos.add(new Curso("Dart"));

        return listCursos;
    }

    public ArrayList<String> getListNomeCursos() {
        ArrayList<String> listNomeCursos = new ArrayList<String>();

        for (int i = 0; i < getListCursos().size(); i++){
            listNomeCursos.add(getListCursos().get(i).getNome());
        }

        return listNomeCursos;
    }
}
