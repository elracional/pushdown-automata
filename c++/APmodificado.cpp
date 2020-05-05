/*
*/

/*AP que valida (anbn) tal que n>0*/
//Se asignara un lenguaje a validar a cada quien en la clase de ma�ana.//

#include<iostream>
#include<stack>

using namespace std;
stack <char> pila;

int mover(int estado , char simbolo)
{
     if( estado ==1  && simbolo == 'h' )//letra h
        {
          return 1;
        }

     if( (estado == 1 || estado == 2)  && simbolo == 'g' )//letra g
        {
         return 2;
        }

      if( (estado == 3 || estado == 2 || estado ==1)  && simbolo == 'e' )//letra e
           {
             pila.push('E');//añadimos a pila
             return 4;
           }

      if( (estado == 4)  && simbolo == 'e' )
      {
        pila.pop();//borramos de pila y demostramos el par
         return 3;
      }

      if( (estado == 5 || estado == 4 || estado == 3 || estado == 2 || estado ==1)  && simbolo == 'd' )//letrad
           {
             pila.push('D');//añadimos a pila
             pila.push('D');
             return 6;
           }

      if( estado == 6  && simbolo == 'd' )
        {
          pila.pop();
          return 7;//no se añade nada pero se pasa a otro estado
        }

        if( estado == 7 && simbolo == 'd' )
        {
          pila.pop();//tercer estado que demuestra la tercia
          return 5;
        }

 return 0;
}

int scanner(char palabra[15] )
{
    int i = 0;
    int estado = 1; //estado inicial

    while(palabra[i])
         {
          estado = mover(estado,palabra[i]);
          i++;
         }
	bool w= false;
	switch(estado){
		case 2:
		case 1:
		case 3:
		case 5:
			w= true;
	}
    if (pila.empty() && w) //estado final
         return 1;

    return 0;
}

int main()
{

    char palabra[15];

    cout<<"\n\n\t\tIngrese Cadena : ";
    gets(palabra);
	//getline(cin, palabra);

    if( scanner(palabra))
       cout<<"\n\n\t\t\t Corecto !!! ";

    else
       cout<<" \n\n\t\t\t Error !!!!";


    cout<<endl<<endl;

    system("pause");
}
