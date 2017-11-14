package gxf.dev.topology.contoller;

import gxf.dev.topology.entity.Node;
import gxf.dev.topology.service.TopologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author:gongxufan
 * date:11/13/17
 **/
@RestController
public class TopologyManagerContoller {

    private Logger logger = LoggerFactory.getLogger(TopologyManagerContoller.class);
    @Autowired
    private TopologyService topologyService;

    @RequestMapping(value = "/addNode")
    public Object addNode() {
        logger.debug("addNode...");
        Node node = new Node();
        node.setId("1");
        node.setDisplayName("test");
        return topologyService.saveNode(node);
    }


    @RequestMapping(value = "/getNodes")
    public Object getNodes(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        logger.debug("getNodes...");
        return topologyService.getAll();
    }
}
