import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        char[][] tabuleiro = new char[20][20];
                for (int linha = 0;linha<20;linha++){
                    for(int coluna = 0;coluna<20;coluna++){
                        tabuleiro[linha][coluna] = '*';
                    }
                }

        boolean caneta =false;
        int tartarugaLinha = 0;
        int tartarugaColuna= 0;

        int direcao = 0;
        int passo;


        int opcao = 0;
        while (opcao!=9){
            status(tartarugaLinha,tartarugaColuna,direcao,caneta);
            menu();
            System.out.print("Opção --> ");
            opcao = leitor.nextInt();

            switch (opcao){
                case 1:{
                    caneta = false;
                    break;
                }
                case 2:{
                    caneta = true;
                    break;
                }
                case 3:{
                    direcao++;
                    if(direcao>3){
                        direcao = 0;
                    }
                    break;
                }
                case 4:{
                    direcao--;
                    if(direcao<0){
                        direcao = 3;
                    }
                    break;
                }
                case 5:{
                    System.out.print("Passos : " );
                    passo = leitor.nextInt();
                    int movimento = move(tartarugaLinha,tartarugaColuna,direcao,passo);
                        if(direcao == 0){
                            if(caneta) {
                                for (int contador = tartarugaColuna; contador < movimento; contador++) {
                                    tabuleiro[tartarugaLinha][contador] = 'x';
                                }
                                tartarugaColuna=movimento;

                            }else {
                                tartarugaColuna = movimento;
                            }
                        }if(direcao == 1){
                        if(caneta) {
                            for (int contador = tartarugaLinha; contador < movimento; contador++) {
                                tabuleiro[contador][tartarugaColuna] = 'x';
                            }
                            tartarugaLinha=movimento;

                        }else {
                            tartarugaLinha = movimento;
                        }
                    }
                    if(direcao == 2){
                        if(caneta) {
                            for (int contador = tartarugaColuna;contador >movimento ; contador--) {
                                tabuleiro[tartarugaLinha][contador] = 'x';
                            }
                            tartarugaColuna=movimento;

                        }else {
                            tartarugaColuna = movimento;
                        }
                    }if(direcao == 3){
                        if(caneta) {
                            for (int contador = tartarugaLinha;contador>movimento; contador--) {
                                tabuleiro[contador][tartarugaColuna] = 'x';
                            }
                            tartarugaLinha=movimento;

                        }else {
                            tartarugaLinha = movimento;
                        }
                    }

                    break;
                }
                case 6:{
                    imprimeTabuleiro(tabuleiro);
                    break;
                }
                case 9:{
                    System.out.println("Bye!!");
                    break;
                }
            }
        }
    }

    static void imprimeTabuleiro(char[][] tab){
        for (char[] chars : tab) {
            for (char aChar : chars) {
                System.out.printf("%3s", aChar);
            }
            System.out.println();
        }
    }
    static void menu(){
        System.out.print("""
                    Painel
                    ------
                    1 - Caneta para cima
                    2 - Caneta para baixo
                    3 - Vira para direta
                    4 - Vira para esquerda
                    5 - Avanço (passos)
                    6 - Exiba o array 20x20
                    9 - Fim
                    """);
    }

    static int move(int tarLinha, int tarColuna, int dire,int pas){
        int movimento = 0;
        if(dire == 0){
            if((tarColuna + pas) > 20){
                System.out.println("Jogada Ilegal !!!");
                movimento = tarColuna;
            }else {
                movimento = tarColuna + pas;
            }
        }
        if(dire == 1){
            if((tarLinha + pas) > 20){
                System.out.println("Jogada Ilegal !!!");
                movimento = tarLinha;
            }else {
                movimento = tarLinha + pas;
            }
        }
        if(dire == 2){
            if((tarColuna - pas) < 0){
                System.out.println("Jogada Ilegal !!!");
                movimento = tarColuna;
            }else {
                movimento = tarColuna - pas;
            }
        }
        if(dire == 3){
            if((tarLinha - pas) < 0){
                System.out.println("Jogada Ilegal !!!");
                movimento = tarLinha;
            }else {
                movimento = tarLinha - pas;
            }
        }
        return movimento;
    }
    static void status(int tarLinha, int tarColuna,int dire,boolean can){
        String pos = "(" + tarLinha +" , "+tarColuna+ ")";
        String caneta = (can)?"escrevendo":"Suspensa";
        String direcao = "";
            if(dire==0){
                direcao = "para frente";
            }else if(dire == 1){
                direcao = "para baixo";
            }else if(dire == 2) {
                direcao = "para trás";
            }else if(dire == 3){
            direcao = "para cima";
            }

        System.out.printf("Tartaruga%1s, direção %s e caneta %s%n",pos,direcao,caneta);
    }

    }



