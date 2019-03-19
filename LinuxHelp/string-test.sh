str1="hey you"
str2="whats up?"
str3=""

[ "$str1" = "$str2" ]
echo $?

[ "$str1" != "$str2" ] 
echo $?

[ -n "$str1" ]
echo $?

[ -z "$str3" ] 
echo $?

