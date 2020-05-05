/*
Objetivo: Automata de pila por vaciado validando L(anbn|n>=0)
 */
package pila;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author 
 */
public class Pila {
    boolean aceptado; //variable que indica si la cadena es aceptada o no
    //contador para el automata que lo permite avanzar
    int cont;
    //array list para ir agregando espacios en la cadena, ya que el arraylist es dinamico
    ArrayList<Character> car = new ArrayList<Character>();
    //pila que se usara para el automata
    Stack<String> pila = new Stack<String>();
    
    public static void main(String[] args) {
        Pila aut = new Pila();//inicializamos el automata
        String cadena=" aaab";//Modificar e ingresar la cadena a evaluar, siempre debe empezar con un espacio en blanco
        //metodo para convertir la cadena en array
        aut.convertir(cadena);
    }
    
    public void convertir(String cadena){
        //se inicializa el array lista con espacios en blanco
        for (int x=0;x<100;x++){
            car.add(x,' ');
        }
        
        //se ingresan los elementos de la cadena al arraylist
        for(int i = 0; i<cadena.length();i++){
            car.add(i,cadena.charAt(i));
        }
        inicio();//llama al metodo inicio
        if(aceptado)
            System.out.println("Cadena aceptada");//cadena aceptada
        else
            System.out.println("Cadena no aceptada");//cadena no aceptada
    }
    
    public void inicio(){
        //incializacion de variables
        cont = 0;
        aceptado=false;
        //incializacion de la pila
        pila.push("Z");
        p();//llamar al metodo p para el estado inicial
    }
    
    //estado inicial
    public void p(){
        //imprimiendo informacion
        System.out.println("Estado actual: p");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("Elemento al tope "+pila.peek());
        String x = pila.peek(); //se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe un espacio en blanco al comienzo
            if (car.get(cont) == ' '){
                //si en la pila esta Z
                if(x == "Z"){
                  System.out.println("Push: A");
                  //se agrega A a la pila
                  pila.push("A");
                  //se incrementa el contador
                  cont++;
                  //pasamos al siguiente estado
                  q1();
                }
            }
            else{
              System.out.println("Error, la cadena no contiene un elemento en blanco al incio");
            }
        }
    }
    
    public void q1(){
        //imprimiendo informacion
        System.out.println("Estado actual: q1");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("Elemento al tope "+pila.peek());
        String x = pila.peek();//se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe una a
            if (car.get(cont) == 'a'){
                //en la pila esta B
                if(x == "A"){
                    System.out.println("Push: B");
                    //se agrega B a la pila
                    pila.push("B");
                    cont++;
                    q2();
                }
            }
            else{
                //si en la cadena existe un elemento en blanco 
                if(car.get(cont) == ' '){
                    //en la pila esta A
                    if(x == "A"){
                        System.out.println("Pop: A");
                        //se extrae A de la pila
                        pila.pop();
                        cont++;
                        q4();
                    }
                }
                else{
                    //si en la cadena existe una a 
                    if(car.get(cont) == 'a'){
                        //en la pila esta A
                        if(x == "A"){
                          System.out.println("Push: A");
                          //se agrega A a la pila
                          pila.push("A");
                          cont++;
                          q4();
                        }
                    }
                }
            }
        }
    }

  public void q2(){
      //imprimiendo informacion
        System.out.println("Estado actual: q2");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("Elemento al tope "+pila.peek());
        String x = pila.peek();//se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe una a 
            if (car.get(cont) == 'a'){
                //en la pila esta B
                if(x == "B"){
                    System.out.println("Push: B");
                    //se agrega B a la pila
                    pila.push("B");
                    cont++;
                    q2();
                }
            }
            else{
                //si en la cadena existe una b
                if(car.get(cont) == 'b'){
                    //en la pila esta B
                    if(x == "B"){
                        System.out.println("Pop: B");
                        //se extrae B de la pila
                        pila.pop();
                        cont++;
                        q3();
                    }
                }
            }
        }
    }

  public void q3(){
        //imprimiendo informacion
        System.out.println("Estado actual: q3");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("Elemento al tope "+pila.peek());
        String x = pila.peek();//se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe una b
            if (car.get(cont) == 'b'){
                //en la pila esta B
                if(x == "B"){
                    System.out.println("Pop: B");
                    //se extrae B de la pila
                    pila.pop();
                    cont++;
                    q3();
                }
            }
            else{
                //si en la cadena existe un elemento en blanco
                if(car.get(cont) == ' '){
                    //en la pila esta A
                    if(x == "A"){
                        System.out.println("Push: A");
                        //se agrega A a la pila
                        pila.push("A");
                        cont++;
                        q4();
                    }
                }
            }
        }
        else{
            System.out.println("Esta vacia");
        }
    }

  public void q4(){
        //imprimiendo informacion
        System.out.println("Estado actual: q4");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("Elemento al tope "+pila.peek());
        String x = pila.peek(); //se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe un elemento en blanco
            if (car.get(cont) == ' '){
                //en la pila esta A
                if(x == "A"){
                    System.out.println("Pop: A");
                    //se extrae A de la pila
                    pila.pop();
                    cont++;
                    r();
                }
            }
            else{
                //si en la cadena existe un elemento en blanco
                if(car.get(cont) == ' '){
                    //en la pila esta B
                    if(x == "B"){
                        System.out.println("Pop: B");
                        //se extrae B de la pila
                        pila.pop();
                        cont++;
                        r();
                    }
                }
                else{
                    //si en la cadena existe un elemento en blanco
                    if(car.get(cont) == ' '){
                        //en la pila esta Z
                        if(x == "Z"){
                            System.out.println("Pop: Z");
                            //se extrae Z de la pila
                            pila.pop();
                            cont++;
                            r();
                        }
                    }
                }
            }
        }
    }

  public void r(){
        //imprimiendo informacion
        System.out.println("Estado actual: r");
        System.out.println("Cadena: "+car.get(cont));
        System.out.println("En el tope "+pila.peek());
        String x = pila.peek(); //se obtiene el elemento que esta en el tope de la pila
        //si la pila no esta vacia podemos avanzar
        if(!pila.isEmpty())
        {
            //si en la cadena existe un elemento en blanco
            if (car.get(cont) == ' '){
                //en la pila esta A
              if(x == "A"){
                System.out.println("Pop: A");
                //se extrae A de la pila
                pila.pop();
                if(pila.empty())
                    aceptado = true;
                else{
                    cont++;
                    r();
                }
              }
            }
            //si en la cadena existe un elemento en blanco
            if(car.get(cont) == ' '){
                //en la pila esta Z
                if(x=="Z"){
                    System.out.println("Pop: Z");
                    //se extrae Z de la pila
                    pila.pop();
                    if(pila.empty())
                        aceptado = true;
                    else{
                        cont++;
                        r();
                    }
                }
            }
            else{
                //si en la cadena existe un elemento en blanco
                if(car.get(cont) == ' '){
                    //en la pila esta B
                    if(x == "B"){
                        System.out.println("Pop: B");
                        //se extrae B de la pila
                        pila.pop();
                        if(pila.empty())
                          aceptado = true;
                        else{
                            cont++;
                            r();
                        }
                    }
                }
            }
        }
        else{
            aceptado = true;
        }
    }   
}

