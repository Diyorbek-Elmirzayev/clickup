package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name","owner_id"})})
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

    public WorkSpace(String name, String color, User owner, String initialLetter, Attachment avatar) {
        this.name = name;
        this.color = color;
        this.owner = owner;
        this.initialLetter = initialLetter;
        this.avatar = avatar;
    }
}
