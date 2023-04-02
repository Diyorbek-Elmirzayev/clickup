package uz.pdp.appclickup.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbsUUIDEntity extends AbsMainEntity{
    @Id
    @GeneratedValue(generator = "uuid_my_id")
    @GenericGenerator(name = "uuid_my_id", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

}
