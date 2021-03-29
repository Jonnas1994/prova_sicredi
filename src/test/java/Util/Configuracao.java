package Util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configuracao {

    public static ChromeOptions chromeOptions;
    public static String resolucao;
    public static boolean modoGrafico;
    public static String urlBase;

    public Configuracao(){
        try {

            this.resolucao = "1366,768";
            this.modoGrafico =  true;
            chromeOptions = new ChromeOptions();

        }catch (Exception ex){
            new Exception("Exception message");
        }
    }

    public enum Environment
    {
        Grocerycrud("https://www.grocerycrud.com/demo/bootstrap_theme");

        private String url;
        Environment(String envUrl) {
            this.url = envUrl;
        }
        public String getUrl() {
            return url;
        }
    }

    public enum pathWebDriver
    {
        Chrome("webdriver.chrome.driver", "./drivers/chromedriver.exe"),
        Firefox("webdriver.gecko.driver", "./drivers/geckodriver.exe");

        private String dir, driver;

        pathWebDriver(String driver, String pathDriver) {
            this.dir = pathDriver;
            this.driver = driver;
        }
        public String getDir() {
            return dir;
        }
        public String getDriver() {
            return driver;
        }
    }

    public static ChromeDriver getDriver(){

        if(!modoGrafico){

            chromeOptions.addArguments("--window-size=" + resolucao);
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--headless");
        }

        return new ChromeDriver(chromeOptions);
    }

}