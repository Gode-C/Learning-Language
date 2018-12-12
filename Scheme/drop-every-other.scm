;-*
; * Name            : hwk_01.scm
; * Project         : CSCI 5106
; * Description     : drop EveryOther in Scheme
; * Author          : Cyrus Chen 
;
;   Basic idea: check if the list is null or have only element, and return empty list or itself, otherwise return the first element and concat with a recur call to the function with the same list without the first element 


;           -> module load scheme
;           -> scheme
;           -> (load "hwk_01.scm")
;           -> (dropEveryOther '(1 2 3 4))
;           ;Value 2: (1 3)


(define (dropEveryOther l1) 
    (if (null? l1)              ; check empty list
        '()
        (if (null? (cdr l1))       ;check if contains one element
            l1
            (cons (car l1)      ;return first element and
                  (dropEveryOther (cddr l1))    ;recur call
            
            )
        )
    )
)
