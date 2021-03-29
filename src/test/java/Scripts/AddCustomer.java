package Scripts;

import Util.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomer extends Web {

    WebElement identifier;
    Select select;

    public void cadastrar(){

        mudarTemaCombo();
        clicaBtnAdd();
        preencheCamposObrigatorios();
        salvaCadastro();
        validaMsg();
    }

    private void mudarTemaCombo(){
        startStep("Seleciona o tema (Bootstrap V4)");

        identifier = webDriver.findElement(By.id("switch-version-select"));
        select = new Select(identifier);
        select.selectByVisibleText("Bootstrap V4 Theme");

        stopStep();
    }

    private void clicaBtnAdd(){
        startStep("Abre a tela de Cadastro de Customer");

        identifier = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Add Customer')]")));
        identifier.click();

        stopStep();
    }

    private void preencheCamposObrigatorios(){
        startStep("Preenche os campos obrigaorios para o caadstro");

        identifier = wait.until(ExpectedConditions.elementToBeClickable(By.id("field-customerName")));
        identifier.sendKeys("Teste Sicredi");

        identifier = webDriver.findElement(By.id("field-contactLastName"));
        identifier.sendKeys("Teste");

        identifier = webDriver.findElement(By.id("field-contactFirstName"));
        identifier.sendKeys("seu nome");

        identifier = webDriver.findElement(By.id("field-phone"));
        identifier.sendKeys("51 9999-9999");

        identifier = webDriver.findElement(By.id("field-addressLine1"));
        identifier.sendKeys("Av Assis Brasil, 3970");

        identifier = webDriver.findElement(By.id("field-addressLine2"));
        identifier.sendKeys("Torre D");

        identifier = webDriver.findElement(By.id("field-city"));
        identifier.sendKeys("Porto Alegre");

        identifier = webDriver.findElement(By.id("field-state"));
        identifier.sendKeys("RS");

        identifier = webDriver.findElement(By.id("field-postalCode"));
        identifier.sendKeys("91000-000");

        identifier = webDriver.findElement(By.id("field-country"));
        identifier.sendKeys("Brasil");

        //Clica para abrir a combo
        identifier = webDriver.findElement(By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']/a/span"));
        identifier.click();

        //Busca o Empregador
        identifier = webDriver.findElement(By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']/div/div/input"));
        identifier.sendKeys("Fixter");

        //Seleciona o 1º elemento
        identifier = webDriver.findElement(By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']/div/ul/li/em"));
        identifier.click();

        identifier = webDriver.findElement(By.id("field-creditLimit"));
        identifier.sendKeys("200");

        stopStep();
    }

    private void salvaCadastro(){
        startStep("Clica no botao de Salvar");

        identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-button-save")));
        identifier.click();

        stopStep();
    }

    private void validaMsg(){
        startStep("Valida a Mensagem");

        identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='report-success']/p")));
        Assert.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", identifier.getText());

        stopStep();
    }

}