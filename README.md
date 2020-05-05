# Pushdown Automata

Java and C++
PA validate L(g) = {(a^n b^n) | n>0} 

Perl
PA validate L(g) = {(h^u)(g ^j)(e^2n)(d^3n)|u,j,n,i >= 0}

Ruby
PA validate (g) = { (h^n g^j e^2n d^3i) tal que n,j,i>=0 }


From Wikipedia, the free encyclopedia

In the theory of computation, a branch of theoretical computer science, a pushdown automaton (PDA) is a type of automaton that employs a stack.

Pushdown automata are used in theories about what can be computed by machines. They are more capable than finite-state machines but less capable than Turing machines. Deterministic pushdown automata can recognize all deterministic context-free languages while nondeterministic ones can recognize all context-free languages, with the former often used in parser design.

The term "pushdown" refers to the fact that the stack can be regarded as being "pushed down" like a tray dispenser at a cafeteria, since the operations never work on elements other than the top element. A stack automaton, by contrast, does allow access to and operations on deeper elements. Stack automata can recognize a strictly larger set of languages than pushdown automata.[1] A nested stack automaton allows full access, and also allows stacked values to be entire sub-stacks rather than just single finite symbols.