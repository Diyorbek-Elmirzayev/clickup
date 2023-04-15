package uz.pdp.appclickup.payload;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WorkspaceDTO {
    private String name;
    private String color;
    private UUID avatarId;
}
