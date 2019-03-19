## tput in action
tput clear
echo "total rows on screen = \c"
tput lines
echo "total cols on screen = \c"
tput cols
## 15 row 20 col
tput cup 15 20
tput bold
echo "this should work"
echo "\033[0m Bye Bye"

