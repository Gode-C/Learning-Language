{* Name            : hwk_01.pas
 * Project         : CSCI 5106
 * Description     : drop EveryOther in Pascal
 * Author          : Cyrus Chen 
 *}
   
{*          compile     -> fpc hwk_01.pas
            run         -> ./hwk_01
            keep enter numbers, negative trigger output

*}
program dropEveryOther;

{*This program take inputs until get negative number. The inputs are stored
in a dynamic array, then print ever other element in the array*}
Var
   // 
    Inputnum : array of Integer;        {dynamic array}
    i : Integer;
    num : Integer;

begin
    i := 0;

       while true do                    {loop for taking input}
            begin
            write('Enter a number, end with negatives ');
            read(num);
            if num < 0 then
                break
            else
                SetLength(Inputnum, i+1);       {increase array length}
                Inputnum[i] := num;
                i := i + 1;
            end;
    
    for i := 0 to length(Inputnum)-1 do
	begin
	    if odd(i) = false  then         {check if even index, print if true}
            write(Inputnum[i],' ');
	end;
    writeln;

end.




