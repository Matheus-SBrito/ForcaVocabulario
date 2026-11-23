package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {
    private XStream xstream = new XStream(new DomDriver());
    private File arquivo = new File("central.xml");

    public Persistencia() {
        // Versões novas do XStream bloqueiam tipos não autorizados
        xstream.allowTypesByWildcard(new String[] {
            "config.**", "java.util.**", "java.time.**"
        });
    }

    public void salvarCentral(Central central){
        String xml = xstream.toXML(central);

        try (PrintWriter gravar = new PrintWriter(arquivo, "UTF-8")) {
            gravar.print(xml);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public Central recuperarCentral() {
        if (arquivo.exists()) {
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                Central central = (Central) xstream.fromXML(fis);
                Central.definirInstancia(central); // a Central carregada passa a ser a única em uso
                return central;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return Central.obterInstancia();
    }
}
