package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.PoTableEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-05T10:15:57")
@StaticMetamodel(MeasurementunitsEntity.class)
public class MeasurementunitsEntity_ { 

    public static volatile SingularAttribute<MeasurementunitsEntity, Integer> codigomea;
    public static volatile SingularAttribute<MeasurementunitsEntity, String> especificaciones;
    public static volatile ListAttribute<MeasurementunitsEntity, PoTableEntity> poTableEntityList;
    public static volatile SingularAttribute<MeasurementunitsEntity, String> nombre;

}