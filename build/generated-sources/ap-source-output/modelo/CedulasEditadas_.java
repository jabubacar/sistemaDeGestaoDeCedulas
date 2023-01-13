package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.FuncionarioNormal;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-09T10:20:46")
@StaticMetamodel(CedulasEditadas.class)
public class CedulasEditadas_ { 

    public static volatile SingularAttribute<CedulasEditadas, Integer> numeroAssento;
    public static volatile SingularAttribute<CedulasEditadas, Date> dataEdicao;
    public static volatile SingularAttribute<CedulasEditadas, Integer> idCedulaEditadas;
    public static volatile SingularAttribute<CedulasEditadas, FuncionarioNormal> idFuncionario;

}