package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CedulasConfirmadas;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(Requerente.class)
public class Requerente_ { 

    public static volatile SingularAttribute<Requerente, String> distrito;
    public static volatile SingularAttribute<Requerente, String> naturalidade;
    public static volatile SingularAttribute<Requerente, String> telefone;
    public static volatile SingularAttribute<Requerente, String> scannerCertidao;
    public static volatile SingularAttribute<Requerente, String> nomePai;
    public static volatile SingularAttribute<Requerente, Date> dataRequerimento;
    public static volatile SingularAttribute<Requerente, String> nome;
    public static volatile SingularAttribute<Requerente, Date> dataNascimento;
    public static volatile ListAttribute<Requerente, CedulasConfirmadas> cedulasConfirmadasList;
    public static volatile SingularAttribute<Requerente, String> nomeMae;
    public static volatile SingularAttribute<Requerente, String> email;
    public static volatile SingularAttribute<Requerente, Integer> idRequerente;

}