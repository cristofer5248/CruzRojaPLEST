package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.PoTableEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-24T19:11:33")
@StaticMetamodel(IndicatorpoEntity.class)
public class IndicatorpoEntity_ { 

    public static volatile SingularAttribute<IndicatorpoEntity, Integer> codigoind;
    public static volatile SingularAttribute<IndicatorpoEntity, Integer> tipou;
    public static volatile ListAttribute<IndicatorpoEntity, PoTableEntity> poTableEntityList;
    public static volatile SingularAttribute<IndicatorpoEntity, String> detalle;

}