package gxf.dev.topology.repository;

import gxf.dev.topology.entity.Node;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NodeRepository extends PagingAndSortingRepository<Node, String> {
}
