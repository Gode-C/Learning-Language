/****************************************************************************
 * Name            : hwk_01.pl
 * Project         : CSCI 5106
 * Description     : drop EveryOther in Prolog
 * Author          : Cyrus Chen
 
 match case   1. empty list, empty list
 (each line)  2. list with one element
              3. list with two element, drop the second one
              4. 3 or more element, drop the second element and eval with rest.
            
            
  run:  ->  prolog
        ->  [hwk_01].
        ->  dropEveryOther([1,2,3,4], [1,3]).
 
 
 
***************************************************************************/


dropEveryOther([], []).
dropEveryOther([H], [H]).
dropEveryOther([H,_|L1], [H|L2]):-dropEveryOther(L1, L2).
