package uz.pdp.appclickup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.WorkspaceDTO;
import uz.pdp.appclickup.security.CurrentUser;
import uz.pdp.appclickup.service.WorkspaceService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;
    @PostMapping
    HttpEntity<?> addWorkSpace(@RequestBody WorkspaceDTO workspaceDTO, @CurrentUser User user){
        ApiResponse apiResponse = null;
        try {
            apiResponse = workspaceService.addWorkspace(workspaceDTO,user);
        return   ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("{/id}")
    HttpEntity<?> editWorkSpace(@PathVariable Long id,@RequestBody WorkspaceDTO workspaceDTO){
        ApiResponse apiResponse = workspaceService.editWorkspace(id,workspaceDTO);
        return   ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/changeOwner{/id}")
    HttpEntity<?> changeOwner(@PathVariable Long id, @RequestParam UUID ownerId){
        ApiResponse apiResponse = workspaceService.changeOwnerWorkspace(id,ownerId);
        return   ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("{/id}")
    HttpEntity<?> deleteWorkspace(@PathVariable Long id){
        ApiResponse apiResponse = workspaceService.deleteWorkspace(id);
        return   ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
