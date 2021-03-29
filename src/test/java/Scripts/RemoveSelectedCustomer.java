package Scripts;

import Util.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RemoveSelectedCustomer extends Web {

    WebElement identifier;
    Select select;

    public void removeSelected() throws InterruptedException {

        voltarTelaInicial();
        buscaCustomerByName();
        marcaCheck();
        deletar();
        validaPopup();
        deletarRegistro();
        validaExclusao();
    }

    private void voltarTelaInicial(){
        startStep("Volta para a Tela inicial de listagem");

        identifier = webDriver.findElement(By.xpath("//a[contains(text(),'Go back to list')]"));
        identifier.click();
        identifier = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//form[@id='gcrud-search-form']/div"))));

        stopStep();
    }

    private void buscaCustomerByName(){
        startStep("Buusca o customer pelo nome");

        identifier = webDriver.findElement(By.xpath("//input[@name='customerName']"));
        identifier.sendKeys("Teste Sicredi");

        stopStep();
    }

    private void marcaCheck() throws InterruptedException {
        startStep("Marca a caixa de seleção");

        Thread.sleep(3000);
        identifier = webDriver.findElement(By.xpath("//input[@type='checkbox']"));
        identifier.click();

        stopStep();
    }

    private void deletar() {
        startStep("Clica para deletar");

        identifier = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[contains(.,'Delete')]"))));
        identifier.click();

        stopStep();
    }

    private void validaPopup() {
        startStep("Valida a mensagem do Popup");

        identifier = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector(".alert-delete-multiple-one"))));
        Assert.assertEquals("Are you sure that you want to delete this 1 item?", identifier.getText());

        stopStep();
    }

    private void deletarRegistro() {
        startStep("clica no botao deletar");

        identifier = webDriver.findElement(By.cssSelector(".delete-multiple-confirmation-button"));
        identifier.click();

        stopStep();
    }

    private void validaExclusao() {
        startStep("Valida a mensagem de exclusao");

        identifier = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert")));
        identifier = webDriver.findElement(By.xpath("//div[@data-growl='container']/span[@data-growl='message']"));
        Assert.assertEquals("Your data has been successfully deleted from the database.", identifier.getText());

        stopStep();
    }
}