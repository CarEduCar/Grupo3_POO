package Classes;

import java.util.HashSet;
import java.util.Set;

public class CpfUtil {

    protected static Set<String> cpfs = new HashSet<>();

    public static void verificarDuplicado(String cpf){
        if (cpfs.contains(cpf)){
            throw new IllegalArgumentException(("CPF já cadastrado no sistema."));
        }
        cpfs.add(cpf);
    }
}
