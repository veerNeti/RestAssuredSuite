package com.example.runner;

import com.example.config.TestConfig;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.qameta.allure.Allure.step;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 09:04 PM
 */
public class RunTheTestSuite extends TestConfig {

    @Parameters("api")
    @BeforeClass
    @Step("Setup RestAssured API")
    /*public void setUp(@Optional("football") String pickSerive, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest( ).getName( );
        logger = LogManager.getLogger(testName);
        logger.info("pickSerive:" + pickSerive);*/

    public void setUp(@Optional("ReqRes") String pickSerive, ITestContext ctx) {
        step("starting :" + pickSerive);
        if (StringUtils.equalsIgnoreCase("football", pickSerive)) {
            setupFootBallAPIRequestSpec( );
            setupFootBallAPIResponseSpec( );
        } else if (StringUtils.equalsIgnoreCase("ReqRes", pickSerive)) {
            setupReqResFakeAPIRequestSpec( );
            setupReqResFakeResponseSpec( );
        }
    }
}
