echo "enter a name:\c"
read fname
if [ -f $fname ]
then 
      echo "valid file name"
else
      echo " invalid file"
fi
