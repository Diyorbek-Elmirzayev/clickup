package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.WorkspacePermissionName;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpacePermission extends AbsLongEntity {
    @ManyToOne(fetch = FetchType.LAZY)
   private WorkSpaceRole workSpaceRole;
   @Enumerated(EnumType.STRING)
   private WorkspacePermissionName workspacePermissionName;
}
