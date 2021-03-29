package TestCases;

import Util.Configuracao;
import Util.Web;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("EPIC - Adicionar  Customer")
@Feature("Verificar fluxo alternativo segundo regra de negocio RQ.234")
public class FluxoAlternativo extends Web{

    WebElement identifier;
    Select select;

    @BeforeMethod
    public void InicializaTeste() {
        opemNavegador(Configuracao.Environment.Grocerycrud.getUrl());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description="Cadastrar novo  Customer")
    @Description("Teste responsavel por cadastrar um novo Customer usando o thema (Bootstrap V4)")
    public void cadastrar() throws IOException {


    }

    @AfterMethod
    public void tearDown() {
        Web.closeBrowser();
    }

}