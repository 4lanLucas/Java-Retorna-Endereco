package Alan.Retorna.Endereco.Repository;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class JsonToStringConversor {
    public String conversor(BufferedReader bufferedReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = bufferedReader.readLine()) !=null){
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
