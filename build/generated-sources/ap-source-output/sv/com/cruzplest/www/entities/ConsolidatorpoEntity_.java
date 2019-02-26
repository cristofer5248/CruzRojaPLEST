package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.PhysicalGoalEntity;
import sv.com.cruzplest.www.entities.PoTableEntity;
import sv.com.cruzplest.www.entities.ResultsEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-24T19:11:33")
@StaticMetamodel(ConsolidatorpoEntity.class)
public class ConsolidatorpoEntity_ { 

    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> ejecutado;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> year;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> planificado;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> trimestre;
    public static volatile SingularAttribute<ConsolidatorpoEntity, PhysicalGoalEntity> physicalGoalEntity;
    public static volatile SingularAttribute<ConsolidatorpoEntity, ResultsEntity> resultsEntity;
    public static volatile SingularAttribute<ConsolidatorpoEntity, String> comentario;
    public static volatile SingularAttribute<ConsolidatorpoEntity, PoTableEntity> codigoPO;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> codigocon;

}