package steps;

import pages.ResearchAmazonPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ResearchAmazonSteps {

    ResearchAmazonPage researchAmazonPage = new ResearchAmazonPage();

    @Dado("que eu acesse o site da Amazon")
    public void que_eu_acesse_o_site_da_amazon() {
        researchAmazonPage.acessarSiteAmazon();
    }

    @Dado("que eu selecione o idioma Portugues")
    public void que_eu_selecione_o_idioma_Portugues() {
        researchAmazonPage.selecionarIdiomaPortugues();
    }

    @Dado("que eu pesquise o produto desejado {string}")
    public void queEuPesquiseOProdutoDesejado(String produtoPesquisar) {
        researchAmazonPage.pesquisarProdutoDesejado(produtoPesquisar);
    }

    @Quando("seleciono o tamanho dos produtos")
    public void selecionoOTamanhoDosProdutos() {
        researchAmazonPage.selecionarTamanhoProdutos();
    }

    @Quando("ordeno o tipo de exibicao dos produtos")
    public void ordenoOTipoDeExibicaoDosProdutos() {
        researchAmazonPage.ordernarExibicaoProdutos();
    }

    @Quando("clico no produto para visualizar")
    public void clicoNoProdutoParaVisualizar() { researchAmazonPage.visualizarProduto(); }

    @Entao("a navegacao foi realizada com sucesso")
    public void a_navegacao_foi_realizada_com_sucesso() {
        researchAmazonPage.navegacaoFinalizadaComSucesso();
    }
}
