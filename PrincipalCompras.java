import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PrincipalCompras {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Product> cart = new ArrayList<Product>();

        System.out.println("Digite o valor do limite do cartão: ");
        double cardLimit = Double.parseDouble(input.nextLine());

        double sumProductsCart = 0.0;

        var option = 1;
                
        while (option != 0) {
            
            System.out.println("\nQual produto deseja comprar: ");
            String productName = input.nextLine();
            
            System.out.println("Qual valor do produto: ");
            double productValue = Double.parseDouble(input.nextLine());

            if (sumProductsCart + productValue <= cardLimit) {
                Product product = new Product(productName, productValue);
                cart.add(product);
                
                sumProductsCart += productValue;
            } else {
                System.out.println("Não possui limite no cartão de crédito!!!\n");                
            }
            
            System.out.println("\nDigite 1 para continuar ou 0 para sair.");
            option = Integer.parseInt(input.nextLine());
        }

        cart.sort(Comparator.comparing(Product::getValue));

        System.out.println("**************************");
        System.out.println("COMPRAS REALIZADAS: \n");

        cart.forEach(product -> System.out.println(product));

        System.out.println("\n**************************");

        input.close();
    }

}
