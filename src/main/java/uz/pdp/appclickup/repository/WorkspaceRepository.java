package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.WorkSpace;

import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<WorkSpace,Long> {
    boolean existsByOwnerIdAndName(UUID owner_id, String name);
}
