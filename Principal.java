import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(9);
        lista.add(3);
        lista.add(1);

        System.out.println(lista);
        Collections.sort(lista);
        System.out.println(lista);
        
        ArrayList<Titulo> listaTitulos = new ArrayList<Titulo>();
        Titulo avatar = new Titulo("Avatar", 2000);
        Titulo matrix = new Titulo("Matrix", 1998);

        listaTitulos.add(matrix);
        listaTitulos.add(avatar);

        System.out.println(listaTitulos);
        Collections.sort(listaTitulos);
        System.out.println(listaTitulos);
        listaTitulos.sort(Comparator.comparing(Titulo::getAno));
        System.out.println(listaTitulos);

    }
}
