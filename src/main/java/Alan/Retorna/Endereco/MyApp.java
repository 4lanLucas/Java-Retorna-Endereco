package Alan.Retorna.Endereco;

import Alan.Retorna.Endereco.Repository.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyApp implements CommandLineRunner {
    @Autowired
    private WebService webService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------");
        System.out.print("digite seu cep: ");
        String cep = new Scanner(System.in).nextLine();
        webService.retornaEndereco(cep);
        System.out.println("-------");
    }
}
