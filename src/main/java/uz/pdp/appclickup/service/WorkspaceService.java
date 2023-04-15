package uz.pdp.appclickup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.Attachment;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.WorkSpace;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspaceDTO;
import uz.pdp.appclickup.repository.AttachmentRepository;
import uz.pdp.appclickup.repository.WorkspaceRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    private final AttachmentRepository attachmentRepository;

    public ApiResponse addWorkspace(WorkspaceDTO workspaceDTO, User user) throws InstantiationException, IllegalAccessException {
        boolean exists = workspaceRepository.existsByOwnerIdAndName(user.getId(), workspaceDTO.getName());
        if (exists) {
            return new ApiResponse("Sizda bunday nomli ishxona mavjud", false);
        }
        WorkSpace workSpace = new WorkSpace(
                workspaceDTO.getName(),
                workspaceDTO.getColor(),
                user,
                workspaceDTO.getName().substring(0, 1),
                (workspaceDTO.getAvatarId() == null) ? null
                        : attachmentRepository.findById(workspaceDTO.getAvatarId()).orElse(new Attachment())
        );
        workspaceRepository.save(workSpace);
        return new ApiResponse("Successfully added", true);
    }

    public ApiResponse editWorkspace(Long id, WorkspaceDTO workspaceDTO) {
        return null;
    }

    public ApiResponse changeOwnerWorkspace(Long id, UUID ownerId) {
        return null;
    }

    public ApiResponse deleteWorkspace(Long id) {
        return null;
    }
}
