echo "enter a filename:\c"
read fname

terminal=`tty`
exec < $fname

nol=0
now=0

while read line
do
	nol=`expr $nol + 1`
	set $line
	now=`expr $now + $#`
done

echo "no of lines : $nol"
echo "no of words: $now"

exec < $terminal
