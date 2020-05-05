#!/usr/bin/env perl


#use warnings;
use strict;

my @pila;
my $apC=0;
my $apP=0;
my $temp=0;
my $estado;
print"AUTOMATA DE PILA PARA L(g) = {(h^u)(g ^j)(e^2n)(d^3n)|u,j,n,i >= 0}\nIngrese una cadena: \n";
my $cadena = <STDIN>;
chomp($cadena);
my @cadena = split(undef, $cadena);
inicio();

sub inicio {
  print"---INICIO---\n\n\n";
  push(@pila, "Z");
  q0(@cadena);
}

sub q0 {
  print"EN Q0\n";
  print"LEIDO: $cadena[$apC]\n";
  print"EN pila: $pila[$apP]\n";
  #h,Z;h
  if ( ($cadena[$apC] eq "h")  &&  ($pila[$apP] eq "Z") ) {
    push (@pila, "h");
    $apC++;
    $apP++;
    verPila(@pila);
    q1(@cadena);
  }
}

sub q1 {
  print"EN Q1\n";
  print"LEIDO: $cadena[$apC]\n";
  print"EN pila: $pila[$apP]\n";
  #h,Z;h
  if ( ($cadena[$apC] eq "h")  &&  ($pila[$apP] eq "Z") ) {
    push (@pila, "h");
    $apC++;
    $apP++;
    verPila(@pila);
    q1(@cadena);
  }
  #h,h;ł
  if ( ($cadena[$apC] eq "h") && ($pila[$apP] eq "h") ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q1(@cadena);
  }
  #g,Z;g
  if ( ($cadena[$apC] eq "g") && ($pila[$apP] eq "Z") ) {
    push(@pila, "g");
    $apC++;
    $apP++;
    verPila(@pila);
    q2(@cadena);
  }
  #g,h,ł
  if ( ($cadena[$apC] eq "g") && ($pila[$apP] eq "h") ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q2(@cadena);
  }
}

sub q2 {
  print "EN Q2\n";
  print"LEIDO: $cadena[$apC]\n";
  print"EN pila: $pila[$apP]\n";
  #g,Z;g
  if ( ($cadena[$apC] eq "g") && ($pila[$apP] eq "Z") ) {
    push(@pila, "g");
    $apC++;
    $apP++;
    verPila(@pila);
    q2(@cadena);
  }
 #g,g;ł
  if ( ($cadena[$apC] eq "g") && ($pila[$apP] eq "g") ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q2(@cadena);
  }
  #e,Z;e
  if ( ($cadena[$apC] eq "e") && ($pila[$apP] eq "Z")  ) {
    push(@pila, "e");
    $apC++;
    $apP++;
    verPila(@pila);
    q3(@cadena);
  }
  #e,g;ł
  if ( ($cadena[$apC] eq "e") && ($pila[$apP] eq "g")  ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q3(@cadena);
  }
}

sub q3 {
  print "EN Q3\n";
  print"LEIDO: $cadena[$apC]\n";
  print"EN pila: $pila[$apP]\n";
  #e,e;e
  if ( ($cadena[$apC] eq "e") && ($pila[$apP] eq "e") ) {
    push(@pila, "e");
    $apC++;
    $apP++;
    verPila(@pila);
    q3(@cadena);
  }
  #e,Z;e
  if (($cadena[$apC] eq "e") && ($pila[$apP] eq "Z")) {
    push(@pila, "e");
    $apC++;
    $apP++;
    verPila(@pila);
    q3(@cadena);
  }
  #d,e;ł
  if ( ($cadena[$apC] eq "d") && ($pila[$apP] eq "e") ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q4(@cadena);
  }
}

sub q4 {
  print "EN Q4\n";
  print"LEIDO: $cadena[$apC]\n";
  print"EN pila: $pila[$apP]\n";
  #d,e;ł
  if ( ($cadena[$apC] eq "d") && ($pila[$apP] eq "e") ) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q4(@cadena);
  }
  #d,Z
  if (( $cadena[$apC] eq  "d") && ($pila[$apP] eq "Z")) {
    $temp = $apC;
    $apC++;
    if ($cadena[$temp] eq $cadena[$apC] ) {
      push(@pila, "d");
      push(@cadena, "Z");
      $apP++;
      verPila(@pila);
      q4(@cadena);
    }
    else{ #d,Z,ł
      pop(@pila);
      verPila(@pila);
      q5();
    }
  }
  #d,d,ł
  if ( ($cadena[$apC] eq "d") && ($pila[$apP] eq "d")) {
    pop(@pila);
    $apC++;
    $apP--;
    verPila(@pila);
    q4(@cadena);
  }
  #Z,Z,Ł
  if ( ($cadena[$apC] eq "Z")  && ($pila[$apP] eq "Z") ) {
    pop(@pila);
    verPila(@pila);
    q5();
  }
}

sub q5 {
  print"EN Q5\n";
  print"CADENA VALIDA\n\n";
}

sub verPila {
  print "--PILA--\n";
  foreach my $x (@pila) {
    print "$x";
  }
  print"\n\n\n";
}
