package gxf.dev.topology.repository;

import gxf.dev.topology.entity.Stage;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * author:gongxufan
 * date:11/13/17
 **/
public interface SceneRepository extends PagingAndSortingRepository<Stage, String> {
}
