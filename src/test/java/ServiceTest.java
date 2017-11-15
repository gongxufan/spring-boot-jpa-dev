import gxf.dev.topology.Application;
import gxf.dev.topology.entity.Node;
import gxf.dev.topology.repository.CustomSqlDao;
import gxf.dev.topology.service.TopologyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:gongxufan
 * date:11/13/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ServiceTest {
    @Autowired
    private TopologyService topologyService;

    @Autowired
    private CustomSqlDao customSqlDao;
    @Test
    public void testNode() {
        Node node = new Node();
        node.setId("node:2");
        node.setDisplayName("test1");
        topologyService.saveNode(node);
    }

    @Test
    public void testNative(){
        System.out.println(customSqlDao.querySqlObjects("select * from node"));
        System.out.println(customSqlDao.getMaxColumn("id","node"));
    }

    @Test
    public void count(){
        customSqlDao.getCount("node");
    }
}
