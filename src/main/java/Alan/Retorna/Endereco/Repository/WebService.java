package Alan.Retorna.Endereco.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WebService {
    @Autowired
    private JsonToStringConversor jsonToStringConversor;
    public void retornaEndereco(String cep) throws Exception {
        //montagem da url para requisicao na api
        String urlParaChamada = "http://viacep.com.br/ws/" + cep + "/json";

        try{
            //transformado o string em url para a requisicao
            URL url = new URL(urlParaChamada);
            //requisicao HTTP feita com o novo objeto do tipo url criado
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            //verificacao de erro
            if (conexao.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());
            }
            //novo objeto recebe a resposta da requisicao HTTP
            BufferedReader respostaService = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            //o objeto recebido é transformado de json para String
            String jsonEmString = jsonToStringConversor.conversor(respostaService);
            //String convertida é printada na tela
            System.out.println(jsonEmString);

        } catch (Exception e){
            throw new Exception("Erro: " + e);
        }
    };
}
