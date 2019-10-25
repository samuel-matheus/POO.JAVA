public class Estacionamento {
  private String nome;
  private VeiculoCondutor[] veiculos;
  private int qtd;
  
  public Estacionamento(String nome){
    this.nome = nome;
    veiculos = new VeiculoCondutor[100];
    this.qtd = 0;
}
  public void adicionarVeiculo(VeiculoCondutor v){
    if(qtd < veiculos.length){
      veiculos[qtd] = v;
      qtd ++;
      System.out.println("Veiculo adicionado");
}
    else{
      System.out.println("Nao e possivel adicionar mais veiculos");
}
}
public void removerVeiculo(String placa){
  for(int i = 0; i < qtd; i++){
    if(veiculos[i] != null && veiculos[i].getPlaca() == placa){
      veiculos[i] = null;
      for(int j = i; j < qtd -1; j++){
        veiculos[j] = veiculos[j+1];
        veiculos[j+1] = null;
}
    qtd --;
    break;
    }
  }
}
public void exibirVeiculoMenorValor(){
  VeiculoCondutor menorValor = null;
    if(qtd > 0){
      menorValor = veiculos[0];
      for(int i = 1; i < qtd; i++) {
        if (veiculos[i].getValor() < menorValor.getValor()) {

        menorValor = veiculos[i];
}
}
        if(menorValor instanceof Moto){
          System.out.println("Veiculo com menor valor: " + menorValor.getDescricao() + "Valor: " + menorValor.getValor() + " Tipo de veiculo: Moto" );
}
        else if(menorValor instanceof Carro){
          System.out.println("Veiculo com menor valor: " + menorValor.getDescricao() + "Valor: " + menorValor.getValor() + " Tipo de veiculo: Carro" );
}
        else if(menorValor instanceof Onibus){
          System.out.println("Veiculo com menor valor: " + menorValor.getDescricao() + "Valor: " + menorValor.getValor() + " Tipo de veiculo: Onibus" );
}
        else if(menorValor instanceof Caminhao){
          System.out.println("Veiculo com menor valor: " + menorValor.getDescricao() + "Valor: " + menorValor.getValor() + " Tipo de veiculo: Caminhao" );
}
}
}
public void exibirValorTotalFrota(){
  double totalFrota = 0;
  for (int i = 0; i < qtd; i++) {
    totalFrota = totalFrota + veiculos[i].getValor();
  }
  System.out.println("Valor total da frota: " + totalFrota);
}
public void exibirveiculosCadastrados(){
  System.out.println("Veiculos cadastrados");
  for(int i = 0; i < qtd; i++){
    if(veiculos[i] != null){
      System.out.println("Descricao: " + veiculos[i].getDescricao() + " Velocidade: " + veiculos[i].getVelocidade() + " Ano: " + veiculos[i].getAno());
    }
  }
}
public void qtdVeiculosTipo(){

  int contMoto = 0;
  int contCarro = 0;
  int contOnibus = 0;
  int contCaminhao = 0;
  for(int i = 0; i < qtd; i++){
    if(veiculos[i] instanceof Moto){
      contMoto ++;
    }
  else if(veiculos[i] instanceof Carro){
    contCarro ++;
    }
  else if(veiculos[i] instanceof Onibus){
    contOnibus ++;
    }
  else if(veiculos[i] instanceof Caminhao){
    contCaminhao ++;
    }
  }
  System.out.println("Quantidade de veiculos por tipo Moto: " + contMoto);
  System.out.println("Quantidade de veiculos por tipo Carro: " + contCarro);
  System.out.println("Quantidade de veiculos por tipo Onibus: " + contOnibus);
  System.out.println("Quantidade de veiculos por tipo Caminhao: " + contCaminhao);
}
public void exibirtipoVeiculoMaiorQtd(){
  int contMoto = 0;
  int contCarro = 0;
  int contOnibus = 0;
  int contCaminhao = 0;
  for(int i = 0; i < qtd; i++){
    if(veiculos[i] instanceof Moto){
      contMoto ++;
    }
    else if(veiculos[i] instanceof Carro){
      contCarro ++;
    }
    else if(veiculos[i] instanceof Onibus){
      contOnibus ++;
    }
    else if(veiculos[i] instanceof Caminhao){
      contCaminhao ++;
    }

  }
  if(contMoto > contCarro && contMoto > contOnibus && contMoto > contCaminhao){
    System.out.println("O tipo de veiculo em maior quantidade e Moto");
  }
  else if(contCarro > contMoto && contCarro > contOnibus && contCarro > contCaminhao){
    System.out.println("O tipo de veiculo em maior quantidade e Carro");
  }
  else if(contOnibus > contMoto && contOnibus > contCarro &&contOnibus > contCaminhao){
    System.out.println("O tipo de veiculo em maior quantidade e Onibus");
  }
  else if(contCaminhao > contMoto && contCaminhao > contCarro && contCaminhao > contOnibus){
    System.out.println("O tipo de veiculo em maior quantidade e Caminhao");
  }
}
}

//Classe VeiculoCondutor

public abstract class VeiculoCondutor {
  double velocidade;
  private String descricao;
  private String ano;
  private double valor;
  private String placa;
  double potencia;
  public VeiculoCondutor(String descricao, String ano, double valor, String placa, double potencia) {
    this.velocidade = 0;
    this.descricao = descricao;
    this.ano = ano;
    this.valor = valor;
    this.placa = placa;
    this.potencia = potencia;
   }
  public double getVelocidade() {
    return velocidade;
  }

  public String getDescricao() {
    return descricao;
  }
  public String getAno() {
    return ano;
  }
  public double getValor() {
    return valor;
  }
  public String getPlaca() {
    return placa;
  }
  public double getPotencia() {
    return potencia;
  }
  public void setVelocidade(double velocidade) {
    this.velocidade = velocidade;
  }

}

//Classe Veiculo

public interface Veiculo {
  public void acelerar();
  public void frear();
}

//Classe Moto

public class Moto extends VeiculoCondutor implements Veiculo {
  public Moto(String descricao, String ano, double valor, String placa, double potencia) {
  super(descricao, ano, valor, placa, potencia);
  }
  @Override
  public void acelerar() {

    if(velocidade < potencia){
      velocidade += 10;
    }
  }
  @Override
  public void frear() {
    if(velocidade > 0){
      velocidade -= 10;
    }
  }
}

//Classe Carro

public class Carro extends VeiculoCondutor implements Veiculo {
  private double qtdPortas;
  public Carro(String descricao, String ano, double valor, String placa, double potencia, double qtdPortas) {
   super(descricao, ano, valor, placa, potencia);
   this.qtdPortas = qtdPortas;
  }
  public double getQtdPortas() {
    return qtdPortas;
  }
  public double getPotencia() {
    return potencia;
  }
  @Override
  public void acelerar() {
    if(velocidade < potencia){
      velocidade += 10;
    }
  }
  @Override
  public void frear() {
    if(velocidade > 0){
      velocidade -= 10;

    }
  }
}

//Classe Onibus

public class Onibus extends VeiculoCondutor implements Veiculo {
  private double comprimento;
  private double capacidade;
  public Onibus(String descricao, String ano, double valor, String placa, double potencia, double comprimento, double capacidade) {
    super(descricao, ano, valor, placa, potencia);
    this.comprimento = comprimento;
    this.capacidade = capacidade;
    }
  public double getComprimento() {
    return comprimento;
  }
  public double getCapacidade() {
    return capacidade;
  }
  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }
  public void setCapacidade(double capacidade) {
    this.capacidade = capacidade;
  }
  @Override
  public void acelerar() {
    if(velocidade < potencia){
      velocidade += 8;
    }
  }
  @Override
  public void frear() {

    if(velocidade > 0){
      velocidade -= 8;
    }
  }
}

//Classe Caminhao

public class Caminhao extends VeiculoCondutor implements Veiculo {
  private double cargaSuportada;
  private double comprimento;
  public Caminhao(String descricao, String ano, double valor, String placa, double potencia, double cargaSuportada, double comprimento) {
    super(descricao, ano, valor, placa, potencia);
    this.cargaSuportada = cargaSuportada;
    this.comprimento = comprimento;
  }
  public double getCargaSuportada() {
    return cargaSuportada;
  }
  public double getComprimento() {
    return comprimento;
  }
  public void setCargaSuportada(double cargaSuportada) {
    this.cargaSuportada = cargaSuportada;
  }
  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }
  @Override
  public void acelerar() {
    if(velocidade < potencia){
      velocidade += 8;
    }
  }
  @Override

  public void frear() {
    if(velocidade > 0){
      velocidade -= 8;
    }
  }
}

//Classe Principal

public class Principal {
  public static void main(String[]args){
    Estacionamento e = new Estacionamento("Estacionamento");
    Moto moto = new Moto("Suzuki GSX-R1000", "2001", 50320.50, "NPQ5432", 285);
    Carro carro = new Carro("Lamborghini Gallardo", "2012", 100420.35, "OEZ1056", 320, 2);
    Carro carro1 = new Carro("Ferrari F430", "2015", 120420.35, "OPQ2540", 320, 2);
    Onibus onibus = new Onibus("Onibus convencional", "2010", 30000, "CEO9865", 120, 15, 30);
    Caminhao caminhao = new Caminhao("Bitrem", "2016", 50000, "GBA0786", 220, 45, 18.15);
    e.adicionarVeiculo(moto);
    e.adicionarVeiculo(carro);
    e.adicionarVeiculo(carro1);
    e.adicionarVeiculo(onibus);
    e.adicionarVeiculo(caminhao);
    e.qtdVeiculosTipo();
    e.exibirVeiculoMenorValor();
    e.exibirtipoVeiculoMaiorQtd();
    e.exibirValorTotalFrota();
    moto.acelerar();
    carro.acelerar();
    carro1.acelerar();
    onibus.acelerar();
    caminhao.acelerar();
    e.exibirveiculosCadastrados();
    moto.frear();
    carro.frear();
    carro1.frear();
    onibus.frear();
    caminhao.frear();
  }
}
