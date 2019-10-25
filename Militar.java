abstract class Militar {
  private String patente;
  private int matricula;
  

  public Militar(String patente, int matricula){
    this.patente = patente;
    this.matricula = matricula;
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
  public boolean podeProgredir(){
    if (pceam == true){
      return true;
    }else{
      return false;
    }
  }
}

class CadastroMilitar {
  private int qtd;
  private  Militar[] militar;
  public CadastroMilitar(int qtd){
    this.qtd = 0;
    this.militar = new Militar[qtd]; 
  }

  public boolean addMilitar( Militar M){
    if (qtd <= 10) return false;
    
      this.militar[qtd++] = M;
      return true;
  }
}


class Main {
  public static void main(String[] args) {
    CadastroMilitar c = new CadastroMilitar(10);
    MilitarAeronautica Ma = new MilitarAeronautica(15.8, 100.5, "Capitao",15546575);
    MilitarExercito Me = new MilitarExercito( "Capitao",15546575, true, false);
    MilitarMarinha Mm = new MilitarMarinha( "Capitao",15546575, true);
    System.out.println("Militar Aeronautica pode progredir: " + Ma.podeProgredir());
    System.out.println("Militar Exercito pode progredir: " + Me.podeProgredir());
    System.out.println("Militar Marinha pode progredir: " + Mm.podeProgredir());
  }
}
