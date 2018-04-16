import java.util.ArrayList;
import java.util.List;

public class Ordner implements Componente{
private List<Componente>childOrdner=new ArrayList<Componente>();
int ebene=1;
public void showContent(){
	for(Componente componente:childOrdner){
		componente.showContent();
		System.out.println("Ebene:"+ebene);
		ebene=ebene+1;
	}
}
public Ordner(){

}
public void add(Componente componente){
	childOrdner.add(componente);
}

public void remove(Componente componente){
	childOrdner.remove(componente);
}
}
