# floating point arithmetic
a=10.5
b=3.5
a=`echo $a + $b | bc`
b=`echo $a - $b | bc`
c=`echo $a \* $b | bc`
d=`echo $a / $b| bc`
echo $a
echo $b
echo $c
echo $d
