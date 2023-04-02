package uz.pdp.appclickup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsLongEntity;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpace extends AbsLongEntity {
    @Column(nullable = false)
    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private User owner;
    @Column(nullable = false)
    private String initialLetter;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

}
