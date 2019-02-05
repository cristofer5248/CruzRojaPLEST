package sv.com.cruzplest.www.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.cruzplest.www.entities.TypenotiEntity;
import sv.com.cruzplest.www.entities.UsersEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-05T10:15:57")
@StaticMetamodel(NotificationsEntity.class)
public class NotificationsEntity_ { 

    public static volatile SingularAttribute<NotificationsEntity, String> descripcion;
    public static volatile SingularAttribute<NotificationsEntity, TypenotiEntity> tipo;
    public static volatile SingularAttribute<NotificationsEntity, Integer> codigonoti;
    public static volatile SingularAttribute<NotificationsEntity, UsersEntity> usuario;

}