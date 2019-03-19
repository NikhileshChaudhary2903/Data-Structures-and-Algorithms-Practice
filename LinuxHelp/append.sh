echo "enter fname:\c"
read fname
if [ -f $fname ]
then
      if [ -w $fname ]
      then 
	     echo "type matter to append "
	     cat >> $fname
      else
             echo "you dont have permission to write"
      fi
fi

