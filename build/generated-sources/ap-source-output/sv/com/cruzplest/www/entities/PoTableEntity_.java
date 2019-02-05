package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.entities.IndicatorpoEntity;
import sv.com.cruzplest.www.entities.MeasurementunitsEntity;
import sv.com.cruzplest.www.entities.StrategicareasEntity;
import sv.com.cruzplest.www.entities.UsersEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-05T10:15:57")
@StaticMetamodel(PoTableEntity.class)
public class PoTableEntity_ { 

    public static volatile SingularAttribute<PoTableEntity, MeasurementunitsEntity> unidad;
    public static volatile SingularAttribute<PoTableEntity, IndicatorpoEntity> indicatores;
    public static volatile SingularAttribute<PoTableEntity, UsersEntity> encargado;
    public static volatile SingularAttribute<PoTableEntity, StrategicareasEntity> areaest;
    public static volatile ListAttribute<PoTableEntity, ConsolidatorpoEntity> consolidatorpoEntityList;
    public static volatile SingularAttribute<PoTableEntity, Integer> codigopo;
    public static volatile SingularAttribute<PoTableEntity, String> actividad;
    public static volatile SingularAttribute<PoTableEntity, Integer> metaGlobal;

}