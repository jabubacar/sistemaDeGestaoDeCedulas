package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioAceite;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(RequerimentoFuncionarioNormal.class)
public class RequerimentoFuncionarioNormal_ { 

    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> distrito;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> telefone;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> scannerBI;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> nome;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, Integer> idRequerimentoFunc;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> naturalidade;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> nrBI;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> nomePai;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, Date> dataRequerimento;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, Date> dataNascimento;
    public static volatile ListAttribute<RequerimentoFuncionarioNormal, FuncionarioAceite> funcionarioAceiteList;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> nomeMae;
    public static volatile SingularAttribute<RequerimentoFuncionarioNormal, String> email;

}