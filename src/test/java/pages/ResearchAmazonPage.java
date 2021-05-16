package pages;

import maps.ResearchAmazonElementMap;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.DriverInitializer;

public class ResearchAmazonPage extends ResearchAmazonElementMap {

    WebDriver webDriver = null;

    public void acessarSiteAmazon() {
        webDriver = DriverInitializer.getDriver("chrome");
        webDriver.manage().window().maximize();
        webDriver.get("https://www.amazon.com/");
    }

    public void selecionarIdiomaPortugues() {
        Actions actions = new Actions(webDriver);

        WebElement btnSelecaoIdioma = webDriver.findElement(By.id(byIdBtnSelecaoIdioma));
        btnSelecaoIdioma.click();

        WebElement radIdiomaPortugues = webDriver.findElement(By.xpath(byValueRadIdiomaPortugues));
        actions.moveToElement(radIdiomaPortugues).click().perform();

        WebElement btnSalvarAteracoes = webDriver.findElement(By.id(byIdBtnSalvarAteracoes));
        actions.moveToElement(btnSalvarAteracoes).click().perform();
    }

    public void pesquisarProdutoDesejado(String produtoPesquisar) {
        WebElement txtPesquisarProduto = webDriver.findElement(By.id(byIdTxtPesquisarProduto));
        txtPesquisarProduto.sendKeys(produtoPesquisar);

        WebElement btnPesquisarProduto = webDriver.findElement(By.id(byIdBtnPesquisarProduto));
        btnPesquisarProduto.click();
    }

    public void selecionarTamanhoProdutos() {
        JavascriptExecutor jsx = (JavascriptExecutor) webDriver;
        jsx.executeScript("window.scrollBy(0,1500)", "");

        WebElement btnTamanhoProduto = webDriver.findElement(By.id(byIdBtnTamanhoProduto));
        btnTamanhoProduto.click();
    }

    public void ordernarExibicaoProdutos() {
        WebElement btnOrdernarExibicao = webDriver.findElement(By.id(byIdBtnOrdernarExibicao));
        btnOrdernarExibicao.click();

        WebElement cboTamanhoProduto = webDriver.findElement(By.id(byIdCboTamanhoProduto));
        cboTamanhoProduto.click();
    }

    public void visualizarProduto() {
        WebElement btnVisualizarProduto = webDriver.findElement(By.xpath(byValueVisualizarProduto));
        btnVisualizarProduto.click();
    }

    public void navegacaoFinalizadaComSucesso() { webDriver.quit(); }
}
