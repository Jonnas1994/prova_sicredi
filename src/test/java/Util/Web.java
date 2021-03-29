package Util;

import com.google.common.io.Files;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Web {

    public static WebDriver webDriver;
    protected static WebDriverWait wait;
    public static Configuracao config = new Configuracao();
    StepResult sr;
    String uuid;

    public static void opemNavegador(String url) {
        System.setProperty(Configuracao.pathWebDriver.Chrome.getDriver(), Configuracao.pathWebDriver.Chrome.getDir());
        modoExecucao(url);
    }

    private static void modoExecucao(String urlAplicacao){

        webDriver = config.getDriver();
        wait = new WebDriverWait(webDriver, 30);

        webDriver.get(urlAplicacao);
    }

    public static void closeBrowser() {
        webDriver.quit();
    }

    public static byte[] screenshot(WebDriver driver) /* throws IOException */ {
        try {

            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);

        } catch (IOException e) {
            return null;
        }
    }

    public String startStep(String name){
        sr = new StepResult();
        sr.setName(name);
        sr.setStatus(Status.PASSED);
        uuid = UUID.randomUUID().toString();

        Allure.getLifecycle().startStep(uuid, sr);
        return uuid;
    }
    public void stopStep(Status status, String uuid){

        sr.setStatus(status);
        Allure.getLifecycle().updateStep(uuid, stepResult -> stepResult.setStatus(status));
        Allure.getLifecycle().stopStep(uuid);
    }
    public void stopStep(){

        Allure.getLifecycle().stopStep(uuid);
    }
}
