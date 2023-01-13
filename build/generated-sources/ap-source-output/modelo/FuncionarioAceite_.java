package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioAdmin;
import modelo.RequerimentoFuncionarioNormal;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(FuncionarioAceite.class)
public class FuncionarioAceite_ { 

    public static volatile SingularAttribute<FuncionarioAceite, String> distrito;
    public static volatile SingularAttribute<FuncionarioAceite, String> telefone;
    public static volatile SingularAttribute<FuncionarioAceite, String> nome;
    public static volatile SingularAttribute<FuncionarioAceite, String> userName;
    public static volatile SingularAttribute<FuncionarioAceite, String> provincia;
    public static volatile SingularAttribute<FuncionarioAceite, FuncionarioAdmin> idFuncionario;
    public static volatile SingularAttribute<FuncionarioAceite, RequerimentoFuncionarioNormal> idRequerimentoFunc;
    public static volatile SingularAttribute<FuncionarioAceite, Integer> senha;
    public static volatile SingularAttribute<FuncionarioAceite, String> naturalidade;
    public static volatile SingularAttribute<FuncionarioAceite, String> nrBi;
    public static volatile SingularAttribute<FuncionarioAceite, String> nomePai;
    public static volatile SingularAttribute<FuncionarioAceite, String> sexo;
    public static volatile SingularAttribute<FuncionarioAceite, Date> dataNascimento;
    public static volatile SingularAttribute<FuncionarioAceite, String> nomeMae;
    public static volatile SingularAttribute<FuncionarioAceite, String> email;

}