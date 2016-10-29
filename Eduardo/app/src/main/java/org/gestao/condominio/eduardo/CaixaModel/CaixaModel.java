package org.gestao.condominio.eduardo.CaixaModel;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Eduardo on 30/09/2016.
 */
@Table(name = "Caixa")
public class CaixaModel extends Model implements Serializable {

    private Long myId;

    @Column(name = "Gerente")
    private String Gerente;

    @Column(name = "CodeCaixa")
    private String codcaixa;

    @Column(name = "Data")
    private String data;


    @Column(name = "Hora")
    private String hora;

    public CaixaModel() {

        super();
    }

    public CaixaModel(String gerente, String codcaixa, String data, String hora) {
        Gerente = gerente;
        this.codcaixa = codcaixa;
        this.data = data;
        this.hora = hora;
    }

    public CaixaModel findById(){
        return new Select()
                .from(CaixaModel.class)
                .where("id = ?", myId)
                .executeSingle();
    }


    public List<CaixaModel> findAll() {
        return new Select().from(CaixaModel.class).execute();
    }


    public Long getMyId() {
        return myId;
    }

    public void setMyId() {
        this.myId = getId();
    }

    public String getGerente() {
        return Gerente;
    }

    public void setGerente(String gerente) {
        Gerente = gerente;
    }

    public String getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(String codcaixa) {
        this.codcaixa = codcaixa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
