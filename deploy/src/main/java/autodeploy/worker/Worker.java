package autodeploy.worker;

import autodeploy.core.PlatformFactory;
import autodeploy.entity.Host;
import autodeploy.entity.Platform;
import autodeploy.entity.Service;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class Worker {
    private List<String> platformCodes;

    public Worker (List<String> platformCodes){
        this.platformCodes = platformCodes;
    }

    public void startDeploy(){
        for(String platformCode : platformCodes){
            Platform platform = PlatformFactory.createPlatform(platformCode);

            List<Service> serviceList = platform.getServiceList();

            for(Service service : serviceList){
                List<Host> hostList = service.getServiceHosts();
                /*for(Host host : hostList){
                }*/
            }

            System.out.println(JSON.toJSONString(platform));
        }
    }

    public boolean uploadServicePackage(){
        return false;
    }

    public List<String> getPlatformCodes() {
        return platformCodes;
    }

    public void setPlatformCodes(List<String> platformCodes) {
        this.platformCodes = platformCodes;
    }
}
