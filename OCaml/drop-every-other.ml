(*
 * Name            : hwk_01.ml
 * Project         : CSCI 5106
 * Description     : dropEveryOther in Ocaml
 * Author          : Cyrus Chen 
 
   Basic Idea      : match the input list l1 with 3 different cases:
   
             if l1 is empty, return empty
             if l1 has only one element, return itself
             if l1 has more than one element, return the first, skip the second, then recur with the rest *)

(*  run:    -> ocaml
            -> #use "hwk_01.ml";;
            -> dropEveryOther [1;2;3;4];;
            - : int list = [1; 3]

*)


let rec dropEveryOther l1 =
match l1 with
|[]-> []                                (* check empty list*)
|[x] -> [x]                             (* check one element list*)
|x::y::ys -> x::dropEveryOther ys ;;    (* recur call to same list without*)
                                        (* firsttwo element*)

