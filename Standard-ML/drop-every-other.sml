(****************************************************************************
 * Name            : hwk_01.sml
 * Project         : CSCI 5106
 * Description     : drop EveryOther in SML
 * Author          : Cyrus Chen 

    run:        ->      sml
                ->      use "hwk_01.sml";
                ->      (dropEveryOther [1,2,3,4]);
                val it = [1,3] : int list


***************************************************************************)

(* Use a helper function to recursively drop every other element*)

fun helper i [] = []                (*base case: no element*)
  | helper i (x::xs) =
  if i = 2                          (*drop elements when index is even*)
  then helper 1 xs
  else x :: (helper 2 xs)           (*add elemten on odd number element*)
  
    
fun dropEveryOther l1 = helper 1 l1


