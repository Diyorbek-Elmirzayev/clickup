package uz.pdp.appclickup.entity.enums;

import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    CAN_ADD_MEMBER("Add/Remove members",
            "Gives user permission to add or remove members",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_REMOVE_MEMBER("Can Remove members",
            "Gives user the permission to remove members",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_WORKSPACE("Can Edit workspace",
            "Gives user permission to edit workspace",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_GUEST("Add guest",
            "Gives user permission to add guests",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TIME_ESTIMATED("CAN_SEE_TIME_ESTIMATED",
            "Gives user permission to see time estimated",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TIME_SPENT("CAN_SEE_TIME_SPENT",
            "Gives user permission to see time spent",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_CREATE_SPACE("CAN_CREATE_SPACE",
            "Gives user permission to create space",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_FOLDER("CAN_ADD_FOLDER",
            "Gives user permission to add folder",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_LISTS("CAN_ADD_LISTS",
            "Gives user permission to add lists",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_DELETE_COMMENTS("CAN_DELETE_COMMENTS",
            "Gives user permission to delete comments",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_DELETE_ITEMS("CAN_DELETE_ITEMS",
            "Gives user permission to delete items ",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_DESCRIPTIONS("CAN_EDIT_DESCRIPTIONS",
            "Gives user permission to edit description",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_LIST_STATUS("CAN_ADD_LIST_STATUS",
            "Gives user permission to add list status",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_LIST_STATUS("CAN_EDIT_LIST_STATUS",
            "Gives user permission to edit list status",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_TEAM("CAN_EDIT_TEAM",
            "Gives user permission to edit team",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EDIT_TEAM_OWNER("CAN_EDIT_TEAM_OWNER",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_EXPORT_TASKS("CAN_EXPORT_TASKS",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_MANAGE_TASKS("CAN_MANAGE_TASKS",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_SHARE("CAN_SHARE",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_MANAGE_STATUS("CAN_MANAGE_STATUS",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_SEE_TEAM_MEMBERS("CAN_SEE_TEAM_MEMBERS",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_ADD_ROLE("CAN_ADD_ROLE",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    ),
    CAN_CHANGE_PERMISSION("CAN_CHANGE_PERMISSION",
            "Gives user permission to export tasks",
            Arrays.asList(WorkspaceRoleName.OWNER, WorkspaceRoleName.ROLE_ADMIN)
    );

    public final String name;
    public final String description;
    private final List<WorkspaceRoleName> workspaceRoleNames;

    WorkspacePermissionName(String name, String description, List<WorkspaceRoleName> workspaceRoleNames) {
        this.name = name;
        this.description = description;
        this.workspaceRoleNames = workspaceRoleNames;
    }

    public List<WorkspaceRoleName> getWorkspaceRoleNames() {
        return workspaceRoleNames;
    }
}
