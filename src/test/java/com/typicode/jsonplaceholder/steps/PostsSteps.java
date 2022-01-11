package com.typicode.jsonplaceholder.steps;

import com.google.gson.Gson;
import com.typicode.jsonplaceholder.api.ApiHeaders;
import com.typicode.jsonplaceholder.api.ApiRequest;
import com.typicode.jsonplaceholder.pojo.Posts;
import com.typicode.jsonplaceholder.utils.PropertiesUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class PostsSteps extends ApiRequest {

    PropertiesUtils prop = new PropertiesUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Posts posts;

    private static final String POSTS_ENDPOINT = "/posts";

    @Dado("que estou no sistema JSONPlaceholder")
    public void queEstouNoSistemaJSONPlaceholder() {
        super.uri = prop.getProp("uri_jsonplaceholder") + POSTS_ENDPOINT;
        super.headers = apiHeaders.jsonPlaceHeaders();
    }

    @Quando("crio um post com dados validos")
    public void crioUmPostComDadosValidos() {
        posts = Posts.builder().
                userId(1).
                id(101).
                tittle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit").
                body("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto").
                build();

        super.body = new JSONObject(new Gson().toJson(posts));
        super.POST();
    }

    @Entao("o post deve ser criado corretamente")
    public void oPostDeveSerCriadoCorretamente() {
        assertEquals(posts, response.jsonPath().getObject("", Posts.class));
    }

    @E("o status code do request deve ser {int}")
    public void oStatusCodeDoRequestDeveSer(int statusEsperado) {
        assertEquals(statusEsperado, response.getStatusCode());
    }

    @Quando("busco um post ja existente")
    public void buscoUmPostJaExistente() {
        posts = Posts.builder().
                userId(1).
                id(1).
                body("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto").
                build();
        super.uri = prop.getProp("uri_jsonplaceholder") + POSTS_ENDPOINT + "/" + posts.getId();
        super.body = new JSONObject();
        super.GET();
    }

    @Entao("os dados do post devem ser retornados")
    public void osDadosDoPostDevemSerRetornados() {
        assertEquals(posts, response.jsonPath().getObject("", Posts.class));
    }

    @E("existe um post na api")
    public void existeUmPostNaApi() {
        buscoUmPostJaExistente();
    }

    @Quando("altero os dados do post")
    public void alteroOsDadosDoPost() {
        posts.setTittle("sunt aut facere repellat provident occaecati");
        posts.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum");
        super.body = new JSONObject(new Gson().toJson(posts));
        super.PUT();
    }

    @Entao("o post deve ser alterado com sucesso")
    public void oPostDeveSerAlteradoComSucesso() {
        assertEquals(posts, response.jsonPath().getObject("", Posts.class));
    }

    @Quando("altero um ou mais dados do post")
    public void alteroUmOuMaisDadosDoPost() {
        posts.setTittle("sunt");
        super.body = new JSONObject(new Gson().toJson(posts));
        super.PATCH();
    }

    @Quando("deleto esse post")
    public void deletoEssePost() {
        buscoUmPostJaExistente();
        super.body = new JSONObject();
        super.DELETE();
    }

    @Entao("o post deve ser deletado com sucesso")
    public void oPostDeveSerDeletadoComSucesso() {
        assertEquals("{\n    \n}", response.asString());
    }

    @Quando("busco por um post com id invalido")
    public void buscoPorUmPostComIdInvalido() {
        int id = 102;
        super.uri = prop.getProp("uri_jsonplaceholder") + POSTS_ENDPOINT + "/" + id;
        super.body = new JSONObject();
        super.GET();
    }

    @Entao("os dados do post nao devem ser retornados")
    public void osDadosDoPostNaoDevemSerRetornados() {
        assertEquals("{\n    \n}", response.asString());
    }

}
