package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.WorkspaceRoleName;
import uz.pdp.appclickup.entity.template.AbsLongEntity;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole extends AbsUUIDEntity {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkSpace workSpace;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private WorkspaceRoleName extendRole;

}
