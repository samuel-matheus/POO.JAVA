import java.util.ArrayList;
import java.util.List;

abstract class imposto implements tributo{
  private String nome, descricao;
  private double taxa;

  public imposto(String nome, String descricao, double taxa){
    this.nome = nome;
    this.descricao = descricao;
    this.taxa = taxa;
  }

  public String getNome(){
    return nome;
  }

  public String getDescricao(){
    return descricao;
  }

  public double getTaxa(){
    return taxa;
  }

}

  interface tributo{
    public double calcular();
  }

class IR extends imposto{
  private double vrenda;

  public IR(String nome, String descricao, double taxa, double vrenda){
    super(nome, descricao, taxa);
    this.vrenda = vrenda;
  }

  public double calcular(){
    return getTaxa() * vrenda;
  }


}

class IPTU extends imposto {
  private double vimovel;

  public IPTU(String nome, String descricao, double taxa, double vimovel){
    super(nome, descricao, taxa);
    this.vimovel = vimovel;
  }

  public double calcular(){
    return getTaxa() * vimovel;
  }

}


class IPVA extends imposto {
  private double vcarro;

  public IPVA(String nome, String descricao, double taxa, double vcarro){
    super(nome, descricao, taxa);
    this.vcarro = vcarro;
  }

  public double calcular(){
    return getTaxa() * vcarro;
  }

}

class contribuinte {
  private String nome;
  private List<imposto> Impostos;

  public contribuinte (String nome){
    this.nome = nome;
    this.Impostos = new ArrayList<imposto>();
  }
  public boolean addImposto(imposto I){
    this.Impostos.add(I);
    return true;
   }

  public double calcular(){ 
    double total = 0;
    for (int i = 0; i < Impostos.size(); ++i){ 
      total = total + Impostos.get(i).calcular(); //polimofismo } }
}
    return total;
}10
}
public class Main{
  public static void main(String args[]){
    contribuinte c = new contribuinte("jose");
    IR im = new IR("Italo", "tgyudggruy", 50.0, 25.0);
    IPTU ip = new IPTU("MAThEUS", "tgyufruy", 70.0, 5.0);
    IPVA ia = new IPVA("CORNOOOO", "tgyufyhuy", 20.0, 75.0);
    c.addImposto(im);
    c.addImposto(ip);
    c.addImposto(ia);
    System.out.println(c.calcular());
  }


}
