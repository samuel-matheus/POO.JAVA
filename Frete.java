import java.util.ArrayList;
import java.util.List;

abstract class Frete {
    private double distanciaKm, valorPorKm;
 public Frete(double distanciaKm, double valorPorKm){
     this.distanciaKm = distanciaKm;
     this.valorPorKm = valorPorKm;
     }
     
     public String toString(){
      return (" Distancia em Km: ") + distanciaKm + (" Valor Por Km: ") + valorPorKm;
  }
     public double getDistanciaKm(){
         return distanciaKm;
         
     } public double getValorPorKm(){
         return valorPorKm;
         
     }
 public abstract double calcularFrete();
   
}
class fretePadrao extends Frete {
 public fretePadrao(double distanciaKm,double valorPorKm){
     super(distanciaKm, valorPorKm);
     
 }
 public String toString(){
      return super.toString();
 }
 
 public double calcularFrete(){
     return (getDistanciaKm() * getValorPorKm());
     
 }
}
class FreteExpresso extends Frete {
    private int nivelUrgencia;
 public FreteExpresso(double distanciaKm, double valorPorKm, int nivelUrgencia){
     super(distanciaKm, valorPorKm);
     this.nivelUrgencia = nivelUrgencia;
     
 }
  public String toString(){
      return super.toString() + "Nivel de Urgencia" + nivelUrgencia;
 }
 
 public int getNivelUrgencia(){
     return nivelUrgencia;
     
 } public double calcularFrete(){
     return (getDistanciaKm() * getValorPorKm()) + (getNivelUrgencia() * 100);
     
 }
   
}
class FreteSuperExpresso extends FreteExpresso{
    private double valorDoSeguro;
 public FreteSuperExpresso(double distanciaKm, double valorPorKm, int nivelUrgencia, double valorDoSeguro){
     super(distanciaKm, valorPorKm, nivelUrgencia);
     this.valorDoSeguro = valorDoSeguro;
     }
     public String toString(){
      return super.toString() + " Valor do Seguro: " + valorDoSeguro;
 }
     
     public double getValorDoSeguro(){
         return valorDoSeguro;
         
     }
     public double calcularFrete() {
         return (getDistanciaKm() * getValorPorKm()) + (getNivelUrgencia() * 100) + getValorDoSeguro();
        }
   
}
class CadastroFrete {
    private int qtd;
    private List<Frete> frete;
   
    public CadastroFrete(int qtd){
        this.qtd = 0;
        this.frete = new ArrayList<Frete>();
    }
    public boolean addFrete( Frete f){
        this.frete.add(f);
        return true;
    }
    public double calcularFrete(){
        double total = 0;
        for (int i = 0; i < frete.size(); ++i){
            total = total + frete.get(i).calcularFrete(); //polimofismo } }
           
        }
          return total;  
        }
       
    }

public class Main{
    public static void main(String []args){
        CadastroFrete c = new CadastroFrete(10);
        fretePadrao f = new fretePadrao(50.0 , 10.0);
        FreteExpresso E = new FreteExpresso(50.0 , 10.0, 2);
        FreteSuperExpresso SE = new FreteSuperExpresso(50.0 , 10.0, 2, 100 );
        c.addFrete(f);
        c.addFrete(E);
        c.addFrete(f);
        System.out.println(c.calcularFrete());
    }
}


MILITAR 2.0
import java.util.ArrayList;
import java.util.List;

abstract class Militar {
  private String patente;
  private int matricula;
 

  public Militar(String patente, int matricula){
    this.patente = patente;
    this.matricula = matricula;
  }
 
  public String toString(){
      return ("Patente: ") + patente + ("Matricula: ") + matricula;
  }
  public String getpatente(){
    return patente;
  }
  public int getMatricula(){
    return matricula;
  }
 

 public abstract boolean podeProgredir();
 
}


class MilitarAeronautica extends Militar{
  private double duraPatente;
  private double horaVoo;

  public MilitarAeronautica(double duraPatente, double horaVoo,String patente, int matricula){
    super (patente, matricula);
    this.duraPatente = duraPatente;
    this.horaVoo = horaVoo;
  }
 
  public String toString(){
      return  super.toString() + " Duração da Patente: " + duraPatente + " horas Voando: " + horaVoo;
  }
  public boolean podeProgredir(){
    if (duraPatente > 2 && horaVoo > 100){
      return true;
    }else {
      return false;
    }
  }
}

class MilitarExercito extends Militar {
  private boolean ptcp, pgg;
  public MilitarExercito(String patente, int matricula, boolean ptcp, boolean pgg){
     super(patente,matricula);
     this.ptcp = ptcp;
     this.pgg = pgg;
  }
 
  public String toString(){
      return  super.toString() + " Participou da Guerra: " + ptcp + " Ganhou a Guerra: " + pgg;
  }
 
  public boolean podeProgredir(){
    if (ptcp == true && pgg == true){
      return true;
    }else{
      return false;
    }
  }
}

class MilitarMarinha extends Militar {
  private boolean pceam;
  public MilitarMarinha(String patente, int matricula, boolean pceam){
    super(patente,matricula);
    this.pceam = pceam;
  }
 
  public String toString(){
      return  super.toString() + " Consertou um avião em alto-mar: " + pceam;
  }
 
  public boolean podeProgredir(){
    if (pceam == true){
      return true;
    }else{
      return false;
    }
  }
}

class CadastroMilitar{
  private int qtd;
  private List<Militar> militar;
  public CadastroMilitar(int qtd){
    this.qtd = 0;
    this.militar =  new ArrayList<Militar>();
}

  public boolean addMilitar( Militar m){
   
      this.militar.add(m);
      return true;
  }
 
  public void militarPodeProgredir(){
    for(int i = 0; i < militar.size();   ++i){
        if(militar.get(i).podeProgredir() == true){
          System.out.println(militar.get(i));
        }
    }
  }
}

public class Main {
    public static void main(String[] args) {
    CadastroMilitar c = new CadastroMilitar(10);
    MilitarAeronautica Ma = new MilitarAeronautica(15.8, 100.5, "Capitao",15546575);
    MilitarExercito Me = new MilitarExercito( "Capitao",15546575, true, false);
    MilitarMarinha Mm = new MilitarMarinha( "Capitao",15546575, true);
    c.addMilitar(Ma);
    c.addMilitar(Mm);
    c.addMilitar(Me);
    c.militarPodeProgredir();
       
    }
}
