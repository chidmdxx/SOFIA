package mx.udlap.equations;

public class Equation_Methods2 {

	public boolean validacion(int a, int b, int c){
        if(a==0 && b==0 && c==0){			
			return false; //Esta mal escrita
		}
        if(a!=0 && b==0 && c!=0){
			return false; //Esta mal escrita
        }
        else {
        	return true; //La ecuacion esta escrita correctamente.
        }
	}
}
