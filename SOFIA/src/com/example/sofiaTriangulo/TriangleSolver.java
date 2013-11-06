package com.example.sofiaTriangulo;

//package mx.udlap.funciones;

public abstract class TriangleSolver{

/*
@param A,B,C son los lados; alfa, beta y gamma los angulos correspondientes a los lados
Los lados o angulos que no ponga el usuario se deben pasar como 0
Pasar por lo menos 3 parametros
valores validos (no negativos, letras, etc.)
que generen un triangulo
*/
	public static double[] solver(double A,double B,double C,double alfa,double beta,double gamma){

		int numLados=0; 
		int numAngulos=0;

		//caso 1 y 2
		double senA, senB, senC, ratio;

		//caso 3

		double ladoConocido=0;
		double anguloConocido=0;
		double temp, ladoParcial=0;
		double anguloParcial=0;
		double ladoDesconocido=0;
		double anguloDesconocido=0;

		//calculo de numero de lados y angulos

		if(A != 0){numLados++;}
		if(B != 0){numLados++;}
		if(C != 0){numLados++;}

		if(alfa != 0){numAngulos++;}
		if(beta != 0){numAngulos++;}
		if(gamma != 0){numAngulos++;}

		
		//esto se revisa en el front-end
		/*if (numLados + numAngulos != 3)
			System.out.println("Debes llenar por lo menos 3 campos");//cambiar para mandar error
		*/


		if (numLados == 0){//caso 1: 3 angulos
			//este metodo sirve con 3 o mas parametros

			A = 1;

			senA = Math.sin(Math.toRadians(alfa));
			senB = Math.sin(Math.toRadians(beta));
			senC = Math.sin(Math.toRadians(gamma));

			ratio = 0;

			//regla de senos

			if (A != 0) {ratio = A / senA;}
			if (B != 0) {ratio = B / senB;}
			if (C != 0) {ratio = C / senC;}

			if (A == 0) A = ratio * senA;
			if (B == 0) B = ratio * senB;
			if (C == 0) C = ratio * senC;

		}
//FALTA UN LADO
		else if (numAngulos == 2 ){//caso 2: 2 angulos, 1 lado
			//este metodo sirve con 3 o mas parametros

			if (alfa == 0) { alfa = 180 - beta - gamma; }
			if (beta == 0) { beta = 180 - gamma - alfa; }
			if (gamma == 0) { gamma = 180 - alfa - beta; }

			senA = Math.sin(Math.toRadians(alfa));
			senB = Math.sin(Math.toRadians(beta));
			senC = Math.sin(Math.toRadians(gamma));

			ratio = 0;

			//regla de senos

			if (A != 0) { ratio = A / senA; }
			if (B != 0) { ratio = B / senB; }
			if (C != 0) { ratio = C / senC; }

			if (A == 0) { A = ratio * senA; }
			if (B == 0) { B = ratio * senB; }
			if (C == 0) { C = ratio * senC; }


		}else if (numLados == 2){ //caso 3: l angulo, 2 lados

			if(alfa != 0 && A == 0||alfa != 0 && C == 0 || beta != 0 && B == 0 || gamma != 0 && C == 0){//caso 3.1: lado-angulo-lado

				if (A == 0) A = resuelveLado(B, C, alfa);
				if (B == 0) B = resuelveLado(C, A, beta);
				if (C == 0) C = resuelveLado(A, B, gamma);
				//if (C == 0) C = resuelveLado(A, B, alfa);
				if (alfa == 0) alfa = resuelveAngulo(B, C, A);
				if (beta == 0) beta = resuelveAngulo(C, A, B);
				if (gamma == 0) gamma = resuelveAngulo(A, B, C);


			} 
			else {//caso 3.2: lado-lado-angulo

				if (A != 0 && alfa != 0) { 
					ladoConocido = A; 
					anguloConocido = alfa; 
				}

				if (B != 0 && beta != 0) { 
					ladoConocido = B; 
					anguloConocido = beta; 
				}

				if (C != 0 && gamma != 0) { 
					ladoConocido = C; 
					anguloConocido = gamma; 
				}

				if (A != 0 && alfa == 0){ ladoParcial = A;}
				if (B != 0 && beta == 0){ ladoParcial = B;}
				if (C != 0 && gamma == 0){ ladoParcial = C;}

				ratio = ladoConocido / Math.sin(Math.toRadians(anguloConocido));

				temp = ladoParcial / ratio;

					ladoParcial = Math.toDegrees(Math.asin(temp));
					anguloDesconocido = 180 - anguloConocido - anguloParcial;
					ladoDesconocido = ratio * Math.sin(Math.toRadians(anguloDesconocido)); //ley de senos

				}
					


			



		} else if (numLados == 3){//caso 4: 3 lados

			alfa = resuelveAngulo(B, C, A);
			beta = resuelveAngulo(C, A, B);
			gamma = resuelveAngulo(A, B, C);

		}

		return new double[]{A,B,C,alfa,beta,gamma};

	}

	public static double resuelveLado(double a, double b, double C) {  
		// Regla de cosenos
		return Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(C)));
	}

	public static double  resuelveAngulo(double a, double b, double c) {  
		// Regla de cosenos
		double temp = (a * a + b * b - c * c) / (2 * a * b);
		if (temp >= -1 && temp <= 1)
			return Math.toDegrees(Math.acos(temp));
		else
			return -5;
	}

}