package com.example.genius;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencia {
    Context contexto;
    final String ARQ_PREF = "REF";
    SharedPreferences preference;
    SharedPreferences.Editor editor;
    String chaveNome = "recorde";
    public Preferencia (Context c) {
        this.contexto = c;
        preference = contexto.getSharedPreferences(ARQ_PREF, 0);
        editor = preference.edit();
    }
    public void salvarDados(String dados)
    {
        editor.putString ( chaveNome, dados);
        editor.commit();
    }
    public String recuperarDados()
    {
        return preference.getString(chaveNome,"");
    }
}
