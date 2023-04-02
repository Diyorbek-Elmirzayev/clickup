package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.WorkspaceRoleName;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceUser extends AbsUUIDEntity {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkSpace workSpace;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkSpaceRole workSpaceRole;
    @Column(nullable = false)
    private Timestamp dateInvited;
    private Timestamp dateJoined;


}
