package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioNormal;
import modelo.Requerente;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(CedulasConfirmadas.class)
public class CedulasConfirmadas_ { 

    public static volatile SingularAttribute<CedulasConfirmadas, Integer> numeroAssento;
    public static volatile SingularAttribute<CedulasConfirmadas, String> distrito;
    public static volatile SingularAttribute<CedulasConfirmadas, String> registoCivil;
    public static volatile SingularAttribute<CedulasConfirmadas, String> nomePai;
    public static volatile SingularAttribute<CedulasConfirmadas, String> nome;
    public static volatile SingularAttribute<CedulasConfirmadas, Date> dataNascimento;
    public static volatile SingularAttribute<CedulasConfirmadas, String> sexo;
    public static volatile SingularAttribute<CedulasConfirmadas, Date> dataEmissao;
    public static volatile SingularAttribute<CedulasConfirmadas, FuncionarioNormal> idFuncionario;
    public static volatile SingularAttribute<CedulasConfirmadas, String> nomeMae;
    public static volatile SingularAttribute<CedulasConfirmadas, Requerente> idRequerente;

}