package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestRule;
import maps.ResearchAmazonElementMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ResearchAmazonPage extends ResearchAmazonElementMap {

    public ResearchAmazonPage() {
        PageFactory.initElements(TestRule.getDriver(), this);
    }
    WebDriver webDriver = TestRule.getDriver();

    public void acessarSiteAmazon() { webDriver.navigate().to("https://www.amazon.com/"); }

    public void selecionarIdiomaPortugues() {
        Actions actions = new Actions(TestRule.getDriver());
        byIdBtnSelecaoIdioma.click();
        actions.moveToElement(byValueRadIdiomaPortugues).click().perform();
        actions.moveToElement(byIdBtnSalvarAteracoes).click().perform();
    }

    public void pesquisarProdutoDesejado(String produtoPesquisar) {
        byIdTxtPesquisarProduto.sendKeys(produtoPesquisar);
        byIdBtnPesquisarProduto.click();
    }

    public void selecionarTamanhoProdutos() {
        JavascriptExecutor jsx = (JavascriptExecutor) TestRule.getDriver();
        jsx.executeScript("window.scrollBy(0,1500)", "");
        byIdBtnTamanhoProduto.click();
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

    public void navegacaoFinalizadaComSucesso() {  }
}
