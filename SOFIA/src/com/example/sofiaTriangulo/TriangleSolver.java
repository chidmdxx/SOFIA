package com.example.sofiaTriangulo;

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

		else if (numAngulos == 2){//caso 2: 2 angulos, 1 lado
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
			else if (B != 0) { ratio = B / senB; }
			else if (C != 0) { ratio = C / senC; }

			if (A == 0) { A = ratio * senA; }
			if (B == 0) { B = ratio * senB; }
			if (C == 0) { C = ratio * senC; }


		}else if (numLados == 2){ //caso 3: l angulo, 2 lados

			if(alfa != 0 && A == 0 || beta != 0 && B == 0 || gamma != 0 && C == 0){//caso 3.1: lado-angulo-lado

				if (A == 0) A = resuelveLado(B, C, alfa);
				if (B == 0) B = resuelveLado(C, A, beta);
				if (C == 0) C = resuelveLado(A, B, gamma);
				if (alfa == 0) alfa = resuelveAngulo(B, C, A);
				if (beta == 0) beta = resuelveAngulo(C, A, B);
				if (gamma == 0) gamma = resuelveAngulo(A, B, C);


			} else {//caso 3.2: lado-lado-angulo

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

					anguloParcial = Math.toDegrees(Math.asin(temp));
					anguloDesconocido = 180 - anguloConocido - anguloParcial;
					ladoDesconocido = ratio * Math.sin(Math.toRadians(anguloDesconocido)); //ley de senos

				}

		} else if (numLados == 3){//caso 4: 3 lados

			if (alfa==0){alfa = resuelveAngulo(B, C, A);}
			if (beta==0){beta = resuelveAngulo(C, A, B);}
			if (gamma==0){gamma = resuelveAngulo(A, B, C);}

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
			return -1;
	}


	/*
	*================================================================================================================================================
	*Aquí empieza la parte del texto
	*================================================================================================================================================
	*/


	public static String pasoPorPaso(double A,double B,double C,double alfa,double beta,double gamma){

		StringBuffer aRegresar = new StringBuffer ();

		aRegresar.append("\n\nSOLUCION PASO POR PASO \n======================");

		int numLados=0; 
		int numAngulos=0;

		//caso 1 y 2
		double senA, senB, senC, ratio, senCon;

		//caso 3

		double ladoConocido=0;
		double anguloConocido=0;
		double temp, ladoParcial=0;
		double anguloParcial=0;
		double ladoDesconocido=0;
		double anguloDesconocido=0;

		//calculo de numero de lados y angulos

		aRegresar.append("\n\nDATOS:\n");

		if(A != 0){
			numLados++;
			aRegresar.append("\nTenemos el lado A = "+ A);
		}

		if(B != 0){
			numLados++;
			aRegresar.append("\nTenemos el lado B = "+ B);
		}

		if(C != 0){
			numLados++;
			aRegresar.append("\nTenemos el lado C = "+ C);
		}

		if(alfa != 0){
			numAngulos++;
			aRegresar.append("\nTenemos el ángulo alfa = "+ alfa);
		}

		if(beta != 0){
			numAngulos++;
			aRegresar.append("\nTenemos el ángulo beta = "+ beta);
		}

		if(gamma != 0){
			numAngulos++;
			aRegresar.append("\nTenemos el ángulo gamma = "+ gamma);
		}

		aRegresar.append("\n\n\nPROCEDIMIENTO:");

		
		//esto se revisa en el front-end
		/*if (numLados + numAngulos != 3)
			System.out.println("Debes llenar por lo menos 3 campos");//cambiar para mandar error
		*/


		if (numLados == 0){//caso 1: 3 angulos
			//este metodo sirve con 3 o mas parametros

			aRegresar.append("\n\nComo tenemos 3 ángulos, usaremos la ley de senos para determinar los ángulos restantes:");
			aRegresar.append("\nA/sen(alfa) = B/sen(beta) = C/sen(gamma)");
			aRegresar.append("\n\nComo no tenemos el valor de ningún lado, asignaremos al lado A el valor de 1 para poder continuar.");
			A = 1;

			senA = Math.sin(Math.toRadians(alfa));
			senB = Math.sin(Math.toRadians(beta));
			senC = Math.sin(Math.toRadians(gamma));

			ratio = 0;

			//regla de senos

			if (A != 0) {
				ratio = A / senA;
			}

			//en teoría nunca llega a estos casos
			if (B != 0) {ratio = B / senB;}
			if (C != 0) {ratio = C / senC;}
			if (A == 0) A = ratio * senA;

			//hasta aqui llegamos por asignar A = 1
			if (B == 0){ 
				aRegresar.append("\n\n------\nLADO B:\n------");

				aRegresar.append("\n\nComo conocemos A, usaremos sólo una fracción de la ley de senos:");
				aRegresar.append("\nA/sen(alfa) = B/sen(beta)");

				aRegresar.append("\n\nSi despejamos B: B = (A/sen(alfa)) * sen(beta)");
				aRegresar.append("\nSustituimos: B = ("+A+" / "+senA+") * "+senB);
				aRegresar.append("\nB = "+ratio+" * "+senB);

				B = ratio * senB;
				aRegresar.append("\n\nB = "+B);
			}
			if (C == 0){
				aRegresar.append("\n\n------\nLADO C:\n------");

				aRegresar.append("\n\nComo conocemos A, usaremos sólo una fracción de la ley de senos:");
				aRegresar.append("\nA/sen(alfa) = C/sen(gamma)");

				aRegresar.append("\n\nSi despejamos C: C = (A/sen(alfa)) * sen(gamma)");
				aRegresar.append("\nSustituimos: C = ("+A+" / "+senA+") * "+senC);
				aRegresar.append("\nC = "+ratio+" * "+senC);

				C = ratio * senC;
				aRegresar.append("\n\nC = "+C);
			}

		}

		else if (numAngulos == 2){//caso 2: 2 angulos, 1 lado
			//este metodo sirve con 3 o mas parametros

			aRegresar.append("\n\nPrimero calculamos el ángulo faltante:");

			if (alfa == 0) { 
				aRegresar.append("\n\n------\nALFA:\n------");
				alfa = 180 - beta - gamma; 
				aRegresar.append("\n\nPara conocer el ángulo alfa, usamos simple álgebra:");
				aRegresar.append("\nSabemos que los ángulos de un triángulo suman 180. Entonces alfa + beta + gamma = 180");
				aRegresar.append("\nPor lo tanto, alfa = 180 - beta - gamma");
				aRegresar.append("\nSustituimos: alfa = 180 - "+beta+" - "+gamma);
				aRegresar.append("\n\nalfa = "+alfa);
			}
			if (beta == 0) { 
				aRegresar.append("\n\n------\nBETA:\n------");
				beta = 180 - gamma - alfa;
				aRegresar.append("\n\nPara conocer el ángulo beta, usamos simple álgebra:");
				aRegresar.append("\nSabemos que los ángulos de un triángulo suman 180. Entonces alfa + beta + gamma = 180");
				aRegresar.append("\nPor lo tanto, beta = 180 - alfa - gamma");
				aRegresar.append("\nSustituimos: alfa = 180 - "+alfa+" - "+gamma);
				aRegresar.append("\n\nbeta = "+beta);				 
			}
			if (gamma == 0) {
				aRegresar.append("\n\n------\nGAMMA:\n------");
				gamma = 180 - alfa - beta; 
				aRegresar.append("\n\nPara conocer el ángulo gamma, usamos simple álgebra:");
				aRegresar.append("\nSabemos que los ángulos de un triángulo suman 180. Entonces alfa + beta + gamma = 180");
				aRegresar.append("\nPor lo tanto, gamma = 180 - alfa - beta");
				aRegresar.append("\nSustituimos: gamma = 180 - "+alfa+" - "+beta);
				aRegresar.append("\n\ngamma = "+gamma);
			}

			senA = Math.sin(Math.toRadians(alfa));
			senB = Math.sin(Math.toRadians(beta));
			senC = Math.sin(Math.toRadians(gamma));

			ratio = 0;

			//regla de senos

			String lCon="";
			senCon = 0;


			if (A != 0) {
				//ratio = A / senA; 
				ladoConocido = A;
				senCon = senA;
				lCon = "A";
			}
			else if (B != 0) { 
				//ratio = B / senB; 
				ladoConocido = B;
				senCon = senB;
				lCon = "B";
			}
			else if (C != 0) { 
				//ratio = C / senC; 
				ladoConocido = C;
				senCon = senC;
				lCon = "C";
			}

			if (A == 0) { 
				//A = ratio * senA; 
				aRegresar.append(leySenos("A",lCon,ladoConocido,senCon, senA));

			}
			if (B == 0) {
			 	//B = ratio * senB; 
			 	aRegresar.append(leySenos("B",lCon,ladoConocido,senCon, senB));
			}
			if (C == 0) { 
				//C = ratio * senC; 
				aRegresar.append(leySenos("C",lCon,ladoConocido,senCon, senC));
			}


		}else if (numLados == 2){ //caso 3: l angulo, 2 lados

			if(alfa != 0 && A == 0 || beta != 0 && B == 0 || gamma != 0 && C == 0){//caso 3.1: lado-angulo-lado

				if (A == 0){
					A = resuelveLado(B, C, alfa);
				}
				if (B == 0) {
					B = resuelveLado(C, A, beta);
				}
				if (C == 0) {
					C = resuelveLado(A, B, gamma);
				}
				if(alfa ==0){
				//alfa = resuelveAngulo(B, C, A);
				aRegresar.append(resuelveAnguloString(B, C, A,"A","B","C","alfa"));
				}
				if (beta == 0){
					//beta = resuelveAngulo(C, A, B);
					aRegresar.append(resuelveAnguloString(C, A, B,"B","C","A","beta"));

				}
				if (gamma == 0){
					//gamma = resuelveAngulo(A, B, C);
					aRegresar.append(resuelveAnguloString(A, B, C,"C","A","B","gamma"));
				}


			} else {//caso 3.2: lado-lado-angulo

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

				anguloParcial = Math.toDegrees(Math.asin(temp));
				anguloDesconocido = 180 - anguloConocido - anguloParcial;
				ladoDesconocido = ratio * Math.sin(Math.toRadians(anguloDesconocido)); //ley de senos

				}

		} else if (numLados == 3){//caso 4: 3 lados

			aRegresar.append("\n\nExisten 3 lados, entonces podemos utilizar la ley de cosenos para determinar los ángulos faltantes.");
			aRegresar.append("\nUtilizamos diferentes formas de dicha ley para determinar cada ángulo:");

			if(alfa ==0){
				//alfa = resuelveAngulo(B, C, A);
				aRegresar.append(resuelveAnguloString(B, C, A,"A","B","C","alfa"));
			}
			if (beta == 0){
				//beta = resuelveAngulo(C, A, B);
				aRegresar.append(resuelveAnguloString(C, A, B,"B","C","A","beta"));

			}
			if (gamma == 0){
				//gamma = resuelveAngulo(A, B, C);
				aRegresar.append(resuelveAnguloString(A, B, C,"C","A","B","gamma"));
			}

		}

		return aRegresar.toString();

	}

	public static String resuelveLadoString(double a, double b, double C) {  
		// Regla de cosenos
		StringBuffer regresaMetodo = new StringBuffer ();
		regresaMetodo.append("Para resolver el lado usamos la ley de cosenos:");


		Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(C)));

		return regresaMetodo.toString();
	}

	public static String leySenos(String ladoACalc, String ladoCon, double dbLadoCon, double senladoCon, double senLadoACalc){

		StringBuffer regresaMetodo = new StringBuffer ();

		regresaMetodo.append("\n\n------\nLADO "+ladoACalc+":\n------");

		regresaMetodo.append("\n\nComo conocemos "+ladoCon+", usaremos sólo una fracción de la ley de senos:");
		regresaMetodo.append("\n"+ladoCon+"/sen("+regresaCorrespondiente(ladoCon)+") = "+ladoACalc+"/sen("+regresaCorrespondiente(ladoACalc)+")");

		regresaMetodo.append("\n\nSi despejamos "+ladoACalc+": "+ladoACalc+" = ("+ladoCon+"/sen("+regresaCorrespondiente(ladoCon)+")) * sen("+regresaCorrespondiente(ladoACalc)+")");
		regresaMetodo.append("\nSustituimos: "+ladoACalc+" = ("+dbLadoCon+" / "+senladoCon+") * "+senLadoACalc);
		double ratio = dbLadoCon/senladoCon;
		regresaMetodo.append("\n"+ladoACalc+" = "+ratio+" * "+senladoCon);

		double dbladoACalc = ratio * senLadoACalc;
		regresaMetodo.append("\n\n"+ladoACalc+" = "+dbladoACalc);

		return regresaMetodo.toString();
	}

	public static String regresaCorrespondiente(String lado){


		if(lado.equals("A"))
			return "alfa";
		else if(lado.equals("B"))
			return "beta";
		else if(lado.equals("C"))
			return "gamma";
		else if(lado.equals("alfa"))
			return "A";
		else if(lado.equals("beta"))
			return "B";
		else if(lado.equals("gamma"))
			return "C";

		return "";

	}

	public static String  resuelveAnguloString(double a, double b, double c, String Sa, String Sb, String Sc, String nomAngulo) {  
		// Regla de cosenos

		StringBuffer regresaMetodo = new StringBuffer ();

		regresaMetodo.append("\n\n------\n"+nomAngulo.toUpperCase()+":\n------");
		regresaMetodo.append("\n\nPara resolver el angulo "+nomAngulo+", usamos esta forma de la ley de cosenos:");

		regresaMetodo.append("\n"+Sa+"^2 = "+Sb+"^2 + "+Sc+"^2 - 2*"+Sb+"*"+Sc+" * cos("+nomAngulo+")");

		regresaMetodo.append("\n\nDespejamos cos("+nomAngulo+"): ("+Sa+"^2 - "+Sb+"^2 - "+Sc+"^2) / - 2*"+Sb+"*"+Sc+"  = cos("+nomAngulo+")");
		regresaMetodo.append("\nMultiplicaos la parte izquierda por (-1): -"+Sa+"^2 + "+Sb+"^2 + "+Sc+"^2) / 2*"+Sb+"*"+Sc+"  = cos("+nomAngulo+")");
		regresaMetodo.append("\nUsamos coseno inverso para despejar "+nomAngulo+": cos^-1(-"+Sa+"^2 + "+Sb+"^2 + "+Sc+"^2) / 2*"+Sb+"*"+Sc+") = "+nomAngulo);

		regresaMetodo.append("\n\nSustituimos: cos^-1((-"+c+"^2 + "+b+"^2 - "+a+"^2) / (2 * "+a+" * "+b+")) = "+nomAngulo);

		double temp = (a * a + b * b - c * c) / (2 * a * b);

		regresaMetodo.append("\ncos^-1("+temp+") = "+nomAngulo);



		if (temp >= -1 && temp <= 1){
			double res = Math.toDegrees(Math.acos(temp));
			regresaMetodo.append("\n\n"+nomAngulo+" = "+res);
		}
		else if (temp < -1){
			regresaMetodo.append("\n\nComo el valor "+temp+" es menor a -1, no puede ser evaluada por la función cos^-1.");
			regresaMetodo.append("\nPor lo tanto, no existe solución para este ángulo");
		} else {
			regresaMetodo.append("\n\nComo el valor "+temp+" es mayor a 1, no puede ser evaluada por la función cos^-1.");
			regresaMetodo.append("\nPor lo tanto, no existe solución para este ángulo");

		}

		return regresaMetodo.toString();
	}

}