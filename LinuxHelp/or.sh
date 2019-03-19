echo "enter lowercase character :\c"
read var
if [ `echo $var | wc -c` -eq 2 ]
then
	if [ $var = a -o $var = e -o $var = i -o $var = o -o $var = u ]
	then 
		echo "you entered vowel"
	else
		echo "didn't enter vowel"
	fi
else
	echo "invalid input"
fi

