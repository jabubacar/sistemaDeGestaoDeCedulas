package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioNormal;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(CedulasExcluidas.class)
public class CedulasExcluidas_ { 

    public static volatile SingularAttribute<CedulasExcluidas, Integer> idCedulaExcluida;
    public static volatile SingularAttribute<CedulasExcluidas, Integer> numeroAssento;
    public static volatile SingularAttribute<CedulasExcluidas, Date> dataExclusao;
    public static volatile SingularAttribute<CedulasExcluidas, FuncionarioNormal> idFuncionario;

}