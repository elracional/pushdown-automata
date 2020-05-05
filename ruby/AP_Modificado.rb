
# Programa en Ruby que simula un AP que valida L(g) = { (h^n g^j e^2n d^3i) tal que n,j,i>=0 }

pila = []

def mover(pila, estado, simbolo)
  if( estado == 1 && simbolo == 'h' ) #Por cada 'h' introduce una H en la pila
    pila << 'H'
    return 1
  end
  if( estado == 1 && simbolo == 'g' ) #Por cada g, no se realiza nada en la pila, g,lambda:lambda
    return 1
  end
  if( estado == 1 && simbolo == 'e') #Por una 'e' se elimina la H introducida en la pila y manda a un estado 2 que verifica que la 'e' se encuentre en parejas
    return 2
  end
  if( estado == 2 && simbolo == 'e') #Elimina la H introducida en la pila por cada h
    pila.pop
    return 1
  end
  if( estado == 1 && simbolo == 'd') #Para que la 'd' este en grupos de 3, manda a un segundo estado para verificar que haya una segunda letra 'd'
    pila << 'D'
    return 2
  end
  if( estado == 2 && simbolo == 'd')#Elimina la 'd' introducida en la pila y manda a otro estado para verificar que haya una tercera letra
    pila.pop
    return 3
  end
  if( estado == 3 && simbolo == 'd')#Regresa al estado valido
    return 1
  end
end

def scanner(pila, palabra)
    i = 0
    estado = 1  #estado inicial y estado final ya que puede no haber letras
    while(palabra[i])
      estado = mover(pila, estado,palabra[i])
      i+=1
    end  
    #Si termina en el estado final y la pila vac�a, es valida
    if ( estado == 1 && pila.length == 0) #estado final
      return 1
    end   
end

def main(pila)
  puts "Ingrese Cadena : "
  palabra = gets.chomp #Almacena la cadena a validar

  if(scanner(pila, palabra))
    puts "\n\n\t\t\t Corecto !!! "
  else
    puts " \n\n\t\t\t Error !!!!"
  end
end

main(pila)