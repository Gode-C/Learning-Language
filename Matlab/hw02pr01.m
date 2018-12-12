function [ b ] = make_echelon( a )


nrows = size(a,1);
ncols = size(a,2);


b = a;


firstrow = 1;

	for j = 1:ncols

		if b(firstrow,:) != 0
            if b(firstrow,firstrow) = 0
			m = b(firstrow,:);
			b(firstrow,:) = b((firstrow+1),:);
			b((firstrow+1),:) = m;
		else
			for i = (firstrow+1):1:nrows;
				b(i,:)=(b(i,:)/((b(i,firstrow))/(b(firstrow,firstrow))))-(b(firstrow,firstrow))

			end
	firstrow = firstrow + 1;
        end
end