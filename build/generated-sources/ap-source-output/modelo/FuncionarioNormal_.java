package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CedulasConfirmadas;
import modelo.CedulasEditadas;
import modelo.CedulasExcluidas;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(FuncionarioNormal.class)
public class FuncionarioNormal_ { 

    public static volatile SingularAttribute<FuncionarioNormal, String> distrito;
    public static volatile SingularAttribute<FuncionarioNormal, String> telefone;
    public static volatile SingularAttribute<FuncionarioNormal, String> scannerBI;
    public static volatile SingularAttribute<FuncionarioNormal, String> nome;
    public static volatile SingularAttribute<FuncionarioNormal, Integer> idFuncionario;
    public static volatile ListAttribute<FuncionarioNormal, CedulasConfirmadas> cedulasConfirmadasList;
    public static volatile ListAttribute<FuncionarioNormal, CedulasEditadas> cedulasEditadasList;
    public static volatile SingularAttribute<FuncionarioNormal, String> naturalidade;
    public static volatile SingularAttribute<FuncionarioNormal, String> nomeUsuario;
    public static volatile SingularAttribute<FuncionarioNormal, String> senha;
    public static volatile ListAttribute<FuncionarioNormal, CedulasExcluidas> cedulasExcluidasList;
    public static volatile SingularAttribute<FuncionarioNormal, String> nrBI;
    public static volatile SingularAttribute<FuncionarioNormal, String> nomePai;
    public static volatile SingularAttribute<FuncionarioNormal, Date> dataNascimento;
    public static volatile SingularAttribute<FuncionarioNormal, String> sexo;
    public static volatile SingularAttribute<FuncionarioNormal, String> nomeMae;
    public static volatile SingularAttribute<FuncionarioNormal, String> email;

}