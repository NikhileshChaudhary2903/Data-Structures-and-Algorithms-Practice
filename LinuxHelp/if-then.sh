echo "enter source and target"
read source target
if mv $source $target
then
echo "your file has been renamed"
else
echo "invalid input"
fi

