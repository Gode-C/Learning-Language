{-****************************************************************************
 * Name            : hwk_01.hs
 * Project         : CSCI 5106
 * Description     : drop EveryOther in Haskell
 * Author          : Cyrus Chen ***************************************************************************-}
{- Basic Idea      : Using a helper function rec to solve the problem recursively rec takes an extra argument using as index which swich switch back and force between 1 and 2 to check which element to drop.
        base case is null string
        when i == 1, return first element and rec call to the rest
        when i == 2, return rec call to the rest of the list -}



{-      run: -> ghci
             -> :load "hwk_01.hs"
             ->  dropEveryOther [1,2,3]
             [1,3]

-}





dropEveryOther :: [a] -> [a]
dropEveryOther = rec 1                  {- helper function -}
    where rec _ []     = []             {- empty list -}
          rec i (x:xs) = if i == 2 
            then rec 1 xs               {- recur without first element -}
            else x:rec (i+1) xs         {- first element + recur call -}
