package org.gestao.condominio.eduardo.PrestarContas;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Eduardo on 02/10/2016.
 */
@Table(name="PrestarContas")
public class PrestarContasModel extends Model implements Serializable{



    private Long myId;
    @Column(name= "Descricao")
    private String descricao;
    @Column(name = "CodigoEmpresa")
    private String codempresa;
    @Column(name = "Date")
    private String data;
    @Column(name = "Hora")
    private String hora;
    @Column(name = "Valor")
    private String valor;


    public PrestarContasModel(){
        super();
    }

    public PrestarContasModel(String descricao, String codempresa, String data, String hora, String valor) {
        this.descricao = descricao;
        this.codempresa = codempresa;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
    }

    public PrestarContasModel findById() {
        return new Select()
                .from(PrestarContasModel.class)
                .where("id = ?", myId)
                .executeSingle();
    }


    public List<PrestarContasModel> findAll() {
        return new Select().from(PrestarContasModel.class).execute();
    }

    public Long getMyId() {
        return myId;
    }

    public void setMyId() {
        this.myId = getId();
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(String codempresa) {
        this.codempresa = codempresa;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
