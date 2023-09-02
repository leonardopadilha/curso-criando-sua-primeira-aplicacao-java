import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        String nome, tipoConta;
        double saldoInicial = 0, recebeValor = 0, valorTransferencia = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o nome do cliente: ");
        nome = teclado.nextLine();

        System.out.print("Informe o tipo da conta: ");
        tipoConta = teclado.nextLine();

        System.out.print("Informe o saldo inicial: ");
        saldoInicial = teclado.nextDouble();

        System.out.println("*********************************");

        System.out.println("Dados iniciais do cliente:");

        System.out.println("Nome: " + nome + "\n" +
                           "Tipo conta: " + tipoConta + "\n" +
                           "Saldo inicial: " + saldoInicial);

        System.out.println("*********************************");

        int operacao = 0;

        do  {
            System.out.println("Operações: " + "\n" +
                    "1 - Consultar saldo" + "\n" +
                    "2 - Receber valor" + "\n" +
                    "3 - Transferir valor" + "\n" +
                    "4 - Sair");

            operacao = teclado.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println(String.format("R$ %.2f reais", saldoInicial));
                break;

                case 2:
                    System.out.print("Informe o valor a receber: ");
                    recebeValor = teclado.nextDouble();

                    if (recebeValor > 0) {
                        saldoInicial += recebeValor;
                    } else {
                        System.out.print("Não é possível depositar valor menor ou igual a 0 \n");
                        break;
                    }
                    System.out.print(String.format("Saldo atualizado R$ %.2f", saldoInicial) + "\n");
                break;

                case 3:
                    System.out.print("Informe o valor que deseja transferir: ");
                    valorTransferencia = teclado.nextDouble();

                    if (valorTransferencia > 0 && valorTransferencia <= saldoInicial) {
                        saldoInicial -= valorTransferencia;
                    } else {
                        System.out.print("Não é possível realizar transferência \n");
                        break;
                    }
                    System.out.print(String.format("Saldo atualizado R$ %.2f", saldoInicial) + "\n");
                break;

                default:
                    System.out.print("Opção inválida \n");
                break;
            }
        } while (operacao != 4);

        System.out.print("Até breve!!!");
    }
}
