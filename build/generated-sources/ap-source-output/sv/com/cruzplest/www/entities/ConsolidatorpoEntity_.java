package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.PhysicalGoalEntity;
import sv.com.cruzplest.www.entities.PoTableEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-07T18:48:49")
@StaticMetamodel(ConsolidatorpoEntity.class)
public class ConsolidatorpoEntity_ { 

    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> ejecutado;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> year;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> planificado;
    public static volatile SingularAttribute<ConsolidatorpoEntity, PhysicalGoalEntity> physicalgoal;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> trimestre;
    public static volatile SingularAttribute<ConsolidatorpoEntity, String> comentario;
    public static volatile SingularAttribute<ConsolidatorpoEntity, PoTableEntity> codigoPO;
    public static volatile SingularAttribute<ConsolidatorpoEntity, Integer> codigocon;

}