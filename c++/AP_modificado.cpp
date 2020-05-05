//*AP que valida (anbn) tal que n>0 
#include<iostream>
#include<stack>
// el automata cuenta con dos estados 1 y 2 
// Siendo el estado 1: el estado inicial
// Y 2 el estado final 
using namespace std;
stack <char> pila; 

int mover(int estado , char simbolo)
{
     if( estado == 1 && simbolo == 'a' )
        {
          pila.push('A');
          return 1;
        } 
        
     if( estado == 1 && simbolo == 'b' )
        {
         pila.pop();
         return 2;
        } 
        
     if( estado == 2 && simbolo == 'c' )
        {
         pila.pop();
         return 2;
        }      

 return 0;
}
     
int scanner(string cadena )
{
    int i = 0;
    int estado = 1; //estado inicial
    
    while(cadena[i])
         {
          estado = mover(estado,cadena[i]);
          i++;
         }
    
    if ( estado == 2 && pila.empty()) //estado final
         return 1;       
    
    return 0;     
}

int main()
{
    system("color b0");
    string cadena;
    cout<<"Automata de Pila Modificado "<<endl;
    cout<<"b) aibck | i,k >=1 & i>k "<<endl;
    cout<<"\nIngrese la cadena : ";
    getline(cin,cadena);
    
    if( scanner(cadena))
       cout<<"\n\tCorecto !!! \n\tCadena valida ";
  
    else
       cout<<" \n\n\t Error: Cadena no valida !";   
       
    
    cout<<endl<<endl;
   
}
