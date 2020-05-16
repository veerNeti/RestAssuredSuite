package com.example.runner;

import com.example.config.TestConfig;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 09:04 PM
 */
public class RunTheTestSuite extends TestConfig {
    @Parameters("api")
    @BeforeClass
    public void setUp(@Optional("football") String pickSerive) {
        if (StringUtils.equalsIgnoreCase("football", pickSerive)) {
            setupFootBallAPIRequestSpec( );
            setupFootBallAPIResponseSpec( );
        } else if (StringUtils.equalsIgnoreCase("ReqRes", pickSerive)) {
            setupReqResFakeAPIRequestSpec( );
            setupReqResFakeResponseSpec( );
        }
    }
}
