package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResearchAmazonElementMap {

    @FindBy(id = "icp-nav-flyout")
    protected WebElement byIdBtnSelecaoIdioma;

    @FindBy(xpath = "//input[@value='pt_BR']")
    protected WebElement byValueRadIdiomaPortugues;

    @FindBy(id = "icp-btn-save-announce")
    protected WebElement byIdBtnSalvarAteracoes;

    @FindBy(id = "twotabsearchtextbox")
    protected WebElement byIdTxtPesquisarProduto;

    @FindBy(id = "nav-search-submit-button")
    protected WebElement byIdBtnPesquisarProduto;

    @FindBy(id = "a-autoid-16")
    protected WebElement byIdBtnTamanhoProduto;

    public static String byIdBtnOrdernarExibicao = "a-autoid-0-announce";
    public static String byIdCboTamanhoProduto = "s-result-sort-select_3";
    public static String byValueVisualizarProduto = ".//div[@class='a-section a-spacing-none a-spacing-top-small']";

   /* @FindBy(id = "a-autoid-0-announce")
    protected WebElement byIdBtnOrdernarExibicao;

    @FindBy(id = "s-result-sort-select_3")
    protected WebElement byIdCboTamanhoProduto;

    @FindBy(xpath = ".//div[@class='a-section a-spacing-none a-spacing-top-small']")
    protected WebElement byValueVisualizarProduto;

    public static String byIdBtnSelecaoIdioma = "icp-nav-flyout";
    public static String byValueRadIdiomaPortugues = "//input[@value='pt_BR']";
    public static String byIdBtnSalvarAteracoes = "icp-btn-save-announce";
    public static String byIdTxtPesquisarProduto = "twotabsearchtextbox";
    public static String byIdBtnPesquisarProduto = "nav-search-submit-button";
    public static String byIdBtnTamanhoProduto = "a-autoid-16";*/
}
