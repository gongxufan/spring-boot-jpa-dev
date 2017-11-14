package gxf.dev.topology.service;

import gxf.dev.topology.entity.Node;
import gxf.dev.topology.repository.NodeRepository;
import gxf.dev.topology.repository.SceneRepository;
import gxf.dev.topology.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * dao操作
 * author:gongxufan
 * date:11/13/17
 **/
@Component
public class TopologyService {

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private SceneRepository sceneRepository;

    @Autowired
    private StageRepository stageRepository;

    @Transactional
    public Node saveNode(Node node) {
        return nodeRepository.save(node);
    }

    public Iterable<Node> getAll() {
        return nodeRepository.findAll();
    }
}
