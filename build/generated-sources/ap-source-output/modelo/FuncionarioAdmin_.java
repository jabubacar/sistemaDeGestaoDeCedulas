package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioAceite;
import modelo.FuncionarioNormalExcluido;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(FuncionarioAdmin.class)
public class FuncionarioAdmin_ { 

    public static volatile SingularAttribute<FuncionarioAdmin, String> distrito;
    public static volatile SingularAttribute<FuncionarioAdmin, String> telefone;
    public static volatile SingularAttribute<FuncionarioAdmin, String> scannerBI;
    public static volatile SingularAttribute<FuncionarioAdmin, String> nome;
    public static volatile SingularAttribute<FuncionarioAdmin, Integer> idFuncionario;
    public static volatile SingularAttribute<FuncionarioAdmin, String> provincia;
    public static volatile ListAttribute<FuncionarioAdmin, FuncionarioNormalExcluido> funcionarioNormalExcluidoList;
    public static volatile SingularAttribute<FuncionarioAdmin, String> naturalidade;
    public static volatile SingularAttribute<FuncionarioAdmin, String> nomeUsuario;
    public static volatile SingularAttribute<FuncionarioAdmin, String> senha;
    public static volatile SingularAttribute<FuncionarioAdmin, String> nrBI;
    public static volatile SingularAttribute<FuncionarioAdmin, String> nomePai;
    public static volatile SingularAttribute<FuncionarioAdmin, String> sexo;
    public static volatile SingularAttribute<FuncionarioAdmin, Date> dataNascimento;
    public static volatile ListAttribute<FuncionarioAdmin, FuncionarioAceite> funcionarioAceiteList;
    public static volatile SingularAttribute<FuncionarioAdmin, String> nomeMae;
    public static volatile SingularAttribute<FuncionarioAdmin, String> email;

}